 Phase 1: Feature Extraction
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Train:   0%|                                                                                  | 0/14 [00:00<?, ?it/s]D:\ML project\master\pilot_v2\venv\Lib\site-packages\torch\utils\data\dataloader.py:1118: UserWarning: 'pin_memory' argument is set as true but no accelerator is found, then device pinned memory won't be used.
  super().__init__(loader)
Traceback (most recent call last):
  File "D:\ML project\master\pilot_v2\src\train.py", line 231, in <module>
    main()
    ~~~~^^
  File "D:\ML project\master\pilot_v2\src\train.py", line 195, in main
    best_p1 = train_phase(model, train_loader, val_loader, room_criterion, feat_criterion,
                          optimizer, scheduler, device, p1["epochs"],
                          "Phase 1: Feature Extraction", es, model_dir, log,
                          room_weight, feat_weight)
  File "D:\ML project\master\pilot_v2\src\train.py", line 119, in train_phase
    train_loss, train_acc = train_one_epoch(
                            ~~~~~~~~~~~~~~~^
        model, train_loader, room_criterion, feat_criterion,
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        optimizer, device, room_weight, feat_weight)
        ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
  File "D:\ML project\master\pilot_v2\src\train.py", line 66, in train_one_epoch
    feat_loss = feat_criterion(feat_logits, feat_labels)
  File "D:\ML project\master\pilot_v2\venv\Lib\site-packages\torch\nn\modules\module.py", line 1776, in _wrapped_call_impl
    return self._call_impl(*args, **kwargs)
           ~~~~~~~~~~~~~~~^^^^^^^^^^^^^^^^^
  File "D:\ML project\master\pilot_v2\venv\Lib\site-packages\torch\nn\modules\module.py", line 1787, in _call_impl
    return forward_call(*args, **kwargs)
  File "D:\ML project\master\pilot_v2\venv\Lib\site-packages\torch\nn\modules\loss.py", line 833, in forward
    return F.binary_cross_entropy_with_logits(
           ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~^
        input,
        ^^^^^^
    ...<3 lines>...
        reduction=self.reduction,
        ^^^^^^^^^^^^^^^^^^^^^^^^^
    )
    ^
  File "D:\ML project\master\pilot_v2\venv\Lib\site-packages\torch\nn\functional.py", line 3637, in binary_cross_entropy_with_logits
    raise ValueError(
        f"Target size ({target.size()}) must be the same as input size ({input.size()})"
    )
ValueError: Target size (torch.Size([16, 21])) must be the same as input size (torch.Size([16, 22]))
