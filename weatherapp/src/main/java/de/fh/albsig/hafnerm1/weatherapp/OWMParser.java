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
     * dataIn.
     */
    private InputStream dataIn;

    /**
     * Constructor generating new reader.
     */
    public OWMParser() {
        this.reader = new SAXReader();
    }

    /**
     * @param dataInp InputStream
     * @return weather object
     * @throws DocumentException can't find data in xml
     */
    public final Weather parse(final InputStream dataInp)
            throws DocumentException {
        this.dataIn = dataInp;
        this.document = this.reader.read(this.dataIn);

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
        weather.setMinTemp(minTemp);
        final String maxTemp = this.document
                .valueOf("/current/temperature/@max");
        weather.setMaxTemp(maxTemp);
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

        final String lastUpdate = this.document
                .valueOf("/current/lastupdate/@value");
        weather.setLastUpdate(lastUpdate);

        return weather;
    }

    /**
     * @return xmlFile as String
     * @throws DocumentException can't read stream
     */
    public final String getXML() throws DocumentException {
        this.document = this.reader.read(this.dataIn);
        return this.document.asXML();
    }

}
