package TestCases;

import driverManagement.DriverManager;
import org.testng.annotations.Test;
import pageObjects.SigninPage;

public class Dipti_SignIn extends DriverManager
{
    @Test
    public void ForgotPassword(){
        try{

            getBrowser();
            SigninPage signinPage = new SigninPage(driver);
            signinPage.enterEmail("diptiswami.mscit@gmail.com").clickForgotPwd();
        }
        catch (Exception ex){

        }
    }
}
