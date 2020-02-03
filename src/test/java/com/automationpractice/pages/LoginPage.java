package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver) {
        super(driver);
    }


    /*********   WebElements       *********/

    @FindBy(xpath = ".//button[@name='SubmitLogin']")
    private WebElement loginButton;

    @FindBy(xpath = ".//input[@name='email']")
    private WebElement emailFieldLogin;

    @FindBy(xpath = ".//input[@name='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = ".//input[@name='email_create']")
    private WebElement emailFieldCreate;

    @FindBy(xpath = "//li[contains(text(), \"An email address required.\")]")
    private WebElement emailRequiredMessage;

    @FindBy(xpath = ".//div[@class=\"form-group form-ok\"]")
    private WebElement correctMailForm;

    @FindBy(xpath = ".//div[@class=\"form-group form-error\"]")
    private WebElement invalidMailForm;

    @FindBy(xpath = "//li[contains(text(), \"Password is required.\")]")
    private WebElement passwordRequiredMessage;

    @FindBy(xpath = "//li[contains(text(), \"Authentication failed.\")]")
    private WebElement authenticationFailedMessage;


    /*********   Methods       *********/

    public LoginPage sendMailToLogin(String mail) {
        emailFieldLogin.clear();
        emailFieldLogin.sendKeys(mail);
        passwordField.click();
        return this;
    }

    public LoginPage sendPasswordToLogin(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
        return this;
    }

    public LoginPage clickLoginButton(){
        loginButton.click();
        return this;
    }

    public boolean isDisplayedLoginButton(){
        return loginButton.isDisplayed();
    }

    public LoginPage waitForElemntsLoginPage(){
        wait.until(ExpectedConditions.visibilityOf(loginButton));
        return this;
    }

    /*********   Errors       *********/

    public boolean isEmailRequiredMessage(){
        return wait.until(ExpectedConditions.visibilityOf(emailRequiredMessage)).isDisplayed();
    }

    public boolean isEmailValidGreenBackgroundVisible(){
        return correctMailForm.isDisplayed();
    }

    public boolean isEmailInvalidRedBackgroundVisible(){
        return invalidMailForm.isDisplayed();
    }

    public boolean isPasswordRequiredMessageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(passwordRequiredMessage)).isDisplayed();
    }

    public boolean isAuthenticationFailedMessageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(authenticationFailedMessage)).isDisplayed();
    }

}