package com.nashtech.demoqa.pages.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

import com.nashtech.demoqa.contents.ConfigConstants;
import com.nashtech.demoqa.pages.BasePage;

public class NavigatePage extends BasePage {

    public NavigatePage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
    public void navigate(String url) throws InterruptedException {
        Thread.sleep(5000); 
        driver.get(ConfigConstants.BASE_URL + url);
    }

}
