package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class for Continent
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class Continent {
    // Placeholder for SQL connection
    private Connection con = null;
    // Continent Name
    private String continentName;
    // Continent Population
    private long continentPopulation;

    /**
     * Constructor for Continent
     */
    public Continent(){

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public long getContinentPopulation() {
        return continentPopulation;
    }

    public void setContinentPopulation(long continentPopulation) {
        this.continentPopulation = continentPopulation;
    }
}
