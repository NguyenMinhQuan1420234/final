package com.nashtech.demoqa.tests;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.pages.RegisterStudentPage;
import com.nashtech.demoqa.pages.helper.NavigatePage;

import java.io.IOException;

public class RegisterStudentTest extends BaseTest {
    RegisterStudentPage studentRegistrationPage;
    NavigatePage navigatePage;
    
    @BeforeMethod
    public void Precondition() throws IOException {
        studentRegistrationPage = new RegisterStudentPage(driver);
        navigatePage = new NavigatePage(driver);
    }
    
    @Test
    public void ClickSubmitButton() throws InterruptedException {
        navigatePage.navigate(UrlConstants.PRACTICE_FORM_URL);
        studentRegistrationPage.ClickSubmitButton();
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("pause");
    }
}
