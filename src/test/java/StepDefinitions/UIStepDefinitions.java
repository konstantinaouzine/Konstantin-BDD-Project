package StepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.testng.Assert;
import PageObjects.BankLoginPage;
import Utils.SharedDriver;

public class UIStepDefinitions {

    private BankLoginPage bankLoginPage;
    private SharedDriver sharedDriver;

    public UIStepDefinitions(SharedDriver sharedDriver, BankLoginPage bankLoginPage)
    {
        this.sharedDriver = sharedDriver;
        this.bankLoginPage = bankLoginPage;
    }

    @Given("^I am on the login page$")
    public void i_am_on_the_login_page() {
        bankLoginPage.openLoginPage();
    }

    @Then("^I should see login fields$")
    public void i_should_see_login_fields() {
        Assert.assertTrue(bankLoginPage.verifyOnLoginPage());
    }

    @Given("^I stay on login page$")
    public void i_stay_on_login_page() {
        Assert.assertTrue(bankLoginPage.verifyOnLoginPage());
    }

    @When("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
    public void i_fill_in_with(String param1_type, String param2_value) {
        switch(param1_type){
            case "Username":
                bankLoginPage.inputUsername(param2_value);
                break;
            case "Password":
                bankLoginPage.inputPassword(param2_value);
                break;
            default:
                throw new IllegalArgumentException("Argument not in list");

        }
    }

    @When("^I click on the LogIn button$")
    public void i_click_on_the_LogIn_button() {
        bankLoginPage.clickLoginButton();
    }

    @Then("^I am on the MyProfile page on URL \"([^\"]*)\"$")
    public void i_am_on_the_MyProfile_page_on_URL(String url) {
        Assert.assertTrue(bankLoginPage.verifyLoggedIn());
    }

    @And("^I should see the LogOut button$")
    public void i_should_see_the_LogOut_button() {
        Assert.assertTrue(bankLoginPage.verifyLogOutButtonShown());
    }

    @Then("^I should get Error screen$")
    public void i_should_get_Error_screen() {
        System.out.println(sharedDriver.switchTo().alert().getText());
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        sharedDriver.switchTo().alert().dismiss();
    }

}
