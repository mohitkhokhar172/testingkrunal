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
    public void valid_adtitle(){
        LandingPage landingPage=new LandingPage(driver);
        PostAdPage postAdPage=landingPage.afterClickingPostAdBtn();
        postAdPage.editAdTitleFiled("QA Automation");
        postAdPage.clickNextBtn();
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

    @Test
    public void addetail_changecategory(){
        valid_signin();

        WebElement signedin_user = (new WebDriverWait(driver, 10)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//button[@aria-label='Navigation menu button']")));

        String user = signedin_user.getText();
        Assert.assertEquals(user, "A", "Login for posting ad is invalid");

        valid_adtitle();
        PostAdPage postAdPage = new PostAdPage(driver);


        if(postAdPage.getServices().isDisplayed()) {

            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.elementToBeClickable(postAdPage.getServices()));
            postAdPage.ClickServices();

        }else{
            System.out.println("Services not found on PostAd Page");
        }


        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("window.scrollBy(0,600)", "");


        try {

            Thread.sleep(1000);
        }
        catch (Exception ex)
        {

        }


        if(postAdPage.getTutorLanguage().isDisplayed()) {

            Actions actions=new Actions(driver);
            actions.moveToElement(postAdPage.getTutorLanguage()).click().build().perform();

        }else{
            System.out.println("Tutors & Languages not found on PostAd Page");
        }


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
