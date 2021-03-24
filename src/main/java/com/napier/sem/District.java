package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class for District
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class District {
    // District Name
    private String districtName;
    // District Population
    private long districtPopulation;

    /**
     * District Constructor
     * @param districtName
     */
    public District(String districtName){
        this.districtName = districtName;
    }

    /**
     * District Constructor
     */
    public District(){

    }

    /**
     * Returns the District Name
     * @return districtName
     */
    public String getDistrictName() {
        return districtName;
    }

    /**
     * Sets a value for District Name
     * @param districtName
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * Returns the District Population
     * @return districtPopulation
     */
    public long getDistrictPopulation() {
        return districtPopulation;
    }

    /**
     * Sets a value for the District Population
     * @param districtPopulation
     */
    public void setDistrictPopulation(long districtPopulation) {
        this.districtPopulation = districtPopulation;
    }
}
