package com.petstore.testing.stepdefinitions;

import io.cucumber.java.en.Then;

import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

public class CommonStepDefinitions {

    @Then("status of response is {int} ")
    public void responseStatus(int status) {
        restAssuredThat(response -> response.statusCode(status));
    }
}
