package de.fh.albsig.hafnerm1.weatherapp;

public interface Formatter<T, R> {

	R format(T in);
	
}
