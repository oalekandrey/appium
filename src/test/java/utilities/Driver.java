package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;

import java.net.URL;

public class Driver {

    static private MobileDriver<MobileElement> driver;

    private Driver(){}

    public static  MobileDriver<MobileElement> getDriver(){
        String driverType;
        URL url = null;
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability(MobileCapabilityType.PLATFORM_NAME, PropertyReader.readProperty("platformName"));
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION, PropertyReader.readProperty("platformVersion"));
        caps.setCapability(MobileCapabilityType.DEVICE_NAME, PropertyReader.readProperty("deviceName"));
        caps.setCapability(MobileCapabilityType.UDID, PropertyReader.readProperty("udid"));
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, PropertyReader.readProperty("newCommandTimeout"));
//        caps.setCapability(MobileCapabilityType.APP, PropertyReader.readProperty("app"));
//        caps.setCapability(MobileCapabilityType.BROWSER_NAME, PropertyReader.readProperty("browserName"));
//        caps.setCapability("appPackage","com.myos.calculator");               // for native apps only
//        caps.setCapability("appActivity","com.myos.calculator.Calculator");  // for native apps only

        try {
            url = new URL(PropertyReader.readProperty("appiumServerUrl"));
        }catch(Exception e){
            System.out.println("Cause is : " + e.getCause());
            System.out.println("Message is : " + e.getMessage());
            e.printStackTrace();
        }


        if(driver == null) {
            driverType = PropertyReader.readProperty("driverType");

            switch (driverType.toLowerCase()) {
                case "android":
                    driver = new AndroidDriver<MobileElement>(url,caps);
                    break;
                case "ios":
                    driver = new IOSDriver<MobileElement>(url, caps);
                    break;
                case "appium":
                    driver = new AppiumDriver<MobileElement>(url,caps);
                    break;
                default:
                    throw new RuntimeException("Invalid driver type");
            }
        }
        return driver;
    }


    public static  void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }

}
