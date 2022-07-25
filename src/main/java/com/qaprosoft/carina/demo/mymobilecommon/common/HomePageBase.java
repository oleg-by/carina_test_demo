package com.qaprosoft.carina.demo.mymobilecommon.common;

import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;

public abstract class HomePageBase extends AbstractPage {
    public HomePageBase(WebDriver driver) {
        super(driver);
    }

    public abstract PhonePageBase clickPhoneIcon();

    public abstract MessagePageBase clickMessageIcon();

    public abstract ChromePageBase clickChromeIcon();

    public abstract CameraPageBase clickCameraIcon();

}
