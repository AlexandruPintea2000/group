package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Integration Tests for methods in App
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
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

    /**
     * Testing generateTopNCapitalPopulationInRegion() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCapitalPopulationInRegion(){
        City first = app.generateTopNCapitalPopulationInRegion("Middle East", 3).get(0);
        City second = app.generateTopNCapitalPopulationInRegion("Middle East", 3).get(1);
        City third = app.generateTopNCapitalPopulationInRegion("Middle East", 3).get(2);

        assertEquals(65, first.getCityID());
        assertEquals(126, second.getCityID());
        assertEquals(144, third.getCityID());
    }

    /**
     * Testing generateTopNCityPopulationInRegion() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCityPopulationInRegion(){
        City first = app.generateTopNCityPopulationInRegion("Middle East", 3).get(0);
        City second = app.generateTopNCityPopulationInRegion("Middle East", 3).get(1);
        City third = app.generateTopNCityPopulationInRegion("Middle East", 3).get(2);

        assertEquals(3357, first.getCityID());
        assertEquals(1365, second.getCityID());
        assertEquals(3173, third.getCityID());
    }

    /**
     * Testing generateTopNCityPopulationInCountry() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCityPopulationInCountry(){
        City first = app.generateTopNCityPopulationInCountry("India", 3).get(0);
        City second = app.generateTopNCityPopulationInCountry("India", 3).get(1);
        City third = app.generateTopNCityPopulationInCountry("India", 3).get(2);

        assertEquals(1024, first.getCityID());
        assertEquals(1025, second.getCityID());
        assertEquals(1026, third.getCityID());
    }

    /**
     * Testing generateTopNCityPopulationInContinent() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCityPopulationInContinent(){
        City first = app.generateTopNCityPopulationInContinent("Europe", 3).get(0);
        City second = app.generateTopNCityPopulationInContinent("Europe", 3).get(1);
        City third = app.generateTopNCityPopulationInContinent("Europe", 3).get(2);

        assertEquals(3580, first.getCityID());
        assertEquals(456, second.getCityID());
        assertEquals(3581, third.getCityID());
    }

    /**
     * Testing generateTopNCityPopulationInDistrict() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCityPopulationInDistrict(){
        City first = app.generateTopNCityPopulationInDistrict("Texas", 3).get(0);
        City second = app.generateTopNCityPopulationInDistrict("Texas", 3).get(1);
        City third = app.generateTopNCityPopulationInDistrict("Texas", 3).get(2);

        assertEquals(3796, first.getCityID());
        assertEquals(3800, second.getCityID());
        assertEquals(3801, third.getCityID());
    }

    /**
     * Testing generateCityPopulationInRegionLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCityPopulationInRegionLargestToSmallest(){
        City first = app.generateCityPopulationInRegionLargestToSmallest("Middle East").get(0);
        City second = app.generateCityPopulationInRegionLargestToSmallest("Middle East").get(1);
        City third = app.generateCityPopulationInRegionLargestToSmallest("Middle East").get(2);

        assertEquals(3357, first.getCityID());
        assertEquals(1365, second.getCityID());
        assertEquals(3173, third.getCityID());
    }

    /**
     * Testing generateCityPopulationInDistrictLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCityPopulationInDistrictLargestToSmallest(){
        City first = app.generateCityPopulationInDistrictLargestToSmallest("Texas").get(0);
        City second = app.generateCityPopulationInDistrictLargestToSmallest("Texas").get(1);
        City third = app.generateCityPopulationInDistrictLargestToSmallest("Texas").get(2);

        assertEquals(3796, first.getCityID());
        assertEquals(3800, second.getCityID());
        assertEquals(3801, third.getCityID());
    }

    /**
     * Testing generateCapitalPopulationInWorldLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCapitalPopulationInWorldLargestToSmallest(){
        City first = app.generateCapitalPopulationInWorldLargestToSmallest().get(0);
        City second = app.generateCapitalPopulationInWorldLargestToSmallest().get(1);
        City third = app.generateCapitalPopulationInWorldLargestToSmallest().get(2);

        assertEquals(2331, first.getCityID());
        assertEquals(939, second.getCityID());
        assertEquals(2515, third.getCityID());
    }

    /**
     * Testing generateCapitalPopulationInRegionLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCapitalPopulationInRegionLargestToSmallest(){
        City first = app.generateCapitalPopulationInRegionLargestToSmallest("Middle East").get(0);
        City second = app.generateCapitalPopulationInRegionLargestToSmallest("Middle East").get(1);
        City third = app.generateCapitalPopulationInRegionLargestToSmallest("Middle East").get(2);

        assertEquals(1365, first.getCityID());
        assertEquals(3173, second.getCityID());
        assertEquals(3358, third.getCityID());
    }


    /*********************************
     ******* TESTS FOR COUNTRY *******
     *********************************/

    /**
     * Testing generateCountryReport() to check if it returns the expected value
     */
    @Test
    void testGenerateCountryReport(){
        Country country = new Country();
        country.setCountryCode("GBR");
        app.generateCountryReport(country);

        assertEquals("GBR", country.getCountryCode());
        assertEquals("United Kingdom", country.getCountryName());
        assertEquals("British Islands", country.getCountryRegion());
        assertEquals(59623400, country.getCountryPopulation());
        assertEquals(456, country.getCountryCapital());
    }

    /**
     * Testing generateCountryLargestToSmallest() to check if it returns the expected value
     */
    @Test
    void testGenerateCountryLargestToSmallest(){
        Country first = app.generateCountryLargestToSmallest().get(0);
        Country last = app.generateCountryLargestToSmallest().get(app.generateCountryLargestToSmallest().size() - 8);

        assertEquals(239, app.generateCountryLargestToSmallest().size());
        assertEquals("CHN", first.getCountryCode());
        assertEquals("PCN", last.getCountryCode());
    }

    /**
     * Testing generateCountryTopN() to check if it returns the expected value
     */
    @Test
    void testGenerateCountryTopN(){
        Country first = app.generateCountryTopN(3).get(0);
        Country second = app.generateCountryTopN(3).get(1);
        Country third = app.generateCountryTopN(3).get(2);

        assertEquals("CHN", first.getCountryCode());
        assertEquals("IND", second.getCountryCode());
        assertEquals("USA", third.getCountryCode());
    }

    /**
     * Testing generateCountryPopulationInContinentLargestToSmallest() to check if it returns the expected value
     */
    @Test
    void testGenerateCountryPopulationInContinentLargestToSmallest(){
        Country first = app.generateCountryPopulationInContinentLargestToSmallest("Europe").get(0);
        Country second = app.generateCountryPopulationInContinentLargestToSmallest("Europe").get(1);
        Country third = app.generateCountryPopulationInContinentLargestToSmallest("Europe").get(2);

        assertEquals("RUS", first.getCountryCode());
        assertEquals("DEU", second.getCountryCode());
        assertEquals("GBR", third.getCountryCode());
    }

    /**
     * Testing generateCountryPopulationInRegionLargestToSmallest() to check if it returns the expected value
     */
    @Test
    void testGenerateCountryPopulationInRegionLargestToSmallest(){
        Country first = app.generateCountryPopulationInRegionLargestToSmallest("Middle East").get(0);
        Country second = app.generateCountryPopulationInRegionLargestToSmallest("Middle East").get(1);
        Country third = app.generateCountryPopulationInRegionLargestToSmallest("Middle East").get(2);

        assertEquals("TUR", first.getCountryCode());
        assertEquals("IRQ", second.getCountryCode());
        assertEquals("SAU", third.getCountryCode());
    }

    /**
     * Testing generateTopNCountryInContinent() to check if it returns the expected value
     */
    @Test
    void testGenerateTopNCountryInContinent(){
        Country first = app.generateTopNCountryInContinent("Europe", 3).get(0);
        Country second = app.generateTopNCountryInContinent("Europe", 3).get(1);
        Country third = app.generateTopNCountryInContinent("Europe", 3).get(2);

        assertEquals("RUS", first.getCountryCode());
        assertEquals("DEU", second.getCountryCode());
        assertEquals("GBR", third.getCountryCode());
    }


    /*********************************
     ******* TESTS FOR CONTINENT *****
     *********************************/

    /**
     * Testing continentPopulation() to check if it returns the expected value
     */
    @Test
    void testContinentPopulation(){
        Continent continent = new Continent();
        continent.setContinentName("Oceania");

        assertEquals(30401150, app.continentPopulation(continent));
    }


    /*********************************
     ******* TESTS FOR DISTRICT ******
     *********************************/

    /**
     * Testing districtPopulation() to check if it returns the expected value
     */
    @Test
    void testDistrictPopulation(){
        District district = new District();
        district.setDistrictName("Texas");

        assertEquals(9208281, app.districtPopulation(district));
    }


    /*********************************
     ******* TESTS FOR REGION ********
     *********************************/

    /**
     * Testing regionPopulation() to check if it returns the expected value
     */
    @Test
    void testRegionPopulation(){
        Region region = new Region();
        region.setRegionName("Caribbean");

        assertEquals(38140000, app.regionPopulation(region));
    }


    /*********************************
     ******* TESTS FOR WORLD *********
     *********************************/

    /**
     * Testing worldPopulation() to check if it returns the expected value
     */
    @Test
    void testWorldPopulation(){
        long worldPopulation = 7508309334L;
        assertEquals(worldPopulation, app.worldPopulation());
    }
}
