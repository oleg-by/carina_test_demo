package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractHomePage extends AbstractPage {
    public AbstractHomePage(WebDriver driver) {
        super(driver);
    }

    public abstract AbstarctViewMenu viewMenu();

    public abstract boolean isLogoPresent();

    public abstract AbstractProductPage clickGoodImage(String title);

}
