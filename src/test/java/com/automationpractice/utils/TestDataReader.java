package com.automationpractice.utils;

import com.automationpractice.pages.CreateAccountFormPage;
import org.apache.commons.logging.Log;

public class TestDataReader extends ReadFile{
    private String testDataFileLocation;
    private LoginData loginData;
    private CreateAccountData createAccountData;

    public TestDataReader(String testDataFileLocation) {
        super(testDataFileLocation);
        this.testDataFileLocation=testDataFileLocation;
    }

    @Override
    void loadData() {
    loginData=new LoginData(properties);
    createAccountData=new CreateAccountData(properties);
    }

    public String getTestDataFileLocation() {
        return testDataFileLocation;
    }

    public LoginData getLoginData() {
        return loginData;
    }

    public CreateAccountData getCreateAccountData() {
        return createAccountData;
    }
}
