"""
Data Splitter — CSV-based
==========================
Reads labels.csv and creates stratified train/val/test splits
based on room type (ensures each room type appears in all splits).

Usage:
    python scripts/split_data.py
"""

import os
import sys
import shutil
import argparse
from pathlib import Path

import yaml
import pandas as pd
from sklearn.model_selection import train_test_split


def main():
    parser = argparse.ArgumentParser()
    parser.add_argument("--config", default="configs/config.yaml")
    args = parser.parse_args()

    with open(args.config, "r") as f:
        config = yaml.safe_load(f)

    label_file = config["paths"]["label_file"]
    raw_dir = Path(config["paths"]["raw_data"])
    splits_dir = Path(config["paths"]["splits_dir"])
    ratios = config["data"]["split_ratios"]
    seed = config["data"]["random_seed"]

    if not os.path.exists(label_file):
        print(f"❌ No labels found at {label_file}")
        print(f"   Run labeling first: python scripts/label_helper.py\n")
        return

    df = pd.read_csv(label_file)
    print(f"\n📊 Label Summary")
    print(f"{'─'*50}")
    print(f"  Total labeled images: {len(df)}")
    print(f"\n  Room type distribution:")
    for room, count in df["room_type"].value_counts().items():
        bar = "█" * min(count, 40)
        print(f"    {room:20s} {count:4d}  {bar}")

    # Check minimum counts
    min_per_room = config["data"]["min_images_per_room"]
    low_rooms = df["room_type"].value_counts()
    low_rooms = low_rooms[low_rooms < min_per_room]
    if len(low_rooms) > 0:
        print(f"\n  ⚠️  Some room types have fewer than {min_per_room} images:")
        for room, count in low_rooms.items():
            print(f"      {room}: {count} (need {min_per_room}+)")
        print(f"      Training may still work, but accuracy for these will be lower.\n")

    # Feature counts
    feature_cols = [c for c in df.columns if c not in ("filename", "room_type")]
    feat_counts = df[feature_cols].sum().sort_values(ascending=False)
    nonzero = feat_counts[feat_counts > 0]
    print(f"\n  Feature detection ({len(nonzero)}/{len(feature_cols)} features have labels):")
    for feat, count in nonzero.head(15).items():
        bar = "█" * min(int(count), 40)
        print(f"    {feat.replace('_', ' '):30s} {int(count):4d}  {bar}")
    if len(nonzero) > 15:
        print(f"    ... and {len(nonzero) - 15} more")

    # Stratified split on room_type
    val_test_ratio = ratios["val"] + ratios["test"]

    # Handle room types with very few samples
    # Merge any class with < 6 images into "rare_combined" for stratification
    # (need at least 6 so that after 70/15/15 split, each set gets at least 1)
    stratify_col = df["room_type"].copy()
    counts = df["room_type"].value_counts()
    rare_mask = df["room_type"].map(counts) < 6
    stratify_col[rare_mask] = "rare_combined"

    # If rare_combined itself is still too small or doesn't exist, fall back to no stratification
    stratify_counts = stratify_col.value_counts()
    use_stratify = all(c >= 2 for c in stratify_counts.values)

    if use_stratify:
        train_df, valtest_df = train_test_split(
            df, test_size=val_test_ratio, stratify=stratify_col, random_state=seed,
        )
    else:
        print(f"\n  ⚠️  Too few samples in some classes for stratification — using random split")
        train_df, valtest_df = train_test_split(
            df, test_size=val_test_ratio, random_state=seed,
        )

    # Second split: val vs test
    # Re-check stratification feasibility on the smaller set
    valtest_stratify = valtest_df["room_type"].copy()
    vt_counts = valtest_df["room_type"].value_counts()
    rare_mask2 = valtest_df["room_type"].map(vt_counts) < 2
    valtest_stratify[rare_mask2] = "rare_combined"

    vt_strat_counts = valtest_stratify.value_counts()
    use_stratify2 = all(c >= 2 for c in vt_strat_counts.values)

    relative_test = ratios["test"] / val_test_ratio
    if use_stratify2:
        val_df, test_df = train_test_split(
            valtest_df, test_size=relative_test, stratify=valtest_stratify, random_state=seed,
        )
    else:
        val_df, test_df = train_test_split(
            valtest_df, test_size=relative_test, random_state=seed,
        )

    # Save split CSVs and copy images
    if splits_dir.exists():
        shutil.rmtree(splits_dir)
    splits_dir.mkdir(parents=True)

    for split_name, split_df in [("train", train_df), ("val", val_df), ("test", test_df)]:
        split_path = splits_dir / split_name
        split_path.mkdir()
        split_df.to_csv(split_path / "labels.csv", index=False)

        # Copy images
        copied = 0
        for _, row in split_df.iterrows():
            src = raw_dir / row["filename"]
            if src.exists():
                shutil.copy2(src, split_path / row["filename"])
                copied += 1

        print(f"\n  {split_name:5s}: {len(split_df)} labels, {copied} images copied")
        room_dist = split_df["room_type"].value_counts()
        for room, count in room_dist.items():
            print(f"         {room}: {count}")

    print(f"\n✅ Splits saved to {splits_dir}/")
    print(f"   Next step: python src/train.py\n")


if __name__ == "__main__":
    main()
