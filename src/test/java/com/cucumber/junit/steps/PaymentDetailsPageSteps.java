package com.cucumber.junit.steps;

import com.cucumber.junit.TestContext;
import desktop.pages.PaymentDetailsPage;
import enums.Context;
import io.cucumber.java.en.Then;
import org.assertj.core.api.SoftAssertions;

public class PaymentDetailsPageSteps extends BaseStep {

    public PaymentDetailsPageSteps(TestContext testContext) {
        super(testContext);
    }

    PaymentDetailsPage paymentDetailsPage = new PaymentDetailsPage();

    @Then("the order contains corresponding prices")
    public void reviewPricesForFirstBook() {

        String vat = "0,00 €";

        SoftAssertions softAssertions = new SoftAssertions();

        softAssertions.assertThat(paymentDetailsPage.getTotal()).as("Total is incorrect")
                .isEqualTo(getScenarioContext().getContext(Context.BOOK_PRICE));
        softAssertions.assertThat(paymentDetailsPage.getSubTotal()).as("SubTotal is incorrect")
                .isEqualTo(getScenarioContext().getContext(Context.BOOK_PRICE));
        softAssertions.assertThat(paymentDetailsPage.getVat()).as("Vat is incorrect")
                .isEqualTo(vat);
        System.out.println(paymentDetailsPage.getVat());

        softAssertions.assertAll();
    }
}
