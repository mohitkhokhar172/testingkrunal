package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PostAdPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@name='AdTitleForm']")
    private WebElement adTitle;

    @FindBy(xpath = "//*[text() ='Next']")
    private WebElement nextBtn;

    @FindBy (id = "AdTitleForm")
    private WebElement adTitlefield;

    @FindBy(xpath = "//span[@class='maxCharCountdown-2996436710']")
    WebElement spnCountChar;

    @FindBy(css = ".headerButtonPostAd-2493039301")
    WebElement btnPostAd;


    @FindBy (xpath = "//div//li[5]")
    WebElement services;

    @FindBy(xpath = "//div//li[12]")
    WebElement tutorLanguage;


    @FindBy(xpath = "//*[text() = 'Services']")
    private WebElement servicesLink;

    @FindBy(xpath = "//*[text() = 'Tutors & Languages']")
    private WebElement tutorAndLanguageLink;

    @FindBy(id = "pstad-descrptn")
    private WebElement descriptionField;

    @FindBy(id = "pstad-map-address")
    private WebElement addressField;

    @FindBy(xpath = "//input[@name='postAdForm.phoneNumber']")
    private WebElement phoneField;

    @FindBy(xpath = "//button[@data-qa-id='package-0-bottom-select']")
    private WebElement basicPackageBtn;

    @FindBy(id = "PostAdPreview")
    private WebElement previewBtn;

//    @FindBy(xpath = "//div[@class='allCategoriesContainer-1722591519']")
//    private List<WebElement> selectCatgories;


    @FindBy (xpath = "//*[text()='Services']")
     private WebElement selectServices;


    @FindBy (xpath = "//*[text ()= 'Tutors & Languages']")
    public WebElement selectTutorNLanguage;



    public PostAdPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

//    public PostAdPage getAllCategories(){
//        this.selectCatgories.getClass();
//        return this;
//    }

    public PostAdPage enterDescription(String descriptionDetails){
        this.descriptionField.sendKeys(descriptionDetails);
        return this;
    }


    public PostAdPage enterAddress(String addressDetails){
        this.addressField.sendKeys(addressDetails);
        return this;
    }

    public PostAdPage enterPhoneNumber(String phonenumber){
        this.phoneField.sendKeys(phonenumber);
        return this;
    }

    public PostAdPage selectBasicPackage(){
        this.basicPackageBtn.click();
        return this;
    }


    public PostAdPage clickPreviewBtn(){
        this.previewBtn.click();
        return this;
    }


    public PostAdPage clickTutorAndLanguageLink(){
        this.tutorAndLanguageLink.click();
        return this;
    }

    public PostAdPage clickServicesLink(){
        this.servicesLink.click();
        return this;
    }


    public PostAdPage editAdTitleFiled(String titleOfChoice){
        this.adTitle.sendKeys(titleOfChoice);
        return this;
    }

    public PostAdPage enterInvalidAdTitle(String title){
        try {
            Thread.sleep(5000);
            Assert.assertTrue(driver.getTitle().contains("Kijiji in Mississauga / Peel Region. - Buy, Sell & Save with Canada's #1 Local Classifieds."),"Page title has been matched");
            btnPostAd.click();
            this.adTitle.sendKeys(title);
            if(spnCountChar.isDisplayed()){
                Assert.assertTrue(nextBtn.isEnabled() == false, "Invalid character length");
            }
        }
        catch (Exception e) {

        }
        return this;
    }

    public PostAdPage clickNextBtn(){
        this.nextBtn.click();
        return this;
    }
    public void clickServices(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.services));
        this.services.click();
    }

    public void clickTutorLanguage(){
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(this.services));
        this.tutorLanguage.click();

    }

    public PostAdPage enterDiscription (String description) {
        this.adTitlefield.sendKeys(description);
        return this;
    }

    public PostAdPage selectServices(){
      this.selectServices .click();
     return this;
   }

    public PostAdPage selectTutorNLanguage (){
      this. selectTutorNLanguage.click();
     return this;
    }





}
