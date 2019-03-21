package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.PostAdPage;
import pageObjects.SigninPage;

public class Krupali_PostAdTest extends DriverManager {

    // this is the method to sign in with valid credentials
    public void valid_signin(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.clickOnSignin();
        SigninPage signinPage=new SigninPage(driver);
        signinPage.enterEmail("kselproj.2019@gmail.com")
                .enterPassword("Kselproj2019*")
                .clickCheckBox()
                .checkTheCheckBox()
                .clickLogin();
    }


    @BeforeSuite
    public void setup(){
        getBrowser();
        driver.manage().window().maximize();
    }

    // test method for adding title with combination of nums and symbols
    @Test
    public void Adtitle_numsym8char(){


        valid_signin();
        WebElement signedin_user = (new WebDriverWait(driver, 30)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='root-46216517 color-red-432684940 avatar-26778576']")));

        String user = signedin_user.getText();
        Assert.assertEquals(user, "A", "Login for posting ad is invalid");


        LandingPage landingPage=new LandingPage(driver);
        PostAdPage postAdPage=landingPage.afterClickingPostAdBtn();
        postAdPage.editAdTitleFiled("1111****")
                .clickNextBtn();
        WebElement sel_category=driver.findElement(By.xpath("//div/h3[@class='categoryListsHeader-2557181585']"));
        Assert.assertEquals(sel_category.getText(),"Select a category","Select category form is not appeared");
    }
    @AfterSuite
    public void endupExec(){

        driver.quit();
    }
}
