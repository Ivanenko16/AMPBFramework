package com.cucumber.junit.steps;

import desktop.pages.BasketPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;

import java.util.List;
import java.util.Map;

public class BasketPageSteps {

    BasketPage basketPage = new BasketPage();

    @When("the user navigates to the payment page")
    public void navigateToPaymentPage() {
        basketPage.navigateToPaymentDetailsPage();
    }

    @And("Basket order summary is as following:")
    public void basketOrderSummaryIsAsFollowing(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        SoftAssertions softAssertions = new SoftAssertions();
        for (Map<String, String> columns : rows) {
            softAssertions.assertThat(columns.get("Delivery cost")).as("Delivery cost is incorrect")
                    .isEqualTo(basketPage.getDeliveryCost());
            softAssertions.assertThat(columns.get("Total")).as("Total is incorrect")
                    .isEqualTo(basketPage.getTotal());
        }
        softAssertions.assertAll();
    }

    @And("I click Checkout button on Basket page")
    public void clickCheckoutButtonOnBasketPage() {
        basketPage.navigateToPaymentDetailsPage();
    }
}
