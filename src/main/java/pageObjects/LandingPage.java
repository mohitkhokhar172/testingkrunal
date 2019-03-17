package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {


    //Locator for the signin button
    @FindBy (xpath = "//a[@title='Sign In']")
    private WebElement signinButton;

    //Locator for the signin button
    @FindBy (css= "[title=Register]")
    private WebElement registerButton;

    public LandingPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

    //Click on signin button on the homepage
    public void clickOnSignin(){
        this.signinButton.click();

    }

    //Click on register button on the homepage
    public void clickonRegister(){
        this.registerButton.click();
    }




}
