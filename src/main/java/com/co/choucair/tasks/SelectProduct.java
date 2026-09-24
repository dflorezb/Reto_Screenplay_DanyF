package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.AddProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SelectProduct implements Task {
    private final String productName;

    public SelectProduct(String productName) {
        this.productName = productName;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AddProductPage.product(productName), isVisible()).forNoMoreThan(10).seconds(),
                Click.on(AddProductPage.product(productName))
        );
    }
    public static SelectProduct producto(String productName){
        return instrumented(SelectProduct.class, productName);
    }



}
