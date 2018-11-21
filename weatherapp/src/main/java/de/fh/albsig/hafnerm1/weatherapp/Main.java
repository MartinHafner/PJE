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
        log = LogManager.getLogger(Main.class);
        // PropertyConfigurator.configure(
        // Main.class.getClassLoader().getResource("log4j.xml"));

        String cityid = "3220838";
        try {
            cityid = args[0];
        } catch (final Exception e) {
            log.warn("no CityID provided, using: " + cityid);
        }

        try {
            new Main(cityid).start();
        } catch (final Exception e1) {
            log.error("can't retrive data for :" + cityid);
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
        Weather weather = null;
        try {
            weather = owmParser.parse(dataIn);
        } catch (final DocumentException e) {
            log.error("can't parse weather to text");
        }

        final XMLFormatter xmlFormatter = new XMLFormatter(weather);
        xmlFormatter.format();
        final String path = "src/main/resources/";
        try {
            xmlFormatter.save(path);
        } catch (final IOException e) {
            log.error("can't save weather under: " + path);
        }

        // Format (Print) Data
        log.info(new WeatherFormatter().format(weather));
    }
}
