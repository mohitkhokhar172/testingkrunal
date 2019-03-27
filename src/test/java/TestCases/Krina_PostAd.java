package TestCases;

import com.sun.glass.ui.Pixels;
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

import java.util.List;

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


//    public void signIn_ValidEmail() {
//        LandingPage landingPage = new LandingPage(driver);
//        landingPage.clickOnSignin();
//        SigninPage signinPage = new SigninPage(driver);
//        signinPage.enterEmail("kselproj.2019@gmail.com")
//                .enterPassword("Kselproj2019*")
//                .clickCheckBox()
//                .checkTheCheckBox()
//                .clickLogin();
    //   }

    @Test
    public void add_Title() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();
        SigninPage signIn = new SigninPage(driver);
        signIn.enterEmail("kselproj.2019@gmail.com")
                .enterPassword("Kselproj2019*")
                .clickCheckBox()
                .checkTheCheckBox()
                .clickLogin();


        WebElement loggedInAccount = driver.findElement(By.xpath("//div//div[@class='root-46216517 color-red-432684940 avatar-26778576']"));
        Assert.assertEquals(loggedInAccount.getText(), "A");
        PostAdPage postAdPage = landingPage.clickOnPostAdBtn()
                .afterClickingPostAdBtn()
                .editAdTitleFiled("QA automation")
                .clickNextBtn();

        WebElement selectCategory = driver.findElement(By.className("categoryListsHeader-2557181585"));
        Assert.assertEquals(selectCategory.getText(), "Select a category");
        setWait(selectCategory);
        selectCategory.click();

        WebElement selectServices = driver.findElement(By.xpath("//div//li[5]"));
        wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(selectServices));
        selectServices.click();

        WebElement subCategorySection = driver.findElement(By.xpath("//ul[@class='categoryList-1515474558']"));
        List<WebElement> allCategories = subCategorySection.findElements(By.xpath("//li[@class='categoryListItem-3123839590']"));

        int totalNumberOfCategories = allCategories.size();

        WebElement tutorLanguageLink = driver.findElement(By.xpath("//*[text() = 'Tutors & Languages']"));
        setWait(tutorLanguageLink);
        for (int i = 0; i < totalNumberOfCategories; i++) {
            WebElement currentElement = allCategories.get(i);
            setClickableWait(currentElement);
            String currentCategory = currentElement.getText();
            if (currentCategory.equals("Tutors & Languages")) {
                allCategories.get(i).click();
                break;
            }
        }
        System.out.println("Clicked on -T and L- link");

//        WebElement tutorLanguages = driver.findElement(By.xpath("//div//li[12]"));
//        Assert.assertEquals(tutorLanguages.getText(), "Tutors & Languages");
//        setWait(tutorLanguages);
//        tutorLanguages.click();
        
//
    }
    @Test
    public void selectCheckbox(){

        add_Title();
      // WebElement Checkbox =driver.findElement(By.xpath("//div//label[@class='radio-button-rd']"));
        WebElement Checkbox =driver.findElement(By.xpath("//span[@class='radio-label']"));
       Assert.assertEquals(Checkbox.getText(),"I am offering - You are offering an item for sale");
//        wait = new WebDriverWait(driver, 30);
//        wait.until(ExpectedConditions.elementToBeClickable(Checkbox));
//        Checkbox.click();
////


    }


 @AfterSuite
    public void end(){
        driver.quit();
    }
}


