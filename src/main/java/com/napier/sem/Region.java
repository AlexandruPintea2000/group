package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class for Region
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class Region {
    // Region Name
    private String regionName;
    // Region Population
    private long regionPopulation;

    /**
     * Region Constructor
     * @param regionName
     */
    public Region(String regionName){
        this.regionName = regionName;
    }

    /**
     * Region Constructor
     */
    public Region(){

    }

    /**
     * Returns the Region Name
     * @return regionName
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * Sets a value for the Region Name
     * @param regionName
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * Returns the Region Population
     * @return regionPopulation
     */
    public long getRegionPopulation() {
        return regionPopulation;
    }

    /**
     * Sets a value for Region Population
     * @param regionPopulation
     */
    public void setRegionPopulation(long regionPopulation) {
        this.regionPopulation = regionPopulation;
    }
}
