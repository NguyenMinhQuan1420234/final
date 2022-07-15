package com.nashtech.demoqa.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import com.nashtech.demoqa.pages.locators.StudentRegistrationLocators;

public class StudentRegistrationPage extends BasePage {

    public StudentRegistrationPage(WebDriver driver) {
        super(driver);
        //TODO Auto-generated constructor stub
    }
    
    public void ClickSubmitButton() {
        sendKeysFromKeyBoard(StudentRegistrationLocators.TXT_CURRENT_ADDRESS, Keys.TAB);
        sendKeysFromKeyBoard(StudentRegistrationLocators.TXT_CURRENT_ADDRESS, Keys.TAB);
        // clickElement(StudentRegistrationLocators.BTN_SUBMIT);
        sendKeysFromKeyBoard(StudentRegistrationLocators.BTN_SUBMIT, Keys.ENTER);
    }
}
