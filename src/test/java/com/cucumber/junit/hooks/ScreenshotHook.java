package com.cucumber.junit.hooks;

import driver.DriverManager;
import io.cucumber.java.Scenario;
import io.cucumber.java.After;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static constants.Constants.IMAGE_PNG;

public class ScreenshotHook {

    @After
    public void takeScreenshot(Scenario scenario) {
        scenario.log(DriverManager.getDriver().getCurrentUrl());
        byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
        scenario.attach(screenshot, IMAGE_PNG, scenario.getName());
    }
}
