package com.testing.tasks;

import com.testing.tasks.managers.PageManager;
import org.junit.jupiter.api.Test;

public class HomePageTest {

    @Test
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
