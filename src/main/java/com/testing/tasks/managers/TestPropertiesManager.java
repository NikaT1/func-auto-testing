package com.testing.tasks.managers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class TestPropertiesManager {

    private final Properties properties = new Properties();
    private static TestPropertiesManager INSTANCE;

    private TestPropertiesManager() {
        loadApplicationProperties();
        loadCustomProperties();
    }

    private void loadApplicationProperties() {
        try {
            properties.load(new FileInputStream("src/main/resources/" +
                    System.getProperty("propertiesFile", "application")
                    + ".properties"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void loadCustomProperties() {
        properties.forEach((key, value) -> System.getProperties()
                .forEach((custom_key, custom_value) -> {
                    if (custom_key.toString().equals(key.toString())) {
                        properties.setProperty(key.toString(), custom_value.toString());
                    }
                })
        );
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
