package com.petstore.testing.pet;

import com.petstore.testing.WebServiceEndPoints;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class PetActions {

    @Step("Record a new pet")
    public void withPetDetails(String pet) {


        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .post(WebServiceEndPoints.ORDER.getUrl() + "/pet");
    }

    @Step("Update pet details")
    public void withUpdatePetDetails(String pet) {

        SerenityRest.given()
                .relaxedHTTPSValidation()
                .contentType("application/json")
                .header("Content-Type", "application/json")
                .body(pet)
                .when()
                .put(WebServiceEndPoints.ORDER.getUrl()+ "/pet");
    }

}
