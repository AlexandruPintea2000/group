package com.napier.sem;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CountryTest {
    static Country country;

    @BeforeAll
    static void init(){
        country = new Country();
    }

    @Test
    void getCountryNameTest(){
        country.setCountryName("Brazil");
        assertEquals("Brazil", country.getCountryName());
    }
}
