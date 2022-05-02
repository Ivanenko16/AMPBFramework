package com.cucumber.junit.steps;

import desktop.pages.LoginPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class LoginPageSteps {

    LoginPage loginPage = new LoginPage();

    @When("the user opens BookDepositoryLogin page")
    public void openBookDepositoryLoginPage() {
        loginPage.openBookDepositoryLoginPage();
    }

    @When("the user fills {string} field")
    public void fillField(String field) {
        if ("Email".equals(field) || "BookDepositoryPassword".equals(field)) {
            loginPage
                    .switchToLogInFrame()
                    .fillField(field);
        } else {
            loginPage
                    .switchToRegisterFrame()
                    .fillField(field);
        }
    }

    @Then("clear button is appeared on {string} field")
    public void checkVisibleClearButton(String field) {
        Assert.assertTrue(loginPage.clearButtonIsDisplayed(field));
    }

    @And("the user click on the clear button in the {string} field")
    public void clickClearButton(String field) {
        loginPage.clickClearButton(field);
    }

    @Then("the {string} field is empty")
    public void checkFieldData(String field) {
        Assert.assertFalse(String.format("The %s field isn't empty", field), loginPage.clearButtonIsDisplayed(field));
    }
}
