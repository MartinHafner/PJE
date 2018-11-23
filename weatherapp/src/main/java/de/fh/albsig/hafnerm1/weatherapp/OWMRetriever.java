package de.fh.albsig.hafnerm1.weatherapp;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

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
    private final Logger log;

    /**
     * Constructor.
     */
    public OWMRetriever() {
        this.log = LogManager.getLogger(OWMRetriever.class);
        this.baseURL = "http://api.openweathermap.org/data/2.5";
        this.mode = "&mode=xml";
    }

    /**
     * @param cityid city id
     * @return InputStream from connection
     * @throws Exception can't access weather
     */
    public final InputStream retrieveByCityID(final String cityid) {
        this.log.info("Retrieving OWMWeather Data");
        InputStream downstream = null;
        final String url = this.baseURL + "/weather?id=" + cityid + this.mode
                + this.apiKey;
        URLConnection conn;
        try {
            conn = new URL(url).openConnection();
            downstream = conn.getInputStream();
        } catch (final MalformedURLException e) {
            this.log.error("Malformed URL: " + url);
        } catch (final IOException e) {
            this.log.error("can't get connection");
        }
        return downstream;
    }
}
