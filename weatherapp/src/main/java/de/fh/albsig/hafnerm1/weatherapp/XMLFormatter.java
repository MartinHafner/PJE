package de.fh.albsig.hafnerm1.weatherapp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

/**
 * @author martin
 *
 */
public class XMLFormatter {

    /**
     * weather object to be converted.
     */
    private final OWMWeather weather;

    /**
     * document for generating xml.
     */
    private final Document document;

    /**
     * @param weatherp weather
     */
    public XMLFormatter(final OWMWeather weatherp) {
        this.weather = weatherp;
        this.document = DocumentHelper.createDocument();
    }

    /**
     * @return XML String
     */
    public final String format() {
        final Element rootTag = this.document.addElement("weather");

        final Element locationTag = rootTag.addElement("location");
        locationTag.addText(
                this.weather.getCity() + "," + this.weather.getCountry());

        final Element conditionTag = rootTag.addElement("condition");
        conditionTag.addText(this.weather.getCondition() + ", "
                + this.weather.getCloudsName());

        final Element tempTag = rootTag.addElement("temperature");

        final Element maxtempTag = tempTag.addElement("max");
        maxtempTag.addText(String.valueOf(this.weather.getMaxTempInCelsius()));

        final Element avgtempTag = tempTag.addElement("avg");
        avgtempTag.addText(String.valueOf(this.weather.getTempInCelsius()));

        final Element mintempTag = tempTag.addElement("min");
        mintempTag.addText(String.valueOf(this.weather.getMinTempInCelsius()));

        final Element humidityTag = rootTag.addElement("humidity");
        humidityTag
                .addText(String.valueOf(this.weather.getHumidityInPercent()));

        final Element pressureTag = rootTag.addElement("pressure");
        pressureTag.addText(String.valueOf(this.weather.getPressureInHPA()));

        final Element windTag = rootTag.addElement("wind");

        final Element speedTag = windTag.addElement("speed");
        speedTag.addText(String.valueOf(this.weather.getWindInKMH()));

        final Element dirTag = windTag.addElement("direction");
        dirTag.addText(this.weather.getWindDir());

        final Element windnameTag = windTag.addElement("name");
        windnameTag.addText(this.weather.getWindName());

        final Element lastupdateTag = rootTag.addElement("lastupdate");
        lastupdateTag.addText(this.weather.getLastUpdate().toString());

        return this.document.asXML();
    }

    /**
     * @param path savelocation
     * @throws IOException can't save
     * @return fullPath full Path to saved File
     */
    public final Path save(final String path) throws IOException {
        final Path fullPath = Paths.get(
                path + this.weather.getCountry() + "_" + this.weather.getCity()
                        + "_" + this.weather.getLastUpdate() + ".xml");
        Files.write(fullPath,
                this.document.asXML().getBytes(StandardCharsets.UTF_8));
        return fullPath;
    }

}
