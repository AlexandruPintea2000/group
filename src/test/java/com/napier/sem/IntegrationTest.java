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
        assertEquals("India", first.getCountryName());
        assertEquals("Adamstown", last.getCityName());
    }

    /**
     * Testing generateCityTopN() to check if it returns the expected values
     */
    @Test
    void testGenerateCityTopN(){
        City first = app.generateCityTopN(3).get(0);
        City second = app.generateCityTopN(3).get(1);
        City third = app.generateCityTopN(3).get(2);

        assertEquals("India", first.getCountryName());
        assertEquals("Seoul", second.getCityName());
        assertEquals("Brazil", third.getCountryName());
    }

    /**
     * Testing generateCityPopulation() to check if it returns the expected values
     */
    @Test
    void testGenerateCityPopulation(){
       City city = app.generateCityPopulation("United Kingdom").get(0);

       assertEquals(7285000, city.getCityPopulation());
       assertEquals(81, app.generateCityPopulation("United Kingdom").size());
    }

    /**
     * Testing generateCityPopulationInContinent() to check if it returns the expected values
     */
    @Test
    void testGenerateCityPopulationInContinent(){
        City first = app.generateCityPopulationInContinent("Asia").get(0);
        City last = app.generateCityPopulationInContinent("Asia").get(app.generateCityPopulationInContinent("Asia").size() - 1);

        assertEquals(1766, app.generateCityPopulationInContinent("Asia").size());
        assertEquals("India", first.getCountryName());
        assertEquals("Brunei", last.getCountryName());
    }

    /**
     * Testing generateCapitalPopulationInContinent() to check if it returns the expected values
     */
    @Test
    void testGenerateCapitalPopulationInContinent(){
        City first = app.generateCapitalPopulationInContinent("Europe").get(0);
        City last = app.generateCapitalPopulationInContinent("Europe").get(app.generateCapitalPopulationInContinent("Europe").size()- 1);

        assertEquals(46, app.generateCapitalPopulationInContinent("Europe").size());
        assertEquals("Moscow", first.getCityName());
        assertEquals(455, last.getCityPopulation());
    }

    /**
     * Testing generateTopNCapitalPopulationInContinent() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCapitalPopulationInContinent(){
        City first = app.generateTopNCapitalPopulationInContinent("Oceania", 3).get(0);
        City second = app.generateTopNCapitalPopulationInContinent("Oceania", 3).get(1);
        City third = app.generateTopNCapitalPopulationInContinent("Oceania", 3).get(2);

        assertEquals("Canberra", first.getCityName());
        assertEquals("Port Moresby", second.getCityName());
        assertEquals("Wellington", third.getCityName());
    }

    /**
     * Testing generateTopNCapitalCities() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCapitalCities(){
        City first = app.generateTopNCapitalCities(3).get(0);
        City second = app.generateTopNCapitalCities(3).get(1);
        City third = app.generateTopNCapitalCities(3).get(2);

        assertEquals("Seoul", first.getCityName());
        assertEquals("Jakarta", second.getCityName());
        assertEquals("Mexico", third.getCountryName());
    }

    /**
     * Testing generateTopNCapitalPopulationInRegion() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCapitalPopulationInRegion(){
        City first = app.generateTopNCapitalPopulationInRegion("Middle East", 3).get(0);
        City second = app.generateTopNCapitalPopulationInRegion("Middle East", 3).get(1);
        City third = app.generateTopNCapitalPopulationInRegion("Middle East", 3).get(2);

        assertEquals("Baghdad", first.getCityName());
        assertEquals("Riyadh", second.getCityName());
        assertEquals("Ankara", third.getCityName());
    }

    /**
     * Testing generateTopNCityPopulationInRegion() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCityPopulationInRegion(){
        City first = app.generateTopNCityPopulationInRegion("Middle East", 3).get(0);
        City second = app.generateTopNCityPopulationInRegion("Middle East", 3).get(1);
        City third = app.generateTopNCityPopulationInRegion("Middle East", 3).get(2);

        assertEquals("Istanbul", first.getCityName());
        assertEquals("Baghdad", second.getCityName());
        assertEquals("Riyadh", third.getCityName());
    }

    /**
     * Testing generateTopNCityPopulationInCountry() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCityPopulationInCountry(){
        City first = app.generateTopNCityPopulationInCountry("India", 3).get(0);
        City second = app.generateTopNCityPopulationInCountry("India", 3).get(1);
        City third = app.generateTopNCityPopulationInCountry("India", 3).get(2);

        assertEquals("Maharashtra", first.getCityDistrict());
        assertEquals("Delhi", second.getCityName());
        assertEquals("India", third.getCountryName());
    }

    /**
     * Testing generateTopNCityPopulationInContinent() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCityPopulationInContinent(){
        City first = app.generateTopNCityPopulationInContinent("Europe", 3).get(0);
        City second = app.generateTopNCityPopulationInContinent("Europe", 3).get(1);
        City third = app.generateTopNCityPopulationInContinent("Europe", 3).get(2);

        assertEquals("Moscow", first.getCityName());
        assertEquals("London", second.getCityName());
        assertEquals("Pietari", third.getCityDistrict());
    }

    /**
     * Testing generateTopNCityPopulationInDistrict() to check if it returns the expected values
     */
    @Test
    void testGenerateTopNCityPopulationInDistrict(){
        City first = app.generateTopNCityPopulationInDistrict("Texas", 3).get(0);
        City second = app.generateTopNCityPopulationInDistrict("Texas", 3).get(1);
        City third = app.generateTopNCityPopulationInDistrict("Texas", 3).get(2);

        assertEquals("Houston", first.getCityName());
        assertEquals("Dallas", second.getCityName());
        assertEquals("San Antonio", third.getCityName());
    }

    /**
     * Testing generateCityPopulationInRegionLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCityPopulationInRegionLargestToSmallest(){
        City first = app.generateCityPopulationInRegionLargestToSmallest("Middle East").get(0);
        City second = app.generateCityPopulationInRegionLargestToSmallest("Middle East").get(1);
        City third = app.generateCityPopulationInRegionLargestToSmallest("Middle East").get(2);

        assertEquals("Istanbul", first.getCityName());
        assertEquals("Baghdad", second.getCityName());
        assertEquals("Riyadh", third.getCityName());
    }

    /**
     * Testing generateCityPopulationInDistrictLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCityPopulationInDistrictLargestToSmallest(){
        City first = app.generateCityPopulationInDistrictLargestToSmallest("Texas").get(0);
        City second = app.generateCityPopulationInDistrictLargestToSmallest("Texas").get(1);
        City third = app.generateCityPopulationInDistrictLargestToSmallest("Texas").get(2);

        assertEquals("Houston", first.getCityName());
        assertEquals("Dallas", second.getCityName());
        assertEquals("San Antonio", third.getCityName());
    }

    /**
     * Testing generateCapitalPopulationInWorldLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCapitalPopulationInWorldLargestToSmallest(){
        City first = app.generateCapitalPopulationInWorldLargestToSmallest().get(0);
        City second = app.generateCapitalPopulationInWorldLargestToSmallest().get(1);
        City third = app.generateCapitalPopulationInWorldLargestToSmallest().get(2);

        assertEquals("Seoul", first.getCityName());
        assertEquals("Jakarta", second.getCityName());
        assertEquals("Mexico", third.getCountryName());
    }

    /**
     * Testing generateCapitalPopulationInRegionLargestToSmallest() to check if it returns the expected values
     */
    @Test
    void testGenerateCapitalPopulationInRegionLargestToSmallest(){
        City first = app.generateCapitalPopulationInRegionLargestToSmallest("Middle East").get(0);
        City second = app.generateCapitalPopulationInRegionLargestToSmallest("Middle East").get(1);
        City third = app.generateCapitalPopulationInRegionLargestToSmallest("Middle East").get(2);

        assertEquals("Baghdad", first.getCityName());
        assertEquals("Riyadh", second.getCityName());
        assertEquals("Ankara", third.getCityName());
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
    }

    /**
     * Testing generateCountryLargestToSmallest() to check if it returns the expected value
     */
    @Test
    void testGenerateCountryLargestToSmallest(){
        Country first = app.generateCountryLargestToSmallest().get(0);
        Country last = app.generateCountryLargestToSmallest().get(app.generateCountryLargestToSmallest().size() - 8);

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

    /**
     * Testing generateTopNCountryInRegion() to check if it returns the expected value
     */
    @Test
    void testGenerateTopNCountryInRegion(){
        Country first = app.generateTopNCountryInRegion("Middle East", 3).get(0);
        Country second = app.generateTopNCountryInRegion("Middle East", 3).get(1);
        Country third = app.generateTopNCountryInRegion("Middle East", 3).get(2);

        assertEquals("TUR", first.getCountryCode());
        assertEquals("IRQ", second.getCountryCode());
        assertEquals("SAU", third.getCountryCode());
    }

    /**
     * Testing generateLivingInCityStatsInCountry() to check if it returns the expected value
     */
    @Test
    void testGenerateLivingInCityStatsInCountry(){
        InOrOutCity first = app.generateLivingInCityStatsInCountry("IND").get(0);

        int x = (int)Math.ceil(first.getInCityPercentage());
        int y = (int)Math.ceil(first.getOutCityPercentage());

        assertEquals("India", first.getPlace());
        assertEquals(1013662000, first.getPopulation());
        assertEquals(123298526, first.getInCityPopulation());
        assertEquals(13, x);
        assertEquals(890363474, first.getOutCityPopulation());
        assertEquals(88, y);
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

    /**
     * Testing generateLivingInCityStatsInContinent() to check if it returns the expected value
     */
    @Test
    void testGenerateLivingInCityStatsInContinent(){
        InOrOutCity first = app.generateLivingInCityStatsInContinent("Europe").get(0);

        assertEquals("Europe", first.getPlace());
        assertEquals(730074600, first.getPopulation());
        assertEquals(241942813, first.getInCityPopulation());
        assertEquals(33.13949966430664, first.getInCityPercentage());
        assertEquals(488131787, first.getOutCityPopulation());
        assertEquals(66.8604965209961, first.getOutCityPercentage());
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

    /**
     * Testing generateLivingInCityStatsInRegion() to check if it returns the expected value
     */
    @Test
    void testGenerateLivingInCityStatsInRegion(){
        InOrOutCity first = app.generateLivingInCityStatsInRegion("Middle East").get(0);

        assertEquals("Middle East", first.getPlace());
        assertEquals(188380700, first.getPopulation());
        assertEquals(70371374, first.getInCityPopulation());
        assertEquals(37.355899810791016, first.getInCityPercentage());
        assertEquals(118009326, first.getOutCityPopulation());
        assertEquals(62.644100189208984, first.getOutCityPercentage());
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

    /*********************************
     ******* TESTS FOR LANGUAGE ******
     *********************************/

    /**
     * Testing generateLanguageReport() to check if it returns the expected value
     */

    @Test
    void testGenerateLanguageReport(){
        Language first = app.generateLanguageReport().get(0);
        Language second = app.generateLanguageReport().get(1);
        Language third = app.generateLanguageReport().get(2);
        Language fourth = app.generateLanguageReport().get(3);
        Language fifth = app.generateLanguageReport().get(4);

        assertEquals("Chinese", first.getLanguage());
        assertEquals("Hindi", second.getLanguage());
        assertEquals("Spanish", third.getLanguage());
        assertEquals("English", fourth.getLanguage());
        assertEquals("Arabic", fifth.getLanguage());
    }
}
