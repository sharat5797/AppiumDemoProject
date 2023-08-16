package org.example;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

public class BrowserAutomationWithWebElements {

    public static void main(String[] args) throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel_6");
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("browserName", "Chrome");
        capabilities.setCapability("udid", "emulator-5554");
        capabilities.setCapability("chromedriverExecutable","/Users/testvagrant/Downloads/chromedriver_mac64-2/chromedriver");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("w3c", false);
        capabilities.merge(chromeOptions);

        AppiumDriver<MobileElement> driver = new AndroidDriver<MobileElement>(new URL("http://localhost:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        driver.get("https://web-playground.ultralesson.com/");

        String title = driver.getTitle();
        System.out.println("Webpage Title: " + title);

        WebElement featuredProductElement = driver.findElement(By.cssSelector("#shopify-section-template--15328405749981__featured_products > div > slider-component > ul > li:nth-child(1) > div > div.card-information > div > h3 > a"));
        System.out.println("Featured Product Heading: " + featuredProductElement.getText());

        driver.quit();
    }
}
