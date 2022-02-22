package com.cucumber.junit.steps;

import desktop.pages.BookDepositoryLoginPage;
import driver.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BookDepositoryLoginPageSteps {

    BookDepositoryLoginPage bookDepositoryLoginPage = new BookDepositoryLoginPage(DriverManager.getDriver());

    @When("the user opens BookDepositoryLogin page")
    public void openBookDepositoryLoginPage() {
        bookDepositoryLoginPage.openBookDepositoryLoginPage();
    }

    @When("the user fills email field")
    public void theUserFillsEmailField() {
        bookDepositoryLoginPage
                .switchToLogInFrame()
                .setEmail("tractor@gmail.com");
    }

    @Then("clear button is appeared on email field")
    public void clearButtonIsAppearedOnEmailField() {
        String style = bookDepositoryLoginPage.getStyleClearEmailButton();

        Assert.assertEquals("No button", "display: block;", style);
    }
}
