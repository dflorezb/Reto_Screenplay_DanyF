package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.AddProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AddProductToCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(
                        AddProductPage.BTN_ADDTOCART,
                        isVisible()
                ).forNoMoreThan(10).seconds(),
                Click.on(AddProductPage.BTN_ADDTOCART)
        );
    }

    public static AddProductToCart add() {
        return instrumented(AddProductToCart.class);
    }
}
