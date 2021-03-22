package com.petstore.testing.order;

import com.petstore.testing.WebServiceEndPoints;
import io.restassured.response.Response;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class RetrieveOrder {


    @Step("RetrieveOrder")

    public void withorderid(String orderId) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(WebServiceEndPoints.ORDER.getUrl()+'/'+orderId);
    }
}
