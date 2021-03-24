package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit Tests for methods in App
 * @author Suparno Deb, Alexandru Pintea, Stephen Messer, Vassilis Papadodimas
 */
public class UnitTest {
    static App app;

    @BeforeAll
    static void init(){
        app = new App();
    }

    /******************************
     ******* TESTS FOR CITY *******
     ******************************/

    /**
     * Testing to check printCityList(null) does not throw error
     */
    @Test
    void printNullCityListTest(){
        app.printCityList(null);
    }

    /**
     * Testing to check empty printCityList() does not throw error
     */
    @Test
    void printEmptyCityListTest(){
        ArrayList<City> cityList = new ArrayList<City>();
        app.printCityList(cityList);
    }

    /**
     * Testing to check empty object in printCityList() does not throw error
     */
    @Test
    void printCityListContainsNull(){
        ArrayList<City> cityList = new ArrayList<City>();
        cityList.add(null);
        app.printCityList(cityList);
    }

    /**
     * Testing to check the methods in City works
     */
    @Test
    void printCityReport(){
        City city = new City();
        city.setCityID(456);
        city.setCityName("London");
        city.setCountryCode("GBR");
        city.setCityDistrict("England");
        city.setCityPopulation(7285000);

        assertEquals(456, city.getCityID());
        assertEquals("London", city.getCityName());
        assertEquals("GBR", city.getCountryCode());
        assertEquals("England", city.getCityDistrict());
        assertEquals(7285000, city.getCityPopulation());
    }

    /**
     * Testing to check the printCityList() method works
     */
    @Test
    void printCityList(){
        ArrayList<City> cityList = new ArrayList<City>();

        City del = new City();
        del.setCityID(1025);
        del.setCountryCode("IND");
        del.setCityName("Delhi");
        del.setCityPopulation(7206704);
        cityList.add(del);

        City lag = new City();
        lag.setCityID(2741);
        lag.setCountryCode("NGA");
        lag.setCityName("Lagos");
        lag.setCityPopulation(1518000);
        cityList.add(lag);

        City mos = new City();
        mos.setCityID(3580);
        mos.setCountryCode("RUS");
        mos.setCityName("Moscow");
        mos.setCityPopulation(8389200);
        cityList.add(mos);

        City syd = new City();
        syd.setCityID(130);
        syd.setCountryCode("AUS");
        syd.setCityName("Sydney");
        syd.setCityPopulation(3276207);
        cityList.add(syd);

        app.printCityList(cityList);
    }


    /*********************************
     ******* TESTS FOR COUNTRY *******
     *********************************/

    /**
     * Testing to check printCountryList() does not throw error with empty list
     */
    @Test
    void printEmptyCountryListTest(){
        ArrayList<Country> countryList = new ArrayList<Country>();
        app.printCountryList(countryList);
    }

    /**
     * Testing to check printCountryList() does not throw error with null list
     */
    @Test
    void printCountryListContainsNull(){
        ArrayList<Country> countryList = new ArrayList<Country>();
        countryList.add(null);
        app.printCountryList(countryList);
    }

    /**
     * Testing to check Country methods work
     */
    @Test
    void printCountryReport(){
        Country country = new Country();
        country.setCountryName("Bangladesh");
        country.setCountryContinent("Asia");
        country.setCountryRegion("Southern and Central Asia");
        country.setCountryPopulation(129155000);
        country.setCountryCapital(150);

        assertEquals("Bangladesh", country.getCountryName());
        assertEquals("Asia", country.getCountryContinent());
        assertEquals("Southern and Central Asia", country.getCountryRegion());
        assertEquals(129155000, country.getCountryPopulation());
        assertEquals(150, country.getCountryCapital());
    }

    /**
     * Testing to check printCountryList() works
     */
    @Test
    void printCountryList(){
        ArrayList<Country> countryList = new ArrayList<Country>();

        Country bd = new Country();
        bd.setCountryCode("BGD");
        bd.setCountryName("Bangladesh");
        bd.setCountryPopulation(129155000);
        countryList.add(bd);

        Country uk = new Country();
        uk.setCountryCode("GBR");
        uk.setCountryName("United Kingdom");
        uk.setCountryPopulation(59623400);
        countryList.add(uk);

        Country can = new Country();
        can.setCountryCode("CAN");
        can.setCountryName("Canada");
        can.setCountryPopulation(31147000);
        countryList.add(can);

        Country gha = new Country();
        gha.setCountryCode("GHA");
        gha.setCountryName("Ghana");
        gha.setCountryPopulation(20212000);
        countryList.add(gha);

        app.printCountryList(countryList);
    }
}
