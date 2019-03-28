package TestCases.PostAd_TestCase;

import TestCases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.PostAdPage;
import pageObjects.SigninPage;

import java.util.List;

public class PostAd_Invalid_TestCases extends BaseTest {

    PostAdPage postAdPage;
    LandingPage landingPage;
    SigninPage signinPage;
    /************ Dipti Test Cases ****************/

    public void validLogin() {
        try {
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

    @Test
    public void tc1_InvalidTitle() {
        try {
            validLogin();
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

    @Test
    public void tc2_postAdWithoutPhoneNo() {
        try {
            validLogin();
            postAdPage = new PostAdPage(driver);
            postAdPage.enterInvalidAdTitle("Qa Automation");
            WebElement nextBtn = driver.findElement(By.xpath("//*[text() ='Next']"));
            boolean flag = nextBtn.isEnabled();
            if (nextBtn.isEnabled()) {
                Assert.assertTrue(flag, "true");
                postAdPage.clickNextBtn();
            }
            System.out.println("Next button has been clicked");
            // validTitle();
            Thread.sleep(1000);
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

    /****************** Karan Test Cases **********************/

//    @BeforeMethod
//    public void signinSuccessfully() {
//        getBrowser();
//        landingPage = new LandingPage(driver);
//        signinPage = landingPage.clickOnSignin()
//                .afterClickOnSignin()
//                .enterEmail("kselproj.2019@gmail.com")
//                .enterPassword("Kselproj2019*")
//                .checkTheCheckBox()
//                .clickLogin();
//    }

    @Test
    public void postAdMin8chars(){
        System.out.println("TC1 - STARTED");
        validLogin();
        WebElement avatar = driver.findElement(By.xpath("//div[text() = 'A']"));
        while(!avatar.isDisplayed()){
            signinPage.enterEmail("kselproj.2019@gmail.com")
                    .enterPassword("Kselproj2019*")
                    .clickLogin();
        }

        WebElement postAdBtn = driver.findElement(By.xpath("//a[@title='Post ad']"));
        setClickableWait(postAdBtn);
        postAdPage = landingPage
                .clickOnPostAdBtn()
                .afterClickingPostAdBtn();
        System.out.println("Post ad clicked!");

        WebElement titleField = driver.findElement(By.xpath("//*[@name='AdTitleForm']"));
        setClickableWait(titleField);
        postAdPage.editAdTitleFiled("11111111");


        WebElement NxtBtn = driver.findElement(By.xpath("//*[text() ='Next']"));
        Boolean NextBtnIsEnabled = NxtBtn.isEnabled();
        Assert.assertTrue(NextBtnIsEnabled, "true");
        setWait(NxtBtn);
        postAdPage.clickNextBtn();
        System.out.println("TC1 - ENDED");

    }
    @Test
    public void priviewAdWitoutAddress() {
        System.out.println("TC2 - STARTED");
        try {
            postAdMin8chars();
            Thread.sleep(10);
            WebElement text = driver.findElement(By.xpath("//*[text() = 'Select a category']"));
            setFluentWait(text);
            String expectedText = text.getText();
            Assert.assertEquals(expectedText, "Select a category", "Error: The text does not exist");

            WebElement selectCatgoriesSection = driver.findElement(By.xpath("//div[@class='allCategoriesContainer-1722591519']"));
            List<WebElement> selectACategory = selectCatgoriesSection.findElements(By.xpath("//li[@class='categoryListItem-3123839590']"));

            int numberOfCategories = selectACategory.size();

            for (int i = 0; i < numberOfCategories; i++) {
                String currentCategory = selectACategory.get(i).getText();
                if (currentCategory.equals("Services")) {
                    selectACategory.get(i).click();
                    break;
                }
            }

            System.out.println("Clicked on Services link");

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

            WebElement descriptionFiled = driver.findElement(By.id("pstad-descrptn"));
            setClickableWait(descriptionFiled);
            postAdPage.enterDescription("Description goes here!!!")
                    .enterPhoneNumber("6479054166")
                    .selectBasicPackage();

            WebElement postButtonsSection = driver.findElement(By.cssSelector("#mainPageContent"));
            List<WebElement> buttons= postButtonsSection.findElements(By.tagName("button"));
            int totalButtons = postButtonsSection.findElements(By.tagName("button")).size();
            System.out.println(totalButtons);

            for (int i = 0; i <totalButtons; i++){
                String currentButton = buttons.get(i).getText();
                Thread.sleep(100);
                if(currentButton.trim().equalsIgnoreCase("Preview")){
                    buttons.get(i).click();
                    break;
                }
            }


            WebElement validationMsg = (driver.findElement(By.xpath("//*[text() = 'Please fix the errors on the page']")));
            setWait(validationMsg);
            if(validationMsg.isDisplayed()) {
                System.out.println("The below message is displayed on the screen");
                String getMsg = driver.findElement(By.xpath("//*[text() = 'Please enter information above.']")).getText();
                System.out.println("######" + getMsg + "######");
                Assert.assertEquals(getMsg, "Please enter information above.", "Error: The validation message does not match");
                System.out.println("Validated the error message sucessfully!!");
            }else{
                System.out.println("The message is NOT displayed on the screen");
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        System.out.println("TC2 - ENDED");

    }


}
