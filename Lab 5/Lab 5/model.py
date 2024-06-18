import pandas as pd
from sklearn.ensemble import RandomForestRegressor
import joblib

# Load the dataset
df = pd.read_csv('car+data.csv')

# Drop the 'Car_Name' column
df = df.drop('Car_Name', axis=1)

# Calculate the age of the car
current_year = 2023
df['Age'] = current_year - df['Year']

# Drop the 'Year' column
df = df.drop('Year', axis=1)

# Drop the 'Present_Price' column
df = df.drop('Present_Price', axis=1)

# Prepare the feature matrix X and the target variable y
X = df.drop('Selling_Price', axis=1)
X = pd.get_dummies(X, drop_first=True)  # Convert categorical variables to dummy/indicator variables
y = df['Selling_Price']

# Train the model
model = RandomForestRegressor()
model.fit(X, y)

# Save the trained model
joblib.dump(model, 'model.pkl')
