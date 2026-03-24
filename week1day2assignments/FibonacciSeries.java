Label Summary
──────────────────────────────────────────────────
  Total labeled images: 301

  Room type distribution:
    bathroom               78  ████████████████████████████████████████
    bedroom                74  ████████████████████████████████████████
    kitchen                73  ████████████████████████████████████████
    exterior_front         63  ████████████████████████████████████████
    exterior_back          10  ██████████
    other                   3  ███

  ⚠️  Some room types have fewer than 30 images:
      exterior_back: 10 (need 30+)
      other: 3 (need 30+)
      Training may still work, but accuracy for these will be lower.


  Feature detection (13/21 features have labels):
    all stainless steel appliances   47  ████████████████████████████████████████
    accent backsplash in kitchen     34  ██████████████████████████████████
    kitchen island                   26  ██████████████████████████
    double sinks in primary bathroom   18  ██████████████████
    separate tub and shower in primary bathroom   17  █████████████████
    patio                             5  █████
    fireplace                         5  █████
    covered patio                     2  ██
    fenced in backyard                2  ██
    walk in closet in primary bedroom    2  ██
    low maintenance landscaping       2  ██
    double closets in primary bedroom    1  █
    great cabinet storage in kitchen    1  █
Traceback (most recent call last):
  File "D:\ML project\master\pilot_v2\scripts\split_data.py", line 120, in <module>
    main()
    ~~~~^^
  File "D:\ML project\master\pilot_v2\scripts\split_data.py", line 88, in main
    val_df, test_df = train_test_split(
                      ~~~~~~~~~~~~~~~~^
        valtest_df, test_size=relative_test, stratify=valtest_stratify, random_state=seed,
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
    )
    ^
  File "D:\ML project\master\pilot_v2\venv\Lib\site-packages\sklearn\utils\_param_validation.py", line 218, in wrapper
    return func(*args, **kwargs)
  File "D:\ML project\master\pilot_v2\venv\Lib\site-packages\sklearn\model_selection\_split.py", line 2945, in train_test_split
    train, test = next(cv.split(X=arrays[0], y=stratify))
                  ~~~~^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  File "D:\ML project\master\pilot_v2\venv\Lib\site-packages\sklearn\model_selection\_split.py", line 1928, in split
    for train, test in self._iter_indices(X, y, groups):
                       ~~~~~~~~~~~~~~~~~~^^^^^^^^^^^^^^
  File "D:\ML project\master\pilot_v2\venv\Lib\site-packages\sklearn\model_selection\_split.py", line 2346, in _iter_indices
    raise ValueError(
    ...<5 lines>...
    )
ValueError: The least populated classes in y have only 1 member, which is too few. The minimum number of groups for any class cannot be less than 2. Classes with too few members are: ['rare_combined']
