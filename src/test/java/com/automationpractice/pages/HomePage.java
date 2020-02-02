package com.automationpractice.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }
    /*** WebElements       ***/
        @FindBy(css =".login")
         WebElement signInButton;

    /*********  Methods     *************/
        public void  clickSignInButton(){
            signInButton.click();
        }
    }

