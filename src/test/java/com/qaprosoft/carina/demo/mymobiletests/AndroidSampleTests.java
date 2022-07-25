package com.qaprosoft.carina.demo.mymobiletests;

import com.qaprosoft.carina.core.foundation.IAbstractTest;
import com.qaprosoft.carina.core.foundation.utils.mobile.IMobileUtils;
import com.qaprosoft.carina.core.foundation.utils.ownership.MethodOwner;
import com.qaprosoft.carina.demo.mymobilecommon.android.HomePage;
import com.qaprosoft.carina.demo.mymobilecommon.common.CameraPageBase;
import com.qaprosoft.carina.demo.mymobilecommon.common.ChromePageBase;
import com.qaprosoft.carina.demo.mymobilecommon.common.MessagePageBase;
import com.qaprosoft.carina.demo.mymobilecommon.common.PhonePageBase;
import com.zebrunner.agent.core.annotation.TestLabel;
import io.appium.java_client.android.AndroidDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class AndroidSampleTests implements IAbstractTest, IMobileUtils {

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testPhonePage(){
        ((AndroidDriver) (castDriver())).runAppInBackground(Duration.ofSeconds(-1));
        HomePage homePage = new HomePage(getDriver());
        PhonePageBase phonePage = homePage.clickPhoneIcon();
        Assert.assertTrue(phonePage.isSearchBarPresent(), "Phone App isn't opened!");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testMessagePage(){
        ((AndroidDriver) (castDriver())).runAppInBackground(Duration.ofSeconds(-1));
        HomePage homePage = new HomePage(getDriver());
        MessagePageBase messagePage = homePage.clickMessageIcon();
        Assert.assertTrue(messagePage.isSearchBarPresent(), "Message App isn't opened!");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testCameraPage(){
        ((AndroidDriver) (castDriver())).runAppInBackground(Duration.ofSeconds(-1));
        HomePage homePage = new HomePage(getDriver());
        CameraPageBase cameraPage = homePage.clickCameraIcon();
        Assert.assertTrue(cameraPage.isImagePresent(), "Camera isn't opened!");
    }

    @Test()
    @MethodOwner(owner = "oleg-by")
    @TestLabel(name = "feature", value = {"mobile", "regression"})
    public void testChromePage(){
        ((AndroidDriver) (castDriver())).runAppInBackground(Duration.ofSeconds(-1));
        HomePage homePage = new HomePage(getDriver());
        ChromePageBase chromePage = homePage.clickChromeIcon();
        Assert.assertTrue(chromePage.isAcceptBtnPresent(), "Chrome isn't opened!");
    }
}
