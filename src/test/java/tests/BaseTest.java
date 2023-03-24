package tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.*;
import utilities.Driver;
import utilities.PropertyReader;
import utilities.Utils;

import java.lang.reflect.Method;
import java.net.URL;

public class BaseTest {

  protected MobileDriver<MobileElement> driver;
  protected static ExtentReports report;
  protected static ExtentSparkReporter htmlReport;
  protected static ExtentTest logger;


   @BeforeSuite(alwaysRun = true)
   public void setupReport(){
       report = new ExtentReports();
       String path = System.getProperty("user.dir") + "/target/extentReports/extentReport.html";
       htmlReport = new ExtentSparkReporter(path);
       report.attachReporter(htmlReport);
       report.setSystemInfo("Name","Test Automation results");
       report.setSystemInfo("Automation Engineer","Andrey Oreshenkov");

   }

   @AfterSuite(alwaysRun = true)
   public void tearDownReport(){
       report.flush();
   }

    @BeforeMethod(alwaysRun = true)
    public void setupMethod(Method method){
       driver = Driver.getDriver();
       logger = report.createTest(method.getName());
    }


    @AfterMethod(alwaysRun = true)
    public void tearDownMethod(ITestResult testResult){
        if(testResult.getStatus() == ITestResult.SUCCESS){
            logger.pass("Test PASSED: " + testResult.getName());
        }else if(testResult.getStatus() == ITestResult.SKIP){
            logger.skip("Test SKIPPED: " + testResult.getName());
        }else if(testResult.getStatus() == ITestResult.FAILURE){
            logger.fail("Test FAILED: " + testResult.getName());
            logger.fail("The exception message: " + testResult.getThrowable());
            logger.addScreenCaptureFromPath(Utils.getScreenshotOnFailure());
        }

       Driver.closeDriver();
    }
}
