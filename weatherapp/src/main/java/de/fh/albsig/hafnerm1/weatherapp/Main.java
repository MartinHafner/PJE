package de.fh.albsig.hafnerm1.weatherapp;

import java.io.IOException;
import java.io.InputStream;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

/**
 * @author martin
 *
 */
public class Main {
	/**
	 * error logger.
	 */
	private static Logger log;

	/**
	 * @param args program parameters
	 * @throws Exception no parameters found
	 */
	public static void main(final String[] args) throws Exception {
		setLog(LogManager.getLogger(Main.class));

		String cityid = "3220838";
		try {
			cityid = args[0];
		} catch (final Exception e) {
			getLog().warn("no CityID provided, using: " + cityid);
		}

		try {
			new Main(cityid).start();
		} catch (final Exception e1) {
			getLog().error("can't retrive data for :" + cityid);
		}
	}

	/**
	 * The given City-id.
	 */
	private final String id;

	/**
	 * @param cid City-id
	 */
	public Main(final String cid) {
		setLog(LogManager.getLogger(Main.class));
		this.id = cid;
	}

	/**
	 * @throws Exception Can't get weather
	 */
	public final void start() {
		// Retrieve Data
		final InputStream dataIn = new OWMRetriever().retrieveByCityID(this.id);
		// Parse Data
		final OWMParser owmParser = new OWMParser();
		OWMWeather oWMWeather = null;
		try {
			oWMWeather = owmParser.parse(dataIn);
		} catch (final DocumentException e) {
			getLog().error("can't parse weather to text");
		}

		final XMLFormatter xmlFormatter = new XMLFormatter();
		xmlFormatter.format(oWMWeather);
		final String path = "src/main/resources/";
		try {
			xmlFormatter.save(path);
		} catch (final IOException e) {
			getLog().error("can't save weather under: " + path);
		}

		// Format (Print) Data
		getLog().info(new WeatherFormatter().format(oWMWeather));
	}

	public static Logger getLog() {
		return log;
	}

	public static void setLog(Logger log) {
		Main.log = log;
	}
}
