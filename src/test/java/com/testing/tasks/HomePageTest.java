package com.testing.tasks;

import com.testing.tasks.base.BaseTests;
import com.testing.tasks.managers.PageManager;
import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.CRITICAL;

public class HomePageTest extends BaseTests {

    @Test
    @DisplayName("Тест оформления страховки туриста")
    @Description("Проверка корректной ошибки при попытке оформления страховки для путешественников")
    @Severity(CRITICAL)
    @Owner("Nika")
    @Link(name = "Website", url = "https://www.rgs.ru/")
    @Issue("TRAVEL-123")
    @TmsLink("TMS-123")
    void firstTest() {
        PageManager.getInstance().getHomePage()
                .selectSliderMenuElement("Путешествия")
                .goToTravelPageFromSliderMenu()
                .checkOpenPage("Страховка для туристов");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
}
