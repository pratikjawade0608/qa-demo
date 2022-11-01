package stepdefinitions.api;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.http.ParseException;
import reusable.TestBase;

import java.io.IOException;

public class APIStepDef extends TestBase {

    public APIStepDef() throws IOException {
    }

    @Given("Some pre condition is met")
    public void preCondition() throws ParseException {
    }

    @When("User does something")
    public void action() {
    }

    @Then("A condition passes")
    public void alwaysPass() {
        assert true;
    }

    @Then("A condition that never passes")
    public void neverPass() {
        assert false;
    }

}
