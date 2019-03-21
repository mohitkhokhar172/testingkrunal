package TestCases;

import driverManagement.DriverManager;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.PostAdPage;
import pageObjects.SigninPage;

public class Dipti_PostAd extends DriverManager {
    @Test
    public void invalidPosAdTitle(){
        try{
            getBrowser();
            LandingPage landingPage = new LandingPage(driver);
            landingPage.clickOnSignin();
            SigninPage signIn=new SigninPage(driver);
            signIn.enterEmail("kselproj.2019@gmail.com")
                    .enterPassword("Kselproj2019*")
                    .clickLogin();
            PostAdPage postAdPage = new PostAdPage(driver);
            postAdPage.enterInvalidAdTitle("QA Aut");
        }
        catch (Exception exec){
            System.out.println("Test is Failed, Post Ad Title contains minimum 8 character!");
        }
    }

}
