package com.sauceLabs.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class HomeScreen {
    public static By products = AppiumBy.xpath("//*[@text='Products']");
    private final By openMenuLocator = AppiumBy.xpath("//*[@content-desc=\"open menu\"]");
    private final By loginButton = AppiumBy.accessibilityId("menu item log in");
    private final By product1 = AppiumBy.xpath("(//*[@content-desc=\"store item\"])[1]");

    AndroidDriver driver;

    public HomeScreen(AndroidDriver driver) {
        this.driver = driver;
    }

    /**
     *
     * @return Home Screen
     */
    @Step("click On Open Menu")
    public HomeScreen clickOnOpenMenu() {
        driver.findElement(openMenuLocator).click();
        return this;
    }

    /**
     *
     * @return new Login Screen
     */
    @Step("click On Login")
    public LoginScreen clickOnLogin() {
        driver.findElement(loginButton).click();
        return new LoginScreen(driver);
    }

    /**
     *
     * @return new Product Screen
     */
    @Step("choose Product")
    public ProductScreen chooseProduct() {
        driver.findElement(product1).click();
        return new ProductScreen(driver);
    }
}
