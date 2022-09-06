package com.cucumber.junit.steps;

import com.cucumber.junit.hooks.DriverHook;
import desktop.pages.HomePage;
import configuration.driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;

import static constants.Constants.HOME_URL;

public class NavigationBarSteps {

    private static final Logger logger = LogManager.getLogger(NavigationBarSteps.class);

    HomePage homePage = new HomePage();

    @When("the user opens BookDepositoryHomePage page")
    public void openBookDepositoryHomePage() {
        homePage.open(HOME_URL);
        logger.info("Home page is opened");
    }

    @When("the user click on the {string} icon")
    public void clickOnIcon(String icon) {
        homePage.getNavigationBar().getIcon(icon).click();
    }

    @Then("I am redirected to a {string}")
    public void verifyPageUrl(String pageUrl) {
        JavascriptExecutor js = (JavascriptExecutor)DriverManager.getDriver();
        String actualPageUrl = js.executeScript("return document.URL;").toString();
        switch (pageUrl) {
            case "Help":
                String helpUrl = HOME_URL + pageUrl.toLowerCase();
                Assert.assertEquals("URL invalid or null", actualPageUrl, helpUrl);
                break;
            case "Order Status":
                String orderStatusUrl = HOME_URL + "track";
                Assert.assertEquals("URL invalid or null", actualPageUrl, orderStatusUrl);
                break;
            case "Contact us":
                String contactUsUrl = HOME_URL + pageUrl.toLowerCase().replace(" ", "");
                Assert.assertEquals("URL invalid or null", actualPageUrl, contactUsUrl);
                break;
            case "Wishlist":
                String wishListUrl = HOME_URL + "account/login";
                Assert.assertEquals("URL invalid or null", actualPageUrl, wishListUrl);
                break;
            case "Sign in/Join":
                String signUrl = HOME_URL + "account/login/to/account";
                Assert.assertEquals("URL invalid or null", actualPageUrl, signUrl);
                break;
            case "Search page":
                Assert.assertTrue("URL invalid or null", actualPageUrl.contains("search"));
                break;
            case "Basket page":
                Assert.assertTrue("URL invalid or null", actualPageUrl.contains("basket"));
                break;
        }
    }
}
