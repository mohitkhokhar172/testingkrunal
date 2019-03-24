package TestCases;

import driverManagement.DriverManager;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SigninPage;

public class Dipti_SignIn extends DriverManager
{
    @Test
    public void ForgotPassword(){
        try{
            getBrowser();
            LandingPage landingPage=new LandingPage(driver);
            SigninPage signinPage = landingPage
                    .clickOnSignin()
                    .afterClickOnSignin()
                    .enterEmail("kselproj.2019@gmail.com")
                    .clickForgotPwd()
                    .clickOnSendEmail();
            System.out.println("Your password has been send");
        }
        catch (Exception ex){

        }
    }
}
