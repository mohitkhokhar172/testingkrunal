package TestCases;

import driverManagement.DriverManager;
import listeners.ScreenshotListeners;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.*;
import pageObjects.LandingPage;
import pageObjects.PostAdPage;
import pageObjects.SigninPage;

import java.util.List;

@Listeners(ScreenshotListeners.class)
public class Dipti_PostAd extends DriverManager {
    PostAdPage postAdPage;

    @Test
    public void validLogin() {
        try {
            getBrowser();
            LandingPage landingPage = new LandingPage(driver);
            Thread.sleep(1000);
            landingPage.clickOnSignin();
            SigninPage signIn = new SigninPage(driver);
            signIn.enterEmail("kselproj.2019@gmail.com")
                    .enterPassword("Kselproj2019*")
                    .clickLogin();
            Thread.sleep(5000);
        } catch (Exception ex) {
        }
    }

    @Test(dependsOnMethods = {"validLogin"})
    public void InvalidTitle() {
        try {
            //validLogin();
            postAdPage = new PostAdPage(driver);
            postAdPage.enterInvalidAdTitle("Qa AUt");
            Thread.sleep(5000);
            WebElement spnCountChar = driver.findElement(By.className("maxCharCountdown-2996436710"));
            if (spnCountChar.isDisplayed()) {
                WebElement nextBtn = driver.findElement(By.xpath("//*[text() ='Next']"));
                Assert.assertTrue(nextBtn.isEnabled() == false, "Invalid character length");
            }
        } catch (Exception exec) {
            System.out.println("Test is Failed, Post Ad Title contains minimum 8 character!");
        }
    }


    @Test(dependsOnMethods = {"validLogin"})
    public void validTitle() {
        try {
            //validLogin();
            postAdPage = new PostAdPage(driver);
            postAdPage.enterInvalidAdTitle("Qa Automation");
            WebElement nextBtn = driver.findElement(By.xpath("//*[text() ='Next']"));
            boolean flag = nextBtn.isEnabled();
            if (nextBtn.isEnabled()) {
                Assert.assertTrue(flag, "true");
                postAdPage.clickNextBtn();
            }
            System.out.println("Next button has been clicked");

        } catch (Exception exec) {
            System.out.println("Test is Failed!");
        }
    }

    @Test(dependsOnMethods = {"validLogin", "validTitle"})
    public void postAdWithoutPhoneNo() {
        try {
            // validTitle();
            String sCategory = "Services";
            selectElement(sCategory);
            Thread.sleep(1000);
            String sService = "Tutors & Languages";
            selectElement(sService);
            Thread.sleep(1000);
            //Assert.assertTrue(driver.getTitle().contains("Post Your Ad - Select a Category | Kijiji"),"Page Title matched");
            WebElement chkAdType = driver.findElement(By.id("adType1"));
            Assert.assertTrue(chkAdType.isSelected() == true, "Ad Type is selected.");

            WebElement txtAdTitle = driver.findElement(By.id("postad-title"));
            Assert.assertTrue(txtAdTitle.getText() != "", "Post Ad Title is not blank");

            if (txtAdTitle.getText() != "") {

                WebElement txtDescription = driver.findElement(By.id("pstad-descrptn"));
                setWait(txtDescription);
                txtDescription.sendKeys("\"Enter description here!\"");
                Select location = new Select(driver.findElement(By.id("locationLevel0")));
                location.selectByVisibleText("Mississauga / Peel Region");
                WebElement txtAddress = driver.findElement(By.id("pstad-map-address"));
                txtAddress.sendKeys("Address");
                WebElement selectImage = driver.findElement(By.id("ImageUploadButton"));
                selectImage.sendKeys("E:\\Selenium\\download.png");
                Thread.sleep(5000);
                WebElement txtPhoneNo = driver.findElement(By.id("PhoneNumber"));
                txtPhoneNo.sendKeys("");
                postAdPage.selectBasicPackage();
                Thread.sleep(1000);
                postAdPage.clickPreviewBtn();
            }
        } catch (Exception ex) {
        }
    }

    public void selectElement(String selectValue) {
        List<WebElement> allElement = driver.findElements(By.xpath("//ul[@class='categoryList-1515474558']/li"));
        for (WebElement element : allElement) {
            if (element.getText().equals(selectValue)) {
                element.click();
                break;
            }
        }

    }


}
