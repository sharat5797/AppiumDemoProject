package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

public class WebViewContextSwitch {

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
        MobileElement defaultUser = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-standard_user\"]/android.widget.TextView"));
        defaultUser.click();
        MobileElement logIn =driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView"));
        logIn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        MobileElement burgerIcon = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView"));
        burgerIcon.click();

        MobileElement webviewButton = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-WEBVIEW\"]/android.widget.TextView"));
        webviewButton.click();

        MobileElement webURLInputField = driver.findElement(By.xpath("//android.widget.EditText[@content-desc=\"test-enter a https url here...\"]"));
        webURLInputField.sendKeys("https://www.ultralesson.ai");

        MobileElement goToSite = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-GO TO SITE\"]"));
        goToSite.click();

        Set<String> contextHandles = driver.getContextHandles();

        Thread.sleep(10000);

        for(String context : contextHandles) {
            System.out.println(context);
            if (context.contains("WEBVIEW")) {
                driver.context(context);
                break;
            }
        }

        System.out.println("Title of webpage: " + driver.getTitle());

        driver.context("NATIVE_APP");

        MobileElement burgerIcon_ = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-Menu\"]/android.view.ViewGroup/android.widget.ImageView"));
        burgerIcon_.click();

        Thread.sleep(3000);
        System.out.println("completed");
        driver.quit();
    }
}
