package com.sauceLabs.screens;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginScreen {

    private final By userNameLocator = AppiumBy.accessibilityId("Username input field");
    private final By passwordLocator = AppiumBy.accessibilityId("Password input field");
    private final By loginButtonLocator = AppiumBy.accessibilityId("Login button");

    AndroidDriver driver;
    public LoginScreen(AndroidDriver driver) {
        this.driver = driver;
    }


    /**
     *
     * @param username value from src/test/resources/testData/loginTestData.json
     * @param password value from src/test/resources/testData/loginTestData.json
     * @return new Home Screen
     */
    @Step("login Using Valid Email And Password ==> user Name: [{username}], password: [{password}]")
    public HomeScreen loginUsingValidEmailAndPassword(String username , String password){
        driver.findElement(userNameLocator).clear();
        driver.findElement(userNameLocator).sendKeys(username);
        driver.findElement(passwordLocator).clear();
        driver.findElement(passwordLocator).sendKeys(password);
        driver.findElement(loginButtonLocator).click();
        return new HomeScreen(driver);
    }


}
