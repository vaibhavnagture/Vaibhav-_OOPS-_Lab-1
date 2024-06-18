import pandas as pd

# Load the dataset
df = pd.read_csv('car+data.csv')

# Get the unique values for each column
unique_values = {}
for column in df.columns:
    unique_values[column] = df[column].unique().tolist()

# Print the unique values for each column
for column, values in unique_values.items():
    print(f"Unique values for {column}:")
    print(values)
    print()
