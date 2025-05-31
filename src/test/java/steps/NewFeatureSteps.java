package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class NewFeatureSteps {
    @Given("User in on the login page")
    public void userInOnTheLoginPage() {
        System.out.println("User is on the login page");
    }

    @Then("User enters valid username and valid password")
    public void userEntersValidUsernameAndValidPassword() {
        System.out.println("User enters valid username and password");
    }

    @And("User clicks on the login button")
    public void userClicksOnTheLoginButton() {
        System.out.println("User clicks on the login button");
    }


    @Then("User is directed to the successful login page")
    public void userIsDirectedToTheSuccessfulLoginPage() {
        System.out.println("User is directed to the login page");
    }
}
