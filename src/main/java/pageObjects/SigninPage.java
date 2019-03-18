package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SiginPage {

    @FindBy(id = "LoginEmailOrNickname")
    private WebElement emailAddressField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-rememberMe")
    private WebElement signInCheckBox;

    @FindBy(xpath = "//button[@id='SignInButton']")
    private WebElement loginButton;


    public SiginPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Enter the email address
    public void enterEmail(){
        this.emailAddressField.sendKeys("abc@123.com");

    }

    //Enter the password
    public void enterPassword(){
        this.passwordField.sendKeys("password");
    }

    //Check/Uncheck the checkbox
    public void clickCheckBox(){
        this.signInCheckBox.click();
    }


    //Click on the Sigin-in button
    public void clickLogin(){
        this.loginButton.click();

    }

}
