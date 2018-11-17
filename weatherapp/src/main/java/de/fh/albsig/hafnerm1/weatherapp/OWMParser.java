package de.fh.albsig.hafnerm1.weatherapp;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

public class OWMParser {
	
	private SAXReader reader;
	private Document document;
	
	

	public Weather parse(InputStream dataIn) throws DocumentException {
		this.reader = new SAXReader();
		this.document = this.reader.read(dataIn);
		//System.out.println(this.document.asXML());
		
		Weather weather = new Weather();
		String city = this.document.selectSingleNode("/current/city").valueOf("@name");
		weather.setCity(city);
		String country = this.document.valueOf("/current/city/country/text()");
		weather.setCountry(country);
		weather.setCondition("-");//TODO
		String temp = this.document.selectSingleNode("/current/city").valueOf("@value");
		weather.setTemp(temp);
		weather.setChill("-"); //TODO
		String humidity = this.document.selectSingleNode("/current/humidity").valueOf("@value");
		weather.setHumidity(humidity);
		
		return weather;
	}

}
