package config;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.net.MalformedURLException;
import java.net.URL;

public class AppiumConfig {

    public static AppiumDriver<AndroidElement> driver;


       // "platformName": "Android",                            iz Appium
       //   "deviceName": "GalinaNext5",
       // "platformVersion": "11.0",
       //"appPackage": "com.telran.ilcarro",
       // "appActivity": ".SplashActivity"

    @BeforeMethod
    public void setup(){   //nastroyki podklychenia k appium
        DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
        desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName", "GalinaNext5");
        desiredCapabilities.setCapability("platformVersion","11.0");
        desiredCapabilities.setCapability("appPackage", "com.telran.ilcarro");
        desiredCapabilities.setCapability("appActivity", ".SplashActivity");
        desiredCapabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME,"Appium");
        String urlNex5 = "http://localhost:4723/wd/hub";           //put' k metu emulatora


        try {
            driver = new AppiumDriver<>(new URL(urlNex5), desiredCapabilities);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


    }

    @AfterMethod
    public void tearDown(){
      //  driver.quit();

    }

}
