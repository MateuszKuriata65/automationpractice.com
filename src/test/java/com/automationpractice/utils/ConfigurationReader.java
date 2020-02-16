package com.automationpractice.utils;

public class ConfigurationReader extends ReadFile{

    private String configFileLocation;
    private String browserName;
    private String baseURL;
    private String hubURL;

    public ConfigurationReader(String configFileLocation) {
        super(configFileLocation);
        this.configFileLocation=configFileLocation;
    }


    @Override
    void loadData() {
        browserName=properties.getProperty("browserName");
        baseURL=properties.getProperty("baseURL");
        hubURL=properties.getProperty("hubURL");
    }

    public String getConfigFileLocation() {
        return configFileLocation;
    }

    public String getBrowserName() {
        return browserName;
    }

    public String getBaseURL() {
        return baseURL;
    }

    public String getHubURL() {
        return hubURL;
    }
}
