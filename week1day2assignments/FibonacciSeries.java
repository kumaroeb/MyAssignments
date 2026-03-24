 File "D:\ML project\master\pilot_v2\scripts\split_data.py", line 144, in <module>
    main()
    ~~~~^^
  File "D:\ML project\master\pilot_v2\scripts\split_data.py", line 84, in main
    use_stratify = all(c >= 2 for c in stratify_counts.values())
                                       ~~~~~~~~~~~~~~~~~~~~~~^^
TypeError: 'numpy.ndarray' object is not callable
