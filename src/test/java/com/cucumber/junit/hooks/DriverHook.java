package com.cucumber.junit.hooks;

import io.cucumber.java.Before;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import static configuration.driver.DriverManager.getDriver;

public class DriverHook {

    private static final Logger logger = LogManager.getLogger(DriverHook.class);

    @Before
    public static void setupDriver() {
        getDriver();
        logger.info("Browser is started successfully");
    }

}
