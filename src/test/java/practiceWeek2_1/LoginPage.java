package test.java.practiceWeek2_1;

import org.openqa.selenium.NotFoundException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Abraham on 1/5/2017.
 */
public class LoginPage {

    @FindBy(css = ".s-login-login > input")
    private WebElement email;

    @FindBy(css = ".s-login-password > input")
    private WebElement password;

    @FindBy (className = "s-login-button")
    private WebElement loginButton;

    @FindBy(xpath="//label[contains(text(),'E-mail')]/span")
    private WebElement messageEmailInvalid;

    @FindBy(xpath="//label[contains(text(),'Password')]/span")
    private WebElement messagePasswordInvalid;

    @FindBy(xpath="//label[contains(text(),'Password')]/span")
    private WebElement messageInvalidAccount;

    public void login(String email, String password) {
        this.email.clear();
        this.password.clear();
        this.email.sendKeys(email);
        this.password.sendKeys(email);
        loginButton.click();
    }

    public String getMessageInvalidEmail() {
//        System.out.println("getMessageInvalidEmail "+messageEmailInvalid.getText());
        return messageEmailInvalid.getText();
    }

    public String getMessageInvalidPasword() {
//        System.out.println("getMessageInvalidPasword "+ messagePasswordInvalid.getText());
        return messagePasswordInvalid.getText();
    }

    public String getMessageInvalidAccount() {
//        System.out.println("getMessageInvalidAccount "+messageInvalidAccount.getText());
        return messageInvalidAccount.getText();
    }

    public boolean messageNotShow() {
        try{
            getMessageInvalidAccount();
        } catch (NotFoundException messageInvalidAccount){
            return true;
        }
        return false;
    }

    public WebElement getEmailElement() {
        return email;
    }

    public WebElement getPasswordElement() {
        return password;
    }

    public WebElement getMessageAtEmailElement() {
        return messageEmailInvalid;
    }

    public WebElement getMessageAtPasswordElement() {
        return messagePasswordInvalid;
    }

}
