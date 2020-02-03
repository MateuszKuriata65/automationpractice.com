package com.automationpractice.test;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.net.MalformedURLException;

public class BaseTest {

    protected WebDriver driver;
    protected String baseURL="http://automationpractice.com/index.php";


    @BeforeClass
    //methods will be run before first test in class
    public void  setUpTest()  {
      /***  tests on local machine */
       //open browser
        WebDriverManager.chromedriver().setup();
        // create new WebDriver object
         driver= new ChromeDriver();
         // go to page
         driver.navigate().to(baseURL);
    }

    @AfterClass
    //methods will be run after last test in class
    public  void  closeDriver(){
        driver.quit();
    }


}
