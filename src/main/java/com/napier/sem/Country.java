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

    /**
     * Returns the Country Code
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets a value for the Country Code
     * @param countryCode
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Returns the Country Name
     * @return countryName
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets a value for the Country Name
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Returns the Country Continent
     * @return countryContinent
     */
    public String getCountryContinent() {
        return countryContinent;
    }

    /**
     * Sets a value for Country Continent
     * @param countryContinent
     */
    public void setCountryContinent(String countryContinent) {
        this.countryContinent = countryContinent;
    }

    /**
     * Returns the Country Region
     * @return countryRegion
     */
    public String getCountryRegion() {
        return countryRegion;
    }

    /**
     * Sets a value for Country Region
     * @param countryRegion
     */
    public void setCountryRegion(String countryRegion) {
        this.countryRegion = countryRegion;
    }

    /**
     * Returns the Country Population
     * @return countryPopulation
     */
    public long getCountryPopulation() {
        return countryPopulation;
    }

    /**
     * Sets a value for Country Population
     * @param countryPopulation
     */
    public void setCountryPopulation(long countryPopulation) {
        this.countryPopulation = countryPopulation;
    }

    /**
     * Returns the Country Capital
     * @return countryCapital
     */
    public int getCountryCapital() {
        return countryCapital;
    }

    /**
     * Sets a value for Country Capital
     * @param countryCapital
     */
    public void setCountryCapital(int countryCapital) {
        this.countryCapital = countryCapital;
    }
}
