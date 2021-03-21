package com.petstore.testing.order;

import com.petstore.testing.WebServiceEndPoints;
import io.restassured.RestAssured;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RecordNewOrder {

    @Step("Record a new order")
    public void withDetails(String order) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(order)
                .when()
                .post(WebServiceEndPoints.ORDER.getUrl());
    }
}
