package PageObjects;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import Utils.SharedDriver;


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

    public BankLoginPage(SharedDriver sharedDriver) {
        super(sharedDriver);
        PageFactory.initElements(sharedDriver, this);
        this.url = "http://demo.guru99.com/V1/index.php";
    }

    public void openLoginPage() {
        sharedDriver.get(this.url);
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
        return sharedDriver.getCurrentUrl().equals("http://demo.guru99.com/V1/html/Managerhomepage.php");
    }

    public boolean verifyOnLoginPage(){
        return (loginUsernameField.isDisplayed() && loginPasswordField.isDisplayed());
    }

    public boolean verifyLogOutButtonShown(){
        return sharedDriver.findElement(By.linkText("Log out")).isDisplayed();
    }
}
