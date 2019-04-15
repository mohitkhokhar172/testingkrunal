package driverManagement;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static java.util.concurrent.TimeUnit.SECONDS;

public class DriverManager {

    public static WebDriver driver;
    private static Properties properties;
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


    public void selectElement(String selectValue) {
        List<WebElement> allElement = driver.findElements(By.xpath("//ul[@class='categoryList-1515474558']/li"));
        for (WebElement element : allElement) {
            if (element.getText().equals(selectValue)) {
                element.click();
                break;
            }
        }
    }


    // Open browser method
//    public WebDriver getBrowser() {
//
//        try {
//
//            FileInputStream fis = new FileInputStream("data.properties");
//            Properties prop = new Properties();
//            prop.load(fis);
//            String browser = prop.getProperty("browser");
//            String chromePath = prop.getProperty("chromePath");
//            String firefoxPath = prop.getProperty("fi   refoxPath");
//            String internetExplorerPath = prop.getProperty("internetExplorerPath");
//
//
//            if (browser.equals("chrome")) {
//                System.setProperty("webdriver.chrome.driver", chromePath);
//                driver = new ChromeDriver();
//
//            } else if (browser.equals("firefox")) {
//                System.setProperty("webdriver.gecko.driver", firefoxPath);
//                driver = new FirefoxDriver();
//
//            } else if (browser.equals("internetexplorer")) {
//                System.setProperty("webdriver.ie.driver", internetExplorerPath);
//                driver = new InternetExplorerDriver();
//
//            } else {
//                System.out.println("The browser can either be chrome, firefox or ie only");
//
//            }
//            driver.manage().timeouts().implicitlyWait(10, SECONDS);
//            driver.get("https://www.kijiji.ca/");
//            driver.manage().window().maximize();
//        } catch (Exception ex){
//            ex.getMessage();
//        }
//        return driver;
//    }


    /** Modified Driver Manager File By Dipti **/

    public static void getBrowser(){
        driver = Create(BrowserType.Chrome);
        driver.get("https://www.kijiji.ca/");
        driver.manage().window().maximize();
    }

    public static WebDriver Create(BrowserType browserType) {
        switch (browserType) {
            case Ie:
                return GetIEDriver();
            case Chrome:
                return GetChromeDriver();
            case FireFox:
                return GetFirefoxDriver();
            case Edge:
                return GetEdgeDriver();
            default:
                throw new NoSuchElementException("No such browser found");
        }
    }

    public static String getProperty(String key) {
        try
        {
            if(properties == null) {
                properties = new Properties();
                FileInputStream fileInputStream = new FileInputStream("data.properties");
                properties.load(fileInputStream);
            }
        }
        catch (IOException io){}
        return properties.get(key).toString();
    }

    private static WebDriver GetChromeDriver(){
        System.setProperty("webdriver.chrome.driver", getProperty("chromePath"));
        ChromeOptions options = new ChromeOptions();
        Boolean headless = Boolean.valueOf(getProperty("headless"));
        options.setHeadless(headless);
        return new ChromeDriver(options);
    }

    private static WebDriver GetFirefoxDriver(){
        System.setProperty("webdriver.chrome.driver", getProperty("firefoxPath"));
        return new FirefoxDriver();
    }

    private static WebDriver GetIEDriver(){
        System.setProperty("webdriver.ie.driver", getProperty("internetExplorerPath"));
        return new InternetExplorerDriver();
    }

    private static WebDriver GetEdgeDriver(){
        System.setProperty("webdriver.edge.driver", getProperty("EdgePath "));
        return new InternetExplorerDriver();
    }



}