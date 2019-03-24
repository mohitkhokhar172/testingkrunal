package pageObjects;

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
    WebElement adTitlefield;

    @FindBy(xpath = "//span[@class='maxCharCountdown-2996436710']")
    WebElement spnCountChar;

    @FindBy(css = ".headerButtonPostAd-2493039301")
    WebElement btnPsotAd;

    @FindBy (xpath = "//div//li[5]")
    WebElement services;

    @FindBy(xpath = "//div//li[12]")
    WebElement tutorLanguage;


    public PostAdPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }



    public PostAdPage editAdTitleFiled(String titleOfChoice){
        this.adTitle.sendKeys(titleOfChoice);
        return this;
    }

    public PostAdPage enterInvalidAdTitle(String title){
        try {
            Thread.sleep(5000);
            Assert.assertTrue(driver.getTitle().contains("Kijiji in Mississauga / Peel Region. - Buy, Sell & Save with Canada's #1 Local Classifieds."),"Page title has been matched");
            btnPsotAd.click();
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



}
