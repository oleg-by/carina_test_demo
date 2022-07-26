package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ViewMenuBase extends AbstractPage {
    public ViewMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isViewMenuPresent(String item);

    public abstract AbstractPage clickMenuItem(String item);

    public abstract HomePageBase closeMenu();

    public abstract HomePageBase clickCatalogItem(String catalog);
}
