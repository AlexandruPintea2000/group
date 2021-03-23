package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class for City
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class City {
    // City ID
    private int cityID;
    // City name
    private String cityName;
    // Country code
    private String countryCode;
    // Country name
    private String countryName;
    // City district
    private String cityDistrict;
    // City population
    private long cityPopulation;

    /**
     * City Constructor
     * @param cityID
     * @param cityName
     * @param countryCode
     * @param cityDistrict
     * @param cityPopulation
     */
    public City(int cityID, String cityName, String countryCode, String cityDistrict, long cityPopulation){
        this.cityID = cityID;
        this.cityName = cityName;
        this.countryCode = countryCode;
        this.cityDistrict = cityDistrict;
        this.cityPopulation = cityPopulation;
    }

    /**
     * City Constructor
     */
    public City(){

    }

    /**
     * Returns the City ID
     * @return cityID
     */
    public int getCityID() {
        return cityID;
    }

    /**
     * Sets a value for City ID
     * @param cityID
     */
    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    /**
     * Returns the City Name
     * @return cityName
     */
    public String getCityName() {
        return cityName;
    }

    /**
     * Sets a value for City Name
     * @param cityName
     */
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Returns the Country Code
     * @return countryCode
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets a value for Country Code
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
     * Sets a value for Country Name
     * @param countryName
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Returns the City District
     * @return cityDistrict
     */
    public String getCityDistrict() {
        return cityDistrict;
    }

    /**
     * Sets a value for City District
     * @param cityDistrict
     */
    public void setCityDistrict(String cityDistrict) {
        this.cityDistrict = cityDistrict;
    }

    /**
     * Returns the City Population
     * @return cityPopulation
     */
    public long getCityPopulation() {
        return cityPopulation;
    }

    /**
     * Sets a value for City Population
     * @param cityPopulation
     */
    public void setCityPopulation(long cityPopulation) {
        this.cityPopulation = cityPopulation;
    }
}
