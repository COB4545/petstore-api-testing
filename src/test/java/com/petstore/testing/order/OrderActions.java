package com.petstore.testing.order;

import com.petstore.testing.WebServiceEndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class OrderActions {

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

    @Step("RetrieveOrder")
    public void withOrderId(String orderId) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(WebServiceEndPoints.ORDER.getUrl()+'/'+orderId);
    }
}
