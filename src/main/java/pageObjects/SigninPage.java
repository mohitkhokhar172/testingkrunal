package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SigninPage {

    WebDriver driver;

    @FindBy(id = "LoginEmailOrNickname")
    private WebElement emailAddressField;

    @FindBy(id = "login-password")
    private WebElement passwordField;

    @FindBy(id = "login-rememberMe")
    private WebElement signInCheckBox;

    @FindBy(xpath = "//button[@id='SignInButton']")
    private WebElement loginButton;


    @FindBy(id = "LoginForgottenPassword")
    private WebElement forgotPwButton;

    @FindBy(id = "ResetPasswordEmail")
    private WebElement resetPwEmail;

    @FindBy(id = "Cancel")
    private WebElement cancelbutton;


    @FindBy(id = "LoginForgottenPassword")
    WebElement frgPassBtn;


    @FindBy(id = "ResetPasswordEmail")
    WebElement frgPass;

    @FindBy(id = "SendEmail")
    WebElement btnSendEmail;

    @FindBy(xpath = "//div[@class='root-2862412925']//ul//button[contains(text,'')]")
    private WebElement logoutBtn;


    public SigninPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //Enter the email address
    public SigninPage enterEmail(String email) {
        this.emailAddressField.sendKeys(email);
        return this;
    }

    //Enter the password
    public SigninPage enterPassword(String password) {
        this.passwordField.sendKeys(password);
        return this;
    }

    //Select/UnSelect the checkbox
    public SigninPage clickCheckBox() {
        this.signInCheckBox.click();
        return this;
    }

    //Verify is the checkbox is checked or not
    public SigninPage checkTheCheckBox() {
        this.signInCheckBox.isSelected();
        return this;
    }

    //Click on the Sigin-in button
    public SigninPage clickLogin() {
        this.loginButton.click();
        return this;
    }

    //to click on forgot PW button
    public SigninPage clickForgotPw() {
        this.forgotPwButton.click();
        return this;
    }

    // to click on reset email box
    public SigninPage PwresetEmail(String Email) {
        this.resetPwEmail.sendKeys(Email);
        return this;

    }

    // to click on cancel button
    public SigninPage cancelButton() {
        this.cancelbutton.click();
        return this;

    }


    public SigninPage clickForgotPwd() {
        this.frgPassBtn.click();
        return this;
    }

    public SigninPage clickOnSendEmail() {
        if (frgPass.getText() != "") {
            btnSendEmail.click();
        }
        return this;
    }
        //Click on Logout button

        public SigninPage clickLogoutBtn () {
            this.logoutBtn.click();
            return this;
        }

    public void ValidateSignin(){
        LandingPage landingPage=new LandingPage(driver);
        landingPage.afterClickOnSignin();
        this.enterEmail("kselproj.2019@gmail.com")
                .enterPassword("Kselproj2019*")
                .clickCheckBox()
                .checkTheCheckBox()
                .clickLogin();
    }

    }

