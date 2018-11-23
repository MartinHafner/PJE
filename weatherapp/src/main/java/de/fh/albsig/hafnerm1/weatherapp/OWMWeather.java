package de.fh.albsig.hafnerm1.weatherapp;

import java.time.LocalDateTime;

/**
 * @author martin
 *
 */
public class OWMWeather implements Weather {

    private final int cityID;
    private final String city;
    private final String country;
    private final String condition;
    private final double temp;
    private final double minTemp;
    private final double maxTemp;
    private final double wind;
    private final String windName;
    private final String windDir;
    private final double humidity;
    private final double pressure;
    private final String cloudsName;
    private final LocalDateTime lastUpdate;

    /**
     * Konstruktor.
     */
    public OWMWeather() {
        this.cityID = 0;
        this.city = "n/a";
        this.country = "n/a";
        this.condition = "n/a";
        this.temp = 0.0;
        this.minTemp = 0.0;
        this.maxTemp = 0.0;
        this.wind = 0.0;
        this.windName = "n/a";
        this.windDir = "n/a";
        this.humidity = 0.0;
        this.pressure = 0.0;
        this.cloudsName = "n/a";
        this.lastUpdate = LocalDateTime.now();

    }

    public OWMWeather(final int cityID, final String city, final String country,
            final String condition, final double temp, final double minTemp,
            final double maxTemp, final double wind, final String windName,
            final String windDir, final double humidity, final double pressure,
            final String cloudsName, final LocalDateTime lastUpdate) {
        this.cityID = cityID;
        this.city = city;
        this.country = country;
        this.condition = condition;
        this.temp = temp;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.wind = wind;
        this.windName = windName;
        this.windDir = windDir;
        this.humidity = humidity;
        this.pressure = pressure;
        this.cloudsName = cloudsName;
        this.lastUpdate = lastUpdate;

    }

    @Override
    public LocalDateTime getLastUpdate() {
        return this.lastUpdate;
    }

    @Override
    public int getCityID() {
        return this.cityID;
    }

    @Override
    public String getCity() {
        return this.city;
    }

    @Override
    public String getCountry() {
        return this.country;
    }

    @Override
    public String getCondition() {
        return this.condition;
    }

    @Override
    public double getTempInKelvin() {
        return this.temp;
    }

    @Override
    public double getTempInCelsius() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getMinTempInKelvin() {
        return this.minTemp;
    }

    @Override
    public double getMinTempInCelsius() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getMaxTempInKelvin() {
        return this.maxTemp;
    }

    @Override
    public double getMaxTempInCelsius() {
        // TODO Auto-generated method stub
        return 0;
    }

    @Override
    public double getWindInKMH() {
        return this.wind;
    }

    @Override
    public String getWindName() {
        return this.windName;
    }

    @Override
    public String getWindDir() {
        return this.windDir;
    }

    @Override
    public double getHumidityInPercent() {
        return this.humidity;
    }

    @Override
    public double getPressureInHPA() {
        return this.pressure;
    }

    @Override
    public String getCloudsName() {
        return this.cloudsName;
    }

}