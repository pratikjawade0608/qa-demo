package stepdefinitions.functional;

import dataProviders.ConfigProperties;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import helpers.pageobjects.SampleDemoPage;

import java.io.IOException;

public class SampleDemoStepDef {

    private final SampleDemoPage window;
    private final ConfigProperties configProperties;

    public SampleDemoStepDef() throws IOException {
        this.window = new SampleDemoPage();
        this.configProperties = ConfigProperties.getConfigProperties();
    }

    @Given("^User is on the login page of Sample Test application$")
    public void user_is_on_the_login_page_of_Sample_Test_application() throws Throwable {
        window.validateWebsitelaunch();
    }

    @When("^User click on the hyperlink click here$")
    public void user_click_on_the_hyperlink_click_here() throws Throwable {
        window.clickOnclickHere();
    }

    @When("^the child window opens$")
    public void the_child_window_opens() throws Throwable {
        window.switchToNewtab();
    }

    @Then("^the user enters email in the text box$")
    public void the_user_enters_email_in_the_text_box() throws Throwable {
        window.enterEmail(this.configProperties.getString("AddMobileNum"));
    }

    @Then("^User navigates back to parent window$")
    public void user_navigates_back_to_parent_window() throws Throwable {
        window.switchToParentTab();
    }

    @Given("^User is click on the down button using mouse over action on the Test application$")
    public void user_is_click_on_the_down_button_using_mouse_over_action_on_the_Test_application() throws Exception {
        window.validatePageLaunch();
    }

    @When("^User enter the city in filter box and select the city$")
    public void user_enter_the_city_in_filter_box_and_select_the_city() throws Exception {
        window.mouseOverClickonelement();
    }

    @Then("^then the user user enter the pincode city select the filter options$")
    public void then_the_user_user_enter_the_pincode_city_select_the_filter_options() throws Exception {
        window.getCityFromDropDown();
        window.addPinCode();
    }

    @Given("^User is on the login page of the medibuddysite$")
    public void user_is_on_the_login_page_of_the_medibuddysite() throws Throwable {
        window.validatePagesLaunch();
    }

    @When("^User scrolls down to the e-card section and click on it$")
    public void user_scrolls_down_to_the_e_card_section_and_click_on_it() throws Throwable {
        window.clickOnEcard();
    }

    @Then("^User will be navigated to the ecard page$")
    public void user_will_be_navigated_to_the_ecard_page() throws Throwable {
        window.validateEcardpageDisplay();
    }

    @Then("^User will select any other radio button and enter the details in the employee id$")
    public void user_will_select_any_other_radio_button_and_enter_the_details_in_the_employee_id() throws Throwable {
        window.clickOnEmpIdRadioButton();
    }
}
