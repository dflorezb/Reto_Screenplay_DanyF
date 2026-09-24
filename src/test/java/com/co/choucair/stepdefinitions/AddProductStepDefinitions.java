package com.co.choucair.stepdefinitions;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.questions.ValidateText;
import com.co.choucair.tasks.AddProductToCart;
import com.co.choucair.tasks.SelectProduct;
import com.co.choucair.tasks.SaucedemoLoginSteps;

import com.co.choucair.tasks.ViewCart;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;

import static com.co.choucair.userinterfaces.AddProductPage.productNameValidation;
import static com.co.choucair.utils.GlobalData.ACTOR;
import static com.co.choucair.utils.GlobalData.URL;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static org.hamcrest.Matchers.containsString;

public class AddProductStepDefinitions {

    @Given("that the user is logged in")
    public void thatTheUserIsLoggedIn(DataTable dataTable) {
        OnStage.theActorCalled(ACTOR).wasAbleTo(Open.url(URL));
        OnStage.theActorInTheSpotlight().attemptsTo(
                SaucedemoLoginSteps.onTheSite(UserLoombokData.setData(dataTable).get(0))
        );

    }
    @When("select the product {string}")
    public void selectTheProduct(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(SelectProduct.producto(productName));

    }
    @When("add the product to the shopping cart")
    public void addTheProductToTheShoppingCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddProductToCart.add());
    }
    @Then("you should see the product {string} in the cart")
    public void youShouldSeeTheProductInTheCart(String productName) {
        OnStage.theActorInTheSpotlight().attemptsTo(ViewCart.view());
        OnStage.theActorInTheSpotlight().should(seeThat(ValidateText.of(productNameValidation(productName)), containsString(productName)));
    }
}
