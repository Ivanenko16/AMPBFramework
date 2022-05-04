package com.cucumber.junit.steps;

import com.cucumber.junit.TestContext;
import desktop.pages.SearchResultPage;
import enums.Context;
import io.cucumber.java.en.When;

public class SearchResultPageSteps extends BaseStep {

    public SearchResultPageSteps(TestContext testContext) {
        super(testContext);
    }

    SearchResultPage searchResultPage = new SearchResultPage();

    @When("the user adds the first book to the basket")
    public void addBookToBasket() {
        searchResultPage.addFirstBookToBasket();
    }

    @When("the user navigates to the basket page")
    public void navigateToBasketPage() {
        searchResultPage.navigateToYourBasketPage();
    }

    @When("the user get the price of the first book")
    public void getPriceOfFirstBook() {
        String firstBookPrice = searchResultPage.getPriceFirstBook();
        getScenarioContext().setContext(Context.BOOK_PRICE, firstBookPrice);
    }
}
