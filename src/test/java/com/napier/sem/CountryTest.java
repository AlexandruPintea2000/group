package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryTest {
    @Test
    void getCountryNameTest(){
        App app = new App();
        app.connect();
        Country country = new Country();
        country.setCon(app.con);
        country.setCountryCode("BRA");
        assertEquals("Brazil", country.getCountryName());
    }
}
