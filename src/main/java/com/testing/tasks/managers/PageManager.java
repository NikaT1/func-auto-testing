package com.testing.tasks.managers;

import com.testing.tasks.pages.HomePage;
import com.testing.tasks.pages.TravelPage;
import lombok.Getter;

@Getter
public class PageManager {

    private final HomePage homePage = new HomePage();
    private final TravelPage travelPage = new TravelPage();

    private static PageManager INSTANCE;

    private PageManager() {
    }

    public static PageManager getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new PageManager();
        }
        return INSTANCE;
    }

}
