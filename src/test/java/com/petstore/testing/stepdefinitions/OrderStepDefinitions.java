package com.petstore.testing.stepdefinitions;

import com.petstore.testing.templates.FieldValues;
import com.petstore.testing.templates.MergeFrom;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import com.petstore.testing.order.OrderResponse;
import com.petstore.testing.order.RecordNewOrder;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderStepDefinitions {

    @Steps
    RecordNewOrder recordNewOrder;

    @Steps
    OrderResponse orderResponse;

    String order;

    @Given("the following order:")
    public void the_following_order(List<Map<String, String>> orderDetails) throws IOException {

        order = MergeFrom.template("templates/order.json")
                         .withDefaultValuesFrom(FieldValues.in("templates/standard-order.properties"))
                         .withFieldsFrom(orderDetails.get(0));
    }

    @When("I record the order")
    public void i_record_the_order() {
        recordNewOrder.withDetails(order);
    }

    @Then("the order should have message")
    public void the_order_should_have_message() {
        restAssuredThat(response -> response.statusCode(200));
        Map<String, String> actualResponse = orderResponse.returned();

        assertThat(actualResponse.getOrDefault("message","")).isNotEmpty();
    }

}
