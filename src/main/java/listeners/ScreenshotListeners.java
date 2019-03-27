package listeners;

import Utils.ScreenShotTaker;
import Utils.TestResult;
import driverManagement.DriverManager;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListeners implements ITestListener {

    public void onTestStart(ITestResult result) {

    }

    public void onTestSuccess(ITestResult result) {
        System.out.println("*************** Error " + result.getName() + " test has been passed ****************");
//        ITestContext context = result.getTestContext();
//        WebDriver driver = (WebDriver)context.getAttribute("WebDriver");
        String filename = ScreenShotTaker.generateFileNameWithTimeStamp(result.getName());
        ScreenShotTaker.captureScreenShot(DriverManager.driver, TestResult.PASS,filename);
    }

    public void onTestFailure(ITestResult result) {
        System.out.println("*************** Error " + result.getName() + " test has been failed ****************");
        String filename = ScreenShotTaker.generateFileNameWithTimeStamp(result.getName());
        ScreenShotTaker.captureScreenShot(DriverManager.driver,TestResult.FAIL,filename);
    }

    public void onTestSkipped(ITestResult result) {

    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    public void onStart(ITestContext context) {

    }

    public void onFinish(ITestContext context) {

    }
}
