package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

    WebDriver driver;

    @FindBy(id = "LoginEmailOrNickname")
    public WebElement emailAddressField;

    @FindBy(id = "login-password")
    public WebElement passwordField;

    @FindBy(id = "login-rememberMe")
    public WebElement signInCheckBox;

    @FindBy(xpath = "//button[@id='SignInButton']")
    private WebElement loginButton;


    public SigninPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Enter the email address
    public SigninPage enterEmail(String email){
        this.emailAddressField.sendKeys(email);
        return this;
    }

    //Enter the password
    public SigninPage enterPassword(String password){
        this.passwordField.sendKeys(password);
        return this;
    }

    //Select/UnSelect the checkbox
    public SigninPage clickCheckBox(){
        this.signInCheckBox.click();
        return this;
    }

    //Verify is the checkbox is checked or not
    public SigninPage checkTheCheckBox(){
        this.signInCheckBox.isSelected();
        return this;
    }

    //Click on the Sigin-in button
    public SigninPage clickLogin(){
        this.loginButton.click();
        return this;
    }

}
