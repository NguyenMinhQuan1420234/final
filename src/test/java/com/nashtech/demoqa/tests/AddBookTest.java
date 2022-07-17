package com.nashtech.demoqa.tests;

import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.pages.BookStorePage;
import com.nashtech.demoqa.pages.LoginPage;
import com.nashtech.demoqa.pages.ProfilePage;
import com.nashtech.demoqa.pages.helper.NavigatePage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class AddBookTest extends BaseTest {
    LoginPage loginPage;
    ProfilePage profilePage;
    BookStorePage bookStorePage;
    NavigatePage navigatePage;

    @BeforeMethod
    public void Preconditions() throws IOException, InterruptedException {
        navigatePage = new NavigatePage(driver);
        loginPage = new LoginPage(driver);
        profilePage = new ProfilePage(driver);
        bookStorePage = new BookStorePage(driver);

        navigatePage.navigate(UrlConstants.LOGIN_URL);
        loginPage.Login();
    }

    @Test
    public void AddBookToCollectionSuccessfully() {
        if(profilePage.checkBookExist("Git Pocket Guide")) {

        }
    }

    @AfterMethod
    public void AfterMethod() {
        System.out.println("pause");
    }
}
