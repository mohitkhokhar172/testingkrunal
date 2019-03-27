package driverManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverManager {

    public  WebDriver driver;
    public WebDriverWait wait;
    public Wait<WebElement> fluentWait;

    // Explicit wait method for visibility
    public void setWait(WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
        wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void setWaitUntilVisibilityOfElementLocated(String xPath) {
        wait = (new WebDriverWait(driver, 30));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(xPath)));
    }

    // Explicit wait method for clickable
    public void setClickableWait(WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    // Fluent wait method for stale element
    public void setFluentWait(WebElement element) {
        fluentWait = new FluentWait<WebElement>(element)
                .withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .ignoring(StaleElementReferenceException.class);

    }


    // A method for deleting all the ccookies and closing the window
    public void closureActivities(){

        System.out.println("Deleting all the cookies");
        driver.manage().deleteAllCookies();
        System.out.println("All cookies deleted");

        System.out.println("Closing all the windows");
        driver.close();
        System.out.println("All windows closed");
    }


    // Open browser method
    public WebDriver getBrowser() {

        try {

            FileInputStream fis = new FileInputStream("data.properties");
            Properties prop = new Properties();
            prop.load(fis);
            String browser = prop.getProperty("browser");
            String chromePath = prop.getProperty("chromePath");
            String firefoxPath = prop.getProperty("fi   refoxPath");
            String internetExplorerPath = prop.getProperty("internetExplorerPath");


            if (browser.equals("chrome")) {
                System.setProperty("webdriver.chrome.driver", chromePath);
                driver = new ChromeDriver();

            } else if (browser.equals("firefox")) {
                System.setProperty("webdriver.gecko.driver", firefoxPath);
                driver = new FirefoxDriver();

            } else if (browser.equals("internetexplorer")) {
                System.setProperty("webdriver.ie.driver", internetExplorerPath);
                driver = new InternetExplorerDriver();

            } else {
                System.out.println("The browser can either be chrome, firefox or ie only");

            }
            driver.manage().timeouts().implicitlyWait(10, SECONDS);
            driver.get("https://www.kijiji.ca/");
            driver.manage().window().maximize();
        } catch (Exception ex){
            ex.getMessage();
        }
        return driver;
    }





}