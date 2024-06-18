import pandas as pd

# Load the dataset used for training
train_data = pd.read_csv('car+data.csv')  # Replace with your training dataset file name

# Get the feature names used during training
train_features = train_data.columns.tolist()

# Load the prediction data
prediction_data = pd.read_csv('prediction_data.csv')  # Replace with your prediction dataset file name

# Get the feature names in the prediction data
prediction_features = prediction_data.columns.tolist()

# Compare the feature names
missing_features = set(train_features) - set(prediction_features)
unseen_features = set(prediction_features) - set(train_features)

print("Features missing in the prediction data:")
for feature in missing_features:
    print(f"- {feature}")

print("\nFeatures unseen during training but present in the prediction data:")
for feature in unseen_features:
    print(f"- {feature}")
