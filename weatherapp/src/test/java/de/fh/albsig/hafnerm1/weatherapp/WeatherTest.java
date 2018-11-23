package de.fh.albsig.hafnerm1.weatherapp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(value = Lifecycle.PER_CLASS)
public class WeatherTest {
    private OWMWeather mockedWeather;
    private OWMWeather weather;
    private Path testPath;
    private Logger log;

    @BeforeAll
    void setup() {
        this.log = LogManager.getLogger(WeatherTest.class);
        this.testPath = Paths.get("");

        this.mockedWeather = mock(OWMWeather.class);

        when(this.mockedWeather.getCity()).thenReturn("London");
        when(this.mockedWeather.getCloudsName()).thenReturn("clear sky");
        when(this.mockedWeather.getCondition()).thenReturn("fog");
        when(this.mockedWeather.getCountry()).thenReturn("GB");
        when(this.mockedWeather.getHumidity()).thenReturn("99");
        when(this.mockedWeather.getLastUpdate())
                .thenReturn("2018-11-20T20:20:00"); // as parameter
        when(this.mockedWeather.getMaxTemp()).thenReturn("273.15");
        when(this.mockedWeather.getMaxTempC()).thenReturn("0,00 ");
        when(this.mockedWeather.getMinTemp()).thenReturn("269.15");
        when(this.mockedWeather.getMinTempC()).thenReturn("-4,00");
        when(this.mockedWeather.getPressure()).thenReturn("1009");
        when(this.mockedWeather.getTemp()).thenReturn("271.15");
        when(this.mockedWeather.getTempC()).thenReturn("-2,00");
        when(this.mockedWeather.getWind()).thenReturn("1");
        when(this.mockedWeather.getWindDir()).thenReturn("North");
        when(this.mockedWeather.getWindName()).thenReturn("Calm");

    }

    @BeforeEach
    void everyTest() {
        this.weather = new OWMWeather();
    }

    @Test
    void kelvinCelsiusTest() {
        this.weather.setTemp(this.mockedWeather.getTemp());
        assertEquals(this.weather.getTemp(), this.mockedWeather.getTemp());
        assertEquals(this.weather.getTempC(), this.mockedWeather.getTempC());
    }

    @Test
    void owmRetrieverTest() {
        final OWMRetriever ret = new OWMRetriever();
        final String cityid = "3220838";
        final InputStream in = ret.retrieveByCityID(cityid);
        try {
            assertEquals(in.available() > 0, true);
        } catch (final IOException e) {
            this.log.error("can't access OWM for CityID: " + cityid);
        }

    }

    @Test
    void formatterTest() {
        final XMLFormatter xmlFormatter = new XMLFormatter(this.mockedWeather);
        xmlFormatter.format();
        final String path = "src/target";
        try {
            this.testPath = xmlFormatter.save(path);
        } catch (final IOException e) {
            this.log.error("can't write xml to:" + path);
        }

        assertTrue(new File(this.testPath.toString()).isFile());
    }

    @AfterEach
    void cleanEach() {

    }

    @AfterAll
    void cleanUp() {
        try {
            Files.delete(this.testPath);
        } catch (final IOException e) {
            this.log.error("can't delete file: " + this.testPath);
        }
    }

}