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
    private long countryPopulation;
    private String countryCapital;

    public Country(String countryCode, String countryName, String countryContinent, String countryRegion, long countryPopulation, String countryCapital){
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.countryContinent = countryContinent;
        this.countryRegion = countryRegion;
        this.countryPopulation = countryPopulation;
        this.countryCapital = countryCapital;
    }

    public Country(){

    }

    public void setCon(Connection con){
        this.con = con;
    }

    public String getCountryCode(){
        return countryCode;
    }

    public void setCountryCode(String countryCode){
        this.countryCode = countryCode;
    }

    public String getCountryName(String countryCode){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Name from world.country where code = '" + countryCode + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                countryName = rset.getString("Name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countryName;
    }

    public void setCountryName(String countryName){
        this.countryName = countryName;
    }

    public String getCountryContinent(){
        return countryContinent;
    }

    public void setCountryContinent(String countryContinent){
        this.countryContinent = countryContinent;
    }

    public String getCountryRegion(){
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion){
        this.countryRegion = countryRegion;
    }

    public long getCountryPopulation(String countryCode){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Population from world.country where code = '" + countryCode + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                countryPopulation = rset.getLong("Population");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return countryPopulation;
    }

    public void setCountryPopulation(long countryPopulation){
        this.countryPopulation = countryPopulation;
    }

    public String getCountryCapital(){
        return countryCapital;
    }

    public void setCountryCapital(String countryCapital){
        this.countryCapital = countryCapital;
    }
}
