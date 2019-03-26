package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.AddDetailsPage;
import pageObjects.LandingPage;
import pageObjects.PostAdPage;
import pageObjects.SigninPage;

public class Geetha_PostAd extends DriverManager {

    @BeforeSuite
    public void openBrowser() {
        getBrowser();

    }


    /* TC8 --> AdTitle with 8 symbols
     * Description: Validate AdTitle with 8 character symbol
     * Created by: Geetha
     * Created on March 18th, 2019
     * Updated by: Geetha
     * Updated on: MArch 19th, 2019
     * */

    @Test(enabled=false)
    public void AdTitle_8symbols() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();
        SigninPage signIn=new SigninPage(driver);
        signIn.enterEmail("kselproj.2019@gmail.com")
                .enterPassword("Kselproj2019*")
                .clickLogin();
        WebElement loggedInAccount = driver.findElement(By.xpath("//div//div[@class='root-46216517 color-red-432684940 avatar-26778576']"));
        Assert.assertEquals(loggedInAccount.getText(),"A");
        PostAdPage clickPostAdbutton = landingPage.afterClickingPostAdBtn();
        clickPostAdbutton.enterDiscription("********")
                .clickNextBtn();
        WebElement selectCategory=driver.findElement(By.className("categoryListsHeader-2557181585"));
        Assert.assertEquals(selectCategory.getText(),"Select a category");

    }

@Test
    public void selectRadioBtn(){
    LandingPage landingPage = new LandingPage(driver);
    landingPage.clickOnSignin();
    SigninPage signIn=new SigninPage(driver);
    signIn.enterEmail("kselproj.2019@gmail.com")
            .enterPassword("Kselproj2019*")
            .clickLogin();
    WebElement loggedInAccount = driver.findElement(By.xpath("//div//div[@class='root-46216517 color-red-432684940 avatar-26778576']"));
    Assert.assertEquals(loggedInAccount.getText(), "A");
    PostAdPage clickPostAdbutton = landingPage.afterClickingPostAdBtn();
    clickPostAdbutton.enterDiscription("QA Automation Course")
            .clickNextBtn();
    WebElement selectCategory = driver.findElement(By.className("categoryListsHeader-2557181585"));
    Assert.assertEquals(selectCategory.getText(), "Select a category");
    clickPostAdbutton.ClickServices()
                      .clickTandL();
    AddDetailsPage adddetailspage= new AddDetailsPage(driver);
    adddetailspage.selectRadioBtn();



}
//
//    @AfterSuite
//    public void closureActivities(){
//        driver.quit();
//    }

}
