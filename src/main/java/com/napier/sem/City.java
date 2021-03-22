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

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public int getCityID() {
        return cityID;
    }

    public void setCityID(int cityID) {
        this.cityID = cityID;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCityDistrict() {
        return cityDistrict;
    }

    public void setCityDistrict(String cityDistrict) {
        this.cityDistrict = cityDistrict;
    }

    public long getCityPopulation() {
        return cityPopulation;
    }

    public void setCityPopulation(long cityPopulation) {
        this.cityPopulation = cityPopulation;
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
     * Generates a list on all the cities in a continent organised by largest population to smallest
     * @param continent
     */
    public void generateCityPopulationInContinent(String continent){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select city.Name AS 'City', country.Name AS 'Country', city.Population from city inner join country on city.CountryCode = country.Code where country.Continent = '"+continent+"' order by city.Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                City city = new City();
                city.cityName = rset.getString("City");
                city.countryName = rset.getString("Country");
                city.cityPopulation = rset.getLong("Population");
                cityList.add(city);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        System.out.println("CITY REPORTS IN " + continent);
        System.out.println("City \t\t\t\t Country \t\t\t\t Population");
        for(City city : cityList){
            System.out.println(city.cityName + " \t\t\t\t " + city.countryName + " \t\t\t\t " + city.cityPopulation);
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
