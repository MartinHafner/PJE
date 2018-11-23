package de.fh.albsig.hafnerm1.weatherapp;

import java.time.LocalDateTime;

public interface Weather {
    public static final double CELSIUS_KELVIN = 273.15;

    public LocalDateTime getLastUpdate();

    public int getCityID();

    public String getCity();

    public String getCountry();

    public String getCondition();

    public double getTempInKelvin();

    public double getTempInCelsius();

    public double getMinTempInKelvin();

    public double getMinTempInCelsius();

    public double getMaxTempInKelvin();

    public double getMaxTempInCelsius();

    public double getWindInKMH();

    public String getWindName();

    public String getWindDir();

    public double getHumidityInPercent();

    public double getPressureInHPA();

    public String getCloudsName();

}
