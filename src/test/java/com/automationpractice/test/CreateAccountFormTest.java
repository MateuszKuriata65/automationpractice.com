package com.automationpractice.test;

import com.automationpractice.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CreateAccountFormTest extends BaseTest {
        // test create account from test

    @Test(priority = 1)
    public void isCreateFormPageTest(){
      // go to create account form page and check if this correct page
        HomePage homePage=new HomePage(driver);
        homePage.clickSignInButton();

        LoginPage loginPage=new LoginPage(driver);
        loginPage.waitForElemntsLoginPage();
        Assert.assertEquals(driver.getTitle(),"Login - My Store","This is not Login Page");

        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        createAccountPage.setEmailAddress(testDataReader.getCreateAccountData().getNewMail())
                .crateAccountButtonClick();

        CreateAccountFormPage createAccountFormPage = new CreateAccountFormPage(driver);
        Assert.assertTrue(createAccountFormPage.isAccountCreationFormDisplayed(),"Something went wrong.This is not create account form");
        Assert.assertEquals(createAccountFormPage.getEmail(),testDataReader.getCreateAccountData().getNewMail(),"Something went wrong. Email is not the same as create account email.");
    }

    @Test(priority = 2)
    public void formWithoutCredentialsTest(){
        //try create account without required data
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
        createAccountFormPage.clickRegister();
        Assert.assertTrue(createAccountFormPage.isRequiredCredentialsMessageDisplayed(),"Something went wrong.Check the form maybe some field are filled. ");
    }
    @Test(priority = 3)
    public void msMrsRadioButtonTest(){
        // check action radio button
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
        // Mr. radiobutton Test
        Assert.assertFalse(createAccountFormPage.isSelectedMrRadioButton());
        createAccountFormPage.clickMrRadioButton();
        Assert.assertTrue(createAccountFormPage.isSelectedMrRadioButton());

        // Mrs. radiobutton Test
        Assert.assertFalse(createAccountFormPage.isSelectedMrsRadioButton());
        createAccountFormPage.clickMrsRadioButton();
        Assert.assertTrue(createAccountFormPage.isSelectedMrsRadioButton());

        Assert.assertFalse(createAccountFormPage.isSelectedMrRadioButton());
    }

    @Test(priority = 4)
    public void passwordFiveCharacterTest(){
        // Check if red background is visible when password has less than 5 digits
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
        createAccountFormPage.setPassword(testDataReader.getCreateAccountData().getPasswordLessFiveSigns());
        Assert.assertTrue(createAccountFormPage.isPasswordInvalidRedShadow());
        // Check if green background is visible when password is equal 5 digits or more
        createAccountFormPage.setPassword(testDataReader.getCreateAccountData().getPassword5orMoreSigns());
        Assert.assertTrue(createAccountFormPage.isPasswordValidGreenShadow());
    }

    @Test(priority = 5)
    public void verifyMonthsInDateOfBirthTest(){
        //check if list of months in the page is equal with real months
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
       // List<String> month= Arrays.asList("-","January ","February ","March ","April ","May ","June ","July ","August ","September ","October ",
                //"November ","December ");
        List<String> month= Arrays.asList(testDataReader.getCreateAccountData().getMonths().split(","));
        Assert.assertEquals(month,createAccountFormPage.getMonthsOfBirthList());
    }

    @Test(priority = 6)
    public void createAccountSuccessfullyTest(){
        // try create account with valid data
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
        createAccountFormPage.clickMrRadioButton()
                .setCustomerFirstName(testDataReader.getCreateAccountData().getFirstName())
                .setCustomerLastName(testDataReader.getCreateAccountData().getLastName());
        Assert.assertEquals(createAccountFormPage.getFirstNameAddress(),testDataReader.getCreateAccountData().getFirstName());
        Assert.assertEquals(createAccountFormPage.getLastNameAddress(),testDataReader.getCreateAccountData().getLastName());

        createAccountFormPage.setPassword(testDataReader.getCreateAccountData().getPassword())
                .setDayOfBirth(testDataReader.getCreateAccountData().getDayOfBirth())
                .setMonthOfBirth(testDataReader.getCreateAccountData().getMonthOfBirth())
                .setYearOfBirth(testDataReader.getCreateAccountData().getYearOfBirth())
                .setAddress(testDataReader.getCreateAccountData().getAddress())
                .setCity(testDataReader.getCreateAccountData().getCity())
                .setState(testDataReader.getCreateAccountData().getState())
                .setPostalCode(testDataReader.getCreateAccountData().getPostalCode())
                .setMobilePhone(testDataReader.getCreateAccountData().getMobilePhone());

        Assert.assertEquals(createAccountFormPage.getAliasAddress(),"My address","Something went wrong.Alias is not equal 'My address'");

        createAccountFormPage.clickRegister();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        Assert.assertEquals(driver.getTitle(),"My account - My Store","Something went wrong. This is not My account page.");
        Assert.assertEquals(myAccountPage.getCustomerAccountName(),testDataReader.getCreateAccountData().getFirstName() +' '+testDataReader.getCreateAccountData().getLastName(),"Something went wrong. This is not <name> account");
    }


}
