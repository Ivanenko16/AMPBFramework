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
        String str = DriverManager.getDriver().findElement(By.xpath("//div[@class='product-summary__wrapper']/a")).getText();
        Assert.assertTrue("Cart contains expected product", str.contains("2876350"));
    }
}
