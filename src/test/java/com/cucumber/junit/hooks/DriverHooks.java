package com.cucumber.junit.hooks;

import driver.DriverManager;
import org.junit.After;
import org.junit.Before;


public class DriverHooks {

    @Before
    public void setupDriver() {
        DriverManager.getDriver();
    }

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
