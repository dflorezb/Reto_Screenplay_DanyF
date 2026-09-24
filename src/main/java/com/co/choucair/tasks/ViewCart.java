package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.AddProductPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ViewCart implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(AddProductPage.BTN_CART)
        );
    }

    public static ViewCart view() {
        return instrumented(ViewCart.class);
    }
}
