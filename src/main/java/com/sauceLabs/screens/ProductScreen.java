package com.sauceLabs.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class ProductScreen {

    private final By counterPlusButton = AppiumBy.xpath("//*[@content-desc=\"counter plus button\"]");
    private final By addToCartButton = AppiumBy.xpath("//*[@content-desc=\"Add To Cart button\"]");
    private final By cartBadge = AppiumBy.xpath("//*[@content-desc=\"cart badge\"]");

    AndroidDriver driver;

    public ProductScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @return Product Screen
     */
    @Step("click On counter Plus Button")
    public ProductScreen clickOncounterPlusButton() {
        driver.findElement(counterPlusButton).click();
        return this;
    }

    /**
     *
     * @return Product Screen
     */
    @Step("click On Add To Cart Button")
    public ProductScreen clickOnaddToCartbutton() {
        driver.findElement(addToCartButton).click();
        return this;
    }

    /**
     *
     * @return new CartScreen
     */
    @Step("click On Cart Badge")
    public CartScreen clickOnCartBadge() {
        driver.findElement(cartBadge).click();
        return new CartScreen(driver);
    }
}
