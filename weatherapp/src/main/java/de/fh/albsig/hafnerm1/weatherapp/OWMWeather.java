package de.fh.albsig.hafnerm1.weatherapp;

/**
 * @author martin
 *
 */
public class OWMWeather {

    /**
     * Constant for converting kelvin to celsius.
     */
    private static final double CELSIUS_KELVIN = 273.15;
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
     * timestamp of weather probing.
     */
    private String lastUpdate;

    /**
     * Konstruktor.
     */
    public OWMWeather() {
        this.city = "n/a";
        this.country = "n/a";
        this.condition = "n/a";
        this.temp = "0.00";
        this.minTemp = "0.00";
        this.maxTemp = "0.00";
        this.wind = "n/a";
        this.windName = "n/a";
        this.windDir = "n/a";
        this.humidity = "n/a";
        this.pressure = "n/a";
        this.cloudsName = "n/a";
        this.lastUpdate = "n/a";

    }

    /**
     * @param kelv kelvin value
     * @return celsius value
     */
    private String kelvinToCelsius(final String kelv) {
        return String.format("%.2f",
                Double.parseDouble(kelv) - OWMWeather.CELSIUS_KELVIN);
    }

    /**
     * @return lastUpdate
     */
    public String getLastUpdate() {
        return this.lastUpdate;
    }

    /**
     * @param lastUpdatep lastUpdate
     */
    public void setLastUpdate(final String lastUpdatep) {
        this.lastUpdate = lastUpdatep;
    }

    /**
     * @return city
     */
    public String getCity() {
        return this.city;
    }

    /**
     * @param cityp city
     */
    public void setCity(final String cityp) {
        this.city = cityp;
    }

    /**
     * @return country
     */
    public String getCountry() {
        return this.country;
    }

    /**
     * @param countryp country
     */
    public void setCountry(final String countryp) {
        this.country = countryp;
    }

    /**
     * @return condition
     */
    public String getCondition() {
        return this.condition;
    }

    /**
     * @param conditionp condition
     */
    public void setCondition(final String conditionp) {
        this.condition = conditionp;
    }

    /**
     * @return temp
     */
    public String getTemp() {
        return this.temp;
    }

    /**
     * @return temp in celsius
     */
    public String getTempC() {
        return this.kelvinToCelsius(this.temp);
    }

    /**
     * @param tempp temp
     */
    public void setTemp(final String tempp) {
        this.temp = tempp;
    }

    /**
     * @return minTemp
     */
    public String getMinTemp() {
        return this.minTemp;
    }

    /**
     * @return minTemp in celsius
     */
    public String getMinTempC() {
        return this.kelvinToCelsius(this.minTemp);
    }

    /**
     * @param minTempp minTemp
     */
    public void setMinTemp(final String minTempp) {
        this.minTemp = minTempp;
    }

    /**
     * @return maxTemp
     */
    public String getMaxTemp() {
        return this.maxTemp;
    }

    /**
     * @return maxTemp in celsius
     */
    public String getMaxTempC() {
        return this.kelvinToCelsius(this.maxTemp);
    }

    /**
     * @param maxTempp maxTemp
     */
    public void setMaxTemp(final String maxTempp) {
        this.maxTemp = maxTempp;
    }

    /**
     * @return wind
     */
    public String getWind() {
        return this.wind;
    }

    /**
     * @param windp wind
     */
    public void setWind(final String windp) {
        this.wind = windp;
    }

    /**
     * @return windName
     */
    public String getWindName() {
        return this.windName;
    }

    /**
     * @param windNamep windName
     */
    public void setWindName(final String windNamep) {
        this.windName = windNamep;
    }

    /**
     * @return windDir
     */
    public String getWindDir() {
        return this.windDir;
    }

    /**
     * @param windDirp windDir
     */
    public void setWindDir(final String windDirp) {
        this.windDir = windDirp;
    }

    /**
     * @return humidity
     */
    public String getHumidity() {
        return this.humidity;
    }

    /**
     * @param humidityp humidity
     */
    public void setHumidity(final String humidityp) {
        this.humidity = humidityp;
    }

    /**
     * @return pressure
     */
    public String getPressure() {
        return this.pressure;
    }

    /**
     * @param pressurep pressure
     */
    public void setPressure(final String pressurep) {
        this.pressure = pressurep;
    }

    /**
     * @return cloudsName
     */
    public String getCloudsName() {
        return this.cloudsName;
    }

    /**
     * @param cloudsNamep cloudsName
     */
    public void setCloudsName(final String cloudsNamep) {
        this.cloudsName = cloudsNamep;
    }

}
