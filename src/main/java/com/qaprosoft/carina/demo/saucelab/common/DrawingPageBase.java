package com.qaprosoft.carina.demo.saucelab.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;


public abstract class DrawingPageBase extends AbstractPage {

    public DrawingPageBase(WebDriver driver) {
        super(driver);
    }

    public abstract boolean isDrawingPanelPresent();

}
