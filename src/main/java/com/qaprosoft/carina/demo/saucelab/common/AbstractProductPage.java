package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class AbstractProductPage extends AbstractPage {

    public AbstractProductPage(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitleOpened(String title);

    public abstract AbstractViewMenu viewMenu();

    public abstract void backHome();


}
