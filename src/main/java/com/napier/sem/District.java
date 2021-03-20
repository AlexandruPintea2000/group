package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * CLass for District
 */

public class District {
    // Placeholder for SQL connection
    private Connection con = null;
    // District Name
    private String districtName;
    // District Population
    private long districtPopulation;

    public District(){

    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    // Returns the population of a district
    public long getDistrictPopulation() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select District, sum(Population) as Population from city where District = '"+districtName+"'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                districtPopulation = rset.getLong("Population");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return districtPopulation;
    }

    public void setDistrictPopulation(long districtPopulation) {
        this.districtPopulation = districtPopulation;
    }
}
