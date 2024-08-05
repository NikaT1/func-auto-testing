package com.testing.tasks;

import com.testing.tasks.pages.HomePage;
import org.junit.jupiter.api.Test;

public class HomePageTest {

    @Test
    void firstTest() {
        new HomePage().openHomePage()
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
