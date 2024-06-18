import pandas as pd
from sklearn.ensemble import RandomForestRegressor
import joblib
from flask import Flask, request, jsonify, render_template
import os


app = Flask(__name__)

# Load the trained model
model = joblib.load('model.pkl')

# Render the home page
@app.route('/')
def home():
    # Pass the necessary variables for drop-down menus
    fuelTypes = ['Diesel', 'Petrol']
    sellerTypes = ['Individual', 'Dealer']
    transmissions = ['Manual', 'Automatic']
    owners = [0, 1, 2, 3]
    return render_template('index.html', fuelTypes=fuelTypes, sellerTypes=sellerTypes, transmissions=transmissions, owners=owners)

@app.route('/predict', methods=['POST'])
def predict():
    data = request.get_json()
    age = int(data['age'])
    fuelType = data['fuelType']
    sellerType = data['sellerType']
    transmission = data['transmission']
    owner = int(data['owner'])
    kmsDriven = float(data['kmsDriven'])

    # Get the feature names used during model training
    feature_names = model.feature_names_in_

    # Create input DataFrame
    input_data = pd.DataFrame({
        'Age': [age],
        'Fuel_Type_Diesel': [fuelType == 'Diesel'],
        'Fuel_Type_Petrol': [fuelType == 'Petrol'],
        'Seller_Type_Individual': [sellerType == 'Individual'],
        'Transmission_Manual': [transmission == 'Manual'],
        'Owner': [owner],
        'Kms_Driven': [kmsDriven]
    })

    # Reorder columns to match the feature names used during model training
    input_data = input_data[feature_names]

    # Convert categorical variables to dummy/indicator variables
    input_data = pd.get_dummies(input_data, drop_first=True)

    # Make prediction
    predicted_price = model.predict(input_data)[0]

    # Return the predicted price as JSON response
    response = {'predicted_price': predicted_price}
    return jsonify(response)



if __name__ == '__main__':
    app.run(host='0.0.0.0', port=int(os.environ.get('PORT', 5000)))
