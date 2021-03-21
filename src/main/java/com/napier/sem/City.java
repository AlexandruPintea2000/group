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
    // Placeholder for SQL Connection
    private Connection con;
    // City ID
    private int cityID;
    // City name
    private String cityName;
    // Country code
    private String countryCode;
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

    public void setCon(Connection con){
        this.con = con;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    /**
     * Returns the name of the city where ID is specified
     * @return
     */
    public String getCityName() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Name from world.city where ID = '" + cityID + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                cityName = rset.getString("Name");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    /**
     * Returns the country code of the city where ID is specified
     * @return
     */
    public String getCountryCode() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select CountryCode from world.city where ID = '" + cityID + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                countryCode = rset.getString("CountryCode");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Returns the district of the city where ID is specified
     * @return
     */
    public String getCityDistrict() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select District from world.city where ID = '" + cityID + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                cityDistrict = rset.getString("District");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityDistrict;
    }

    public void setCityDistrict(String cityDistrict) {
        this.cityDistrict = cityDistrict;
    }

    /**
     * Returns the population of the city where ID is specified
     * @return
     */
    public long getCityPopulation() {
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Population from world.city where ID = '" + cityID + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                cityPopulation = rset.getLong("Population");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityPopulation;
    }

    public void setCityPopulation(long cityPopulation) {
        this.cityPopulation = cityPopulation;
    }

    /**
    Generates a full report of a city where ID is specified, in the following format
    City ID: {cityID}
    City Name: {cityName}
    Country Code: {countryCode}
    City District: {cityDistrict}
    City Population: {cityPopulation}
     */
    public void generateCityReport(){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select * from world.city where ID = '" + cityID + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                cityID = rset.getInt("ID");
                cityName = rset.getString("Name");
                countryCode = rset.getString("CountryCode");
                cityDistrict = rset.getString("District");
                cityPopulation = rset.getLong("Population");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("City ID: " + cityID);
        System.out.println("City Name: " + cityName);
        System.out.println("Country Code: " + countryCode);
        System.out.println("City District: " + cityDistrict);
        System.out.println("City Population: " + cityPopulation);
    }

    /**
     * Generates a list of all cities (ordered from population largest - smallest)
     */
    public void generateLargestToSmallest(){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select ID, Name, Population from world.city order by Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("Name");
                city.cityPopulation = rset.getLong("Population");
                cityList.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("ALL CITIES");
        System.out.println("ID \t\t\t\t Name \t\t\t\t Population");
        for(City city : cityList){
            System.out.println(city.cityID + " \t\t\t\t " + city.cityName + " \t\t\t\t " + city.cityPopulation);
        }
    }

    /**
     * Generates a list of the top N populated cities (where N is specified by the user)
     * @param number
     */
    public void generateTopN(int number){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select ID, Name, Population from world.city order by Population desc limit " + number;
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                City city = new City();
                city.cityID = rset.getInt("ID");
                city.cityName = rset.getString("Name");
                city.cityPopulation = rset.getLong("Population");
                cityList.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("TOP " + number + " POPULATED CITIES");
        System.out.println("ID \t\t\t\t Name \t\t\t\t Population");
        for(City city : cityList){
            System.out.println(city.cityID + " \t\t\t\t " + city.cityName + " \t\t\t\t " + city.cityPopulation);
        }
    }

    /**
     * Generates a list of the cities in a country organised by largest population to smallest
     * @param countryCode
     */
    public void generateCityPopulation(String countryCode){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Name, Population from city where CountryCode = '" + countryCode + "' order by Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                City city = new City();
                city.cityName = rset.getString("Name");
                city.cityPopulation = rset.getLong("Population");
                cityList.add(city);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("CITIES");
        System.out.println("Name \t\t\t\t Population");
        for(City city : cityList){
            System.out.println(city.cityName + " \t\t\t\t " + city.cityPopulation);
        }
    }

    /**
     * Generates a list of all the capital cities in a continent organised by largest population to smallest
     * @param continent
     */
    public void generateCapitalPopulationInContinent(String continent){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select country.Name AS 'Country', city.Name AS 'CapitalCity', city.Population from city inner join country on city.Id = country.capital where Continent = '"+continent+"' order by city.Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                City city = new City();
                city.cityName = rset.getString("CapitalCity");
                city.cityPopulation = rset.getLong("Population");
                cityList.add(city);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("CAPITAL CITIES IN " + continent);
        System.out.println("City \t\t\t\t Population");
        for(City city : cityList){
            System.out.println(city.cityName + " \t\t\t\t " + city.cityPopulation);
        }
    }

    /**
     * Generate a list on the top N populated capital cities in a continent where N is provided by the user
     * @param continent
     * @param number
     */
    public void generateTopNCapitalPopulationInContinent(String continent, int number){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select city.Name AS 'CapitalCity', city.Population from city inner join country on city.Id = country.capital where Continent = '"+continent+"' order by city.Population desc limit " + number;
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                City city = new City();
                city.cityName = rset.getString("CapitalCity");
                city.cityPopulation = rset.getLong("Population");
                cityList.add(city);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("TOP " + number + " POPULATED CAPITAL CITIES IN " + continent);
        System.out.println("City \t\t\t\t Population");
        for(City city : cityList){
            System.out.println(city.cityName + " \t\t\t\t " + city.cityPopulation);
        }
    }

    /**
     * Generate a list of the top N populated capital cities in the world where N is provided by the user
     * @param number
     */
    public void generateTopNCapitalCities(int number){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select city.Name AS 'CapitalCity', city.Population from city inner join country on city.Id = country.capital order by city.Population desc limit " + number;
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                City city = new City();
                city.cityName = rset.getString("CapitalCity");
                city.cityPopulation = rset.getLong("Population");
                cityList.add(city);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("TOP " + number + " POPULATED CAPITAL CITIES IN THE WORLD");
        System.out.println("City \t\t\t\t Population");
        for(City city : cityList){
            System.out.println(city.cityName + " \t\t\t\t " + city.cityPopulation);
        }
    }
}
