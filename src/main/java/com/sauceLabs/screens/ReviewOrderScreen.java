package com.sauceLabs.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ReviewOrderScreen {
    private final By placeOrderbutton = AppiumBy.xpath("//*[@content-desc=\"Place Order button\"]");

    AndroidDriver driver ;

    public ReviewOrderScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @return new Checkout Complete Screen
     */
    @Step("click On place Order Button")
    public CheckoutCompleteScreen clickOnplaceOrderbutton (){
        driver.findElement(placeOrderbutton).click();
        return new CheckoutCompleteScreen(driver);
    }
}
