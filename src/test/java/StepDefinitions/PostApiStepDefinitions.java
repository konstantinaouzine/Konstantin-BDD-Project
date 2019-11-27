package StepDefinitions;

import ApiObjects.Pet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;

public class PostApiStepDefinitions {
    private StepData stepData;
    private Pet request_Pet;

    public PostApiStepDefinitions(StepData stepData) {
        this.stepData = stepData;
    }

    @Given("^URL and headers setup performed$")
    public void urlAndHeadersSetupPerformed() throws Throwable {
        stepData.request.given()
            .baseUri("https://petstore.swagger.io/v2")
            .given().basePath("/pet")
            .given().contentType("application/json");
    }

    @Given("^a pet with id (\\d+)$")
    public void aPetWithId(int arg0) throws Throwable {
        //Building Pet
        request_Pet = new Pet.Builder(arg0).build();

        //Building JSON object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JSON = gson.toJson(request_Pet, Pet.class);
        stepData.request.body(JSON);
    }

    @When("^a user sends post request for pet adding$")
    public void aUserSendsPostRequestForPetAdding() throws Throwable {
        stepData.response = stepData.request.when().post();
    }

    @Then("^operation completed with status code (\\d+)$")
    public void operationCompletedWithStatusCode(int arg0) throws Throwable {
        Assert.assertEquals(arg0, stepData.response.getStatusCode());
    }

    @And("^pet successfully added$")
    public void petSuccessfullyAdded() throws Throwable {
        Pet response_Pet = stepData.response.body().as(Pet.class);
        boolean result = (
                response_Pet.getId() == request_Pet.getId() &&
                response_Pet.getName().equals(request_Pet.getName()) &&
                response_Pet.getStatus().equals(request_Pet.getStatus()) &&
                response_Pet.getCategory() == response_Pet.getCategory() &&
                response_Pet.getPhotoUrls() == request_Pet.getPhotoUrls() &&
                response_Pet.getTags() == request_Pet.getTags());
        Assert.assertTrue(result);
    }

    @Given("^a pet with \"([^\"]*)\" set with \"([^\"]*)\"$")
    public void aPetWithSetWith(String arg0, String arg1) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }

    @And("^response message contains \"([^\"]*)\"$")
    public void responseMessageContains(String arg0) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}
