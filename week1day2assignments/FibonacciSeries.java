(venv) D:\ML project\master\pilot_v2>python src/evaluate.py
  💻 Using CPU

🏠 Evaluation — Room Classification + Feature Detection
───────────────────────────────────────────────────────
Warning: You are sending unauthenticated requests to the HF Hub. Please set a HF_TOKEN to enable higher rate limits and faster downloads.
  Backbone: efficientnet_b0 (1280-dim features)
  ❄️  Backbone frozen (Phase 1)
  Loaded model (val acc: 0.956)
  Test set: 46 images
  Evaluating: 100%|██████████████████████████████████████████████████████████████████████| 3/3 [00:07<00:00,  2.57s/it]

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  🏠 ROOM CLASSIFICATION
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  Overall accuracy: 0.826  ⚠️

                precision    recall  f1-score   support

       kitchen      0.800     0.889     0.842         9
       bedroom      1.000     0.727     0.842        11
      bathroom      0.800     0.923     0.857        13
exterior front      0.769     1.000     0.870        10
 exterior back      0.000     0.000     0.000         2
         other      0.000     0.000     0.000         1

      accuracy                          0.826        46
     macro avg      0.562     0.590     0.568        46
  weighted avg      0.789     0.826     0.797        46

  📊 Room confusion matrix → logs\room_confusion_matrix.png

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  🔍 FEATURE DETECTION
━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━

  Features with test examples (9/21):

  Feature                             Examples    Prec  Recall      F1
  ──────────────────────────────────────────────────────────────────
  accent backsplash in kitchen               4   0.750   0.750   0.750  ✅
  all stainless steel appliances             7   0.800   0.571   0.667  ✅
  patio                                      1   0.000   0.000   0.000  ❌
  fenced in backyard                         1   0.000   0.000   0.000  ❌
  covered patio                              1   0.000   0.000   0.000  ❌
  kitchen island                             5   0.000   0.000   0.000  ❌
  double sinks in primary bathroom           5   0.000   0.000   0.000  ❌
  separate tub and shower in primary bathroom        3   0.000   0.000   0.000  ❌
  fireplace                                  2   0.000   0.000   0.000  ❌

  Average feature F1: 0.157
  📊 Feature F1 chart → logs\feature_f1_chart.png

  📄 Results → logs\evaluation_results.json

━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━━
  🟡 ROOM CLASSIFICATION: Promising (83%) — needs more data
  🔴 FEATURE DETECTION: Needs work (avg F1: 0.16) — check labels
