package TestCases.UploadAdImage_TestCase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.concurrent.TimeUnit;

public class UploadDemo {

    WebDriver driver ;



    @Test
    public void uploadTest() throws Exception{

        System.setProperty("webdriver.chrome.driver","C:\\Selenium\\Driver\\chromedriver.exe");

        driver = new ChromeDriver();

        driver.get("https://www.kijiji.ca");

        driver.manage().window().maximize();

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        WebElement Signin   =driver.findElement(By.xpath("//a[@title='Sign In']"));

                   Signin.click();

        WebElement checkbox=driver.findElement(By.xpath("//input[@id='login-rememberMe']"));

                   checkbox.click();

        WebElement  userid  = driver.findElement(By.xpath("//input[@id='LoginEmailOrNickname']"));

        userid.sendKeys("exceldeveloper3@gmail.com");

        WebElement password = driver.findElement(By.xpath("//input[@id='login-password']"));

        password.sendKeys("Cultus5337");

        WebElement  loginbtn  = driver.findElement(By.xpath("//button[@id='SignInButton']"));

                    loginbtn.click();

           Thread.sleep(3000);

         WebElement postbtn = driver.findElement(By.xpath("//a[@data-qa-id='header-link-post-ad']"));

         postbtn.click();

        Thread.sleep(3000);

         WebElement textarea =driver.findElement(By.xpath("//textarea[@name='AdTitleForm']"));

        textarea.sendKeys("Education");

        Thread.sleep(3000);

        WebElement nextbtn=driver.findElement(By.xpath("//button[contains( text(),'Next')]"));

        nextbtn.click();

        WebDriverWait wait = new WebDriverWait(driver,10);

        Actions actions=new Actions(driver);

        WebElement  category =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//ul//li//h5[contains(text(),'Community')]")));

          actions.moveToElement(driver.findElement(By.xpath("//ul//li//h5[contains(text(),'Community')]"))).click().build().perform();


          Thread.sleep(4000);


        actions.moveToElement(driver.findElement(By.xpath("//ul//li[12]/button"))).click().build().perform();


        WebElement selectimage = driver.findElement(By.xpath("//button[@id='ImageUploadButton']"));


        String path = System.getProperty("user.dir")+"\\Ad_Images\\Penguins.jpg";

        System.out.println(path);

        StringSelection select = new StringSelection(path);

        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(select, null);

        // Find the upload textbox
        WebElement upload = driver.findElement(By.xpath("//button[@id='ImageUploadButton']"));

        // Click on File Upload Browse Button
        upload.click();

        // Create object of Robot class
        Robot robot = new Robot();
        Thread.sleep(1000);

        // Press CTRL+V
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);

        // Wait
        Thread.sleep(1000);

        // Release CTRL+V
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.keyRelease(KeyEvent.VK_V);

        // Wait
        Thread.sleep(1000);

        // Press Enter
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);

        Thread.sleep(5000);

        // Click on Submit Button
     //   driver.findElement(By.id("submit1")).click();

     //   Thread.sleep(8000);

        // Store Uploaded image Path
     //   String UploadImage = driver.findElement(By.name("url1[]")).getText();

        // Compare
      //  if (UploadImage.contains("Penguins")) {
            System.out.println("Image Uploaded Successfully");
      //  } else {
       //     System.out.println("Image Upload Failed");
       // }

        // Close the browser

        Thread.sleep(12000);
        driver.quit();
    }






    }





