package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {

    public static String getScreenshotOnFailure () {
        TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
        File source = ts.getScreenshotAs(OutputType.FILE);
        String date = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
        String fileName = "failed" + date + ".png";
        String target = System.getProperty("user.dir") + "/target/extentReports/" + fileName;
        File finalDestination = new File(target);
        try {
            FileUtils.copyFile(source, finalDestination);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }


//    метод, чтоб проверять если клавиатура после набора убрана

//    public static void closeKeyboard(){
//        if(driver.isKeyoardShown){
//            driver.hideKeyboard();
//        }
//    }
}
