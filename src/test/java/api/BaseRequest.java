package api;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class BaseRequest {

    public Response sendPostRequest(RequestSpecification requestSpecification) {
        return given().spec(requestSpecification)
                .when().post()
                .then().extract().response();
    }

}
