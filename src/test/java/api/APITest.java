package api;

import dto.Product;
import dto.Order;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import java.io.File;

import static constants.Constants.KRUIDVAT_URL;
import static enums.RequestPaths.USERS_CARTS;
import static enums.RequestPaths.USER_ENTRIES;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest {

    @Test
    public void verifyOrderInCart() {

        String productCode = "2876350";
        int quantity = 1;

        BaseRequest baseRequest = new BaseRequest();
        SessionStorage sessionStorage = new SessionStorage();

        String jsonString = baseRequest.sendPostRequest(Specifications.requestSpecification(KRUIDVAT_URL + USERS_CARTS.path)).asString();
        sessionStorage.createSessionStorage(jsonString);

        Specifications.installSpecification(Specifications.requestSpecification(KRUIDVAT_URL, "guid", sessionStorage.getSessionStorage()
                .get("guid")), Specifications.responseSpecification(200));

        Product product = new Product(productCode);
        Order order = new Order(product, quantity);

        given()
                .body(order)
                .when()
                .post(USER_ENTRIES.path)
                .then()
                .body("entry.product.code", equalTo(productCode))
                .body("entry.quantity", equalTo(quantity))
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/json-schema/schema.json")));
    }
}
