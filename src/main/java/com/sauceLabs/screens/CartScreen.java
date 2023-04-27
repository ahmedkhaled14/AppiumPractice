package com.sauceLabs.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CartScreen {

   private final By  proceedToCheckoutButton = AppiumBy.xpath("//*[@content-desc=\"Proceed To Checkout button\"]");
    AndroidDriver driver ;
    public CartScreen(AndroidDriver driver) {
        this.driver = driver;
    }


    /**
     *
     * @return new Checkout Screen
     */
    @Step("click On Proceed To Checkout Button")
    public CheckoutScreen clickOnProceedToCheckoutButton(){
        driver.findElement(proceedToCheckoutButton).click();
        return new CheckoutScreen(driver);
    }
}
