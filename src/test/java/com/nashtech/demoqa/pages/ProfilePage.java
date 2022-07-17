package com.nashtech.demoqa.pages;

import com.nashtech.demoqa.pages.locators.AddBookLocators;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

public class ProfilePage extends BasePage {
    public ProfilePage(WebDriver driver) throws IOException {
        super(driver);
    }

    public boolean checkBookExist(String text) {
        return isDisplayed(AddBookLocators.SELECT_BOOK_NAME(text));
    }

    public void clickDeleteButton() {
        clickElement(AddBookLocators.BTN_DELETE_ALL_BOOKS);
    }

    public void clickOkButton() {
        clickElement(AddBookLocators.BTN_DELETE_BOOK_OK);
    }

    public void clickCancelButton() {
        clickElement(AddBookLocators.BTN_DELETE_BOOK_CANCEL);
    }
}
