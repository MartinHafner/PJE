package de.fh.albsig.hafnerm1.weatherapp;

/**
 * @author martin
 *
 */
public class WeatherFormatter {

    /**
     * @param weather Weather Object
     * @return formated String
     */
    public final String format(final Weather weather) {
        String output = "";
        output += "Location: \t";
        output += weather.getCity() + "," + weather.getCountry() + "\n";
        output += "Condition: \t";
        output += weather.getCondition() + "\n";
        output += "Temp: \t\t";
        output += weather.getMinTempC() + "°C : " + weather.getTempC() + "°C : "
                + weather.getMaxTempC() + "°C\n";
        output += "Humidity: \t";
        output += weather.getHumidity() + "%\n";
        output += "Pressure: \t";
        output += weather.getPressure() + "hPa\n";
        output += "Wind: \t\t";
        output += weather.getWind() + "km/h " + weather.getWindDir() + ", "
                + weather.getWindName();
        return output;
    }

}
