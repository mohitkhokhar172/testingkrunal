package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SigninPage;


public class Karan extends DriverManager {

    /* TC6 --> signin(without password) */
    @Test
    public void siginInNoPswd(){
        getBrowser();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();

        SigninPage signinPage = new SigninPage(driver);
        signinPage.enterEmail("karan@gmail.com")
                .enterPassword("")
                .clickCheckBox()
                .checkTheCheckBox()
                .clickLogin();

        boolean checkBoxSelected = driver.findElement(By.id("login-rememberMe")).isSelected();
        Assert.assertEquals(checkBoxSelected, false, "FAIL: The checkbox was not unchecked");

        WebElement errorMsg = driver.findElement(By.xpath("//span[@class='field-message error']"));
        String missingPasswordError = errorMsg.getText();
        Assert.assertEquals(missingPasswordError, "Please enter information above.", "Fail: The error message does not match");


        System.out.println(errorMsg.getCssValue("color"));







    }
}

