package com.automationpractice.utils;

import java.util.Properties;

public class LoginData {

    private String validLoginSyntax;
    private String invalidLoginSyntaxWithoutEta;
    private String invalidLoginSyntaxWithEta;
    private String password;
    private String mailToLogin;


    public LoginData(Properties properties) {
        validLoginSyntax=properties.getProperty("login.validLoginSyntax");
        invalidLoginSyntaxWithoutEta=properties.getProperty("login.invalidMailSyntaxWithoutEta");
        invalidLoginSyntaxWithEta=properties.getProperty("login.invalidMailSyntaxWithEta");
        password=properties.getProperty("login.password");
        mailToLogin=properties.getProperty("login.mailToLogin");
    }

    public String getValidLoginSyntax() {
        return validLoginSyntax;
    }

    public String getInvalidLoginSyntaxWithoutEta() {
        return invalidLoginSyntaxWithoutEta;
    }

    public String getInvalidLoginSyntaxWithEta() {
        return invalidLoginSyntaxWithEta;
    }

    public String getPassword() {
        return password;
    }

    public String getMailToLogin() {
        return mailToLogin;
    }
}
