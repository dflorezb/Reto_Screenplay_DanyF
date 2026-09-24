package com.co.choucair.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class AddProductPage {
    public static Target product(String productName){
        return Target.the("producto "+productName)
                .located(By.xpath(
                        "//div[@data-test='inventory-item-name' and normalize-space()='" + productName + "']"));
    }
    public static final Target BTN_ADDTOCART = Target.the("btn_add-to-cart")
            .located(By.xpath("//button[@id='add-to-cart']"));
    public static final Target BTN_CART = Target.the("btn-cart")
            .located(By.xpath("//a[@class='shopping_cart_link']"));
    public static Target productNameValidation(String productName){
        return Target.the("producto "+productName)
                .located(By.xpath(
                        "//div[@data-test='inventory-item-name' and normalize-space()='" + productName + "']"));
    }
}
