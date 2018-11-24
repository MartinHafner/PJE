package de.fh.albsig.hafnerm1.weatherapp;

import java.io.IOException;
import java.io.InputStream;

import org.dom4j.DocumentException;

public class OWMProvider {

	private String id;

	public final String provideWeather(String id) {
		this.id = id;
		
		String ret;
		// Retrieve Data
		final InputStream dataIn = new OWMRetriever().retrieveByCityID(this.id);
		// Parse Data
		final OWMParser owmParser = new OWMParser();
		
		WeatherFormatter wFormatter = new WeatherFormatter();
		
		OWMWeather oWMWeather = null;
		try {
			oWMWeather = owmParser.parse(dataIn);
		} catch (final DocumentException e) {
			Main.getLog().error("can't parse weather to text");
		}

		// Format (Print) Data
		ret = wFormatter.format(oWMWeather);
			Main.getLog().info(this.id +" : "+ ret);
			
		return ret;
	}
	
}
