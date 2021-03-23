package com.petstore.testing.stepdefinitions;

import com.petstore.testing.templates.FieldValues;
import com.petstore.testing.templates.MergeFrom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.thucydides.core.annotations.Steps;
import com.petstore.testing.order.OrderResponse;
import com.petstore.testing.order.OrderActions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static net.serenitybdd.rest.SerenityRest.get;
import static org.assertj.core.api.Assertions.assertThat;

public class OrderStepDefinitions {

    @Steps
    OrderActions orderActions;

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
        orderActions.withDetails(order);
    }

    @Then("the com.petstore.testing.pet order should have id")
    public void the_pet_order_should_have_id() {
        Map<String, String> actualResponse = orderResponse.returned();

        assertThat(actualResponse.getOrDefault("id","")).isNotEmpty();
    }

    @Then("the com.petstore.testing.pet order should  fail")
    public void the_pet_order_should_fail() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("type","")).isEqualTo("unknown");
    }

    @Given("order details for order {string}")
    public void order_details_for_order(String string) {
        orderActions.withOrderId(string);
    }

    @And("the order details returned")
    public void the_order_details_returned() {
        Map<String, String> actualResponse = orderResponse.returned();

        assertThat(actualResponse.getOrDefault("id","")).isNotEmpty();

    }

    @Then("the order details returned is empty")
    public void the_order_details_returned_is_empty() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("id","")).isEmpty();

    }

    @And("the order details should have orderid")
    public void the_order_details_should_have_orderid() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("id","")).isNotEmpty();
    }

    @And("the order details returned with error message")
    public void the_order_details_returned_with_error_message() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("message","")).isEqualTo("Order not found");
    }

    @And("the order details returned with unknown error message")
    public void the_order_details_returned_with_unknown_error_message() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("type","")).isEqualTo("unknown");
    }

    @Given("delete the purchase order for order {string}")
    public void delete_the_purchase_order_for_order(String string) {
        orderActions.withDeleteId(string);

    }

    @And("purchase order deleted with success message")
    public void purchase_order_deleted_with_success_message() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("code","")).isNotBlank();
    }

    @And("the deletion of purchase order should throw error message")
    public void the_deletion_of_purchase_order_should_throw_error_message() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("message","")).isEqualTo("Order Not Found");
    }

    @And("the deletion of wrong purchase order should throw error message")
    public void the_deletion_of_wrong_purchase_order_should_throw_error_message() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("type","")).isEqualTo("unknown");
    }

    @Given("the com.petstore.testing.pet inventories in store")
    public void the_pet_inventories_in_store() {
        orderActions.withInventories("");

    }

    @And("inventories details of petstore is returned")
    public void inventories_details_of_petstore_is_returned() {
        Map<String, String> actualResponse = orderResponse.returned();
        assertThat(actualResponse.getOrDefault("available","")).isNotBlank();
    }
}
