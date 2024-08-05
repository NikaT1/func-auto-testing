package com.testing.tasks.pages.base;

import com.testing.tasks.managers.DriverManager;
import com.testing.tasks.managers.TestPropertiesManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {

    protected DriverManager driverManager = DriverManager.getInstance();
    private WebDriverWait webDriverWait;

    public BasePage() {
        PageFactory.initElements(driverManager.getDriver(), this);
        webDriverWait = new WebDriverWait(driverManager.getDriver(),
                Duration.ofSeconds(10),
                Duration.ofSeconds(1));
    }

    protected void scrollToElementJS(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driverManager.getDriver();
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true)", webElement);
    }

    protected WebElement waitUntilWebElementToBeClickable(WebElement webElement) {
        return webDriverWait.until(ExpectedConditions.elementToBeClickable(webElement));
    }


}
