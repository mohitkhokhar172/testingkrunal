package driverManagement;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class DriverManager {

    public  WebDriver driver;
    public WebDriverWait wait;

    // Explicit wait method
    public void setWait(WebElement element) {
        wait = new WebDriverWait(driver, 20);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Open browser method
    public WebDriver getBrowser() {

        try {

            FileInputStream fis = new FileInputStream("data.properties");
            Properties prop = new Properties();
            prop.load(fis);
            String browser = prop.getProperty("browser");
            String chromePath = prop.getProperty("chromePath");
            String firefoxPath = prop.getProperty("firefoxPath");
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
            driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            driver.get("https://www.kijiji.ca/");
            driver.manage().window().maximize();
        } catch (Exception ex){
            ex.getMessage();
        }
        return driver;
    }



}