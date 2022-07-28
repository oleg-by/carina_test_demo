package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract MainMenuBase clickMenuBtn();

    public abstract SortByPopUpPageBase clickSortBtn();

    public abstract String getFirstSortedProduct();

    public abstract boolean isLogoPresent();

    public abstract ProductPageBase clickGood(String title);

}
