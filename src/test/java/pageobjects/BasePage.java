package pageobjects;

import io.github.bonigarcia.wdm.ChromeDriverManager;
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
        ChromeDriverManager.getInstance().setup();
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ayzin\\Desktop\\Selenium\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--start-maximized");
        options.addArguments("--disable-notifications");
        this.driver = new ChromeDriver(options);
        this.driver = driver;
        this.driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        this.driver.manage().window().maximize();

    }

    public String getPageTitle(){
        return driver.getTitle();
    }

    public static WebDriver getDriver(){
        return driver;
    }
}