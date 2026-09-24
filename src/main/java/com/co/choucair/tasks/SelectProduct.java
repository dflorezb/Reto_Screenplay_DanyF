package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.AddProductPage;
import com.co.choucair.userinterfaces.SaucedemoLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductSteps implements Task {
    private final String productName;

    public AddProductSteps(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AddProductPage.product(productName), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(AddProductPage.product(productName)),
                WaitUntil.the(AddProductPage.BTN_ADDTOCART,isVisible()).forNoMoreThan(10).seconds(),
                Click.on(AddProductPage.BTN_ADDTOCART),
                Click.on(AddProductPage.BTN_CART),
                WaitUntil.the(AddProductPage.productNameValidation(productName),isVisible()).forNoMoreThan(10).seconds()


        );
    }
    public static AddProductSteps producto(String productName){
        return instrumented(AddProductSteps.class, productName);
    }

    public  static  AddProductSteps add (){
        return instrumented(AddProductSteps.class);
    }

    public  static AddProductSteps viewCart(){
        return instrumented(AddProductSteps.class);
    }

}
