package com.nashtech.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.nashtech.demoqa.pages.locators.RegisterStudentLocators;

import java.io.IOException;

public class RegisterStudentPage extends BasePage {

    public RegisterStudentPage(WebDriver driver) throws IOException {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
    public void ClickSubmitButton() {
        sendKeysFromKeyBoard(RegisterStudentLocators.TXT_CURRENT_ADDRESS, Keys.TAB);
        sendKeysFromKeyBoard(RegisterStudentLocators.TXT_CURRENT_ADDRESS, Keys.TAB);
        // clickElement(StudentRegistrationLocators.BTN_SUBMIT);
        sendKeysFromKeyBoard(RegisterStudentLocators.BTN_SUBMIT, Keys.ENTER);
    }
}
