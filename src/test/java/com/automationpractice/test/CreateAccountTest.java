package com.automationpractice.test;

import com.automationpractice.pages.CreateAccountFormPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {
    // test create account functionality

    @Test(priority = 1)
    public void isCreateAccountPageTest(){
        // go to create account page and check if this correct page
        HomePage homePage=new HomePage(driver);
        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        homePage.clickSignInButton();
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
        Assert.assertTrue(createAccountPage.isDisplayedCreateAccountButton());
    }

    @Test(priority = 2)
    public  void createAccountWithoutEmailTest(){
        //try create account without email
        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        createAccountPage.crateAccountButtonClick();
        Assert.assertTrue(createAccountPage.isDisplayedEmailErrorMessage(),"");
    }

    @Test(priority = 3)
    public void invalidEmailSyntaxTest(){
        // Check if red background is visible when mail has invalid syntax
        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        createAccountPage.setEmailAddress("test")
                .crateAccountButtonClick();
        Assert.assertTrue(createAccountPage.isEmailInvalid());
        Assert.assertTrue(createAccountPage.isDisplayedEmailErrorMessage());
    }


    @Test(priority = 4)
    public void isEmailRegisteredAndValidSyntaxTest(){
        //try create account with email already use
        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        createAccountPage.setEmailAddress("test@test.pl")
                .crateAccountButtonClick();
        Assert.assertTrue(createAccountPage.isDisplayedEmailRegisteredMessage(),"Something went wrong. Maybe email is registered");
        Assert.assertTrue(createAccountPage.isEmailValid());
    }

    @Test(priority = 5)
    public void validEmailTest(){
        //check if user enter valid email, application will go to create account form
        CreateAccountPage createAccountPage=new CreateAccountPage(driver);
        createAccountPage.setEmailAddress("mateusz@testtest.pl")
                .crateAccountButtonClick();

        CreateAccountFormPage createAccountFormPage = new CreateAccountFormPage(driver);
        Assert.assertTrue(createAccountFormPage.isAccountCreationFormDisplayed(),"Something went wrong.This is not create account form");

    }
}
