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

    @Test
    void testGenerateCityLargestToSmallest(){
        City first = app.generateCityLargestToSmallest().get(0);
        City last = app.generateCityLargestToSmallest().get(app.generateCityLargestToSmallest().size() - 1);

        assertEquals(4079, app.generateCityLargestToSmallest().size());
        assertEquals(1024, first.getCityID());
        assertEquals(2912, last.getCityID());
    }

    @Test
    void testGenerateCityTopN(){
        City first = app.generateCityTopN(3).get(0);
        City second = app.generateCityTopN(3).get(1);
        City third = app.generateCityTopN(3).get(2);

        assertEquals(1024, first.getCityID());
        assertEquals(2331, second.getCityID());
        assertEquals(206, third.getCityID());
    }

    @Test
    void testGenerateCityPopulation(){
       City city = app.generateCityPopulation("GBR").get(0);

       assertEquals(7285000, city.getCityPopulation());
       assertEquals(81, app.generateCityPopulation("GBR").size());
    }

    @Test
    void testGenerateCityPopulationInContinent(){
        City first = app.generateCityPopulationInContinent("Asia").get(0);
        City last = app.generateCityPopulationInContinent("Asia").get(app.generateCityPopulationInContinent("Asia").size() - 1);

        assertEquals(1766, app.generateCityPopulationInContinent("Asia").size());
        assertEquals(1024, first.getCityID());
        assertEquals(538, last.getCityID());
    }
}
