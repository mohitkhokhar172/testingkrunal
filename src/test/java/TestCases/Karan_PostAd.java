package TestCases;

import driverManagement.DriverManager;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.PostAdPage;
import pageObjects.SigninPage;

public class Karan_PostAd extends DriverManager {
    /*
    * Note: This is not a test case.
    * It is a common sign-in method that can be called when required to sign-inCreated by: Karan
    * Created on: March 18th, 2019
    * */
    public void signinSuccessfully() {
        getBrowser();
        driver.manage().window().maximize();
        LandingPage landingPage  = new LandingPage(driver);
        SigninPage signinPage = landingPage
                .clickOnSignin()
                .afterClickOnSignin()
                .enterEmail("kselproj.2019@gmail.com")
                .enterPassword("Kselproj2019*")
                .checkTheCheckBox()
                .clickLogin();
    }

    /* TC3 --> Title of the advertisment with exactly 8 characters
     * Description: Validate that the minimum number of characters accepted are 8. The next button will be disabled
     * if the characters are less than 8.
     * Created by: Karan
     * Created on March 17th, 2019
     * Updated by: Karan
     * Updated on: MArch 18th, 2019
     * */
    @Test
    public void postAdMin8chars(){
        signinSuccessfully();
        LandingPage landingPage = new LandingPage(driver);
        PostAdPage postAdPage = landingPage.clickOnPostAdBtn()
                .afterClickingPostAdBtn()
                .editAdTitleFiled("11111111")
                .clickNextBtn();
    }
}