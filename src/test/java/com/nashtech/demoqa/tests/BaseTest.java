package com.nashtech.demoqa.tests;

import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.AfterMethod;

import com.aventstack.extentreports.testng.listener.ExtentIReporterSuiteListenerAdapter;
import com.nashtech.demoqa.utils.PropertiesFileUtil;

import io.github.bonigarcia.wdm.WebDriverManager;

@Listeners({ ExtentIReporterSuiteListenerAdapter.class })
public class BaseTest {
    public WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeSuite
    public void beforeSuite() throws IOException{
        Properties properties = PropertiesFileUtil.loadPropertiesFromFile(System.getProperty("env.properties"));
        PropertiesFileUtil.appendSystemProperties(properties);
    }

    @BeforeMethod
    @Parameters({"browser"})
    public void beforeMethod(String browser) throws InterruptedException {
        String browserType = (browser!=null)? browser:System.getProperty("BROWSER_TYPE");
        WebDriverManager.chromedriver().setup();
        switch (browserType) {
            case "IE":
                WebDriverManager.iedriver().setup();
                driver = new InternetExplorerDriver();
            case "Firefox":
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            case "Edge":
                WebDriverManager.edgedriver().setup();
                driver = new EdgeDriver();
            default:
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
        }
        driver.manage().window().maximize();
        driver.get(System.getProperty("BASE_URL"));

        // solution 1
        // WebDriverManager.chromedriver().setup();
        // ChromeOptions chromeOptions = new ChromeOptions();
        // chromeOptions.addArguments("--incognito");
        // driver = new ChromeDriver(chromeOptions);
        // driver.manage().window().maximize();
        // driver.get(ConfigConstants.BASE_URL);

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

    }

    @AfterMethod
    public void AfterMethod() {
        driver.quit();
    }
}
