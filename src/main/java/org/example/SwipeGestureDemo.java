
package org.example;
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

public class SwipeGestureDemo {
    public static void main(String[] args) throws InterruptedException {
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

        // Setting the implicit wait
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        int startX = 300; // Starting X coordinate
        int startY = 800; // Starting Y coordinate
        int endX = 300; // Ending X coordinate
        int endY = 100; // Ending Y coordinate
        int duration = 2000; // Duration of the swipe (in milliseconds)

        TouchAction touchAction = new TouchAction(driver);
        touchAction.press(PointOption.point(startX, startY))
                .waitAction(waitOptions(Duration.ofMillis(duration)))
                .moveTo(PointOption.point(endX, endY))
                .release()
                .perform();

        // Add a wait time to observe the action
        Thread.sleep(3000);
        System.out.println("completed");
        driver.quit();
    }
}
