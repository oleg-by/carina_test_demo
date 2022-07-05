package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.utils.Configuration;
import com.qaprosoft.carina.core.foundation.utils.R;
import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

    @FindBy(xpath = "//*[@class='auth-bar__item auth-bar__item--text']")
    private ExtendedWebElement loginBtn;

    @FindBy(xpath = "//input[@class='fast-search__input']")
    private ExtendedWebElement searchInputField;

    public HomePage(WebDriver driver) {
        super(driver);
        setPageAbsoluteURL(R.CONFIG.get(Configuration.Parameter.URL.getKey()));
    }

    public LoginPage clickloginBtn() {
        loginBtn.click();
        return new LoginPage(getDriver());
    }

    public SearchSuggestPage typeSearchRq(String rq) {
        searchInputField.type(rq);
        return new SearchSuggestPage(getDriver());
    }

}
