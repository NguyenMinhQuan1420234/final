package com.nashtech.demoqa.tests;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.nashtech.demoqa.tests.testdata.RegisterStudentData;
import com.nashtech.demoqa.utils.JsonUtil;

import org.testng.annotations.Test;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.nashtech.demoqa.contents.UrlConstants;
import com.nashtech.demoqa.pages.RegisterStudentPage;
import com.nashtech.demoqa.pages.helper.NavigatePage;

import java.io.FileNotFoundException;
import java.io.IOException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class RegisterStudentTest extends BaseTest {
    RegisterStudentData registerStudentData;
    RegisterStudentPage registerStudentPage;
    NavigatePage navigatePage;
//    JsonUtil JsonUtil;
    @BeforeMethod
    public void Precondition() throws IOException, InterruptedException {
        registerStudentPage = new RegisterStudentPage(driver);
        navigatePage = new NavigatePage(driver);
        navigatePage.navigate(UrlConstants.PRACTICE_FORM_URL);
    }
    
    @Test
    public void RegisterStudentFormWithAllFieldsSuccessfully() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = JsonUtil.loadJsonfile("RegisterStudentTestData.json");
        RegisterStudentData registerStudentData = gson.fromJson(reader, RegisterStudentData.class);

        registerStudentPage.inputFirstName(registerStudentData.firstName);
        registerStudentPage.inputLastName(registerStudentData.lastName);
        registerStudentPage.inputEmail(registerStudentData.email);
        registerStudentPage.selectGender(registerStudentData.gender);
        registerStudentPage.inputMobile(registerStudentData.mobile);
        registerStudentPage.inputDateOfBird(registerStudentData.dateOfBird);
        registerStudentPage.inputSubject(registerStudentData.subject);
        registerStudentPage.selectHobbySports();
        registerStudentPage.selectPicture(registerStudentData.picture);
        registerStudentPage.inputCurrentAddress(registerStudentData.currentAddress);
        registerStudentPage.selectState(registerStudentData.state);
        registerStudentPage.selectCity(registerStudentData.city);
        registerStudentPage.ClickSubmitButton();

        assertThat("Verify Message:",registerStudentPage.getSuccessfulMessage(),equalTo("Thanks for submitting the form"));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Student Name"), equalTo(registerStudentData.firstName + " " + registerStudentData.lastName));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Student Email"), equalTo(registerStudentData.email));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Gender"), equalTo(registerStudentData.gender));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Mobile"), equalTo(registerStudentData.mobile));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Date of Birth"), equalTo(registerStudentData.dateOfBirdFormat));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Subjects"), equalTo(registerStudentData.subject));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Hobbies"), equalTo(registerStudentData.hobby));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Picture"), equalTo(registerStudentData.pictureName));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Address"), equalTo(registerStudentData.currentAddress));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("State and City"), equalTo(registerStudentData.state + " " + registerStudentData.city));

    }

    @Test
    public void RegisterStudentFormWithMandatoryFieldsSuccessfully() throws FileNotFoundException {
        Gson gson = new Gson();
        JsonReader reader = JsonUtil.loadJsonfile("RegisterStudentTestData.json");
        RegisterStudentData registerStudentData = gson.fromJson(reader, RegisterStudentData.class);

        registerStudentPage.inputFirstName(registerStudentData.firstName);
        registerStudentPage.inputLastName(registerStudentData.lastName);
        registerStudentPage.selectGender(registerStudentData.gender);
        registerStudentPage.inputMobile(registerStudentData.mobile);
        registerStudentPage.ClickSubmitButton();

        assertThat("Verify Message:",registerStudentPage.getSuccessfulMessage(),equalTo("Thanks for submitting the form"));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Student Name"), equalTo(registerStudentData.firstName + " " + registerStudentData.lastName));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Gender"), equalTo(registerStudentData.gender));
        assertThat("Verify Message:", registerStudentPage.getVerifyTextValue("Mobile"), equalTo(registerStudentData.mobile));

    }

}
