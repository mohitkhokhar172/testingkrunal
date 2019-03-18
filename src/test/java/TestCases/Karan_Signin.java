package TestCases;

import driverManagement.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.SigninPage;


public class Karan_Signin extends DriverManager {


    /* TC6 --> signin without entering the password
     * Description: Validate the error message :  "Please enter information above."
     * Created by: Karan
     * Created on March 17th, 2019
     * Updated by: Karan
     * Updated on: MArch 18th, 2019
     * */
    @Test(parameters = {"Priority1"})
    public void siginInNoPswd() {
        getBrowser();

        LandingPage landingPage = new LandingPage(driver);
        landingPage.clickOnSignin();

        SigninPage signinPage = new SigninPage(driver);
        signinPage.enterEmail("karan@gmail.com")
                .enterPassword("")
                .clickCheckBox()
                .checkTheCheckBox()
                .clickLogin();

        WebElement errorMsg = driver.findElement(By.xpath("//span[@class='field-message error']"));
        String missingPasswordError = errorMsg.getText();
        Assert.assertEquals(missingPasswordError, "Please enter information above.", "Fail: The error message does not match");

    }

    /* TC6(B) --> signin without entering the password
     * Description: Validate the color of the error mesage text :  #f1454f
     * Created by: Karan
     * Created on March 17th, 2019
     * Updated by: Karan
     * Updated on: MArch 18th, 2019
     * */

    @Test(dependsOnMethods = {"siginInNoPswd"})
    public void getTheTextColor(){
        WebElement errorMsg = driver.findElement(By.xpath("//span[@class='field-message error']"));
        String textColor = errorMsg.getCssValue("color");
        String[] hexValue = textColor.replace("rgba(", "").replace(")", "").split(",");

        int hexValue1=Integer.parseInt(hexValue[0]);
        hexValue[1] = hexValue[1].trim();
        int hexValue2=Integer.parseInt(hexValue[1]);
        hexValue[2] = hexValue[2].trim();
        int hexValue3=Integer.parseInt(hexValue[2]);

        String actualColor = String.format("#%02x%02x%02x", hexValue1, hexValue2, hexValue3);

        Assert.assertEquals("#f1454f", actualColor, "FAIL: The text colour does not match");
    }

    /* TC6(C) --> signin without entering the password
     * Description: Validate the checkbox has been unchecked sate from checked state
     * Created by: Karan
     * Created on March 17th, 2019
     * Updated by: Karan
     * Updated on: MArch 18th, 2019
     * */
    @Test(dependsOnMethods = {"siginInNoPswd"})
    public void checkBoxIsNotSelected() {
        boolean checkBoxSelected = driver.findElement(By.id("login-rememberMe")).isSelected();
        Assert.assertEquals(checkBoxSelected, false, "FAIL: The checkbox was not unchecked");
    }

    @AfterClass
    public void closureActivities(){

        System.out.println("Deleting all the cookies");
        driver.manage().deleteAllCookies();
        System.out.println("Closing all the windows");
        driver.quit();
    }



}
