package com.automationpractice.test;

import com.automationpractice.pages.CreateAccountFormPage;
import com.automationpractice.pages.CreateAccountPage;
import com.automationpractice.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CreateAccountTest extends BaseTest {


    @Test(priority = 1)
    public void isCreateAccountPageTest(){
        HomePage homePage=new HomePage(driver);
        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        homePage.clickSignInButton();
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
        Assert.assertTrue(createAccountPage.isDisplayedCreateAccountButton());
    }

    @Test(priority = 2)
    public  void createAccountWithoutEmailTest(){
        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        createAccountPage.crateAccountButtonClick();
        Assert.assertTrue(createAccountPage.isDisplayedEmailErrorMessage(),"");
    }

    @Test(priority = 3)
    public void invalidEmailSyntaxTest(){
        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        createAccountPage.setEmailAddress("test")
                .crateAccountButtonClick();
        Assert.assertTrue(createAccountPage.isEmailInvalid());
        Assert.assertTrue(createAccountPage.isDisplayedEmailErrorMessage());
    }


    @Test(priority = 4)
    public void isEmailRegisteredAndValidSyntaxTest(){
        CreateAccountPage createAccountPage =new CreateAccountPage(driver);
        createAccountPage.setEmailAddress("test@test.pl")
                .crateAccountButtonClick();
        Assert.assertTrue(createAccountPage.isDisplayedEmailRegisteredMessage(),"Something went wrong. Maybe email is registered");
        Assert.assertTrue(createAccountPage.isEmailValid());
    }

    @Test(priority = 5)
    public void validEmailTest(){
        CreateAccountPage createAccountPage=new CreateAccountPage(driver);
        createAccountPage.setEmailAddress("mateusz@testtest.pl")
                .crateAccountButtonClick();

        CreateAccountFormPage createAccountFormPage = new CreateAccountFormPage(driver);
        Assert.assertTrue(createAccountFormPage.isAccountCreationFormDisplayed(),"Something went wrong.This is not create account form");

    }
}
