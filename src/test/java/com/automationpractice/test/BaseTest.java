package com.automationpractice.test;


import com.automationpractice.utils.ConfigurationReader;
import com.automationpractice.utils.TestDataReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class BaseTest {
    //class with methods which can use in every test class
    protected WebDriver driver;
    protected ConfigurationReader configurationReader;
    protected TestDataReader testDataReader;

    private String configurationFileLocation="src/test/java/Configuration.properties";
    private String testDataLocation="src/test/java/TestData.properties";


    @BeforeClass
    //methods will be run before first test in class
    public void  setUpTest()  {
        configurationReader=new ConfigurationReader(configurationFileLocation);
        testDataReader=new TestDataReader(testDataLocation);
      /***  tests on local machine */
       //open browser
        WebDriverManager.chromedriver().setup();
        // create new WebDriver object
         driver= new ChromeDriver();
         // go to page
         driver.navigate().to(configurationReader.getBaseURL());
    }

    @AfterClass
    //methods will be run after last test in class
    public  void  closeDriver(){
        driver.quit();
    }


}
