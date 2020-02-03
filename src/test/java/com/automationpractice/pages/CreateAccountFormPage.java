package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class CreateAccountFormPage extends BasePage {

    public  CreateAccountFormPage(WebDriver driver){
        super(driver);
    }

    /*********   WebElements       *********/
    @FindBy(xpath = ".//form[@id='account-creation_form']")
    private WebElement accountCreationForm;

    @FindBy(xpath = ".//input[@id='id_gender1']")
    private WebElement  mrRadio;

    @FindBy(xpath = ".//input[@id='id_gender2']")
    private WebElement  mrsRadio;

    @FindBy(xpath = ".//input[@id='customer_firstname']")
    private WebElement customerFirstName;

    @FindBy(xpath = ".//input[@id='customer_lastname']")
    private WebElement customerLastName;

    @FindBy(xpath = ".//input[@id='email']")
    private WebElement emailField;

    @FindBy(xpath = ".//input[@id='passwd']")
    private WebElement passwordField;

    @FindBy(xpath = ".//select[@id='days']")
    private WebElement dayOfBirthList;

    @FindBy(xpath = ".//select[@id='months']")
    private WebElement monthOfBirthList;

    @FindBy(xpath = ".//select[@id='years']")
    private WebElement yearOfBirthList;

    @FindBy(xpath = ".//input[@id='firstname']")
    private WebElement addressFirstName;

    @FindBy(xpath = ".//input[@id='lastname']")
    private WebElement addressLastName;

    @FindBy(xpath = ".//input[@id='address1']")
    private WebElement addressField;

    @FindBy(xpath = ".//input[@id='city']")
    private WebElement cityField;

    @FindBy(xpath = ".//select[@id='id_state']")
    private WebElement stateList;

    @FindBy(xpath = ".//select[@id='id_country']")
    private WebElement countryList;

    @FindBy(xpath = ".//input[@id='postcode']")
    private WebElement zipPostalCode;

    @FindBy(xpath = ".//input[@id='phone_mobile']")
    private WebElement mobilePhone;

    @FindBy(xpath = ".//input[@id='alias']")
    private WebElement aliasAddress;

    @FindBy(xpath = ".//button[@id='submitAccount']")
    private WebElement registerButton;

    @FindBy(xpath = ".//p[contains(text(), 'There are 8 errors')]")
    private WebElement requiredCredentialsMessage;

    @FindBy (xpath = ".//div[@class='required password form-group form-ok']")
    private WebElement validPasswordGreenShadow;

    @FindBy (xpath = ".//div[@class='required password form-group form-error']")
    private WebElement invalidPasswordRedShadow;

    /*********   Methods       *********/

    public boolean isAccountCreationFormDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(accountCreationForm)).isDisplayed();
    }

    public CreateAccountFormPage clickRegister(){
        registerButton.click();
        return this;
    }

    public CreateAccountFormPage clickMrsRadioButton(){
        mrsRadio.click();
        return this;
    }

    public CreateAccountFormPage clickMrRadioButton(){
        mrRadio.click();
        return this;
    }

    public boolean isSelectedMrRadioButton(){
        if(mrRadio.isSelected()){
            return true;
        }
        else {
            return false;
        }
    }

    public boolean isSelectedMrsRadioButton() {
        if(mrsRadio.isSelected()){
            return true;
        }
        else {
            return false;
        }
    }

    public CreateAccountFormPage setPassword(String password){
        passwordField.clear();
        passwordField.sendKeys(password);
        emailField.click();
        return this;
    }

    public CreateAccountFormPage setDayOfBirth(String day){
        Select dayOfBirth=new Select(dayOfBirthList);
        dayOfBirth.selectByValue(day);
        return this;
    }
    public CreateAccountFormPage setMonthOfBirth(String month){
        Select monthOfBirth=new Select(monthOfBirthList);
        monthOfBirth.selectByVisibleText(month);
        return this;
    }

    public List<String> getMonthsOfBirthList(){
        Select monthOfBirth=new Select(monthOfBirthList);
        List<String> monthOptions= new ArrayList<String>();

        for(WebElement month:monthOfBirth.getOptions()){
            monthOptions.add(month.getText());
        }
        return monthOptions;
    }

    public CreateAccountFormPage setYearOfBirth(String year){
        Select yearOfBirth=new Select(yearOfBirthList);
        yearOfBirth.selectByValue(year);
        return this;
    }

    public String getEmail(){
        return emailField.getAttribute("value");
    }

    public CreateAccountFormPage setCustomerFirstName(String firstName){
        customerFirstName.sendKeys(firstName);
        return this;
    }

    public CreateAccountFormPage setCustomerLastName(String lastName){
        customerLastName.sendKeys(lastName);
        return this;
    }

    public String getFirstNameAddress(){
        return addressFirstName.getAttribute("value");
    }

    public String getLastNameAddress(){
        return addressLastName.getAttribute("value");
    }

    public CreateAccountFormPage setAddress(String address){
        addressField.sendKeys(address);
        return this;
    }

    public CreateAccountFormPage setCity(String city){
        cityField.sendKeys(city);
        return this;
    }

    public CreateAccountFormPage setState(String state){
        Select stateAddressList= new Select(stateList);
        stateAddressList.selectByVisibleText(state);
        return this;
    }

    public CreateAccountFormPage setPostalCode(String postalCode){
        zipPostalCode.sendKeys(postalCode);
             return this;
    }

    public CreateAccountFormPage setMobilePhone(String phone){
        mobilePhone.sendKeys(phone);
        return this;
    }

    public String getAliasAddress(){
        return aliasAddress.getAttribute("value");
    }



    /*********   Errors       *********/
    public boolean isRequiredCredentialsMessageDisplayed(){
        return wait.until(ExpectedConditions.visibilityOf(requiredCredentialsMessage)).isDisplayed();
    }

    public boolean isPasswordValidGreenShadow(){
        return validPasswordGreenShadow.isDisplayed();
    }

    public boolean isPasswordInvalidRedShadow(){
        return invalidPasswordRedShadow.isDisplayed();
    }

}
