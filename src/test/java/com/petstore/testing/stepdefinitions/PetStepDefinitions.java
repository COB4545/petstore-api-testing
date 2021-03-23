package com.petstore.testing.stepdefinitions;

import com.petstore.testing.templates.FieldValues;
import com.petstore.testing.templates.MergeFrom;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;
import com.petstore.testing.pet.PetActions;
import com.petstore.testing.pet.PetResponse;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

public class PetStepDefinitions {

    @Steps
    PetActions petActions ;

    @Steps
    PetResponse petResponse ;

    String pet;

    @Given("the following pet details:")
    public void the_following_pet_details(List<Map<String, String>> petDetails) throws IOException {
        pet = MergeFrom.template("templates/pet.json")
                .withDefaultValuesFrom(FieldValues.in("templates/standard-pet.properties"))
                .withFieldsFrom(petDetails.get(0));
    }

    @When("I add the pet")
    public void i_add_the_pet() {
        petActions.withPetDetails(pet);
    }

    @And("the pet should be added")
    public void the_pet_should_be_added() {
        Map<String, String> actualResponse = petResponse.returned();
        assertThat(actualResponse.getOrDefault("id","")).isNotBlank();
    }

    @And("the pet request should be failed")
    public void the_pet_request_should_be_failed() {
        Map<String, String> actualResponse = petResponse.returned();
        assertThat(actualResponse.getOrDefault("code","")).isNotBlank();
    }

    @When("I update the pet data")
    public void i_update_the_pet_data() {
        petActions.withUpdatePetDetails(pet);
    }

    @Then("the pet id should be updated as given id value")
    public void the_pet_id_should_be_updated_as_given_id_value() {
        Map<String, String> actualResponse = petResponse.returned();
        assertThat(actualResponse.getOrDefault("id","")).isEqualTo("10.0");
    }

    @Then("the pet data update responds an error")
    public void the_pet_data_update_responds_an_error() {

    }

}
