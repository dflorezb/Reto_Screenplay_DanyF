package com.co.choucair.tasks;

import com.co.choucair.models.UserLoombokData;
import com.co.choucair.userinterfaces.SaucedemoLoginPage;
import net.serenitybdd.core.steps.Instrumented;
import net.serenitybdd.screenplay.Actor;

import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class SaucedemoLoginSteps implements Task {
    UserLoombokData userLoombokData;

    public SaucedemoLoginSteps(UserLoombokData userLoombokData) {
        this.userLoombokData = userLoombokData;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(SaucedemoLoginPage.TXT_USER, isVisible()).forNoMoreThan(10).seconds(),
                Enter.theValue(userLoombokData.getUser()).into(SaucedemoLoginPage.TXT_USER),
                Enter.theValue(userLoombokData.getPass()).into(SaucedemoLoginPage.TXT_PASS),
                JavaScriptClick.on(SaucedemoLoginPage.BTN_SUBMIT),
                WaitUntil.the(SaucedemoLoginPage.TXT_VALIDATION, isVisible()).forNoMoreThan(10).seconds()
        );
    }
    public static SaucedemoLoginSteps onTheSite(UserLoombokData userLoombokData){
        return Instrumented.instanceOf(SaucedemoLoginSteps.class).withProperties(userLoombokData);
    }
}
