package com.co.choucair.stepdefinitions;


import io.cucumber.java.After;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

import io.cucumber.java.Before;
import static com.co.choucair.utils.GlobalData.*;
import net.serenitybdd.screenplay.actions.Open;


public class Hooks {

    @Before()

    public void setup (){
        OnStage.setTheStage(new OnlineCast());
    }
    //@Before ("@enterURL")




    /*@After
    public static void CloseDriver() throws IOException, InterruptedException {
        SerenityWebdriverManager.inThisTestThread().getCurrentDriver().quit();
        KillBrowser.processes(List.of((SerenityWebdriverManager.inThisTestThread().getCurrentDriverName()).split(":")).get(0));
    }*/

    @After
    public void CloseDriver() {
        OnStage.drawTheCurtain();
    }
}
