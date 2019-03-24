package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SigninPage;

public class Krina_Signin extends DriverManager {


    @BeforeSuite
    public void openBrowser() {
        getBrowser();

    }
    /* TC1 signin with valid email id and password
     */

    @Test
    public void signIn_ValidEmail() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();
        SigninPage SP = new SigninPage(driver);
        SP.enterEmail("kselproj.2019@gmail.com")
                .enterPassword("Kselproj2019*")
                .clickLogin();
       // WebElement SP1 = driver.findElement(By.xpath("//div[@class=\"logoBar-2615648661\"]"));


    }
    @Test
    public void LogOut() {

        signIn_ValidEmail();

         //WebElement SP1 = driver.findElement(By.xpath("//div[@class='root-46216517 color-red-432684940 avatar-26778576'"));
          WebElement SP1 = driver.findElement(By.xpath("//button[@aria-label= 'Navigation menu button']"));
            setWait(SP1);
            SP1.click();

            WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='root-2862412925']//ul//button[contains(text,'')]"));
            wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
            logoutBtn.click();

//        if(logoutBtn.isEnabled() && logoutBtn.isDisplayed()) {
//          logoutBtn.click();
//        }
//        else {
//            System.out.println("Element not found");
//        }

    }




    @AfterSuite
    public void closureActivities() {

        System.out.println("Deleting all the cookies");
        driver.manage().deleteAllCookies();
        System.out.println("Closing all the windows");
        driver.quit();
    }
}
