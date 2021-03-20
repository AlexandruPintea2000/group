package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class for Continent
 */

public class Continent {
    // Placeholder for SQL connection
    private Connection con = null;
    // Continent Name
    private String continentName;
    // Continent Population
    private long continentPopulation;

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

    // Returns the sum population of a continent
    public long getContinentPopulation() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Continent, sum(Population) as Population from country where Continent = '"+continentName+"'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                continentPopulation = rset.getLong("Population");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return continentPopulation;
    }

    public void setContinentPopulation(long continentPopulation) {
        this.continentPopulation = continentPopulation;
    }
}
