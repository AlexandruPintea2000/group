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
    private int countryCapital;

    public Country(String countryCode, String countryName, String countryContinent, String countryRegion, long countryPopulation, int countryCapital){
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

    public String getCountryName(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Name from world.country where Code = '" + countryCode + "'";
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
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Continent from world.country where Code = '" + countryCode + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                countryContinent = rset.getString("Continent");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryContinent;
    }

    public void setCountryContinent(String countryContinent){
        this.countryContinent = countryContinent;
    }

    public String getCountryRegion(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Region from world.country where Code = '" + countryCode + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                countryRegion = rset.getString("Region");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryRegion;
    }

    public void setCountryRegion(String countryRegion){
        this.countryRegion = countryRegion;
    }

    public long getCountryPopulation(){
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

    public int getCountryCapital(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Capital from world.country where Code = '" + countryCode + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                countryCapital = rset.getInt("Capital");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryCapital;
    }

    public void setCountryCapital(int countryCapital){
        this.countryCapital = countryCapital;
    }

    public void generateCountryReport(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select * from world.country where Code = '" + countryCode + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                countryName = rset.getString("Name");
                countryContinent = rset.getString("Continent");
                countryRegion = rset.getString("Region");
                countryPopulation = rset.getLong("Population");
                countryCapital = rset.getInt("Capital");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Country Code: " + countryCode);
        System.out.println("Country Name: " + countryName);
        System.out.println("Country Continent: " + countryContinent);
        System.out.println("Country Region: " + countryRegion);
        System.out.println("Country Population: " + countryPopulation);
        System.out.println("Country Capital: " + countryCapital);
    }
}
