package com.sauceLabs.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class CheckoutCompleteScreen {

    private final By continueShoppingButton = AppiumBy.xpath("//*[@content-desc=\"Continue Shopping button\"]");



    AndroidDriver driver ;

    public CheckoutCompleteScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @return new Home Screen
     */
    @Step("Click On Continue Shopping Button")
    public HomeScreen ClickOncontinueShoppingButton(){
        driver.findElement(continueShoppingButton).click();
        return new HomeScreen(driver);
    }
}
