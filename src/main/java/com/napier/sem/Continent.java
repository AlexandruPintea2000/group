package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class for Continent
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class Continent {
    // Continent Name
    private String continentName;
    // Continent Population
    private long continentPopulation;

    /**
     * Constructor for Continent
     */
    public Continent(){

    }

    /**
     * Returns the Continent Name
     * @return continentName
     */
    public String getContinentName() {
        return continentName;
    }

    /**
     * Sets a value for Continent Name
     * @param continentName
     */
    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    /**
     * Returns the Continent Population
     * @return continentPopulation
     */
    public long getContinentPopulation() {
        return continentPopulation;
    }

    /**
     * Sets a value for Continent Population
     * @param continentPopulation
     */
    public void setContinentPopulation(long continentPopulation) {
        this.continentPopulation = continentPopulation;
    }
}
