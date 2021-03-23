package com.petstore.testing.stepdefinitions;

import com.petstore.testing.templates.FieldValues;
import com.petstore.testing.templates.MergeFrom;
import io.cucumber.java.en.Given;
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

}
