package com.cucumber.junit.steps;

import desktop.pages.KruidvatCartPage;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class KruidvatCartPageSteps {

    KruidvatCartPage kruidvatCartPage = new KruidvatCartPage();

    @Then("the user verifies that Cart contains expected product")
    public void verifiesThatCartContainsExpectedProduct() {
        kruidvatCartPage.moveCursorToProduct();
        Assert.assertTrue("Cart doesn't contain expected product", kruidvatCartPage.getProductHref().contains("2876350"));
    }

}
