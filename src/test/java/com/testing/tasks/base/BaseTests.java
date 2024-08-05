package com.testing.tasks.base;

import com.testing.tasks.managers.DriverManager;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class BaseTests {

    @BeforeEach
    void before() {
        DriverManager.getInstance().getDriver().get("https://www.rgs.ru/");
    }

    @AfterEach
    void after() {
        DriverManager.getInstance().quiteDriver();
    }
}
