package com.napier.sem;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Class for Country
 */
public class Country {
    private Connection con = null;
    private String countryCode;
    private String countryName;
    private String countryContinent;
    private String countryRegion;
    private int countryPopulation;
    private String countryCapital;

    public Country(String countryCode, String countryName, String countryContinent, String countryRegion, int countryPopulation, String countryCapital){
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryContinent = countryContinent;
        this.countryRegion = countryRegion;
        this.countryPopulation = countryPopulation;
        this.countryCapital = countryCapital;
    }

    public Country(String countryCode){
        this.countryCode = countryCode;
    }

    public Country(){

    }

    public long getCountryPopulation(String code){
        long countryPopulation = 0L;

        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Population from world.country where code = " + code + "";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                countryPopulation = rset.getLong("Population");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countryPopulation;
    }
}
