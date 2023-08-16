package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class LoginInteractionDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        // Initialize the driver and launch the app
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
        // Setting the implicit wait. Note that using explicit waits is recommended for a more efficient and reliable solution
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        // Identify the burger icon and click on it
//        MobileElement burgerIcon = driver.findElement(By.id("test-Username"));
//        burgerIcon.click();



        // Identify the username field, send keys, and hide keyboard
        MobileElement usernameField = driver.findElementByAccessibilityId("test-Username");
        usernameField.sendKeys("abc");
        driver.hideKeyboard();

        // Identify the password field, send keys, and hide keyboard
        MobileElement passwordField = driver.findElementByAccessibilityId("test-Password");
        passwordField.sendKeys("123345");
        driver.hideKeyboard();
// Identify the login button and click on it
        MobileElement logInButton = driver.findElementByAccessibilityId("test-LOGIN");
        logInButton.click();
        Thread.sleep(4000); // For observation purposes only, avoid in production scripts

        driver.quit();
    }
}