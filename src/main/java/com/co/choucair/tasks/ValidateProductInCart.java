package com.co.choucair.tasks;

import com.co.choucair.userinterfaces.AddProductPage;
import com.co.choucair.userinterfaces.SaucedemoLoginPage;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class ValidateProductInCart implements Task {
    private final String productName;

    public ValidateProductInCart(String productName) {
        this.productName = productName;
    }
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(AddProductPage.product(productName), isVisible()).forNoMoreThan(10).seconds());
    }

    public static ValidateProductInCart producto(String productName) {
        return instrumented(ValidateProductInCart.class);
    }
}
