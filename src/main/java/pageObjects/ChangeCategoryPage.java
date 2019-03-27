package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ChangeCategoryPage  {
    WebDriver driver;

    @FindBy(xpath = "//div/h1[@class='headerTitle-1119882424']")
    private WebElement changeCategoryTitle;

    public ChangeCategoryPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    public WebElement getChangeCategoryTitle(){
        return this.changeCategoryTitle;
    }


}
