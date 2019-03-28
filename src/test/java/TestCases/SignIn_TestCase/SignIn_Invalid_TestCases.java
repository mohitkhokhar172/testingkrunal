package TestCases.SignIn_TestCase;

import TestCases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SigninPage;

public class SignIn_Invalid_TestCases extends BaseTest {

    /***** GeeTha Test Cases ******/
    /* TC3 --> signin with invalid email id
     * Description: Validate the error message :  "Email address and password combination is incorrect."
     * Created by: Geetha
     * Created on March 18th, 2019
     * Updated by: Geetha
     * Updated on: MArch 19th, 2019
     * */

    @Test
    public void tc1_signIn_InvalidEmail() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();
        SigninPage signIn=new SigninPage(driver);
        signIn.enterEmail("kselproj.2019")
                .enterPassword("Kselproj2019*")
                .clickLogin();
        WebElement signInErrormsg = driver.findElement(By.xpath("//div[@class='message']//strong"));
        Assert.assertEquals(signInErrormsg.getText(), "Email address and password combination is incorrect.");
    }

    /************ Karan Test CAses ******************/

    @Test
    public void tc2_a_siginInNoPswd() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();

        SigninPage signinPage = new SigninPage(driver);
        signinPage.enterEmail("karan@gmail.com")
                .enterPassword("")
                .clickCheckBox()
                .checkTheCheckBox()
                .clickLogin();

        WebElement errorMsg = driver.findElement(By.xpath("//span[@class='field-message error']"));
        String missingPasswordError = errorMsg.getText();
        Assert.assertEquals(missingPasswordError, "Please enter information above.", "Fail: The error message does not match");
        System.out.println("Tc a passed");

        String textColor = errorMsg.getCssValue("color");
        String[] hexValue = textColor.replace("rgba(", "").replace(")", "").split(",");

        int hexValue1=Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2=Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3=Integer.parseInt(hexValue[2]);

        String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);

        Assert.assertEquals("#f1454f", actualColor, "FAIL: The text colour does not match");
        System.out.println("Tc b passed");
    }


    /***************** Krupali Test Cases ****************/

    @Test
    public void tc3_signin_blank(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.afterClickOnSignin();
        SigninPage signinPage=new SigninPage(driver);
        signinPage.enterEmail("")
                .enterPassword("Kselproj2019*")
                .clickCheckBox()
                .checkTheCheckBox()
                .clickLogin();

        WebElement errormsg =driver.findElement(By.xpath("//*[@class='field-message error']"));
        Assert.assertEquals(errormsg.getText(),"Please enter information above.","Error message is not matching");

    }

    /****************** Shabana Test CAses ****************/
    @Test
    public void tc4_Signin_InvalidPassword() {
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

    @Test
    public void tc5_CancelForgotPw(){
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

    /******************* Dipti Test Cases ****************************/
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
