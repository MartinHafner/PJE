package de.fh.albsig.hafnerm1.weatherapp;

import java.io.InputStream;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

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
        String cityid = "3220838";
        try {
            cityid = args[0];
        } catch (final Exception e) {
            log.warn("no CityID provided, using: " + cityid);
        }
        new Main(cityid).start();
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
    public final void start() throws Exception {
        // Retrieve Data
        final InputStream dataIn = new OWMRetriever().retrieveByCityID(this.id);
        // Parse Data
        final Weather weather = new OWMParser().parse(dataIn);
        // Format (Print) Data
        System.out.print(new WeatherFormatter().format(weather));
    }
}
