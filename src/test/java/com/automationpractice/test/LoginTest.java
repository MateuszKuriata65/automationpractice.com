package com.automationpractice.test;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{
    // tests log in functionality

    @Test(priority = 1)
    public void isLoginPage(){
        //Check is this Login Page
        HomePage homePage=new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        homePage.clickSignInButton();
        loginPage.waitForElemntsLoginPage();
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
        Assert.assertTrue(loginPage.isDisplayedLoginButton());
    }

    @Test(priority = 2)
    public void loginWithoutCredentialsTest(){
        //Check chance of logging without data.
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("")
                .sendPasswordToLogin("")
                .clickLoginButton();
        Assert.assertTrue(loginPage.isEmailRequiredMessage(),"The error message is not displayed");
    }

    @Test(priority = 3)
    public void validMailSyntaxMessageTest(){
        // Check if green background is visible when mail has good syntax
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("test@test.pl");
        Assert.assertTrue(loginPage.isEmailValidGreenBackgroundVisible(),"Mail syntax is incorrect");
    }

    @Test(priority = 4)
    public void invalidMailSyntaxMessageTest(){
        LoginPage loginPage=new LoginPage(driver);
        // Check if red background is visible when mail has invalid syntax
        loginPage.sendMailToLogin("test");
        Assert.assertTrue(loginPage.isEmailInvalidRedBackgroundVisible(),"Mail syntax is correct");

        loginPage.sendMailToLogin("test@test");
        Assert.assertTrue(loginPage.isEmailInvalidRedBackgroundVisible(),"Mail syntax is correct");
    }

    @Test(priority = 5)
    public void loginWithoutPasswordTest(){
        //try log in without password
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("test@test2.pl")
                .sendPasswordToLogin("")
                .clickLoginButton();
        Assert.assertTrue(loginPage.isPasswordRequiredMessageDisplayed());
    }

    @Test(priority = 6)
    public void loginWithoutMailTest(){
        // try log in without email
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("")
                .sendPasswordToLogin("123456789")
                .clickLoginButton();
        Assert.assertTrue(loginPage.isEmailRequiredMessage());
    }

    @Test(priority = 7)
    public void authenticationFailedTest(){
        // try log in using nonexistent user data
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("test@testt.pl")
                .sendPasswordToLogin("123456789")
                .clickLoginButton();
        Assert.assertTrue(loginPage.isAuthenticationFailedMessageDisplayed());
    }

    @Test(priority = 7)
    public void authenticationSuccessTest(){
        // try log in using existing user data
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("mucha65@gmail.com")
                .sendPasswordToLogin("987654321")
                .clickLoginButton();
        // add assert!!!
    }



}
