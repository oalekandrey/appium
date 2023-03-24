package tests;

import io.appium.java_client.MobileBy;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.TestingPage;
import utilities.Driver;

public class TempTests extends BaseTest {

    @Test
    public void testOne(){

        Assert.assertEquals(2,1);
//        // for webBrowser in caps - > searching web elements in regular selenium way
//        driver.findElement(By.xpath(""));
    }

//    @Test
//    public void testTwo(){
//        //  for app in caps - > searching web elements
//        Assert.assertEquals(2,1);
////        driver.findElementByAndroidUIAutomator("new UISelector().resourceId(\"android:id/title\")").click();
////        driver.findElementByAndroidUIAutomator("new UISelector().description(\"neededDescription\")").click();
////        driver.findElementByAndroidUIAutomator("new UISelector().text(\"Hello world\")").click();
////        driver.findElementByAndroidUIAutomator("new UISelector().descriptionContains(\"Hello\")").click();
////        driver.findElementByAndroidUIAutomator("new UISelector().descriptionMatches(\"......\")").click();
////        driver.findElementByAndroidUIAutomator("new UISelector().textContains(\".....\")").click();
////        driver.findElementByAndroidUIAutomator("new UISelector().checked(true or false)").click();
////        driver.findElementByAndroidUIAutomator("new UISelector().index(1)").click();
//
//        //chaining selectors
////        driver.findElementByAndroidUIAutomator("new UISelector().description(\".....\").checked(true)").click();
//
//    }

    @Test
    public void testThree(){
        System.out.println("inside sample test3");

    }


    @Test
    public void testFive(){
        System.out.println("inside sample test5");

    }


    @Test
    public void testSix(){
        System.out.println("inside sample test6");

    }

//    @Test
//    public void testFour(){
//        Driver.getDriver().get("https://www.google.com/");
//
//    }



    @Test
    public void firstTestXPath(){

    }


    @Test
    public void firstTestID(){


    }


    @Test
    public void secondTestXpath(){
        TestingPage testingPage = new TestingPage();
        testingPage.galleryByXpath.click();


    }


    @Test
    public void secondTestID(){
        TestingPage testingPage = new TestingPage();
        testingPage.galleryID.click();

    }

    @Test
    public void thirdTestID(){
        Driver.getDriver().findElementByAccessibilityId("Gallery").click();
        //  Driver.getDriver().findElement(new MobileBy.ByAccessibilityId("Gallery")).click();


    }


    @Test
    public void thirdTestXpath(){
        Driver.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc=\"Gallery\"]")).click();

    }




    @Test
    public void fourthTestID(){
        Driver.getDriver().findElement(By.xpath("//android.appwidget.AppWidgetHostView[@content-desc=\"Search\"]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")).
        sendKeys("Appium", Keys.ENTER);

    }

}
