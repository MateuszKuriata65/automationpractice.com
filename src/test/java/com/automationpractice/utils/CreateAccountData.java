package com.automationpractice.utils;

import java.util.Properties;

public class CreateAccountData {
    private String invalidMailSyntax;
    private String usedEmail;
    private String newMail;
    private String passwordLessFiveSigns;
    private String password5orMoreSigns;
    private String months;
    private String firstName;
    private String lastName;
    private String password;
    private String dayOfBirth;
    private String monthOfBirth;
    private String yearOfBirth;
    private String address;
    private String city;
    private String state;
    private String postalCode;
    private String mobilePhone;

    public CreateAccountData(Properties properties) {
        invalidMailSyntax=properties.getProperty("create.invalidMailSyntax");
        usedEmail=properties.getProperty("create.usedEmail");
        newMail=properties.getProperty("create.newMail");
        passwordLessFiveSigns=properties.getProperty("create.passwordLessFiveSigns");
        password5orMoreSigns=properties.getProperty("create.password5orMoreSigns");
        months=properties.getProperty("create.months");
        firstName=properties.getProperty("create.firstName");
        lastName=properties.getProperty("create.lastName");
        password=properties.getProperty("create.password");
        dayOfBirth=properties.getProperty("create.dayOfBirth");
        monthOfBirth=properties.getProperty("create.monthOfBirth");
        yearOfBirth=properties.getProperty("create.yearOfBirth");
        address=properties.getProperty("create.address");
        city=properties.getProperty("create.city");
        state=properties.getProperty("create.state");
       postalCode=properties.getProperty("create.postalCode");
       mobilePhone=properties.getProperty("create.mobilePhone");
    }

    public String getInvalidMailSyntax() {
        return invalidMailSyntax;
    }

    public String getUsedEmail() {
        return usedEmail;
    }

    public String getNewMail() {
        return newMail;
    }

    public String getPasswordLessFiveSigns() {
        return passwordLessFiveSigns;
    }

    public String getPassword5orMoreSigns() {
        return password5orMoreSigns;
    }

    public String getMonths() {
        return months;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPassword() {
        return password;
    }

    public String getDayOfBirth() {
        return dayOfBirth;
    }

    public String getMonthOfBirth() {
        return monthOfBirth;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public String getMobilePhone() {
        return mobilePhone;
    }
}
