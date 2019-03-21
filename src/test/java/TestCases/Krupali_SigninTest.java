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

public class Krupali_SigninTest extends DriverManager {

        @BeforeSuite
        public void startupExec(){
            getBrowser();
            driver.manage().window().maximize();
        }

        //Sign in with blank as email id

        @Test
        public void signin_blank(){


            LandingPage landingPage=new LandingPage(driver);
            landingPage.afterClickOnSignin();
            SigninPage signinPage=new SigninPage(driver);
            signinPage.enterEmail("")
                    .enterPassword("Kselproj2019*")
                    .clickCheckBox()
                    .checkTheCheckBox()
                    .clickLogin();

            WebElement errormsg=driver.findElement(By.xpath("//*[@class='field-message error']"));
            Assert.assertEquals(errormsg.getText(),"Please enter information above.","Error message is not matching");


        }

        @AfterSuite
        public void  endingExec(){

            driver.quit();
        }
    }


