package com.cucumber.junit.steps;

import desktop.fragments.FilterYourSearch;
import desktop.pages.BestsellersPage;
import configuration.driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

import static constants.Constants.BESTSELLERS_URL;

public class BestsellersPageSteps {

    BestsellersPage bestsellersPage = new BestsellersPage();
    FilterYourSearch filterYourSearch = new FilterYourSearch();

    @When("the user opens BookDepositoryBestsellers page")
    public void openBookDepositoryBestsellersPage() {
        DriverManager.getDriver().get(BESTSELLERS_URL);
    }

    @When("the user select {string} price")
    public void selectPrice(String price) {
        filterYourSearch.selectPriceRange(price);
    }

    @And("the user click on the refine results button")
    public void refineResults() {
        filterYourSearch.refineResults();
    }

    @Then("the books are filtered by {string}")
    public void checkFilteringBooksByPrice(String price) {
        if (Objects.equals(price, "Under €15")) {
            Map<String, Double> booksWrongSortByPrice = bestsellersPage.getAllBooks()
                    .entrySet()
                    .stream()
                    .filter(p -> p.getValue() > 15.00)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            Assert.assertTrue("The books aren't filtered correctly: " + booksWrongSortByPrice,
                    booksWrongSortByPrice.isEmpty());
        } else if (Objects.equals(price, "€15 to €30")) {
            Map<String, Double> booksWrongSortByPrice = bestsellersPage.getAllBooks()
                    .entrySet()
                    .stream()
                    .filter(p -> p.getValue() < 15.00 || p.getValue() > 30.00)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            Assert.assertTrue("The books aren't filtered correctly: " + booksWrongSortByPrice,
                    booksWrongSortByPrice.isEmpty());
        } else if (Objects.equals(price, "€30 +")) {
            Map<String, Double> booksWrongSortByPrice = bestsellersPage.getAllBooks()
                    .entrySet()
                    .stream()
                    .filter(p -> p.getValue() < 30.00)
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
            Assert.assertTrue("The books aren't filtered correctly: " + booksWrongSortByPrice,
                    booksWrongSortByPrice.isEmpty());
        }
    }
}

