package de.fh.albsig.hafnerm1.weatherapp;

/**
 * @author martin
 *
 */
public class WeatherFormatter {

    /**
     * @param weather OWMWeather Object
     * @return formated String
     */
    public final String format(final OWMWeather weather) {
        String output = "\n";
        output += "Location: \t";
        output += weather.getCity() + ", " + weather.getCountry() + "\n";
        output += "Condition: \t";
        output += weather.getCondition() + "," + weather.getCloudsName() + "\n";
        output += "Temp: \t\t";
        output += weather.getMaxTempInCelsius() + "°C : "
                + weather.getTempInCelsius() + "°C : "
                + weather.getMinTempInCelsius() + "°C\n";
        output += "Humidity: \t";
        output += weather.getHumidityInPercent() + "%\n";
        output += "Pressure: \t";
        output += weather.getPressureInHPA() + "hPa\n";
        output += "Wind: \t\t";
        output += weather.getWindInKMH() + "km/h " + weather.getWindDir() + ", "
                + weather.getWindName();
        return output;
    }

}
