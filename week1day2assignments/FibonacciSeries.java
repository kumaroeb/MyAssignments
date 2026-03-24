D:\ML project\master\pilot_v2>python src/train.py
  💻 Using CPU

🏠 Property Photo — Room & Feature Training
───────────────────────────────────────────────────────
  Dataset — Train: 210, Val: 45, Test: 46
  Room types: 8, Features: 21
Warning: You are sending unauthenticated requests to the HF Hub. Please set a HF_TOKEN to enable higher rate limits and faster downloads.
  Backbone: efficientnet_b0 (1280-dim features)
  ❄️  Backbone frozen (Phase 1)
  Parameters: 670,749 trainable / 4,678,297 total

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Phase 1: Feature Extraction
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Train:   0%|                                                                                  | 0/14 [00:00<?, ?it/s]D:\ML project\master\pilot_v2\venv\Lib\site-packages\torch\utils\data\dataloader.py:1118: UserWarning: 'pin_memory' argument is set as true but no accelerator is found, then device pinned memory won't be used.
  super().__init__(loader)
  Epoch   1/10  │  Train: 1.6616 / 0.524  │  Val: 0.9140 / 0.889  │  LR: 0.000976
  💾 Best model saved (val room acc: 0.889)
  Epoch   2/10  │  Train: 0.8812 / 0.767  │  Val: 0.5879 / 0.822  │  LR: 0.000905
  Epoch   3/10  │  Train: 0.5725 / 0.871  │  Val: 0.4899 / 0.911  │  LR: 0.000794
  💾 Best model saved (val room acc: 0.911)
  Epoch   4/10  │  Train: 0.5346 / 0.838  │  Val: 0.4079 / 0.933  │  LR: 0.000655
  💾 Best model saved (val room acc: 0.933)
  Epoch   5/10  │  Train: 0.3167 / 0.929  │  Val: 0.3901 / 0.933  │  LR: 0.000500
  Epoch   6/10  │  Train: 0.3491 / 0.905  │  Val: 0.3891 / 0.933  │  LR: 0.000345
  Epoch   7/10  │  Train: 0.3083 / 0.900  │  Val: 0.3804 / 0.911  │  LR: 0.000206
  Epoch   8/10  │  Train: 0.3417 / 0.895  │  Val: 0.3859 / 0.911  │  LR: 0.000095
  Epoch   9/10  │  Train: 0.2625 / 0.933  │  Val: 0.3748 / 0.933  │  LR: 0.000024
  Epoch  10/10  │  Train: 0.3200 / 0.905  │  Val: 0.3550 / 0.956  │  LR: 0.000000
  💾 Best model saved (val room acc: 0.956)
  🔥 Unfroze 30/211 backbone layers (Phase 2)

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Phase 2: Fine-Tuning
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Epoch   1/20  │  Train: 0.3171 / 0.914  │  Val: 0.3158 / 0.933  │  LR: 0.000099
  💾 Best model saved (val room acc: 0.933)
  Epoch   2/20  │  Train: 0.2046 / 0.952  │  Val: 0.3203 / 0.933  │  LR: 0.000098
  Epoch   3/20  │  Train: 0.1954 / 0.971  │  Val: 0.3218 / 0.956  │  LR: 0.000095
  💾 Best model saved (val room acc: 0.956)
  Epoch   4/20  │  Train: 0.1743 / 0.986  │  Val: 0.3336 / 0.933  │  LR: 0.000090
  Epoch   5/20  │  Train: 0.1304 / 0.981  │  Val: 0.3149 / 0.956  │  LR: 0.000085
  Epoch   6/20  │  Train: 0.1502 / 0.981  │  Val: 0.2889 / 0.956  │  LR: 0.000079
  Epoch   7/20  │  Train: 0.1385 / 0.976  │  Val: 0.2972 / 0.956  │  LR: 0.000073
  Epoch   8/20  │  Train: 0.1053 / 0.990  │  Val: 0.2979 / 0.956  │  LR: 0.000065
  Epoch   9/20  │  Train: 0.1285 / 0.981  │  Val: 0.2832 / 0.956  │  LR: 0.000058
  Epoch  10/20  │  Train: 0.1447 / 0.962  │  Val: 0.2800 / 0.956  │  LR: 0.000050
  Epoch  11/20  │  Train: 0.1401 / 0.971  │  Val: 0.3057 / 0.956  │  LR: 0.000042
  Epoch  12/20  │  Train: 0.1228 / 0.976  │  Val: 0.3416 / 0.956  │  LR: 0.000035
  Epoch  13/20  │  Train: 0.1050 / 0.981  │  Val: 0.3325 / 0.956  │  LR: 0.000027
  Epoch  14/20  │  Train: 0.1079 / 0.986  │  Val: 0.2954 / 0.956  │  LR: 0.000021
  Epoch  15/20  │  Train: 0.1120 / 0.981  │  Val: 0.2972 / 0.956  │  LR: 0.000015
  ⏹  Early stopping at epoch 15

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  ✅ Training complete!
  Best room accuracy: 0.956
  Model: models\best_model.pt
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

  Next: python src/evaluate.py
