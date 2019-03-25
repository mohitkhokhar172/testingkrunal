package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddDetailsPage {

        WebDriver driver;

        @FindBy(xpath="//div/div[@class='container-info']//h2")
        public WebElement Ad_details;

        @FindBy (xpath="//div/a[@class='post-ad-begin']")
        public WebElement Change_category;

        @FindBy (xpath="//div/label/input[@name='postAdForm.adType'and@value='OFFER']")
        public WebElement radio_offer;

        @FindBy(xpath="//span[@class='radio-label']")
        public WebElement radio_offer_label;

        @FindBy (xpath = "//div/input[@class='add-asterisk']")
        public WebElement Ad_details_title;



        public AddDetailsPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

    public WebElement getAd_details(){
        return  this.Ad_details;
    }

    public WebElement getChange_category(){
        return this.Change_category;
    }


        public ChangeCategoryPage chnageCategory_click(){
            this.Change_category.click();
            return new ChangeCategoryPage(driver);
        }

    }









