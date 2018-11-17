package de.fh.albsig.hafnerm1.weatherapp;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class OWMRetriever {
	private String apiKey = "&APPID=8ba83aa18c2bb895f97b58c588c8cc9c";
	private String baseURL;
	private String mode;
	private static Logger log;
	public OWMRetriever(){
		log = LogManager.getLogger(OWMRetriever.class);
		baseURL = "http://api.openweathermap.org/data/2.5";
		mode = "&mode=xml";
	}

	public InputStream retrieveByCityID(String cityid) throws Exception {
		log.info("Retrieving Weather Data");
		String url = baseURL + "/weather?id=" + cityid +mode+ apiKey;
		//url = "https://samples.openweathermap.org/data/2.5/weather?q=London&mode=xml&appid=b6907d289e10d714a6e88b30761fae22";
		URLConnection conn = new URL(url).openConnection();
		return conn.getInputStream();
	}
}
