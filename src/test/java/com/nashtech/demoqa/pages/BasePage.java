package com.nashtech.demoqa.pages;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

import com.nashtech.demoqa.contents.ConfigConstants;



public class BasePage {
    public WebDriver driver;
    public WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(ConfigConstants.TIMEOUT_IN_SECOND));
    }

    public void navigate(String url) {
        driver.get(ConfigConstants.BASE_URL + url);
    }

    public Select elementSelect(By locator) {
        WebElement selectElement = waitForElementToBeClickable(locator);
        Select selectObject = new Select(selectElement);
        return selectObject;
    }

    public void inputText(By locator, String text) {
        WebElement element = waitForElementToBeClickable(locator);
        element.sendKeys(text);
    }

    public void clickElement(By locator) {
        WebElement element = waitForElementToBeClickable(locator);
        element.click();
    }

    public String getTextAttribute(By locator, String attribute) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getAttribute(attribute);
    }

    public String getText(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        return element.getText();   
    }

    public void moveToElement(By locator) {
        WebElement element = waitForElementToBeVisible(locator);
        Actions action = new Actions(driver);
        action.moveToElement(element);
        action.perform();
    }

    public List<WebElement> waitForListOfElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
    }

    public WebElement waitForElementToBeVisible(By locator) {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitForElementToBeClickable(By locator) {
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}
