package com.sauceLabs.tests;

import com.sauceLabs.screens.HomeScreen;
import com.sauceLabs.utils.JsonFileManager;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.qameta.allure.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.*;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

@Epic("Sauce labs Android App")
@Feature("End to End")
public class EndToEndTest {

    private AndroidDriver driver;
    private DesiredCapabilities caps;
    private final JsonFileManager loginTestData = new JsonFileManager("src/test/resources/testData/loginTestData.json");
    private final JsonFileManager checkoutTestData = new JsonFileManager("src/test/resources/testData/checkoutTestData.json");
    private final JsonFileManager paymentTestData = new JsonFileManager("src/test/resources/testData/paymentTestData.json");

    @BeforeSuite
    public void appDesiredCapabilities() {
        caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, System.getProperty("deviceName"));
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, System.getProperty("platformName"));
        caps.setCapability(MobileCapabilityType.AUTOMATION_NAME, System.getProperty("androidAutomationName"));
        caps.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, System.getProperty("androidAppPackage"));
        caps.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, System.getProperty("androidAppActivity"));
        caps.setCapability("app", new File(System.getProperty("user.dir") + "/src/test/resources/app/Android-MyDemoAppRN.1.3.0.build-244.apk").getAbsolutePath());
    }

    @BeforeMethod
    public void upAndroidDriver() {
        try {
            driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    @Description
            (
                    "Given user open Sauce labs mobile application"+
                            "When click on Menu"+
                            "And click on Login"+
                            "And login Using Valid Email & Password"+
                            "And choose Product"+
                            "And click on counter Plus Button"+
                            "And click on add To Cart button"+
                            "And click on Cart Badge"+
                            "And click on Proceed To Checkout Button"+
                            "And fill Checkout Information"+
                            "And fill Payment Information"+
                            "And click on place order button"+
                            "And click on continue shopping button"+
                            "Then user should return to Home screen"
            )
    @Severity(SeverityLevel.CRITICAL)
    @Story("Buy A product")
    @Test(description = "End To End Scenario")
    public void endToEndScenario() {
        new HomeScreen(driver)
                .clickOnOpenMenu()
                .clickOnLogin()
                .loginUsingValidEmailAndPassword
                        (
                                loginTestData.getTestData("email"),
                                loginTestData.getTestData("password")
                        )
                .chooseProduct()
                .clickOncounterPlusButton()
                .clickOnaddToCartbutton()
                .clickOnCartBadge()
                .clickOnProceedToCheckoutButton()
                .fillCheckoutInformation
                        (
                                checkoutTestData.getTestData("FullName"),
                                checkoutTestData.getTestData("AddressLine"),
                                checkoutTestData.getTestData("AddressLine2"),
                                checkoutTestData.getTestData("City"),
                                checkoutTestData.getTestData("State"),
                                checkoutTestData.getTestData("ZipCode"),
                                checkoutTestData.getTestData("Country")
                        )
                .fillPaymentInformation
                        (
                                paymentTestData.getTestData("FullName"),
                                paymentTestData.getTestData("CardNumber"),
                                paymentTestData.getTestData("ExpirationDate"),
                                paymentTestData.getTestData("SecurityCode")
                        )
                .clickOnplaceOrderbutton()
                .ClickOncontinueShoppingButton();

        String productText = driver.findElement(HomeScreen.products).getText();
        Assert.assertEquals(productText, "Products");


    }

    @AfterMethod
    public void quitAndroidDriver() {
        driver.quit();
    }


}


