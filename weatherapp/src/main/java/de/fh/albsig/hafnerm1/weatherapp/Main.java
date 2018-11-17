package de.fh.albsig.hafnerm1.weatherapp;

import java.io.InputStream;

public class Main {
	public static void main(String[] args) throws Exception {
		// Read the zip code from the command line
		// (if none supplied, use 60202)
		String cityid = "2172797";
		try {
			cityid = args[0];
		} catch (Exception e) {
		}
		// Start the program
		new Main(cityid).start();
	}

	private String id;

	public Main(String id) {
		this.id = id;
	}

	public void start() throws Exception {
		// Retrieve Data
		InputStream dataIn = new OWMRetriever().retrieveByCityID(id);
		// Parse Data
		Weather weather = new OWMParser().parse(dataIn);
		// Format (Print) Data
		System.out.print(new WeatherFormatter().format(weather));
	}
}