package com.cucumber.junit.steps;

import desktop.pages.BookDepositoryHomePage;
import driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import static constants.Constants.HOME_URL;

public class NavigationBarSteps {

    BookDepositoryHomePage bookDepositoryHomePage = new BookDepositoryHomePage(DriverManager.getDriver());

    @When("the user opens BookDepositoryHomePage page")
    public void openBookDepositoryHomePage() {
        bookDepositoryHomePage.open(HOME_URL);
    }

    @When("the user click on the {string} icon")
    public void clickOnIcon(String icon) {
        bookDepositoryHomePage.getNavigationBar().getIcon(icon).click();
    }

    @Then("the page with {string} url is displayed")
    public void verifyPageUrl(String pageUrl) {
        String actualPageUrl = DriverManager.getDriver().getCurrentUrl();
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
        }
    }
}
