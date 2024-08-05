package com.testing.tasks.base;

import com.testing.tasks.managers.DriverManager;
import com.testing.tasks.managers.TestPropertiesManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    @BeforeEach
    void before() {
        DriverManager.getInstance()
                .getDriver()
                .get(TestPropertiesManager.getInstance().getProperty("base.url"));
    }

    @AfterEach
    void after() {
        DriverManager.getInstance().quiteDriver();
    }
}
