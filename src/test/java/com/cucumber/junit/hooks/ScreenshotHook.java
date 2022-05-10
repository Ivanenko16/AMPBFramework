package com.cucumber.junit.hooks;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static constants.Constants.IMAGE_PNG;
import static driver.DriverManager.getDriver;
import static driver.DriverManager.quitDriver;

public class ScreenshotHook {

    @After
    public static void takeScreenshot(Scenario scenario) {
        if (scenario.isFailed()) {
            scenario.log(getDriver().getCurrentUrl());
            byte[] screenshot = ((TakesScreenshot) getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, IMAGE_PNG, scenario.getName());
        }
        quitDriver();
    }
}
