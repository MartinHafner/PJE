package de.fh.albsig.hafnerm1.weatherapp;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

/**
 * @author martin
 *
 */
public class OWMParser implements Parser<InputStream, OWMWeather> {

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
    @Override
    public final OWMWeather parse(final InputStream dataInp)
            throws DocumentException {
        this.dataIn = dataInp;
        this.document = this.reader.read(this.dataIn);

        final OWMWeather oWMWeather = new OWMWeather();

        final String city = this.document.valueOf("/current/city/@name");
        oWMWeather.setCity(city);
        final String country = this.document
                .valueOf("/current/city/country/text()");
        oWMWeather.setCountry(country);
        final String condition = this.document
                .valueOf("/current/weather/@value");
        oWMWeather.setCondition(condition);
        final String temp = this.document
                .valueOf("/current/temperature/@value");
        oWMWeather.setTemp(temp);
        final String minTemp = this.document
                .valueOf("/current/temperature/@min");
        oWMWeather.setMinTemp(minTemp);
        final String maxTemp = this.document
                .valueOf("/current/temperature/@max");
        oWMWeather.setMaxTemp(maxTemp);
        final String wind = this.document.valueOf("/current/wind/speed/@value");
        oWMWeather.setWind(wind);
        final String windName = this.document
                .valueOf("/current/wind/speed/@name");
        oWMWeather.setWindName(windName);
        final String windDir = this.document
                .valueOf("/current/wind/direction/@name");
        oWMWeather.setWindDir(windDir);
        final String humidity = this.document
                .valueOf("/current/humidity/@value");
        oWMWeather.setHumidity(humidity);
        final String pressure = this.document
                .valueOf("/current/pressure/@value");
        oWMWeather.setPressure(pressure);
        final String cloudsName = this.document
                .valueOf("/current/clouds/@name");
        oWMWeather.setCloudsName(cloudsName);

        final String lastUpdate = this.document
                .valueOf("/current/lastupdate/@value");
        oWMWeather.setLastUpdate(lastUpdate);

        return oWMWeather;
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
