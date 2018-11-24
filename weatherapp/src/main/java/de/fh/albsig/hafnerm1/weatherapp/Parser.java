package de.fh.albsig.hafnerm1.weatherapp;

import org.dom4j.DocumentException;

public interface Parser <T,R>{

	R parse(T dataInp) throws DocumentException;
}
