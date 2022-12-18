package testautomation.framework.web;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.testng.Reporter;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * <h1>Helper class</h1>
 * contains common methods that can be reused across the tests
 */
public class Helper {

   /**
     * Returns a formatted date from date string
     * @param dateString Date stored as a String
     * @param format The format of date string to be converted
     */
    public static Date getFormattedDate(String dateString, String format){
        Date date = null;
        try{
            date=new SimpleDateFormat(format).parse(dateString);
        }catch (Exception e){
            Reporter.log("Unable parse the given date string");
        }
        return date;
    }

    /**
     * Takes a screenshot and adds it to the report
     * @param driver Selenium WebDriver holding the current execution thread
     * @param fileName String specifying part of the image filename
     */
    public static void captureScreenShot(WebDriver driver, String fileName){
        File screenShotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HH-mm-ss").format(Calendar.getInstance().getTime());
        File screenShotName = new File(System.getProperty("user.dir")+"/Screenshots/"+fileName+timeStamp+".png");
        try {
            FileUtils.copyFile(screenShotFile, screenShotName);
            String filePath = screenShotName.toString();
            String path = "<div><img src='"+filePath+"' alt='"+fileName+"'></div>";
            Reporter.log(path);
        }catch (Exception e){
            Reporter.log("Unable to capture screenshot "+fileName);
        }

    }

}
