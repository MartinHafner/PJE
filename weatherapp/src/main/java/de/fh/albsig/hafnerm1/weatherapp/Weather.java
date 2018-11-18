package de.fh.albsig.hafnerm1.weatherapp;

/**
 * @author martin
 *
 */
public class Weather {

    /**
     * Constant for converting kelvin to celsius.
     */
    private final double celsiusInKelvin = 273.15;
    /**
     * city name.
     */
    private String city;
    /**
     * country tag.
     */
    private String country;
    /**
     * weather condition.
     */
    private String condition;
    /**
     * avg temperature.
     */
    private String temp;
    /**
     * min temperature.
     */
    private String minTemp;
    /**
     * max temperature.
     */
    private String maxTemp;
    /**
     * windspeed in km/h.
     */
    private String wind;
    /**
     * windspeed as text.
     */
    private String windName;
    /**
     * wind direction as text.
     */
    private String windDir;
    /**
     * humidity in percentage.
     */
    private String humidity;
    /**
     * pressure in hPa.
     */
    private String pressure;
    /**
     * cloud condition as text.
     */
    private String cloudsName;

    /**
     * @param kelv kelvin value
     * @return celsius value
     */
    private String kelvinToCelsius(final String kelv) {
        return String.format("%.2f",
                Double.parseDouble(kelv) - this.celsiusInKelvin);
    }

    /**
     * @return city
     */
    public final String getCity() {
        return this.city;
    }

    /**
     * @param cityp city
     */
    public final void setCity(final String cityp) {
        this.city = cityp;
    }

    /**
     * @return country
     */
    public final String getCountry() {
        return this.country;
    }

    /**
     * @param countryp country
     */
    public final void setCountry(final String countryp) {
        this.country = countryp;
    }

    /**
     * @return condition
     */
    public final String getCondition() {
        return this.condition;
    }

    /**
     * @param conditionp condition
     */
    public final void setCondition(final String conditionp) {
        this.condition = conditionp;
    }

    /**
     * @return temp
     */
    public final String getTemp() {
        return this.temp;
    }

    /**
     * @return temp in celsius
     */
    public final String getTempC() {
        return this.kelvinToCelsius(this.temp);
    }

    /**
     * @param tempp temp
     */
    public final void setTemp(final String tempp) {
        this.temp = tempp;
    }

    /**
     * @return minTemp
     */
    public final String getMinTemp() {
        return this.minTemp;
    }

    /**
     * @return minTemp in celsius
     */
    public final String getMinTempC() {
        return this.kelvinToCelsius(this.minTemp);
    }

    /**
     * @param minTempp minTemp
     */
    public final void setMinTemp(final String minTempp) {
        this.minTemp = minTempp;
    }

    /**
     * @return maxTemp
     */
    public final String getMaxTemp() {
        return this.maxTemp;
    }

    /**
     * @return maxTemp in celsius
     */
    public final String getMaxTempC() {
        return this.kelvinToCelsius(this.maxTemp);
    }

    /**
     * @param maxTempp maxTemp
     */
    public final void setMaxTemp(final String maxTempp) {
        this.maxTemp = maxTempp;
    }

    /**
     * @return wind
     */
    public final String getWind() {
        return this.wind;
    }

    /**
     * @param windp wind
     */
    public final void setWind(final String windp) {
        this.wind = windp;
    }

    /**
     * @return windName
     */
    public final String getWindName() {
        return this.windName;
    }

    /**
     * @param windNamep windName
     */
    public final void setWindName(final String windNamep) {
        this.windName = windNamep;
    }

    /**
     * @return windDir
     */
    public final String getWindDir() {
        return this.windDir;
    }

    /**
     * @param windDirp windDir
     */
    public final void setWindDir(final String windDirp) {
        this.windDir = windDirp;
    }

    /**
     * @return humidity
     */
    public final String getHumidity() {
        return this.humidity;
    }

    /**
     * @param humidityp humidity
     */
    public final void setHumidity(final String humidityp) {
        this.humidity = humidityp;
    }

    /**
     * @return pressure
     */
    public final String getPressure() {
        return this.pressure;
    }

    /**
     * @param pressurep pressure
     */
    public final void setPressure(final String pressurep) {
        this.pressure = pressurep;
    }

    /**
     * @return cloudsName
     */
    public final String getCloudsName() {
        return this.cloudsName;
    }

    /**
     * @param cloudsNamep cloudsName
     */
    public final void setCloudsName(final String cloudsNamep) {
        this.cloudsName = cloudsNamep;
    }

}
