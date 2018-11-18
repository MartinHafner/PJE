package de.fh.albsig.hafnerm1.weatherapp;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author martin
 *
 */
public class OWMRetriever {
    /**
     * apiKey for permission to use weatherAPI.
     */
    private final String apiKey = "&APPID=8ba83aa18c2bb895f97b58c588c8cc9c";
    /**
     * URL to the OWM site.
     */
    private final String baseURL;
    /**
     * specifies format.
     */
    private final String mode;
    /**
     * info Logger.
     */
    private static Logger log;

    /**
     * Constructor.
     */
    public OWMRetriever() {
        log = LogManager.getLogger(OWMRetriever.class);
        this.baseURL = "http://api.openweathermap.org/data/2.5";
        this.mode = "&mode=xml";
    }

    /**
     * @param cityid city id
     * @return InputStream from connection
     * @throws Exception can't access weather
     */
    public final InputStream retrieveByCityID(final String cityid)
            throws Exception {
        log.info("Retrieving Weather Data");
        final String url = this.baseURL + "/weather?id=" + cityid + this.mode
                + this.apiKey;
        final URLConnection conn = new URL(url).openConnection();
        return conn.getInputStream();
    }
}
