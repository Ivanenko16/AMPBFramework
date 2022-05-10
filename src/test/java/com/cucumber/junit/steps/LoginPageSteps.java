package com.cucumber.junit.steps;

import com.cucumber.junit.TestContext;
import desktop.pages.LoginPage;
import enums.Context;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class LoginPageSteps extends BaseStep {

    public LoginPageSteps(TestContext testContext) {
        super(testContext);
    }

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

    @When("the user fills join fields")
    public void fillsJoinFields(DataTable dataTable) {
        List<List<String>> userList = dataTable.asLists(String.class);
        loginPage.switchToRegisterFrame();
        for (List<String> user : userList) {
            loginPage.fillJoinField("Name", user.get(0));
            loginPage.fillJoinField("YourEmailAddress", user.get(1));
            loginPage.fillJoinField("CreateAPassword", user.get(2));
            getScenarioContext().setContext(Context.USER_NAME, user.get(0));
        }
    }

    @When("the user click on the CreateYourAccount button")
    public void registerNewAccount() {
        loginPage.registerNewAccount();
    }
}
