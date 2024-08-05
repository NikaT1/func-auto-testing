package com.testing.tasks.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesManager {

    private Properties properties = new Properties();
    private static TestPropertiesManager INSTANCE;

    private TestPropertiesManager() {
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("propertiesFile", "application")
                    + ".properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static TestPropertiesManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new TestPropertiesManager();
        }
        return INSTANCE;
    }

    public String getProperty(String key, String defaultValue) {
        return properties.getProperty(key, defaultValue);
    }

    public String getProperty(String key) {
        return properties.getProperty(key);
    }
}
