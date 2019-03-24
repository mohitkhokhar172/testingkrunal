package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SigninPage;

public class Shabana_Signin extends DriverManager {

    @BeforeSuite
    public void openBrowser(){
        getBrowser();
    }
    // TC 5
    //Signin(wrong password)
    //1. Go to www.kijijii.ca/t-login.html
    //2. click sign in
    //3.Enter valid registered email  id
    //4.Enter wrong password
    //5.click signin

    @Test
    public void Signin_forgotPw() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();
        SigninPage signinPage = new SigninPage(driver);
        signinPage.enterEmail("kselproj.2019@gmail.com");
        signinPage.enterPassword("11111111");
        signinPage.clickLogin();

        WebElement errormessage = driver.findElement( By.xpath ("//div[@class ='message']"));
        String emessage = errormessage.getText();
        Assert.assertEquals("Email address and password combination is incorrect.", "Email address and password combination is incorrect.");


    }

    //TC 9
    //cancel forgot password
    //1. Go to www.kijijii.ca/t-login.html
    //2. type registered email id
    //3.click on forgot your password
    //4. Enter registred email id
    //5.  click cancel


    @Test
    public void CancelForgotPw(){
            try {
                LandingPage landingPage1 = new LandingPage(driver);
                landingPage1.clickOnSignin();
                SigninPage signinPage = new SigninPage(driver);
                signinPage.enterEmail("kselproj.2019@gmail.com");
                signinPage.clickForgotPw();
                signinPage.PwresetEmail("kselproj.2019@gmail.com");
                signinPage.cancelButton();

            } catch (Exception ex){
                System.out.println("Test case failed");
            }


        }


    }







