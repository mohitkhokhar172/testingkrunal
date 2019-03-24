package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

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

        @FindBy (xpath = "//div[@class='form-section']//span[@class='field-message error']")
        private WebElement validationMessage;

        public AddDetailsPage(WebDriver driver){
            this.driver=driver;
            PageFactory.initElements(driver,this);
        }

        public AddDetailsPage validateErrorMsg(){
            String validationMessage = this.validationMessage.getText();
            Assert.assertEquals(validationMessage, "Please enter information above.", "Error: The validation message does not match");
            return this;
        }

        public pageObjects.AddDetailsPage chnageCategory_click(){
            this.Change_category.click();
            return this;
        }

    }









