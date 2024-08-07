package com.testing.tasks.pages;

import com.testing.tasks.managers.PageManager;
import com.testing.tasks.pages.base.BasePage;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Optional;

public class HomePage extends BasePage {

    @FindBy(xpath = "//div[@class='slider-navigation']//li")
    private List<WebElement> sliderMenu;

    @FindBy(xpath = "//div[@class='slide-container is-selected']//a")
    private WebElement selectedSliderMenuButton;

    public HomePage selectSliderMenuElement(String menuElement) {
        Optional<WebElement> currentElement = sliderMenu.stream()
                .filter(e -> e.getText()
                        .contains(menuElement))
                .findFirst();
        if (currentElement.isPresent()) {
            currentElement.get().click();
            Assertions.assertTrue(currentElement.get().getAttribute("class").contains("current"), "Меню " + menuElement + " найдено, но невозможно выбрать");
        } else {
            Assertions.fail("Меню " + menuElement + " не найдено на стартовой странице");
        }
        return this;
    }

    public TravelPage goToTravelPageFromSliderMenu() {
        String newURL = clickButtonSelectedSliderMenuElement();
        Assertions.assertTrue(newURL.contains("travel"));
        driverManager.getDriver().navigate().to(newURL);
        return PageManager.getInstance().getTravelPage();
    }

    private String clickButtonSelectedSliderMenuElement() {
        selectedSliderMenuButton.click();
        return selectedSliderMenuButton.getAttribute("href");
    }


}

