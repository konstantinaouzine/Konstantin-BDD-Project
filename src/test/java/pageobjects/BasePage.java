package pageobjects;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import util.SharedDriver;

import java.util.concurrent.TimeUnit;
//import java.util.logging.Logger;

public abstract class BasePage {

    protected SharedDriver sharedDriver;

    protected String pageTitle;

    //private static Logger log = Logger.getLogger(BasePage.class.getName());

    BasePage(SharedDriver sharedDriver){
        this.sharedDriver = sharedDriver;
        sharedDriver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    }

    public String getPageTitle(){
        return sharedDriver.getTitle();
    }
}