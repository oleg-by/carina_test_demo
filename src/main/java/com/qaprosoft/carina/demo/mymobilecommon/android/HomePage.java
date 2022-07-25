package com.qaprosoft.carina.demo.mymobilecommon.android;

import com.qaprosoft.carina.core.foundation.utils.factory.DeviceType;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.foundation.webdriver.locator.ExtendedFindBy;
import com.qaprosoft.carina.demo.mymobilecommon.common.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

@DeviceType(pageType = DeviceType.Type.ANDROID_PHONE, parentClass = HomePageBase.class)
public class HomePage extends HomePageBase implements IMobileUtils {

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Phone\"]")
    private ExtendedWebElement phoneIcon;

    @ExtendedFindBy(accessibilityId = "Messages")
    private ExtendedWebElement messageIcon;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Chrome\"]")
    private ExtendedWebElement chromeIcon;

    @FindBy(xpath = "//android.widget.TextView[@content-desc=\"Camera\"]")
    private ExtendedWebElement cameraIcon;

    @FindBy(xpath = "//android.widget.FrameLayout[@content-desc=\"Search\"]")
    private ExtendedWebElement searchBar;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/g_icon")
    private ExtendedWebElement gSearchIcon;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/mic_icon")
    private ExtendedWebElement micIcon;

    @FindBy(id = "com.google.android.apps.nexuslauncher:id/lens_icon")
    private ExtendedWebElement gLensIcon;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    @Override
    public PhonePageBase clickPhoneIcon() {
        phoneIcon.click();
        return initPage(getDriver(), PhonePageBase.class);
    }

    @Override
    public MessagePageBase clickMessageIcon() {
        messageIcon.click();
        return initPage(getDriver(), MessagePageBase.class);
    }

    @Override
    public ChromePageBase clickChromeIcon() {
        chromeIcon.click();
        return initPage(getDriver(), ChromePageBase.class);
    }

    @Override
    public CameraPageBase clickCameraIcon() {
        cameraIcon.click();
        return initPage(getDriver(), CameraPageBase.class);
    }


}
