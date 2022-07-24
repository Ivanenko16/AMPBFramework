package com.cucumber.junit.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static constants.Constants.GECKO_WEB_DRIVER_FILE_PATH;
import static org.openqa.selenium.firefox.GeckoDriverService.GECKO_DRIVER_EXE_PROPERTY;

public class ParallelTestSteps {

    private WebDriver driver;

    @Given("^I configured WebDriver$")
    public void configuredWebDriver() {
        System.setProperty(GECKO_DRIVER_EXE_PROPERTY, GECKO_WEB_DRIVER_FILE_PATH);
        driver = new FirefoxDriver();
    }

    @When("^I open the '(.*)' page$")
    public void iOpenThePage(String pageUrl) {
        driver.get(pageUrl);
    }

    @Then("^I verify header is '(.*)'$")
    public void verifyHeader(String expectedHeader) {
        Assertions.assertEquals(expectedHeader, driver.getTitle(), "Incorrect page title");
    }

    @And("^I close browser$")
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }
}
