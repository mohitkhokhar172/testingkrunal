package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SigninPage;

public class Geetha_Signin extends DriverManager {


    @BeforeSuite
    public void openBrowser() {
        getBrowser();

    }


    /* TC3 --> signin with invalid email id
     * Description: Validate the error message :  "Email address and password combination is incorrect."
     * Created by: Geetha
     * Created on March 18th, 2019
     * Updated by: Geetha
     * Updated on: MArch 19th, 2019
     * */

    @Test
    public void signIn_InvalidEmail() {

        LandingPage landingPage = new LandingPage(driver);
         landingPage.clickOnSignin();
         SigninPage signIn=new SigninPage(driver);
        signIn.enterEmail("kselproj.2019")
                .enterPassword("Kselproj2019*")
                .clickLogin();
        WebElement signInErrormsg = driver.findElement(By.xpath("//div[@class='message']//strong"));
        Assert.assertEquals(signInErrormsg.getText(), "Email address and password combination is incorrect.");
    }

    @AfterSuite
    public void closureActivities(){
        System.out.println();
        System.out.println("Deleting all the cookies");
        driver.manage().deleteAllCookies();
        System.out.println("Closing all the windows");
        driver.quit();
    }

}
