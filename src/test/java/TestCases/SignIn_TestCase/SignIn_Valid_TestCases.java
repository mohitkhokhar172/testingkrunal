package TestCases.SignIn_TestCase;


import TestCases.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SigninPage;

public class SignIn_Valid_TestCases extends BaseTest {

    /************************* Krina Test Cases **************************/
    @Test
    public void tc1_signIn_ValidEmail() {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();
        SigninPage SP=new SigninPage(driver);
        SP.enterEmail("kselproj.2019@gmail.com")
                .enterPassword("Kselproj2019*")
                .clickLogin();
        // WebElement SP1 = driver.findElement(By.xpath("//div[@class=\"logoBar-2615648661\"]"));
    }
    @Test
    public void tc2_LogOut() {

        tc1_signIn_ValidEmail();

        //WebElement SP1 = driver.findElement(By.xpath("//div[@class='root-46216517 color-red-432684940 avatar-26778576'"));
        WebElement SP1 = driver.findElement(By.xpath("//button[@aria-label= 'Navigation menu button']"));
        setWait(SP1);
        SP1.click();

        WebElement logoutBtn = driver.findElement(By.xpath("//div[@class='root-2862412925']//ul//button[contains(text,'')]"));
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(logoutBtn));
        logoutBtn.click();

    }

}
