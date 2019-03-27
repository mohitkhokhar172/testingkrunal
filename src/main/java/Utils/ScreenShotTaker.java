package Utils;

import driverManagement.DriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.util.Date;

public class ScreenShotTaker {

    public static void captureScreenShot(WebDriver driver, TestResult status, String fileName) {

        String directory;
        try {
            if (status == TestResult.FAIL) {
                directory = DriverManager.getProperty("failTestScreenshotPath");
                FileUtils.forceMkdir(new File(directory));
                File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File targetFile = new File(directory.toString() + "/" + fileName);
                FileUtils.copyFile(sourceFile, targetFile);
            } else if (status == TestResult.PASS) {
                directory = DriverManager.getProperty("passTestScreenshotPath");
                FileUtils.forceMkdir(new File(directory));
                File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                System.out.println(sourceFile);
                File targetFile = new File(directory.toString() + "/" + fileName);
                System.out.println(targetFile);
                FileUtils.copyFile(sourceFile, targetFile);
            }
        } catch (IOException e) {}
    }

    public static String generateFileNameWithTimeStamp(String testName) {
        Date date = new Date();
        //+ String.format(date.toString(),"ddMMYYYY")
        return "ScreenShot_" + testName + ".png";
    }
}
