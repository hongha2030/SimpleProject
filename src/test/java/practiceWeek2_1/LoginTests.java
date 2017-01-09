package test.java.practiceWeek2_1;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.*;

/**
 * Created by Abraham on 1/5/2017.
 */
public class LoginTests extends TestObject {

    private String validEmail = "lthha+1@lhv.vn";
    private String validPassword = "hamaymay";
    private String invalidEmail = "aabab@";
    private String invalidPass = "";
    private String wrongPass = "ababababababa";

    private String messageInvalidEmail = "This is not a valid email address.";
    private String messageInvalidPass = "Password too short. Minimum length is 7 characters.";
    private String messageInvalidAccount = "Your email or password is incorrect.";
    LoginPage login = null;




    @Test(priority = 0, description = "Login failed when trying to login by invalid account")
    public void testInvalidAccount() {
//        System.out.println("priority = 0");

        login = PageFactory.initElements(driver,LoginPage.class);
        waitForElementPresent(login.getEmailElement());
        login.login(validEmail,wrongPass);
        waitForElementPresent(login.getMessageAtPasswordElement());
        Assert.assertTrue (login.getMessageInvalidAccount().equals(messageInvalidAccount), "Message isn't correct");
        Reporter.log("Testcase: Testing login page by correct email and wrong password", true);
    }

    @Test(priority = 1, description = "System validates invalid account")
    public void testInvalidEmail() {
//        System.out.println("priority = 1");

//        waitForElementPresent(login.getEmailElement());
        login = PageFactory.initElements(driver,LoginPage.class);
        waitForElementPresent(login.getEmailElement());
        waitForElementPresent(login.getEmailElement());
        login.login(invalidEmail,validPassword);
        Assert.assertTrue (login.getMessageInvalidEmail().equalsIgnoreCase(messageInvalidEmail), "Message isn't correct");

        Reporter.log("Testcase: Testing login page by invalid email", true);
    }

    @Test(priority = 2, description = "System validates invalid password")
    public void testInvalidPass() {
//        System.out.println("priority = 2");

        waitForElementPresent(login.getEmailElement());
//        login = PageFactory.initElements(driver,LoginPage.class);
//        System.out.println(invalidPass);
        login.login(invalidEmail, "");

        waitForElementPresent(login.getMessageAtPasswordElement());
        Assert.assertTrue (login.getMessageInvalidPasword().equals(messageInvalidPass), "Message isn't correct");
        Reporter.log("Testcase: Testing login page by invalid pasword (password < 7 characters)", true);
    }

    @Test(priority = 3, description = "System validates blank value")
    public void testBlankValue() {
//        System.out.println("priority = 3");

        waitForElementPresent(login.getEmailElement());
//        login = PageFactory.initElements(driver,LoginPage.class);
        login.login("","");
        waitForElementPresent(login.getMessageAtPasswordElement());
        Assert.assertTrue (login.getMessageInvalidEmail().equals(messageInvalidEmail), "Message isn't correct");
        Assert.assertTrue (login.getMessageInvalidPasword().equals(messageInvalidPass), "Message isn't correct");

        Reporter.log("Testcase: Testing login page by blank email and password",true);
    }

    @Test(priority = 4, description = "Login successful when login by valid account")
    public void testValidAccount() {
        waitForElementPresent(login.getEmailElement());
//        login = PageFactory.initElements(driver,LoginPage.class);
        login.login(validEmail,validPassword);
        Assert.assertTrue(login.messageNotShow(),"Login fail");

        Reporter.log("Testcase: Login successful when try to login by correct email and password", true);
    }
}
