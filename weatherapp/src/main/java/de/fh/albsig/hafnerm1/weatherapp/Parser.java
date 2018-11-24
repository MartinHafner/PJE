package de.fh.albsig.hafnerm1.weatherapp;

import org.dom4j.DocumentException;

/**
 * @author martin
 *
 * @param <T>
 * @param <R>
 */
public interface Parser<T, R> {

    /**
     * @param dataInp input
     * @return output
     * @throws DocumentException can't create dokument
     */
    R parse(T dataInp) throws DocumentException;
}
