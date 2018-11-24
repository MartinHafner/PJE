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

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@TestInstance(value = Lifecycle.PER_CLASS)
public class WeatherTest {
    private OWMWeather weather;
    private Formatter<OWMWeather, String> mockFormatter;
    private Path testPath;

    @BeforeAll
    void setup() {
        this.mockFormatter = mock(Formatter.class);
        this.weather = new OWMWeather();
        this.weather.setCity("na");
        this.weather.setCountry("na");
        this.weather.setCondition("na");
        this.weather.setTemp("0.00");
        this.weather.setMinTemp("0.00");
        this.weather.setMaxTemp("0.00");
        this.weather.setWind("na");
        this.weather.setWindName("na");
        this.weather.setWindDir("na");
        this.weather.setHumidity("na");
        this.weather.setPressure("na");
        this.weather.setCloudsName("na");
        this.weather.setLastUpdate("na");

        when(this.mockFormatter.format(this.weather)).thenReturn("<table>\n"
                + "  <tr>\n" + "    <th>City</th>\n" + "    <th>na</th>\n"
                + "    <th></th>\n" + "  </tr>\n" + "  <tr>\n"
                + "    <td>Country</td>\n" + "    <td>na</td>\n"
                + "    <td></td>\n" + "  </tr>\n" + "  <tr>\n"
                + "    <td>Condition</td>\n" + "    <td>na</td>\n"
                + "    <td></td>\n" + "  </tr>\n" + "  <tr>\n"
                + "    <td><br>Temperatur<br></td>\n" + "    <td>-273,15</td>\n"
                + "    <td>°C</td>\n" + "  </tr>\n" + "  <tr>\n"
                + "    <td>Windspeed</td>\n" + "    <td>0.00</td>\n"
                + "    <td>km/h</td>\n" + "  </tr>\n" + "  <tr>\n"
                + "    <td>Wind direction</td>\n" + "    <td>na</td>\n"
                + "    <td></td>\n" + "  </tr>\n" + "  <tr>\n"
                + "    <td>Humidity</td>\n" + "    <td>100</td>\n"
                + "    <td>%</td>\n" + "  </tr>\n" + "  <tr>\n"
                + "    <td>Pressure</td>\n" + "    <td>1000</td>\n"
                + "    <td>hPa</td>\n" + "  </tr>\n" + "  <tr>\n"
                + "    <td>Clouds</td>\n" + "    <td>na</td>\n"
                + "    <td></td>\n" + "  </tr>\n" + "</table>");

    }

    @BeforeEach
    void everyTest() {
        this.weather.setCity("na");
        this.weather.setCountry("na");
        this.weather.setCondition("na");
        this.weather.setTemp("0.00");
        this.weather.setMinTemp("0.00");
        this.weather.setMaxTemp("0.00");
        this.weather.setWind("0.00");
        this.weather.setWindName("na");
        this.weather.setWindDir("na");
        this.weather.setHumidity("100");
        this.weather.setPressure("1000");
        this.weather.setCloudsName("na");
        this.weather.setLastUpdate("na");
    }

    @Test
    void kelvinCelsiusTest() {
        this.weather.setTemp("200.00");
        assertEquals("200.00", this.weather.getTemp());
    }

    @Test
    void owmRetrieverTest() {
        final OWMRetriever ret = new OWMRetriever();
        final InputStream in = ret.retrieveByCityID("3220838");
        try {
            assertTrue(in.available() > 0);
        } catch (final IOException e) {
            Main.getLog().error("can't retrive OWMWeather");
        }

    }

    @Test
    void xmlFormatterTest() {
        final XMLFormatter xmlFormatter = new XMLFormatter();
        xmlFormatter.format(this.weather);
        final String path = "target/";
        try {
            this.testPath = xmlFormatter.save(path);
        } catch (final IOException e) {
            Main.getLog().error("can't write to file");
        }

        assertTrue(new File(this.testPath.toString()).isFile());
    }

    @Test
    void weatherFormatterTest() {
        final WeatherFormatter testFormatter = new WeatherFormatter();
        assertEquals(this.mockFormatter.format(this.weather),
                testFormatter.format(this.weather));
    }

    @AfterEach
    void cleanEach() {

    }

    @AfterAll
    void cleanUp() {
        try {
            Files.delete(this.testPath);
        } catch (final Exception e) {
            Main.getLog().error("can't clean up testfile");
        }
    }

}
