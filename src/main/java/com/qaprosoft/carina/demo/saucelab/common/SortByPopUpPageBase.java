package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import com.qaprosoft.carina.demo.enums.SortBy;
import org.openqa.selenium.WebDriver;

public abstract class SortByPopUpPageBase extends AbstractPage {

    public SortByPopUpPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isTitlePresent();

    public abstract HomePageBase clickSortingMethodBtn(SortBy sort);
}
