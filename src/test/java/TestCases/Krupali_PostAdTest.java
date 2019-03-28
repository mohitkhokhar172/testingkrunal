package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Krupali_PostAdTest extends DriverManager {

    @BeforeSuite
    public void Setup(){
        getBrowser();
        driver.manage().window().maximize();
    }

    public String GetAuthenticatedUser()
    {
        SigninPage signinPage =  new SigninPage(driver);
        signinPage.ValidateSignin();

        LandingPage landingPage=new LandingPage(driver);

        setWaitUntilVisibilityOfElementLocated(landingPage.authenticatedUserButtonXpath);

        return landingPage.getAuthenticatedUserButton().getText();
    }
    // test method for adding title with combination of nums and symbols
    @Test
    public void ValidateAddTitleWithNumberSymbol(){

        LandingPage landingPage=new LandingPage(driver);

       Assert.assertEquals(GetAuthenticatedUser(), "A", "Login for posting ad is invalid");

        PostAdPage postAdPage=landingPage.afterClickingPostAdBtn();
        postAdPage.editAdTitleFiled("1111****")
                .clickNextBtn().getSelectCategory();

        Assert.assertEquals(postAdPage.getSelectCategory().getText(),"Select a category","Select category form is not appeared");
    }

    @Test
    public void addetail_changecategory(){

        // To check login is valid or not
        LandingPage landingPage=new LandingPage(driver);
        Assert.assertEquals(GetAuthenticatedUser(), "A", "Login for posting ad is invalid");

        // To check cateogry after adding title
        PostAdPage postAdPage = new PostAdPage(driver);
        postAdPage.ValidateAddTitle();
        Assert.assertEquals(postAdPage.getSelectCategory().getText(),"Select a category","Select category form is not appeared");

        // To click on Serivces
        if(postAdPage.getServices().isDisplayed()) {

            setClickableWait(postAdPage.getServices());
            postAdPage.ClickServices();

        }else{
            System.out.println("Services not found on PostAd Page");
        }


    //to click on tutor and languages
      int totalNumberOfCategories = postAdPage.getAllCategories().size();

        setWait(postAdPage.getTutorLanguage());
        for (int i = 0; i < totalNumberOfCategories; i++) {
            WebElement currentElement = postAdPage.getAllCategories().get(i);
            setClickableWait(currentElement);
            String currentCategory = currentElement.getText();
            if (currentCategory.equals("Tutors & Languages")) {
                postAdPage.getAllCategories().get(i).click();
                break;
            }
        }
        System.out.println("clicked on Tutor and Languages");

        AddDetailsPage addDetailsPage=new AddDetailsPage(driver);
        setWait(addDetailsPage.getAd_details());


        if(addDetailsPage.getAd_details().getText().contains("Ad Details")){
            System.out.println("On Ad Details Page");
        }else{
            System.out.println("Not on Ad Details Page");
        }

        ChangeCategoryPage changeCategoryPage=addDetailsPage.chnageCategory_click();

        setWait(changeCategoryPage.getChangeCategoryTitle());
        Assert.assertEquals(changeCategoryPage.getChangeCategoryTitle().getText(),"Change Category","Not on change category page");
    }



    @AfterSuite
    public void endupExec(){

        driver.quit();
    }
}
