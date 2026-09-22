package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class SaucedemoLoginPage {
  public static final Target TXT_USER = Target.the("txt")
          .located(By.id("user-name"));
  public static final Target TXT_PASS = Target.the("txt")
          .located(By.id("password"));
  public static final Target BTN_SUBMIT = Target.the("txt")
          .located(By.xpath("//input[@id='login-button']"));
  public static final Target TXT_VALIDATION = Target.the("txt")
          .located(By.xpath("//div[@class='app_logo']"));

}