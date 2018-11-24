package de.fh.albsig.hafnerm1.weatherapp;

/**
 * @author martin
 *
 */
public class WeatherFormatter {

    /**
     * @param oWMWeather OWMWeather Object
     * @return formated String
     */
    public final String format(final OWMWeather owmWeather) {
        
        String output = "" +
        "<table>\n" + 
		"  <tr>\n" + 
		"    <th>City</th>\n" + 
		"    <th>"+owmWeather.getCity()+"</th>\n" + 
		"    <th></th>\n" + 
		"  </tr>\n" + 
		"  <tr>\n" + 
		"    <td>Country</td>\n" + 
		"    <td>"+owmWeather.getCountry()+"</td>\n" + 
		"    <td></td>\n" + 
		"  </tr>\n" + 
		"  <tr>\n" + 
		"    <td>Condition</td>\n" + 
		"    <td>"+owmWeather.getCondition()+"</td>\n" + 
		"    <td></td>\n" + 
		"  </tr>\n" + 
		"  <tr>\n" + 
		"    <td><br>Temperatur<br></td>\n" + 
		"    <td>"+owmWeather.getTempC()+"</td>\n" + 
		"    <td>°C</td>\n" + 
		"  </tr>\n" + 
		"  <tr>\n" + 
		"    <td>Windspeed</td>\n" + 
		"    <td>"+owmWeather.getWind()+"</td>\n" + 
		"    <td>km/h</td>\n" + 
		"  </tr>\n" + 
		"  <tr>\n" + 
		"    <td>Wind direction</td>\n" + 
		"    <td>"+owmWeather.getWindDir()+"</td>\n" + 
		"    <td></td>\n" + 
		"  </tr>\n" + 
		"  <tr>\n" + 
		"    <td>Humidity</td>\n" + 
		"    <td>"+owmWeather.getHumidity()+"</td>\n" + 
		"    <td>%</td>\n" + 
		"  </tr>\n" + 
		"  <tr>\n" + 
		"    <td>Pressure</td>\n" + 
		"    <td>"+owmWeather.getPressure()+"</td>\n" + 
		"    <td>hPa</td>\n" + 
		"  </tr>\n" + 
		"  <tr>\n" + 
		"    <td>Clouds</td>\n" + 
		"    <td>"+owmWeather.getCloudsName()+"</td>\n" + 
		"    <td></td>\n" + 
		"  </tr>\n" + 
		"</table>";
        
        return output;
    }

}
