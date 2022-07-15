package com.nashtech.demoqa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nashtech.demoqa.contents.ConfigConstants;
import com.nashtech.demoqa.pages.StudentRegistrationPage;
import com.nashtech.demoqa.pages.helper.NavigatePage;

public class StudentRegistrationTest extends BaseTest {
    StudentRegistrationPage studentRegistrationPage;
    NavigatePage navigatePage;
    
    @BeforeMethod
    public void Precondition() {
        studentRegistrationPage = new StudentRegistrationPage(driver);
        navigatePage = new NavigatePage(driver);
    }
    
    @Test
    public void ClickSubmitButton() throws InterruptedException {
        navigatePage.navigate(ConfigConstants.PRACTICE_FORM_URL);
        studentRegistrationPage.ClickSubmitButton();
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("pause");
    }
}
