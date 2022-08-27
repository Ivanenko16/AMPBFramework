package api;

import dto.Product;
import dto.Order;
import io.restassured.module.jsv.JsonSchemaValidator;
import org.junit.jupiter.api.Test;

import java.io.File;

import static constants.Constants.KRUIDVAT_URL;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class APITest {

    @Test
    public void verifyOrderInCart() {

        String productCode = "2876350";
        int quantity = 1;

        Specifications.installSpecification(Specifications.requestSpecification(KRUIDVAT_URL), Specifications.responseSpecification(201));

        String guid = given()
                .when()
                .post("api/v2/kvn/users/anonymous/carts")
                .body().jsonPath().get("guid");

        Specifications.installSpecification(Specifications.requestSpecification(KRUIDVAT_URL), Specifications.responseSpecification(200));

        Product product = new Product(productCode);
        Order order = new Order(product, quantity);

        given()
                .pathParam("guid", guid)
                .body(order)
                .when()
                .post("api/v2/kvn/users/anonymous/carts/{guid}/entries")
                .then()
                .body("entry.product.code", equalTo(productCode))
                .body("entry.quantity", equalTo(quantity))
                .body(JsonSchemaValidator.matchesJsonSchema(new File("src/test/resources/json-schema/schema.json")))
                .extract().response();
    }
}
