package com.cucumber.junit.steps;

import desktop.pages.YourBasketPage;
import io.cucumber.java.en.When;

public class YourBasketPageSteps {

    YourBasketPage yourBasketPage = new YourBasketPage();

    @When("the user navigates to the payment page")
    public void navigateToPaymentPage() {
        yourBasketPage.navigateToPaymentDetailsPage();
    }
}
