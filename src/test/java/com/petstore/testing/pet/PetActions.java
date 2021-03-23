package com.petstore.testing.pet;

import com.petstore.testing.WebServiceEndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetActions {

    @Step("Record a new order")
    public void petDetails(String pet) {


        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .post(WebServiceEndPoints.ORDER.getUrl() + "/com/petstore/testing/pet");
    }

    @Step("RetrieveOrder")
    public void withOrderId(String orderId) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(WebServiceEndPoints.ORDER.getUrl()+ "/order" + '/'+ orderId);
    }

    @Step("DeleteOrder")
    public void withDeleteId(String orderId) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .delete(WebServiceEndPoints.ORDER.getUrl()+ "/order" + '/'+ orderId);
    }

    @Step("GetInventories")
    public void withInventories(String orderId) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .when()
                .get(WebServiceEndPoints.ORDER.getUrl() +  "/inventory");
    }

}
