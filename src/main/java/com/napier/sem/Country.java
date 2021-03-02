package com.napier.sem;

import javax.xml.transform.Result;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/**
 * Class for Country
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

    // Country constructor to initialise an instance of Country object (holding information regarding code, name, continent, region, population and capital
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

    // Returns the name of a country where code is specified
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

    // Returns continent of a country where code is specified
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

    // Returns region of a country where code is specified
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

    // Returns the population of a country where code is specified
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

    // Returns the capital of a country where code is specified
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

    /*
    Generates a full report of a country where code is specified, in the following format
    Country Code: {countryCode}
    Country Name: {countryName}
    Country Continent: {countryContinent}
    Country Region: {countryRegion}
    Country Population: {countryPopulation}
    Country Capital: {countryCapital}
     */
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

    /*
    Generates a list of all countries (ordered from population largest - smallest) stored in the database in the following format
    Code            Name            Population
    {countryCode}   {countryName}   {countryPopulation}
    {countryCode}   {countryName}   {countryPopulation}
    {countryCode}   {countryName}   {countryPopulation}
     */
    public void generateLargestToSmallest(){
        ArrayList<Country> countryList = new ArrayList<Country>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Code, Name, Population from world.country order by Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                Country ctry = new Country();
                ctry.countryCode = rset.getString("Code");
                ctry.countryName = rset.getString("Name");
                ctry.countryPopulation = rset.getLong("Population");
                countryList.add(ctry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Code \t\t\t\t Name \t\t\t\t Population");
        for(Country ctry : countryList){
            System.out.println(ctry.countryCode + " \t\t\t\t " + ctry.countryName + " \t\t\t\t " + ctry.countryPopulation);
        }
    }

    public void generateTopN(int number){
        ArrayList<Country> countryList = new ArrayList<Country>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Code, Name, Population from world.country order by Population desc limit " + number;
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                Country ctry = new Country();
                ctry.countryCode = rset.getString("Code");
                ctry.countryName = rset.getString("Name");
                ctry.countryPopulation = rset.getLong("Population");
                countryList.add(ctry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("TOP " + number + " POPULATED COUNTRIES");
        System.out.println("Code \t\t\t\t Name \t\t\t\t Population");
        for(Country ctry : countryList){
            System.out.println(ctry.countryCode + " \t\t\t\t " + ctry.countryName + " \t\t\t\t " + ctry.countryPopulation);
        }
    }
}
