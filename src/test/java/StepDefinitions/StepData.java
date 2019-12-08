package StepDefinitions;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class StepData {
    Response response;
    ValidatableResponse json;
    RequestSpecification request = io.restassured.RestAssured.given();
}
