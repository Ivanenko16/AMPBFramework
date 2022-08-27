package com.cucumber.junit.steps;

import configuration.driver.DriverManager;
import desktop.pages.KruidvatMainPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.Cookie;

public class KruidvatMainPageSteps {

    KruidvatMainPage kruidvatMainPage = new KruidvatMainPage();

    @Given("the user opens the 'Kruidvat' page$")
    public void openMainPage() {
        kruidvatMainPage.openMainPage();
    }

    @When("the user clears all cookies")
    public void theUserClearsAllCookies() {
        DriverManager.getDriver().manage().deleteAllCookies();
    }

    @When("the user adds the required cookies")
    public void theUserAddsTheRequiredCookies() {
        DriverManager.getDriver().manage().addCookie(new Cookie("guid","2876350"));
    }

    @When("the user refreshes the page")
    public void theUserRefreshesThePage() {
        DriverManager.getDriver().navigate().refresh();
    }

    @When("the user navigates to the Cart page")
    public void theUserNavigatesToTheCartPage() {
        kruidvatMainPage.navigateToTheCart();
    }

}
