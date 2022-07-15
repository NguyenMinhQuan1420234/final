package com.nashtech.demoqa.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;
import com.nashtech.demoqa.contents.ConfigConstants;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ ExtentIReporterSuiteListenerAdapter.class })
public class BaseTest {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void BeforeMethod() throws InterruptedException {
        // solution 1
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.manage().window().maximize();
        driver.get(ConfigConstants.BASE_URL);

        // solution 2
        // WebDriverManager.chromedriver().setup();
        // ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--incognito");
  
        // try {
        //     driver = new ChromeDriver(chromeOptions);
        // }
        // catch(WebDriverException e) {
        //     driver = new ChromeDriver(chromeOptions);
        // }
        // driver.manage().window().maximize();
        // driver.get(ConfigConstants.BASE_URL);

        //solution 3
        // WebDriverManager.chromedriver().setup();
        // ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--incognito");
        // driver = new ChromeDriver(chromeOptions);
        // driver.manage().window().maximize();
        // Thread.sleep(5000);//before navigate to baseURL
        // driver.get(ConfigConstants.BASE_URL);

        // solution 4

    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
