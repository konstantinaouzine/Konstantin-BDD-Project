package stepdefs;

import cucumber.api.PendingException;
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

    @Given("^a pet with \"([^\"]*)\" field$")
    public void aPetWithField(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^pet with \"([^\"]*)\" successfully added$")
    public void petWithSuccessfullyAdded(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Given("^a pet with \"([^\"]*)\" set with \"([^\"]*)\"$")
    public void aPetWithSetWith(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @Then("^pet adding failed with \"([^\"]*)\"$")
    public void petAddingFailedWith(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^response message contains \"([^\"]*)\"$")
    public void responseMessageContains(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
