package com.cucumber.junit.steps;

import com.cucumber.junit.TestContext;
import desktop.pages.PaymentDetailsPage;
import enums.Context;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.assertj.core.api.SoftAssertions;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

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

    @And("I checkout as a new customer with email {string}")
    public void checkoutAsANewCustomerWithEmail(String email) {
        paymentDetailsPage.fillEmail(email);
    }

    @And("Checkout order summary is as following:")
    public void checkoutOrderSummary(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        SoftAssertions softAssertions = new SoftAssertions();
        for (Map<String, String> columns : rows) {
            softAssertions.assertThat(columns.get("Sub-total")).as("Sub-total is incorrect")
                    .isEqualTo(paymentDetailsPage.getSubTotal());
            softAssertions.assertThat(columns.get("Delivery")).as("Delivery is incorrect")
                    .isEqualTo(paymentDetailsPage.getDelivery());
            softAssertions.assertThat(columns.get("VAT")).as("VAT is incorrect")
                    .isEqualTo(paymentDetailsPage.getVat());
            softAssertions.assertThat(columns.get("Total")).as("Total is incorrect")
                    .isEqualTo(paymentDetailsPage.getTotal());
        }
        softAssertions.assertAll();
    }

    @And("I fill delivery address information manually:")
    public void fillDeliveryAddressInformationManually(DataTable dataTable) {
        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);

        for (Map<String, String> columns : rows) {
            paymentDetailsPage.setFullName(columns.get("Full name"));
            paymentDetailsPage.setDeliveryCountyDropdown(columns.get("Delivery country"));
            paymentDetailsPage.setAddress1(columns.get("Address line 1"));
            paymentDetailsPage.setAddress2(columns.get("Address line 2"));
            paymentDetailsPage.setCountry(columns.get("County/State"));
            paymentDetailsPage.setPostcode(columns.get("Postcode"));
            paymentDetailsPage.setCity(columns.get("Town/City"));
        }
    }

    @Then("There is no validation error messages displayed on Delivery Address form")
    public void checkAlertIsAppeared() {
        Assert.assertFalse("Validation error messages are displayed", paymentDetailsPage.checkAlertIsAppeared());
    }

    @When("I enter my card details")
    public void iEnterMyCardDetails(DataTable dataTable) {
        List<List<String>> data = dataTable.cells();
        paymentDetailsPage.enterCardNumber(data.get(0).get(1));
        paymentDetailsPage.enterExpiryCardData(data.get(0).get(1));
        paymentDetailsPage.enterCvvCardData(data.get(0).get(1));
    }
}
