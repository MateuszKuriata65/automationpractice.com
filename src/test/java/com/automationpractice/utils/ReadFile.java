package com.automationpractice.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public abstract class  ReadFile {
    Properties properties;

    protected ReadFile(String fileLocation){
        loadFile(fileLocation);
        loadData();
    }

    public void loadFile (String fileLocation) {
         properties = new Properties();
        try {
            properties.load(new FileInputStream(fileLocation));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Something went wrong. Can't find the file. Check location:" + fileLocation);
        }
    }

    abstract void loadData();
}
