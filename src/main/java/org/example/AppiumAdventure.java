package org.example;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class AppiumAdventure {
    public static void main(String[] args) throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_6");
        caps.setCapability("udid", "emulator-5554"); // You can get it from 'adb devices' command
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/testvagrant/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk"); // Replace with your app's path
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
        AndroidDriver<MobileElement> driver = null;

        try {
            driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        } catch (MalformedURLException e) {
            System.out.println("The URL provided for the Appium server is not well formatted.");
            e.printStackTrace();
        }
        // Setting the implicit wait for demonstration. Note that using explicit waits is recommended for a more efficient and reliable solution
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        // Navigating to login screen
//        MobileElement burgerIcon = driver.findElement(LOCATOR);
//        burgerIcon.click();

//        MobileElement loginScreenNavigationButton = driver.findElement(LOCATOR);
//        loginScreenNavigationButton.click();

        MobileElement usernameField = driver.findElementByAccessibilityId("test-Username");
        usernameField.sendKeys("standard_user");
        driver.hideKeyboard();

        MobileElement passwordField = driver.findElementByAccessibilityId("test-Password");
        passwordField.sendKeys("secret_sauce");
        driver.hideKeyboard();

        MobileElement loginButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView"));
        loginButton.click();

        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\"Sauce Labs Onesie\"))"));

        MobileElement product = driver.findElement(MobileBy.xpath("//*[@text='Sauce Labs Onesie']"));

        product.click();

        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\"ADD TO CART\"))"));

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Adding the product to cart by clicking on the add to cart button
        MobileElement addToCartButton = driver.findElement(MobileBy.AccessibilityId("test-ADD TO CART"));
        addToCartButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Clicking on the cart icon
        MobileElement cartIcon = driver.findElement(MobileBy.xpath("//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView"));
        cartIcon.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Clicking on the proceed to checkout button
        MobileElement proceedToCheckoutButton = driver.findElement(MobileBy.AccessibilityId("test-CHECKOUT"));
        proceedToCheckoutButton.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Adding checkout details
        MobileElement firstNameField = driver.findElement(MobileBy.AccessibilityId("test-First Name"));
        firstNameField.sendKeys("Sharat");
        driver.hideKeyboard();


        MobileElement lastNameField = driver.findElement(MobileBy.AccessibilityId("test-Last Name"));
        lastNameField.sendKeys("Hegde");
        driver.hideKeyboard();


        MobileElement postalCode = driver.findElement(MobileBy.AccessibilityId("test-Zip/Postal Code"));
        postalCode.sendKeys("581336");
        driver.hideKeyboard();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        MobileElement addressLine2 = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        addressLine2.sendKeys("Entrance 1");
//        driver.hideKeyboard();
//
//        MobileElement cityName = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        cityName.sendKeys("Truro");
//        driver.hideKeyboard();
//
//        MobileElement state = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        state.sendKeys("Cornwall");
//        driver.hideKeyboard();
//
//        MobileElement zipCode = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        zipCode.sendKeys("89750");
//        driver.hideKeyboard();
//
//        MobileElement country = driver.findElement(MobileBy.AccessibilityId("LOCATOR"));
//        country.sendKeys("United Kingdom");
//        driver.hideKeyboard();

        // Clicking on the payment button to go to payment page
        MobileElement continueToPayment = driver.findElement(MobileBy.AccessibilityId("test-CONTINUE"));
        continueToPayment.click();

        driver.findElement(MobileBy.AndroidUIAutomator(
                "new UiScrollable(new UiSelector().scrollable(true))"
                        + ".scrollIntoView(new UiSelector().textContains(\"© 2023 Sauce Labs\"))"));

//        int startX = 462; // Starting X coordinate
//        int startY = 1941; // Starting Y coordinate
//        int endX = 462; // Ending X coordinate
//        int endY = 718; // Ending Y coordinate
//        int duration = 2000; // Duration of the swipe (in milliseconds)
//
//        TouchAction touchAction = new TouchAction(driver);
//        touchAction.press(PointOption.point(startX, startY))
//                .waitAction(waitOptions(Duration.ofMillis(duration)))
//                .moveTo(PointOption.point(endX, endY))
//                .release()
//                .perform();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MobileElement finish = driver.findElement(MobileBy.AccessibilityId("test-FINISH"));
        finish.click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Order done");
        driver.quit();

    }
}