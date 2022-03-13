package com.cucumber.junit.steps;

import desktop.pages.BookDepositoryLoginPage;
import driver.DriverManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class BookDepositoryLoginPageSteps {

    BookDepositoryLoginPage bookDepositoryLoginPage = new BookDepositoryLoginPage(DriverManager.getDriver());

    @When("the user opens BookDepositoryLogin page")
    public void openBookDepositoryLoginPage() {
        bookDepositoryLoginPage.openBookDepositoryLoginPage();
    }

    @When("the user fills {string} field")
    public void fillField(String field) {
        if ("Email".equals(field) || "BookDepositoryPassword".equals(field)) {
            bookDepositoryLoginPage
                    .switchToLogInFrame()
                    .fillField(field);
        } else {
            bookDepositoryLoginPage
                    .switchToRegisterFrame()
                    .fillField(field);
        }
    }

    @Then("clear button is appeared on {string} field")
    public void checkVisibleClearButton(String field) {
        String style = bookDepositoryLoginPage.getStyleClearButton(field);

        Assert.assertEquals("No button", "display: block;", style);
    }

    @And("the user click on the clear button in the {string} field")
    public void clickClearButton(String field) {
        bookDepositoryLoginPage.clickClearButton(field);
    }

    @Then("the {string} field is empty")
    public void checkFieldData(String field) {
        String style = bookDepositoryLoginPage.getStyleClearButton(field);

        Assert.assertEquals("No button", "display: none;", style);
    }
}
