package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

    WebDriver driver;

    @FindBy (xpath = "//a[@title='Sign In']")
    private WebElement signinButton;


    @FindBy (css= "[title=Register]")
    private WebElement registerButton;


    @FindBy(xpath = "//a[@title='Post ad']")
    private WebElement postAdBtn;

    @FindBy(xpath = "//div[text() = 'A']")
    private WebElement avatarIcon;

    public LandingPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public LandingPage clickOnAvatar(){
        this.avatarIcon.click();
        return this;
    }



    //Click on Signin button (This is the button on the top-right hand side) on the homepage
    public LandingPage clickOnSignin(){
        this.signinButton.click();
        return this;
    }


    //Click on register button on the homepage
    public LandingPage clickonRegister(){
        this.registerButton.click();
        return this;
    }

    //Click on "Post ad" button on the homepage
    public LandingPage clickOnPostAdBtn(){
        this.postAdBtn.click();
        return this;
    }

    // This method pass the driver from Landing page to Signin page for efficient chaining
    public SigninPage afterClickOnSignin(){
        this.signinButton.click();
        return new SigninPage(driver);
    }

    // This method pass the driver from Landing page to Post ad page for efficient chaining.
    public PostAdPage afterClickingPostAdBtn(){
        //this.postAdBtn.click();
        return new PostAdPage(driver);
    }


}
