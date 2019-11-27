package StepDefinitions;

import ApiObjects.Category;
import ApiObjects.Pet;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import static org.hamcrest.Matchers.equalTo;

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

    @Then("^be happy$")
    public void beHappy() throws Throwable {
        System.out.println("Background executed");
    }
//-----------------------------------------------------------------------------------------------
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

    @Given("^a pet with \"([^\"]*)\" set with \"([^\"]*)\"$")
    public void aPetWithSetWith(String arg0, String arg1) throws Throwable {
        switch(arg0){
            case "id":
                //Building Pet
                request_Pet = new Pet.Builder(Integer.getInteger(arg1)).build();
                break;
            case "name":
                //Building Pet
                request_Pet = new Pet.Builder(1001).setName(arg1).build();
                break;
            case "status":
                //Building Pet
                request_Pet = new Pet.Builder(1001).setStatus(arg1).build();
                break;
            case "category":
                String[] category_arr = arg1.split(", ");
                int first_param = Integer.parseInt(category_arr[0]);
                String second_param = category_arr[1];
                //Building Pet
                request_Pet = new Pet.Builder(1111).setCategory(new Category(first_param,second_param)).build();
                break;
        }

        //Building JSON object
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String JSON = gson.toJson(request_Pet, Pet.class);
        stepData.request.body(JSON);
    }

    @Then("^operation completed with status code (\\d+)$")
    public void operationCompletedWithStatusCode(int arg0) throws Throwable {
        Assert.assertEquals(arg0, stepData.response.getStatusCode());
    }

    @And("^pet successfully added$")
    public void petSuccessfullyAdded() throws Throwable {
        Pet response_Pet = stepData.response.body().as(Pet.class);
        boolean result = (request_Pet.equals(response_Pet));
        Assert.assertTrue(result);
    }

    @And("^response message contains \"([^\"]*)\"$")
    public void responseMessageContains(String arg0) throws Throwable {
    stepData.response.then().body("message", equalTo(arg0));
    }
}
