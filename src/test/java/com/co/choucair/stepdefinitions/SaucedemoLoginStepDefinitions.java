package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.SaucedemoLoginSteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import static com.co.choucair.userinterfaces.SaucedemoLoginPage.TXT_VALIDATION;
import static com.co.choucair.utils.GlobalData.ACTOR;
import static com.co.choucair.utils.GlobalData.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class SaucedemoLoginStepDefinitions {

    @Given("the user is on the saucedemo page")
    public void theUserIsOnTheSerenityDemoPage() {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
    }

    @When("attempts to log in")
    public void attemptsToLogIn(DataTable dataTable) {
        OnStage.theActorInTheSpotlight().attemptsTo(
                SaucedemoLoginSteps.onTheSite(UserLoombokData.setData(dataTable).get(0))
        );
    }

    @Then("^validate the text on screen (.*)$")
    public void validateTheTextOnScreenDashboard(String text) {
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(TXT_VALIDATION), containsString(text)));

    }
}
