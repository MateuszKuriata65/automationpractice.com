package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class CreateAccountPage extends BasePage {


    public CreateAccountPage(WebDriver driver){
        super(driver);
    }
    /*** WebElements       ***/
    @FindBy(xpath = ".//button[@id='SubmitCreate']")
    private WebElement createAccountButton;

    @FindBy(xpath = ".//input[@id='email_create']")
    private WebElement emailFieldCreateAccount;

    @FindBy(xpath = ".//div[@class='form-group form-ok']")
    private WebElement validEmailForm;

    @FindBy(xpath = ".//div[@class='form-group form-error']")
    private WebElement invalidEmailForm;

    @FindBy(xpath = ".//li[contains(text(), \"Invalid email address.\")]")
    private WebElement emailRequiredMessage;

    @FindBy(xpath = ".//li[contains(text(), \"An account using this email address has already been registered." +
            " Please enter a valid password or request a new one. \")]")
    private WebElement emailIsRegisteredMessage;

    /*********  Methods     *************/

    public boolean isDisplayedCreateAccountButton(){
        return createAccountButton.isDisplayed();
    }

    public void crateAccountButtonClick(){
        createAccountButton.click();
    }

    public CreateAccountPage setEmailAddress(String mail){
        emailFieldCreateAccount.clear();
        emailFieldCreateAccount.sendKeys(mail);
        return this;
    }



    /****** Errors ********/

    public boolean isEmailValid(){
        return validEmailForm.isDisplayed();
    }

    public boolean isEmailInvalid(){
        return invalidEmailForm.isDisplayed();
    }

    public boolean isDisplayedEmailErrorMessage(){
        return  wait.until(ExpectedConditions.visibilityOf(emailRequiredMessage)).isDisplayed();
    }

    public boolean isDisplayedEmailRegisteredMessage(){
        return  wait.until(ExpectedConditions.visibilityOf(emailIsRegisteredMessage)).isDisplayed();
    }



}
