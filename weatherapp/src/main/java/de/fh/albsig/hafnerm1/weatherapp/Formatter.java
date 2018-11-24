package de.fh.albsig.hafnerm1.weatherapp;

/**
 * @author martin
 *
 * @param <T>
 * @param <R>
 */
public interface Formatter<T, R> {

    /**
     * @param in input
     * @return output
     */
    R format(T in);

}
