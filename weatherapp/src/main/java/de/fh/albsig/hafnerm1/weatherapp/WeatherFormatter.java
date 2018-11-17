package de.fh.albsig.hafnerm1.weatherapp;

public class WeatherFormatter {

	public String format(Weather weather) {
		String output = "";
		output += "City: " + weather.getCity() + "\n";
		output += "Country: " + weather.getCountry() + "\n";
		output += "Condition: " + weather.getCondition() + "\n";
		output += "Temp: " + weather.getTemp() + "°K\n";
		output += "Chill: " + weather.getChill() + "\n";
		output += "Humidity: " + weather.getHumidity() + "%\n";
		return output;
	}

}
