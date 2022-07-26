package com.cucumber.junit.steps;

import com.cucumber.junit.TestContext;
import desktop.pages.HomePage;
import enums.Context;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import utils.UrlFactory;

public class HomePageSteps extends BaseStep {

    public HomePageSteps(TestContext testContext) {
        super(testContext);
    }

    HomePage homePage = new HomePage();

    @When("the user searches for {string} book")
    public void searchAnyBook(String book) {
        homePage.searchForTerms(book);
    }

    @When("the user navigate to the LoginPage page")
    public void navigateToTheLoginPagePage() {
        homePage.navigateToThePage("Sign in/Join");
    }

    @Then("the Homepage is opened with corresponding welcome message")
    public void checkWelcomeMessage() {
        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(homePage.getWelcomeMessage()).as("Welcome message is incorrect or in-displayed")
                .isEqualTo(String.format("Hello %s", getScenarioContext().getContext(Context.USER_NAME)));
        softAssertions.assertThat(homePage.successAlertIsDisplayed()).as("The success alert message is not displayed")
                .isTrue();
    }

    @Given("I am an anonymous customer with clear cookies")
    public void clearCookies() {
        homePage.deleteAllCookies();
    }

    @And("I open the {string}")
    public void openPage(String page) {
        homePage.open(UrlFactory.getUrl(page));
    }

    @Given("the user opens {string}")
    public void openThePage(String page) {
        homePage.open(UrlFactory.getUrl(page));
    }

    @And("I search for {string}")
    public void searchBook(String bookName) {
        homePage.searchForTerms(bookName);
    }
}
