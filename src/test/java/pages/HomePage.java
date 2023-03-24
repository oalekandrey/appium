package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import utilities.Driver;

import java.util.HashMap;
import java.util.Map;

public class HomePage {

    public HomePage(){
        PageFactory.initElements(new AppiumFieldDecorator(Driver.getDriver()),this);
    }




}
