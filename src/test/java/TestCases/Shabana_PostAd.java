package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.PostAdPage;
import pageObjects.SigninPage;

public class Shabana_PostAd extends DriverManager {

    @BeforeSuite
    public void openBrowser() {
        getBrowser();
    }

    //TC 7
    // Ad title(num&char, 8 chars)
    //1) Go to https://www.kijiji.ca/?uli=true
    //2) Click on post Ad button
    //3) Type char&symbols,  at least of 8 characters (1111aaaa)
    //4) click next


    @Test
    public void Ad_title() {
        try {
            LandingPage landingPage = new LandingPage(driver);
            landingPage.clickOnPostAdBtn();
            SigninPage signinPage = new SigninPage(driver);
            signinPage.enterEmail("kselproj.2019@gmail.com");
            signinPage.enterPassword("Kselproj2019*");
            signinPage.clickLogin();
            PostAdPage postAdPage = new PostAdPage(driver);
            postAdPage.editAdTitleFiled("1111aaaa");
            postAdPage.clickNextBtn();

            driver.manage().window().maximize();
            WebElement obj1 = driver.findElement(By.xpath("//*[text()='Services']"));
            setWait(obj1);
            postAdPage.selectServices();

            WebElement obj2 = driver.findElement(By.xpath("//* [text () = 'Tutors & Languages']"));
            setWait(obj2);
            postAdPage.selectTutorNLanguage();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}