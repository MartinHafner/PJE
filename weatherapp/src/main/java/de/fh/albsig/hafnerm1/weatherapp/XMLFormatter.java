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
public class XMLFormatter implements Formatter<OWMWeather, String> {

	/**
	 * oWMWeather object to be converted.
	 */
	private OWMWeather oWMWeather;

	/**
	 * document for generating xml.
	 */
	private final Document document;

	/**
	 * @param weatherp oWMWeather
	 */
	public XMLFormatter() {
		this.document = DocumentHelper.createDocument();
	}

	/**
	 * @return XML String
	 */
	public final String format(final OWMWeather weatherp) {
		this.oWMWeather = weatherp;
		final Element rootTag = this.document.addElement("oWMWeather");

		final Element locationTag = rootTag.addElement("location");
		locationTag.addText(this.oWMWeather.getCity() + "," + this.oWMWeather.getCountry());

		final Element conditionTag = rootTag.addElement("condition");
		conditionTag.addText(this.oWMWeather.getCondition() + ", " + this.oWMWeather.getCloudsName());

		final Element tempTag = rootTag.addElement("temperature");

		final Element maxtempTag = tempTag.addElement("max");
		maxtempTag.addText(this.oWMWeather.getMaxTempC());

		final Element avgtempTag = tempTag.addElement("avg");
		avgtempTag.addText(this.oWMWeather.getTempC());

		final Element mintempTag = tempTag.addElement("min");
		mintempTag.addText(this.oWMWeather.getMinTempC());

		final Element humidityTag = rootTag.addElement("humidity");
		humidityTag.addText(this.oWMWeather.getHumidity());

		final Element pressureTag = rootTag.addElement("pressure");
		pressureTag.addText(this.oWMWeather.getPressure());

		final Element windTag = rootTag.addElement("wind");

		final Element speedTag = windTag.addElement("speed");
		speedTag.addText(this.oWMWeather.getWind());

		final Element dirTag = windTag.addElement("direction");
		dirTag.addText(this.oWMWeather.getWindDir());

		final Element windnameTag = windTag.addElement("name");
		windnameTag.addText(this.oWMWeather.getWindName());

		final Element lastupdateTag = rootTag.addElement("lastupdate");
		lastupdateTag.addText(this.oWMWeather.getLastUpdate());

		return this.document.asXML();
	}

	/**
	 * @param path savelocation
	 * @throws IOException can't save
	 * @return fullPath full Path to saved File
	 */
	public final Path save(final String path) throws IOException {
		final Path fullPath = Paths.get(path + this.oWMWeather.getCountry() + "_" + this.oWMWeather.getCity() + "_"
				+ this.oWMWeather.getLastUpdate() + ".xml");
		Files.write(fullPath, this.document.asXML().getBytes(StandardCharsets.UTF_8));
		return fullPath;
	}

}
