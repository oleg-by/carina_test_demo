package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainMenuBase extends AbstractPage {
    public MainMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isViewMenuPresent(MenuItem item);

    public abstract HomePageBase clickCatalogItem(MenuItem item);

    public abstract DrawingPageBase clickDrawingItem(MenuItem item);

    public abstract LogInPageBase clickLogInItem(MenuItem item);

    public abstract HomePageBase closeMenu();
}
