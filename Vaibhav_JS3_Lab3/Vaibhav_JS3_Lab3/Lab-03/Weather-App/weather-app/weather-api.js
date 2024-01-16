
// Declare a const for APP_ID / APP_KEY
// Declare a const for BASE_URL

const WEATHER_API_BASE_URL = "https://api.openweathermap.org/data/2.5/weather";
const API_KEY = "fbc0ee13d4cd0ca7ed7b116299399f34";

class WeatherAPI{

  // Accept the locationName
  // units=metric
  // appid
  buildURL(locationName){

    // Make use of URL
    // 
    this.weatherAPIURL = new URL(WEATHER_API_BASE_URL);

    // q
    this.weatherAPIURL.searchParams.append("q", locationName);

    // units
    this.weatherAPIURL.searchParams.append("units", "metric");

    // appid 
    this.weatherAPIURL.searchParams.append("appid", API_KEY);

    console.log(this.weatherAPIURL.toString());
  }

  async invokeURL(){

    // this.buildURL()
    // Option 1 - await / async
    // Option 2 - then.then / catch
    
    // Pass this.weatherAPIURL.toString()
    // Make use of await
    // await responseObj.json()
    // Surrounded with async
    // fetch()

    // Return the JSON

    const responseObj = await fetch(this.weatherAPIURL.toString());

    const responseJSON = await responseObj.json();

    return responseJSON;
  }

}

export {WeatherAPI}