package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstarctViewMenu extends AbstractPage {
    public AbstarctViewMenu(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isViewMenuPresent(String item);

    public abstract AbstractHomePage clickItem(String item);

    public abstract AbstractHomePage closeViewMenu();
}
