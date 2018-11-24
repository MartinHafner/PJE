package de.fh.albsig.hafnerm1.weatherapp;

import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.dom4j.DocumentException;

/**
 * @author martin
 *
 */
public class OWMProvider {

    /**
     * logger.
     */
    private static Logger logger;

    /**
     * id.
     */
    private String id;

    /**
     * Konstruktor.
     */
    public OWMProvider() {
        logger = LogManager.getLogger(OWMProvider.class);
    }

    /**
     * @param cityid cityID
     * @return weather html
     */
    public final String provideWeather(final String cityid) {
        this.id = cityid;
        String ret = "invalid location";

        if (StringUtils.containsOnly(this.id, "1234567890")) {
            // Retrieve Data
            final InputStream dataIn = new OWMRetriever()
                    .retrieveByCityID(this.id);
            // Parse Data
            final OWMParser owmParser = new OWMParser();

            final WeatherFormatter wFormatter = new WeatherFormatter();

            OWMWeather oWMWeather = null;

            try {
                oWMWeather = owmParser.parse(dataIn);
            } catch (final DocumentException e) {
                logger.error("can't parse weather to text" + e.getMessage());
            }

            // Format (Print) Data
            ret = wFormatter.format(oWMWeather);
            logger.info(this.id + " : " + ret);

        }

        return ret;
    }

}
