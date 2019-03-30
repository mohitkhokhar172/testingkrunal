package TestCases.PostAd_TestCase;

import TestCases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;

import java.util.List;

public class PostAd_Valid_TestCases extends BaseTest {
    /************** Geetha Test Cases **********************/

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

    /**************** Karina Test Cases *************************/

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
    }
    @Test
    public void selectCheckbox(){
        add_Title();
        WebElement Checkbox =driver.findElement(By.xpath("//span[@class='radio-label']"));
        Assert.assertEquals(Checkbox.getText(),"I am offering - You are offering an item for sale");
    }

    /***************** Krupali Test Cases ***********************/
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
        setWait(postAdPage.getAdTitle());
        postAdPage.editAdTitleFiled("1111****")
                .clickNextBtn().getSelectCategory();
        setWait(postAdPage.getSelectCategory());
        Assert.assertEquals(postAdPage.getSelectCategory().getText(),"Select a category","Select category form is not appeared");
    }

    @Test
    public void addetail_changecategory(){

        // To check login is valid or not
        try {
            LandingPage landingPage = new LandingPage(driver);
            Assert.assertEquals(GetAuthenticatedUser(), "A", "Login for posting ad is invalid");

            // To check cateogry after adding title
            PostAdPage postAdPage = new PostAdPage(driver);

            postAdPage.ValidateAddTitle();
            setWait(postAdPage.getSelectCategory());
            Assert.assertEquals(postAdPage.getSelectCategory().getText(), "Select a category", "Select category form is not appeared");

            // To click on Serivces
            if (postAdPage.getServices().isDisplayed()) {

                setClickableWait(postAdPage.getServices());
                postAdPage.ClickServices();

            } else {
                System.out.println("Services not found on PostAd Page");
            }


            //to click on tutor and languages
            setWait(postAdPage.getSubCategorySection());
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

            AddDetailsPage addDetailsPage = new AddDetailsPage(driver);
            setWait(addDetailsPage.getAd_details());


            if (addDetailsPage.getAd_details().getText().contains("Ad Details")) {
                System.out.println("On Ad Details Page");
            } else {
                System.out.println("Not on Ad Details Page");
            }

            ChangeCategoryPage changeCategoryPage = addDetailsPage.chnageCategory_click();

            setWait(changeCategoryPage.getChangeCategoryTitle());
            Assert.assertEquals(changeCategoryPage.getChangeCategoryTitle().getText(), "Change Category", "Not on change category page");
        }catch(Exception e){

        }
    }

    /***************** Shabana Tes Cases ************************/
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
