package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTest {
    static App app;

    @BeforeAll
    static void init(){
        app = new App();
        app.connect("db:33060");
    }

    /******************************
     ******* TESTS FOR CITY *******
     ******************************/

    /**
     * Testing generateCityReport() to check if it returns the expected values
     */
    @Test
    void testGenerateCityReport(){
        City city = new City();
        city.setCityID(1000);
        app.generateCityReport(city);

        assertEquals(1000, city.getCityID());
        assertEquals("Taman", city.getCityName());
        assertEquals("IDN", city.getCountryCode());
        assertEquals("East Java", city.getCityDistrict());
        assertEquals(107000, city.getCityPopulation());
    }

    /**
     * Testing generateCityLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCityLargestToSmallest(){
        City first = app.generateCityLargestToSmallest().get(0);
        City last = app.generateCityLargestToSmallest().get(app.generateCityLargestToSmallest().size() - 1);

        assertEquals(4079, app.generateCityLargestToSmallest().size());
        assertEquals(1024, first.getCityID());
        assertEquals(2912, last.getCityID());
    }

    /**
     * Testing generateCityTopN() to check if it returns the expected values
     */
    @Test
    void testGenerateCityTopN(){
        City first = app.generateCityTopN(3).get(0);
        City second = app.generateCityTopN(3).get(1);
        City third = app.generateCityTopN(3).get(2);

        assertEquals(1024, first.getCityID());
        assertEquals(2331, second.getCityID());
        assertEquals(206, third.getCityID());
    }

    /**
     * Testing generateCityPopulation() to check if it returns the expected values
     */
    @Test
    void testGenerateCityPopulation(){
       City city = app.generateCityPopulation("GBR").get(0);

       assertEquals(7285000, city.getCityPopulation());
       assertEquals(81, app.generateCityPopulation("GBR").size());
    }

    /**
     * Testing generateCityPopulationInContinent() to check if it returns the expected values
     */
    @Test
    void testGenerateCityPopulationInContinent(){
        City first = app.generateCityPopulationInContinent("Asia").get(0);
        City last = app.generateCityPopulationInContinent("Asia").get(app.generateCityPopulationInContinent("Asia").size() - 1);

        assertEquals(1766, app.generateCityPopulationInContinent("Asia").size());
        assertEquals(1024, first.getCityID());
        assertEquals(538, last.getCityID());
    }

    /**
     * Testing generateCapitalPopulationInContinent() to check if it returns the expected values
     */
    @Test
    void testGenerateCapitalPopulationInContinent(){
        City first = app.generateCapitalPopulationInContinent("Europe").get(0);
        City last = app.generateCapitalPopulationInContinent("Europe").get(app.generateCapitalPopulationInContinent("Europe").size()- 1);

        assertEquals(46, app.generateCapitalPopulationInContinent("Europe").size());
        assertEquals(3580, first.getCityID());
        assertEquals(3538, last.getCityID());
    }

    /**
     * Testing generateTopNCapitalPopulationInContinent() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCapitalPopulationInContinent(){
        City first = app.generateTopNCapitalPopulationInContinent("Oceania", 3).get(0);
        City second = app.generateTopNCapitalPopulationInContinent("Oceania", 3).get(1);
        City third = app.generateTopNCapitalPopulationInContinent("Oceania", 3).get(2);

        assertEquals(135, first.getCityID());
        assertEquals(2884, second.getCityID());
        assertEquals(3499, third.getCityID());
    }

    /**
     * Testing generateTopNCapitalCities() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCapitalCities(){
        City first = app.generateTopNCapitalCities(3).get(0);
        City second = app.generateTopNCapitalCities(3).get(1);
        City third = app.generateTopNCapitalCities(3).get(2);

        assertEquals(2331, first.getCityID());
        assertEquals(939, second.getCityID());
        assertEquals(2515, third.getCityID());
    }


    /*********************************
     ******* TESTS FOR COUNTRY *******
     *********************************/

    @Test
    void testGenerateCountryReport(){
        Country country = new Country();
        country.setCountryCode("GBR");

        assertEquals("GBR", country.getCountryCode());
        assertEquals("United Kingdom", country.getCountryName());
        assertEquals("British Islands", country.getCountryRegion());
        assertEquals(59623400, country.getCountryPopulation());
        assertEquals(456, country.getCountryCapital());
    }

    @Test
    void testGenerateCountryLargestToSmallest(){
        Country first = app.generateCountryLargestToSmallest().get(0);
        Country last = app.generateCountryLargestToSmallest().get(app.generateCountryLargestToSmallest().size() - 8);

        assertEquals(239, app.generateCountryLargestToSmallest().size());
        assertEquals("CHN", first.getCountryCode());
        assertEquals("PCN", last.getCountryCode());
    }
}
