package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SauceLabsLocatorStrategyDemo {
    public static void main(String[] args) throws MalformedURLException, InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel_6");
        caps.setCapability("udid", "emulator-5554"); // You can get it from 'adb devices' command
        caps.setCapability("platformName", "Android");
        caps.setCapability("automationName", "UiAutomator2");
        caps.setCapability("app", "/Users/testvagrant/Downloads/Android.SauceLabs.Mobile.Sample.app.2.7.1.apk"); // Replace with your app's path
        caps.setCapability("appPackage", "com.swaglabsmobileapp");
        caps.setCapability("appActivity", "com.swaglabsmobileapp.MainActivity");
//        AndroidDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);
        AndroidDriver<MobileElement> driver = null;
        driver = new AndroidDriver<>(new URL("http://localhost:4723/wd/hub"), caps);

        Thread.sleep(7000);
        // Use Accessibility ID locator
        MobileElement element = driver.findElementByAccessibilityId("test-Username");
        System.out.println("Element By Accessibility ID: " + element);

        // Use Class Name locator
        MobileElement elementByClassName = driver.findElementByClassName("android.widget.EditText");
        System.out.println("Element By Class Name: " + elementByClassName);

        // Use XPath locator
        MobileElement elementByXpath = driver.findElement(By.xpath("//*[@text='Username']"));
        System.out.println("Element By XPath: " + elementByXpath);
//        Thread.sleep(4000);
        // Use ID locator
//        MobileElement element2 = driver.findElementById("com.swaglabsmobileapp:id/test-Username");
//        System.out.println("Element By ID: " + element2);

        // Use UI Automator locator
        MobileElement elementByUiAutomator = driver.findElementByAndroidUIAutomator("new UiSelector().text(\"Username\")");
        System.out.println("Element By UI Automator: " + elementByUiAutomator);

        driver.quit();
    }
}