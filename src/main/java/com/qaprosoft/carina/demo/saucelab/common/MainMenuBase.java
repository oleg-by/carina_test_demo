package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class MainMenuBase extends AbstractPage {
    public MainMenuBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isViewMenuPresent(String item);

    public abstract HomePageBase clickCatalogItem(String catalog);

    public abstract DrawingPageBase clickDrawingItem(String item);

    public abstract LogInPageBase clickLogInItem(String item);

    public abstract HomePageBase closeMenu();
}
