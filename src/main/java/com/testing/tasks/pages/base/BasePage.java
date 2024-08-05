package com.testing.tasks.pages.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriver webDriver;


    public BasePage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(15));
        webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        PageFactory.initElements(webDriver, this);
    }

}
