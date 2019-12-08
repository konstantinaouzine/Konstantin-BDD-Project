package PageObjects;

import Utils.SharedDriver;

import java.util.concurrent.TimeUnit;
//import java.Utils.logging.Logger;

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