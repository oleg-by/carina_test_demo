package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractViewMenu extends AbstractPage {
    public AbstractViewMenu(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isViewMenuPresent(String item);

    public abstract AbstractPage clickItem(String item);

    public abstract AbstractHomePage closeViewMenu();

    public abstract AbstractHomePage clickCatalogItem(String catalog);
}
