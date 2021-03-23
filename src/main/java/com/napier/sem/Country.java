package com.napier.sem;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class for Country
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class Country {
    // Placeholder for SQL connection
    private Connection con = null;
    // Country code
    private String countryCode;
    // Country name
    private String countryName;
    // Country continent
    private String countryContinent;
    // Country region
    private String countryRegion;
    // Country population
    private long countryPopulation;
    // Country capital
    private int countryCapital;

    /**
     * Country Constructor
     * @param countryCode
     * @param countryName
     * @param countryContinent
     * @param countryRegion
     * @param countryPopulation
     * @param countryCapital
     */
    public Country(String countryCode, String countryName, String countryContinent, String countryRegion, long countryPopulation, int countryCapital){
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryContinent = countryContinent;
        this.countryRegion = countryRegion;
        this.countryPopulation = countryPopulation;
        this.countryCapital = countryCapital;
    }

    /**
     * Country Constructor
     */
    public Country(){

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCountryContinent() {
        return countryContinent;
    }

    public void setCountryContinent(String countryContinent) {
        this.countryContinent = countryContinent;
    }

    public String getCountryRegion() {
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    public long getCountryPopulation() {
        return countryPopulation;
    }

    public void setCountryPopulation(long countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    public int getCountryCapital() {
        return countryCapital;
    }

    public void setCountryCapital(int countryCapital) {
        this.countryCapital = countryCapital;
    }
}
