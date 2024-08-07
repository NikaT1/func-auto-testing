package com.testing.tasks.base;

import com.testing.tasks.managers.DriverManager;
import com.testing.tasks.managers.InitManager;
import com.testing.tasks.managers.TestPropertiesManager;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

import static com.testing.tasks.utils.PropertiesConstants.BASE_URL;

public class BaseTests {

    protected final TestPropertiesManager properties = TestPropertiesManager.getInstance();
    protected final DriverManager driverManager = DriverManager.getInstance();


    @BeforeAll
    void beforeAll() {
        InitManager.initFramework();
    }

    @BeforeEach
    void beforeEach() {
        driverManager.getDriver().get(properties.getProperty(BASE_URL));
    }

    @AfterAll
    void afterAll() {
        InitManager.quitFramework();
    }
}
