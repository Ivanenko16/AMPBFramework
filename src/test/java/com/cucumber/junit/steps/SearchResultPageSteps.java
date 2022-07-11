package com.cucumber.junit.steps;

import com.cucumber.junit.TestContext;
import desktop.fragments.FilterYourSearch;
import desktop.pages.SearchResultPage;
import enums.Context;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class SearchResultPageSteps extends BaseStep {

    public SearchResultPageSteps(TestContext testContext) {
        super(testContext);
    }

    SearchResultPage searchResultPage = new SearchResultPage();
    FilterYourSearch filterYourSearch = new FilterYourSearch();

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

    @And("Search results contain the following products")
    public void checkSearchResult(DataTable dataTable) {
        List<String> bookList = dataTable.column(0);
        Assert.assertTrue("The search page doesn't contains all needed books", searchResultPage.getTitleAllBooks().containsAll(bookList));
    }

    @And("I apply the following search filters")
    public void filterSearchResult(DataTable dataTable) {
        List<List<String>> rows = dataTable.asLists(String.class);
        for (List<String> columns : rows) {
            filterYourSearch.selectFilter(columns.get(0), columns.get(1));
        }
        filterYourSearch.refineResults();
    }

    @And("Search results contain only the following products")
    public void checkResultSearch(DataTable dataTable) {
        List<String> bookList = dataTable.column(0);

        Assert.assertTrue("The expected book list is not the same as the actual book list",
                listEqualsIgnoreOrder(bookList, searchResultPage.getTitleAllBooks()));
    }

    @And("I click Add to basket button for product with name {string}")
    public void addBookToBasket(String book) {
        searchResultPage.addToBasket(book);
    }

    @And("I select {string} in basket pop-up")
    public void selectInBasketPopUp(String button) throws InterruptedException {
        searchResultPage.interactModalWindow(button);
    }
}
