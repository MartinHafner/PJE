package de.fh.albsig.hafnerm1.weatherapp;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @author martin
 *
 */
public class OWMParser {

    /**
     * SAXReader.
     */
    private final SAXReader reader;
    /**
     * document.
     */
    private Document document;

    /**
     * Constructor generating new reader.
     */
    public OWMParser() {
        this.reader = new SAXReader();
    }

    /**
     * @param dataIn InputStream
     * @return weather object
     * @throws DocumentException can't find data in xml
     */
    public final Weather parse(final InputStream dataIn)
            throws DocumentException {
        this.document = this.reader.read(dataIn);
        System.out.println(this.document.asXML());

        final Weather weather = new Weather();

        final String city = this.document.valueOf("/current/city/@name");
        weather.setCity(city);
        final String country = this.document
                .valueOf("/current/city/country/text()");
        weather.setCountry(country);
        final String condition = this.document
                .valueOf("/current/weather/@value");
        weather.setCondition(condition);
        final String temp = this.document
                .valueOf("/current/temperature/@value");
        weather.setTemp(temp);
        final String minTemp = this.document
                .valueOf("/current/temperature/@min");
        weather.setMaxTemp(minTemp);
        final String maxTemp = this.document
                .valueOf("/current/temperature/@max");
        weather.setMinTemp(maxTemp);
        final String wind = this.document.valueOf("/current/wind/speed/@value");
        weather.setWind(wind);
        final String windName = this.document
                .valueOf("/current/wind/speed/@name");
        weather.setWindName(windName);
        final String windDir = this.document
                .valueOf("/current/wind/direction/@name");
        weather.setWindDir(windDir);
        final String humidity = this.document
                .valueOf("/current/humidity/@value");
        weather.setHumidity(humidity);
        final String pressure = this.document
                .valueOf("/current/pressure/@value");
        weather.setPressure(pressure);
        final String cloudsName = this.document
                .valueOf("/current/clouds/@name");
        weather.setCloudsName(cloudsName);

        return weather;
    }

    /**
     * @param dataIn InputStream
     * @return xmlFile as String
     * @throws DocumentException can't read stream
     */
    public final String getXML(final InputStream dataIn)
            throws DocumentException {
        this.document = this.reader.read(dataIn);
        return this.document.asXML();
    }

}
