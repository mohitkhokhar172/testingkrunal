package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.PostAdPage;
import pageObjects.SigninPage;

public class Krina_PostAd extends DriverManager {




    /*1) Go to https://www.kijiji.ca/?uli=tru
    2) Click on post Ad button
    3) Type a title at least of 8 characters (QA automation-our adv). Click next
    4) Click on Services
    5) Click on tutors and languages
    6) click on Ad type, I am offering */

    @BeforeSuite
    public void openBrowser() {
        getBrowser();

    }

    public void signIn_ValidEmail() {
        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();
        SigninPage signinPage = new SigninPage(driver);
        signinPage.enterEmail("kselproj.2019@gmail.com")
                .enterPassword("Kselproj2019*")
                .clickCheckBox()
                .checkTheCheckBox()
                .clickLogin();
    }

    @Test
    public void add_Title() {

        signIn_ValidEmail();
        WebElement loggedInAccount = driver.findElement(By.xpath("//div//div[@class='root-46216517 color-red-432684940 avatar-26778576']"));
        Assert.assertEquals(loggedInAccount.getText(), "A");

        LandingPage landingPage = new LandingPage(driver);
        PostAdPage postAdPage = landingPage.clickOnPostAdBtn()
                .afterClickingPostAdBtn()
                .editAdTitleFiled("QA automation")
                .clickNextBtn();

        WebElement selectCategory = driver.findElement(By.className("categoryListsHeader-2557181585"));
        Assert.assertEquals(selectCategory.getText(), "Select a category");
        setWait(selectCategory);
        selectCategory.click();

        WebElement SelectServices = driver.findElement(By.xpath("//div//li[5]"));
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SelectServices));
        SelectServices.click();

        WebElement tutorLanguages = driver.findElement(By.xpath("//div//li[12]"));
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(SelectServices));
        tutorLanguages.click();


    }

    @Test
    public void services() {
        add_Title();
    }
}


