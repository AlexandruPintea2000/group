package com.napier.sem;

import java.sql.*;
import java.util.ArrayList;

public class App {
    private Connection con = null;

    public static void main(String[] args) {
        // Create new Application
        App app = new App();

        // Establishing SQL connection for objects
        if (args.length < 1)
        {
            app.connect("db:3306");
        }
        else
        {
            app.connect(args[0]);
        }
        City city = new City();
        city.setCityID(4079);

        app.generateCityReport(city);
        app.printCityList(app.generateCityLargestToSmallest());
        app.printCityList(app.generateCapitalPopulationInContinent("Asia"));
        app.printCityList(app.generateCityPopulation("IND"));
        app.printCityList(app.generateCityPopulationInContinent("Europe"));
        app.printCityList(app.generateCityTopN(5));
        app.printCityList(app.generateTopNCapitalCities(5));
        app.disconnect();
    }

    /**
     * Connect to the MySQL database.
     */
    public void connect(String location)
    {
        try
        {
            // Load Database driver
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch (ClassNotFoundException e)
        {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i)
        {
            System.out.println("Connecting to database...");
            try
            {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://" + location + "/world?allowPublicKeyRetrieval=true&useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            }
            catch (SQLException sqle)
            {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            }
            catch (InterruptedException ie)
            {
                System.out.println("Thread interrupted? Should not happen.");
            }
        }
    }

    /**
     * Disconnect from the MySQL database.
     */
    public void disconnect() {
        if (con != null) {
            try {
                // Close connection
                con.close();
            } catch (Exception e) {
                System.out.println("Error closing connection to database");
            }
        }
    }

    /**
     *******************************************************************************************************************
     ********************************************** METHODS FOR CITY ***************************************************
     *******************************************************************************************************************
     */

    /**
     Generates a full report of a city where ID is specified, in the following format
     City ID: {cityID}
     City Name: {cityName}
     Country Code: {countryCode}
     City District: {cityDistrict}
     City Population: {cityPopulation}
     */
    public void generateCityReport(City city){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select * from world.city where ID = '" + city.getCityID() + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                city.setCityID(rset.getInt("ID"));
                city.setCityName(rset.getString("Name"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setCityDistrict(rset.getString("District"));
                city.setCityPopulation(rset.getLong("Population"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("City ID: " + city.getCityID());
        System.out.println("City Name: " + city.getCityName());
        System.out.println("Country Code: " + city.getCountryCode());
        System.out.println("City District: " + city.getCityDistrict());
        System.out.println("City Population: " + city.getCityPopulation());
    }


    /**
     * Generates a list of all cities (ordered from population largest - smallest)
     */
    public ArrayList<City> generateCityLargestToSmallest(){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select ID, CountryCode, Name, Population from world.city order by Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                City city = new City();
                city.setCityID(rset.getInt("ID"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setCityName(rset.getString("Name"));
                city.setCityPopulation(rset.getLong("Population"));
                cityList.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityList;
    }

    /**
     * Generates a list of the top N populated cities (where N is specified by the user)
     * @param number
     */
    public ArrayList<City> generateCityTopN(int number){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select ID, CountryCode, Name, Population from world.city order by Population desc limit " + number;
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                City city = new City();
                city.setCityID(rset.getInt("ID"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setCityName(rset.getString("Name"));
                city.setCityPopulation(rset.getLong("Population"));
                cityList.add(city);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return cityList;
    }

    /**
     * Generates a list of the cities in a country organised by largest population to smallest
     * @param countryCode
     */
    public ArrayList<City> generateCityPopulation(String countryCode){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select ID, CountryCode, Name, Population from city where CountryCode = '" + countryCode + "' order by Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                City city = new City();
                city.setCityID(rset.getInt("ID"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setCityName(rset.getString("Name"));
                city.setCityPopulation(rset.getLong("Population"));
                cityList.add(city);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return cityList;
    }

    /**
     * Generates a list on all the cities in a continent organised by largest population to smallest
     * @param continent
     */
    public ArrayList<City> generateCityPopulationInContinent(String continent){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select city.ID AS 'ID', city.CountryCode AS 'CountryCode', city.Name AS 'City', country.Name AS 'Country', city.Population from city inner join country on city.CountryCode = country.Code where country.Continent = '"+continent+"' order by city.Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                City city = new City();
                city.setCityID(rset.getInt("ID"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setCityName(rset.getString("City"));
                city.setCityPopulation(rset.getLong("Population"));
                cityList.add(city);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return cityList;
    }

    /**
     * Generates a list of all the capital cities in a continent organised by largest population to smallest
     * @param continent
     */
    public ArrayList<City> generateCapitalPopulationInContinent(String continent){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select country.Name AS 'Country', city.ID AS 'ID', city.CountryCode AS 'CountryCode', city.Name AS 'CapitalCity', city.Population from city inner join country on city.Id = country.capital where Continent = '"+continent+"' order by city.Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                City city = new City();
                city.setCityID(rset.getInt("ID"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setCityName(rset.getString("CapitalCity"));
                city.setCityPopulation(rset.getLong("Population"));
                cityList.add(city);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return cityList;
    }

    /**
     * Generate a list on the top N populated capital cities in a continent where N is provided by the user
     * @param continent
     * @param number
     */
    public ArrayList<City> generateTopNCapitalPopulationInContinent(String continent, int number){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select city.ID AS 'ID', city.CountryCode AS 'CountryCode', city.Name AS 'CapitalCity', city.Population from city inner join country on city.Id = country.capital where Continent = '"+continent+"' order by city.Population desc limit " + number;
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()){
                City city = new City();
                city.setCityID(rset.getInt("ID"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setCityName(rset.getString("CapitalCity"));
                city.setCityPopulation(rset.getLong("Population"));
                cityList.add(city);
            }
        } catch(Exception e){
            e.printStackTrace();
        }
        return cityList;
    }

    /**
     * Generate a list of the top N populated capital cities in the world where N is provided by the user
     * @param number
     */
    public ArrayList<City> generateTopNCapitalCities(int number){
        ArrayList<City> cityList = new ArrayList<City>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select city.ID AS 'ID', city.CountryCode AS 'CountryCode', city.Name AS 'CapitalCity', city.Population from city inner join country on city.Id = country.capital order by city.Population desc limit " + number;
            ResultSet rset = stmt.executeQuery(strSelect);
            while (rset.next()) {
                City city = new City();
                city.setCityID(rset.getInt("ID"));
                city.setCountryCode(rset.getString("CountryCode"));
                city.setCityName(rset.getString("CapitalCity"));
                city.setCityPopulation(rset.getLong("Population"));
                cityList.add(city);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        return cityList;
    }

    /**
     * Prints the ArrayList containing information regarding City to console
     * @param cityList
     */
    public void printCityList(ArrayList<City> cityList){
        System.out.println(String.format("%-10s %-15s %-20s %-8s", "ID", "CountryCode", "City", "Population"));
        for(City city : cityList){
            String cityString =
                    String.format("%-10s %-15s %-20s %-8s",
                            city.getCityID(), city.getCountryCode(), city.getCityName(), city.getCityPopulation());
            System.out.println(cityString);
        }
    }

    /**
     *******************************************************************************************************************
     ********************************************** END OF METHODS FOR CITY ********************************************
     *******************************************************************************************************************
     */


    /**
     *******************************************************************************************************************
     ********************************************** METHODS FOR COUNTRY ************************************************
     *******************************************************************************************************************
     */

    /**
     Generates a full report of a country where code is specified, in the following format
     Country Code: {countryCode}
     Country Name: {countryName}
     Country Continent: {countryContinent}
     Country Region: {countryRegion}
     Country Population: {countryPopulation}
     Country Capital: {countryCapital}
     */
    public void generateCountryReport(Country country){
        try {
            Statement stmt = con.createStatement();
            String strSelect =
                    "select * from world.country where Code = '" + country.getCountryCode() + "'";
            ResultSet rset = stmt.executeQuery(strSelect);
            if(rset.next()){
                country.setCountryName(rset.getString("Name"));
                country.setCountryContinent(rset.getString("Continent"));
                country.setCountryRegion(rset.getString("Region"));
                country.setCountryPopulation(rset.getLong("Population"));
                country.setCountryCapital(rset.getInt("Capital"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("Country Code: " + country.getCountryCode());
        System.out.println("Country Name: " + country.getCountryName());
        System.out.println("Country Continent: " + country.getCountryContinent());
        System.out.println("Country Region: " + country.getCountryRegion());
        System.out.println("Country Population: " + country.getCountryPopulation());
        System.out.println("Country Capital: " + country.getCountryCapital());
    }

    /**
     * Generates a list of all countries (ordered from population largest - smallest)
     */
    public ArrayList<Country> generateCountryLargestToSmallest(){
        ArrayList<Country> countryList = new ArrayList<Country>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Code, Name, Population from world.country order by Population desc";
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                Country ctry = new Country();
                ctry.setCountryCode(rset.getString("Code"));
                ctry.setCountryName(rset.getString("Name"));
                ctry.setCountryPopulation(rset.getLong("Population"));
                countryList.add(ctry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryList;
    }

    /**
     * Generates a list of the top N populated countries (where N is specified by the user)
     * @param number
     */
    public ArrayList<Country> generateCountryTopN(int number){
        ArrayList<Country> countryList = new ArrayList<Country>();
        try{
            Statement stmt = con.createStatement();
            String strSelect =
                    "select Code, Name, Population from world.country order by Population desc limit " + number;
            ResultSet rset = stmt.executeQuery(strSelect);
            while(rset.next()){
                Country ctry = new Country();
                ctry.setCountryCode(rset.getString("Code"));
                ctry.setCountryName(rset.getString("Name"));
                ctry.setCountryPopulation(rset.getLong("Population"));
                countryList.add(ctry);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return countryList;
    }


    /**
     *******************************************************************************************************************
     ********************************************** END OF METHODS FOR COUNTRY *****************************************
     *******************************************************************************************************************
     */
}
