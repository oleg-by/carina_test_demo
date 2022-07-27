package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class ProductPageBase extends AbstractPage {

    public ProductPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitleOpened(String title);

    public abstract boolean scrollPageDown();

    public abstract MainMenuBase clickMenuBtn();

    public abstract void backHome();


}
