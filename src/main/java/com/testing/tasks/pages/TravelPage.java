package com.testing.tasks.pages;

import com.testing.tasks.pages.base.BasePage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TravelPage extends BasePage {

    @FindBy(xpath = "//h1")
    private WebElement pageTitle;

    public void checkOpenPage(String title) {
        Assertions.assertTrue(pageTitle.getText().contains(title), "Заголовок страницы не " +
                "соответствует заданному");
    }
}
