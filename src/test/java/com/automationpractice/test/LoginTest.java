package com.automationpractice.test;

import com.automationpractice.pages.HomePage;
import com.automationpractice.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest extends BaseTest{


    @Test(priority = 1)
    public void isLoginPage(){
        HomePage homePage=new HomePage(driver);
        LoginPage loginPage=new LoginPage(driver);
        homePage.clickSignInButton();
        loginPage.waitForElemntsLoginPage();
        Assert.assertEquals(driver.getTitle(),"Login - My Store");
        Assert.assertTrue(loginPage.isDisplayedLoginButton());
    }

    @Test(priority = 2)
    public void loginWithoutCredentialsTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("")
                .sendPasswordToLogin("")
                .clickLoginButton();
        Assert.assertTrue(loginPage.isEmailRequiredMessage(),"The error message is not displayed");
    }

    @Test(priority = 3)
    public void validMailSyntaxTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("test@test.pl");
        Assert.assertTrue(loginPage.isEmailValid(),"Mail syntax is incorrect");
    }

    @Test(priority = 4)
    public void invalidMailSyntaxTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("test");
        Assert.assertTrue(loginPage.isEmailInvalid(),"Mail syntax is correct");

        loginPage.sendMailToLogin("test@test");
        Assert.assertTrue(loginPage.isEmailInvalid(),"Mail syntax is correct");
    }

    @Test(priority = 5)
    public void loginWithoutPasswordTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("test@test2.pl")
                .sendPasswordToLogin("")
                .clickLoginButton();
        Assert.assertTrue(loginPage.isPasswordRequiredMessageDisplayed());
    }

    @Test(priority = 6)
    public void loginWithoutMailTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("")
                .sendPasswordToLogin("123456789")
                .clickLoginButton();
        Assert.assertTrue(loginPage.isEmailRequiredMessage());
    }

    @Test(priority = 7)
    public void authenticationFailedTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("test@testt.pl")
                .sendPasswordToLogin("123456789")
                .clickLoginButton();
        Assert.assertTrue(loginPage.isAuthenticationFailedMessageDisplayed());
    }

    @Test(priority = 7)
    public void authenticationSuccessTest(){
        LoginPage loginPage=new LoginPage(driver);
        loginPage.sendMailToLogin("mucha65@gmail.com")
                .sendPasswordToLogin("987654321")
                .clickLoginButton();
    }



}
