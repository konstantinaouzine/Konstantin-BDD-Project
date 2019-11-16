package pageobjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import java.time.Duration;


public class BankLoginPage extends BasePage{
    private String url;

    @FindBy(name = "uid")
    private WebElement loginUsernameField;
    @FindBy(name = "password")
    private WebElement loginPasswordField;
    @FindBy(name = "btnLogin")
    private WebElement loginButton;
    @FindBy(name = "btnReset")
    private WebElement loginResetButton;

    /*@SuppressWarnings("all")
    Wait wait = new FluentWait(this.driver)
            .withTimeout(Duration.ofSeconds(30))
            .pollingEvery(Duration.ofSeconds(1))
            .ignoring(NoSuchElementException.class).ignoring(StaleElementReferenceException.class);*/

    public BankLoginPage() {
        super();
        PageFactory.initElements(driver, this);
        this.url = "http://demo.guru99.com/V1/index.php";
    }

    public void openLoginPage() {
        driver.get(this.url);
    }

    public void inputUsername(String username) {
        loginUsernameField.click();
        loginUsernameField.sendKeys(username);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public void inputPassword(String password) {
        loginPasswordField.click();
        loginPasswordField.sendKeys(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void clickLoginButton(){
        loginButton.click();
    }

    public void performLogin(String username, String password){
        inputUsername(username);
        inputPassword(password);
        loginButton.click();
    }

    public boolean verifyLoggedIn(){
        return driver.getCurrentUrl().equals("http://demo.guru99.com/V1/html/Managerhomepage.php");
    }

    public boolean verifyOnLoginPage(){
        return (loginUsernameField.isDisplayed() && loginPasswordField.isDisplayed());
    }

    public boolean verifyLogOutButtonShown(){
        return driver.findElement(By.linkText("Log out")).isDisplayed();
    }
}
