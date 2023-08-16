package org.example;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class MobileElementMethodsDemo {
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
        MobileElement defaultUser = driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-standard_user\"]/android.widget.TextView"));
        defaultUser.click();
        MobileElement logIn =driver.findElement(By.xpath("//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]/android.widget.TextView"));
        logIn.click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        // Replace "Your_Locator_Strategy" and "Your_Locator_Value" with the appropriate locator strategy and value
        List<MobileElement> productTitles = driver.findElements(By.xpath("(//android.widget.TextView[@content-desc=\"test-Item title\"])"));
        System.out.println("Size of the product titles - " + productTitles.size());
        System.out.println("Get the text of single product title - " + productTitles.get(0).getText());
        System.out.println("Get attribute of the product title element - " + productTitles.get(0).getAttribute("package"));
        System.out.println("Is product title element displayed - " + productTitles.get(0).isDisplayed());
        System.out.println("Is product title selected selected - " + productTitles.get(0).isSelected());
        System.out.println("Is product title element enabled - " + productTitles.get(0).isEnabled());
        System.out.println("Get the tag name of product title - " + productTitles.get(0).getTagName());
        System.out.println(productTitles);
        driver.quit();
    }
}