package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PostAdPage {

    WebDriver driver;

    @FindBy(xpath = "//*[@name='AdTitleForm']")
    private WebElement adTitle;

    @FindBy(xpath = "//*[text() ='Next']")
    private WebElement nextBtn;

    @FindBy (id = "AdTitleForm")
    WebElement adTitlefield;

    public PostAdPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }


    public PostAdPage editAdTitleFiled(String titleOfChoice){
        this.adTitle.sendKeys(titleOfChoice);
        return this;
    }

    public PostAdPage clickNextBtn(){
        this.nextBtn.click();
        return this;
    }

    public PostAdPage enterDiscription (String description) {
        this.adTitlefield.sendKeys(description);
        return this;
    }



}
