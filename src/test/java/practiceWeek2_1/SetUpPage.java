package test.java.practiceWeek2_1;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.*;

/**
 * Created by Abraham on 1/5/2017.
 */
public class SetUpPage extends TestObject {
//    private static WebDriver driver;
    private String homePage;

    @BeforeSuite
    public void startDriver() {
        System.out.println("startDriver");
        driver = new FirefoxDriver();
    }
    public WebDriver getDriver() {
        return driver;
    }

    @BeforeTest
    private void openHomePage() throws InterruptedException {
        homePage = System.getProperty("hostname");
        System.out.println(homePage);
        driver.get(homePage);
    }
    @AfterSuite
    public void tearDown() {
        System.out.println("tearDown");
        driver.close();
        driver.quit();
    }
}
