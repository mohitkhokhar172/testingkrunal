package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ForgotPasswordPage {
    WebDriver driver;

    @FindBy(id = "ResetPasswordEmail")
    WebElement frgPass;

    public ForgotPasswordPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }




}
