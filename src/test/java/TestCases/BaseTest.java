package TestCases;

import driverManagement.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest extends DriverManager {

    @BeforeMethod
    public void setUp(){
        System.out.println("**********Browser Open ******************");
        DriverManager.getBrowser();
    }

    @AfterMethod
    public void tearDown(){
        System.out.println("*****************Closed Browser *************");
        System.out.println("Deleting all the cookies");
        DriverManager.driver.manage().deleteAllCookies();
        System.out.println("All cookies deleted");

        System.out.println("Closing all the windows");
        DriverManager.driver.close();
        System.out.println("All windows closed");
        //DriverManager.driver.quit();

    }

}
