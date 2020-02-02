package com.automationpractice.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage{

    public MyAccountPage(WebDriver driver){
        super(driver);
    }

    /*** WebElements       ***/
    @FindBy (xpath = ".//a[@class='account']")
    private WebElement customerName;

    /*********  Methods     *************/

    public String getCustomerAccountName(){
        return customerName.getText();
    }


}
