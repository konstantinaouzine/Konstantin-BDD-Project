package pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

public abstract class BasePage {

    static WebDriver driver;

    protected String pageTitle;

    private static Logger log = Logger.getLogger(BasePage.class.getName());

    BasePage(){
        WebDriverManager.chromedriver().version("78.0.3904.105").setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-infobars");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-browser-side-navigation");
        options.addArguments("--disable-gpu");
        driver = new ChromeDriver(options);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}