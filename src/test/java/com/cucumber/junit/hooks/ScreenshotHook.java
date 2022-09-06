package com.cucumber.junit.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static configuration.driver.DriverManager.getDriver;
import static configuration.driver.DriverManager.quitDriver;
import static constants.Constants.IMAGE_PNG;

public class ScreenshotHook {

    private static final Logger logger = LogManager.getLogger(ScreenshotHook.class);

    @After
    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log(getDriver().getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, IMAGE_PNG, scenario.getName());
        }
        quitDriver();
        logger.info("Browser is closed successfully");
    }
}
