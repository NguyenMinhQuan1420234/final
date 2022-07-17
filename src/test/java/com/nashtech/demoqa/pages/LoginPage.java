package com.nashtech.demoqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) throws IOException {
        super(driver);
    }

    public static final By TXT_USERNAME = By.id("userName");
    public static final By TXT_PASSWORD = By.id("password");
    public static final By BTN_LOGIN = By.id("login");

    public void Login() {
        inputText(TXT_USERNAME, System.getProperty("USERNAME"));
        inputText(TXT_PASSWORD, System.getProperty("PASSWORD"));
        clickElement(BTN_LOGIN);
    }

}
