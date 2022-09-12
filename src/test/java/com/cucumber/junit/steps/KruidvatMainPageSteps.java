package com.cucumber.junit.steps;

import api.BaseRequest;
import api.SessionStorage;
import api.Specifications;
import api.StepData;
import desktop.pages.KruidvatMainPage;
import dto.Order;
import dto.Product;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.openqa.selenium.Cookie;

import java.io.File;

import static configuration.driver.DriverManager.getDriver;
import static constants.Constants.KRUIDVAT_URL;
import static enums.RequestPaths.USERS_CARTS;
import static enums.RequestPaths.USER_ENTRIES;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class KruidvatMainPageSteps {

    private final StepData stepData;

    public KruidvatMainPageSteps(StepData stepData) {
        this.stepData = stepData;
    }

    String productCode = "2876350";
    int quantity = 1;

    Product product = new Product(productCode);
    Order order = new Order(product, quantity);
    BaseRequest baseRequest = new BaseRequest();
    SessionStorage sessionStorage = new SessionStorage();
    KruidvatMainPage kruidvatMainPage = new KruidvatMainPage();

    @Then("the user opens the 'Kruidvat' page$")
    public void openMainPage() {
        kruidvatMainPage.openMainPage();
    }

    @When("the user clears all cookies")
    public void deleteAllCookies() {
        kruidvatMainPage.deleteAllCookies();
    }

    @When("the user adds the {string} cookies")
    public void addRequiredCookies(String cookie) {
        getDriver().manage().addCookie(new Cookie(cookie, (String) sessionStorage.getSessionStorage().get("guid")));
    }

    @When("the user refreshes the page")
    public void refreshPage() {
        kruidvatMainPage.refreshPage();
    }

    @When("the user navigates to the Cart page")
    public void navigateToTheCartPage() {
        kruidvatMainPage.navigateToCart();
    }

    @Given("the user create cart via API")
    public void createCartViaAPI() {
        String jsonString = baseRequest
                .sendPostRequest(Specifications.requestSpecification(KRUIDVAT_URL + USERS_CARTS.path)).asString();
        sessionStorage.createSessionStorage(jsonString);
    }

    @When("the user adds product for {string} path param to cart via API")
    public void addProductForPathParamToCartViaAPI(String pathParam) {
        Specifications.installSpecification(Specifications.requestSpecification(KRUIDVAT_URL, pathParam, sessionStorage.getSessionStorage()
                .get(pathParam)), Specifications.responseSpecification(200));
        stepData.response = given().body(order)
                .when()
                .post(USER_ENTRIES.path);
    }

    @Then("the user verifies that cart response has expected schema: {string}")
    public void verificationSchema(String pathname) {
        stepData.response
                .then()
                .body(JsonSchemaValidator.matchesJsonSchema(new File(pathname)));
    }

    @Then("the user verifies that cart response has expected quantity")
    public void verificationQuantity() {
        stepData.response
                .then().body("entry.quantity", equalTo(quantity));
    }

    @Then("the user verifies that cart response has expected product code")
    public void verificationProductCode() {
        stepData.response
                .then().body("entry.product.code", equalTo(productCode));
    }

}
