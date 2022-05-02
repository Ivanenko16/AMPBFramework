package com.cucumber.junit.steps;

import desktop.pages.HomePage;
import io.cucumber.java.en.When;

public class HomePageSteps {

    HomePage homePage = new HomePage();

    @When("the user searches for {string} book")
    public void searchAnyBook(String book) {
        homePage.searchForTerms(book);
    }

}
