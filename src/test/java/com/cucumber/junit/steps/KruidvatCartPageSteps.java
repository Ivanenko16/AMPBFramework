package com.cucumber.junit.steps;

import configuration.driver.DriverManager;
import desktop.pages.KruidvatCartPage;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class KruidvatCartPageSteps {

    KruidvatCartPage kruidvatCartPage = new KruidvatCartPage();

    @When("the user verifies that Cart contains expected product")
    public void verifiesThatCartContainsExpectedProduct() {
        kruidvatCartPage.moveCursorToProduct();
        String str = DriverManager.getDriver().findElement(By.xpath("//*[contains(@href, '/p/2876350')] ")).getText();
        Assert.assertTrue("Cart doesn't contain expected product", str.contains("2876350"));
    }

}
