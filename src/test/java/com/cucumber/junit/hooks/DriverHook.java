package com.cucumber.junit.hooks;

import io.cucumber.java.Before;

import static configuration.driver.DriverManager.getDriver;

public class DriverHook {

    @Before
    public static void setupDriver() {
        getDriver();
    }

}
