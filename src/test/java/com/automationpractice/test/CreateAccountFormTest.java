package com.automationpractice.test;

import com.automationpractice.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

public class CreateAccountFormTest extends BaseTest {


    @Test(priority = 1)
    public void isCreateFormPageTest(){
        HomePage homePage=new HomePage(driver);
        homePage.clickSignInButton();

        LoginPage loginPage=new LoginPage(driver);
        loginPage.waitForElemntsLoginPage();
        Assert.assertEquals(driver.getTitle(),"Login - My Store","This is not Login Page");

        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        createAccountPage.setEmailAddress("janusz1@test.pl")
                .crateAccountButtonClick();

        CreateAccountFormPage createAccountFormPage = new CreateAccountFormPage(driver);
        Assert.assertTrue(createAccountFormPage.isAccountCreationFormDisplayed(),"Something went wrong.This is not create account form");
        Assert.assertEquals(createAccountFormPage.getEmail(),"janusz@test.pl","Something went wrong. Email is not the same.");
    }

    @Test(priority = 2)
    public void formWithoutCredentialsTest(){
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
        createAccountFormPage.clickRegister();
        Assert.assertTrue(createAccountFormPage.isRequiredCredentialsMessageDisplayed(),"Something went wrong.Check the form maybe some field are filled. ");
    }
    @Test(priority = 3)
    public void msMrsRadioButtonTest(){
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
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
        createAccountFormPage.setPassword("1234");
        Assert.assertTrue(createAccountFormPage.isPasswordInvalidRedShadow());

        createAccountFormPage.setPassword("12345");
        Assert.assertTrue(createAccountFormPage.isPasswordValidGreenShadow());
    }

    @Test(priority = 5)
    public void verifyMonthsInDateOfBirthTest(){
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
        List<String> month= Arrays.asList("-","January ","February ","March ","April ","May ","June ","July ","August ","September ","October ",
                "November ","December ");
        Assert.assertEquals(month,createAccountFormPage.getMonthsOfBirthList());
    }

    @Test(priority = 6)
    public void createAccountSuccessfullyTest(){
        CreateAccountFormPage createAccountFormPage=new CreateAccountFormPage(driver);
        createAccountFormPage.clickMrRadioButton()
                .setCustomerFirstName("Janusz1")
                .setCustomerLastName("Januszowski");
        Assert.assertEquals(createAccountFormPage.getFirstNameAddress(),"Janusz1");
        Assert.assertEquals(createAccountFormPage.getLastNameAddress(),"Januszowski");

        createAccountFormPage.setPassword("123456789")
                .setDayOfBirth("2")
                .setMonthOfBirth("January ")
                .setYearOfBirth("1990")
                .setAddress("Broadway")
                .setCity("New York")
                .setState("Arkansas")
                .setPostalCode("12345")
                .setMobilePhone("123456789");

        Assert.assertEquals(createAccountFormPage.getAliasAddress(),"My address","Something went wrong.Alias is not equal 'My address'");

        createAccountFormPage.clickRegister();
        MyAccountPage myAccountPage=new MyAccountPage(driver);
        Assert.assertEquals(driver.getTitle(),"My account - My Store","Something went wrong. This is not My account page.");
        Assert.assertEquals(myAccountPage.getCustomerAccountName(),"Janusz Januszowski","Something went wrong. This is not <name> account");
    }


}
