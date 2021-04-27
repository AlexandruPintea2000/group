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
        country.setCountryCapital("Dhaka");

        assertEquals("Bangladesh", country.getCountryName());
        assertEquals("Asia", country.getCountryContinent());
        assertEquals("Southern and Central Asia", country.getCountryRegion());
        assertEquals(129155000, country.getCountryPopulation());
        assertEquals("Dhaka", country.getCountryCapital());
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

    /*********************************
     ******* TESTS FOR CONTINENT *****
     *********************************/

    /**
     * Testing to check Continent methods work
     */
    @Test
    void testContinent(){
        Continent continent = new Continent();
        continent.setContinentPopulation(748007090);
        continent.setContinentName("Europe");

        assertEquals(748007090, continent.getContinentPopulation());
        assertEquals("Europe", continent.getContinentName());
    }

    /*********************************
     ******* TESTS FOR DISTRICT  *****
     *********************************/

    /**
     * Testing to check District methods work
     */
    @Test
    void testDistrict(){
        District district = new District();
        district.setDistrictName("Texas");
        district.setDistrictPopulation(29145505);

        assertEquals(29145505, district.getDistrictPopulation());
        assertEquals("Texas", district.getDistrictName());
    }


    /*********************************
     ******* TESTS FOR REGION  *******
     *********************************/

    /**
     * Testing to check Region methods work
     */
    @Test
    void testRegion(){
        Region region = new Region();
        region.setRegionName("Middle East");
        region.setRegionPopulation(411000000);

        assertEquals("Middle East", region.getRegionName());
        assertEquals(411000000, region.getRegionPopulation());
    }

    /*********************************
     *******    MISC TESTS     *******
     *********************************/

    /**
     * Testing InOrOutCity
     */
    @Test
    void testInOrOutCity(){
        InOrOutCity iooc = new InOrOutCity();
        iooc.setPlace("India");
        iooc.setPopulation(1013662000);
        iooc.setInCityPopulation(123298526);
        iooc.setInCityPercentage(12);
        iooc.setOutCityPopulation(890363474);
        iooc.setOutCityPercentage(87);

        assertEquals("India", iooc.getPlace());
        assertEquals(1013662000, iooc.getPopulation());
        assertEquals(123298526, iooc.getInCityPopulation());
        assertEquals(12, iooc.getInCityPercentage());
        assertEquals(890363474, iooc.getOutCityPopulation());
        assertEquals(87, iooc.getOutCityPercentage());
    }

    /**
     * Testing Language
     */
    @Test
    void testLanguage(){
        Language language = new Language();
        language.setLanguage("Hindi");
        language.setPopulation(405633070);
        language.setPercentage(6);

        assertEquals("Hindi", language.getLanguage());
        assertEquals(405633070, language.getPopulation());
        assertEquals(6, language.getPercentage());
    }

    /**
     * Testing to check printIOOCList() does not throw error with empty list
     */
    @Test
    void printEmptyIOOCListTest(){
        ArrayList<InOrOutCity> ioocList = new ArrayList<InOrOutCity>();
        app.printIOOCList(ioocList);
    }

    /**
     * Testing to check printIOOCList() does not throw error with null list
     */
    @Test
    void printIOOCListContainsNull(){
        ArrayList<InOrOutCity> ioocList = new ArrayList<InOrOutCity>();
        ioocList.add(null);
        app.printIOOCList(ioocList);
    }

    /**
     * Testing to check the printIOOCList() method works
     */
    @Test
    void printIOOCList(){
        ArrayList<InOrOutCity> ioocList = new ArrayList<InOrOutCity>();

        InOrOutCity india = new InOrOutCity("India", 1013662000, 123298526, 12, 890363474, 87);
        ioocList.add(india);

        app.printIOOCList(ioocList);
    }

    /**
     * Testing to check printLanguageList() does not throw error with empty list
     */
    @Test
    void printEmptyLanguageListTest(){
        ArrayList<Language> languageList = new ArrayList<Language>();
        app.printLanguageList(languageList);
    }

    /**
     * Testing to check printLanguageList() does not throw error with null list
     */
    @Test
    void printLanguageListContainsNull(){
        ArrayList<Language> languageList = new ArrayList<Language>();
        languageList.add(null);
        app.printLanguageList(languageList);
    }

    /**
     * Testing to check the printLanguageList() method works
     */
    @Test
    void printLanguageList(){
        ArrayList<Language> languageList = new ArrayList<Language>();

        Language chinese = new Language("Chinese", 1191843539, 19);
        languageList.add(chinese);

        Language hindi = new Language("Hindi", 405633070, 6);
        languageList.add(hindi);

        Language spanish = new Language("Spanish", 355029462, 5);
        languageList.add(spanish);

        Language english = new Language("English", 347077867, 5);
        languageList.add(english);

        Language arabic = new Language("Arabic", 233839239, 3);
        languageList.add(arabic);

        app.printLanguageList(languageList);
    }
}
