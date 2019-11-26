package stepdefs;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import util.StepData;

public class PostApiStepDefinitions {
    private StepData stepData;

    public PostApiStepDefinitions(StepData stepData) {
        this.stepData = stepData;
    }

    @Given("a pet with minimum fields")
    public void aPetWithMinimumFields() {
    }

    @When("a user sends post request for pet adding")
    public void aUserSendsPostRequestForPetAdding() {
    }

    @Then("pet successfully added")
    public void petSuccessfullyAdded() {
    }

    @Given("a pet with {string} field")
    public void aPetWithField(String arg0) {
    }

    @Then("pet with <field_response_value> successfully added")
    public void petWithField_response_valueSuccessfullyAdded() {
    }

    @Given("a pet with <field_name> set with <field_value>")
    public void aPetWithField_nameSetWithField_value() {
    }

    @Then("pet adding failed with <status_code>")
    public void petAddingFailedWithStatus_code() {
    }

    @And("response message contains <message_data>")
    public void responseMessageContainsMessage_data() {
    }
}
