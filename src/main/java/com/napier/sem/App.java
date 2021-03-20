package com.napier.sem;

import java.sql.*;

public class App {

    public static void main(String[] args) {
        // Create new Application
        App app = new App();
        // World object
        World world = new World();
        // Country object to access information regarding a list of countries
        Country country = new Country();
        // City object to access information regarding a list of cities
        City city = new City();
        // Country object to hold information regarding Brazil
        Country brazil = new Country();
        // City object to hold information regarding Mumbai (Bombay)
        City mumbai = new City();
        // Continent object
        Continent asia = new Continent();
        // Region object
        Region middleEast = new Region();

        // Establishing SQL connection for objects
        app.connect();
        world.setCon(app.con);
        brazil.setCon(app.con);
        country.setCon(app.con);
        mumbai.setCon(app.con);
        city.setCon(app.con);
        asia.setCon(app.con);
        middleEast.setCon(app.con);


        // Sets the brazil object to the code that corresponds to Brazil
        brazil.setCountryCode("BRA");
        // Returns the population of the world to the user
        System.out.println("The world population is: " + world.getWorldPopulation());
        // Returns the population of Brazil
        System.out.println("The population of " + brazil.getCountryName() + " is " + brazil.getCountryPopulation());
        // Generates a report containing information about Brazil
        brazil.generateCountryReport();
        // Generates a list of all countries in the database
        country.generateLargestToSmallest();
        // Sets the mumbai object to the code that corresponds to Mumbai
        mumbai.setCityID(1024);
        // Returns the population of Mumbai
        System.out.println("The population of " + mumbai.getCityName() + " is " + mumbai.getCityPopulation());
        // Generates a report containing information about Mumbai
        mumbai.generateCityReport();
        // Generates a list of all cities in the database
        city.generateLargestToSmallest();
        // Generates top 20 populated country
        country.generateTopN(20);
        // Generates top 5 populated cities
        city.generateTopN(5);
        // Generates population of Asia
        asia.setContinentName("Asia");
        System.out.println("Population of " + asia.getContinentName() + ": " + asia.getContinentPopulation());
        // Generates population of Middle East
        middleEast.setRegionName("Middle East");
        System.out.println("Population of " + middleEast.getRegionName() + ": " + middleEast.getRegionPopulation());
        // Disconnect from database
        app.disconnect();
    }

    /**
     * Connection to MySQL database.
     */
    private Connection con = null;

    /**
     * Connect to the MySQL database.
     */
    public void connect() {
        try {
            // Load Database driver
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("Could not load SQL driver");
            System.exit(-1);
        }

        int retries = 10;
        for (int i = 0; i < retries; ++i) {
            System.out.println("Connecting to database...");
            try {
                // Wait a bit for db to start
                Thread.sleep(30000);
                // Connect to database
                con = DriverManager.getConnection("jdbc:mysql://db:3306/world?useSSL=false", "root", "example");
                System.out.println("Successfully connected");
                break;
            } catch (SQLException sqle) {
                System.out.println("Failed to connect to database attempt " + Integer.toString(i));
                System.out.println(sqle.getMessage());
            } catch (InterruptedException ie) {
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
}
