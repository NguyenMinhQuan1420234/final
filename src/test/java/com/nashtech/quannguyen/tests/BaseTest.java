package com.nashtech.quannguyen.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseTest {
    public WebDriver driver;


    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void BeforeMethod() throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("");

    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
