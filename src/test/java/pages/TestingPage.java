package pages;

import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class TestingPage {

    public TestingPage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }


    @FindBy(xpath ="//android.widget.TextView[@content-desc=\"Gallery\"]")
    public MobileElement galleryByXpath;


    @AndroidFindBy  (accessibility = "Gallery")
    public AndroidElement galleryID;



    @AndroidFindBy (xpath ="//android.appwidget.AppWidgetHostView[@content-desc=\"Search\"]/android.widget.RelativeLayout/android.widget.LinearLayout/android.widget.TextView")
    public MobileElement searchbarByXpath;

    @AndroidFindBy(id = "com.android.quicksearchbox:id/search_widget_text")
    public AndroidElement searchbarID;





//    searchAttributes can not be blank, exception will be thrown
//    @AndroidFindBy(id = "")
//    public AndroidElement name;
//
//    @AndroidFindBy(id = "")
//    public AndroidElement name2;
//
//    @AndroidFindBy(id = "")
//    public AndroidElement name3;
//
//
//    @AndroidFindBy(id = "")
//    public AndroidElement name4;
//
//
//    @AndroidFindBy(id = "")
//    public AndroidElement name5;
//
//
//    @AndroidFindBy(id = "")
//    public AndroidElement name6;
//
//    public boolean isDisplayed(){
//        return name6.isDisplayed();
//    }
//
//    // Android does NOT have option to create List using findBy
//    // here is the solution
//
//    public Map<String,AndroidElement> elementsMap = new HashMap<>();
//    public void initializeElementsMap(){
//        elementsMap.put("key_01", name);
//        elementsMap.put("key_02", name2);
//        elementsMap.put("key_03", name3);
//        elementsMap.put("key_04", name4);
//        elementsMap.put("key_05", name5);
//    }

}
