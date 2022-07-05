package com.qaprosoft.carina.demo.web.pages;

import com.qaprosoft.carina.core.foundation.webdriver.decorator.ExtendedWebElement;
import com.qaprosoft.carina.core.gui.AbstractPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends AbstractPage {

    @FindBy(xpath = "//*[@class = 'auth-form__preview']")
    private ExtendedWebElement title;

    @FindBy(xpath = "//*[@class = 'auth-button auth-button_subsidiary auth-button_huge auth-form__button auth-form__button_fb']")
    private ExtendedWebElement fbBtn;

    @FindBy(xpath = "//*[@class = 'auth-button auth-button_extra auth-button_huge auth-form__button auth-form__button_vk']")
    private ExtendedWebElement vkBtn;

    @FindBy(xpath = "//*[@class = 'auth-button auth-button_accessorial auth-button_huge auth-form__button auth-form__button_gg']")
    private ExtendedWebElement ggBtn;

    @FindBy(xpath = "//input[@placeholder='Ник или e-mail']")
    private ExtendedWebElement usernameInput;

    @FindBy(xpath = "//input[@placeholder='Пароль']")
    private ExtendedWebElement passwordInput;

    @FindBy(xpath = "//div[@class='auth-form__control auth-form__control_condensed-additional']")
    private ExtendedWebElement enterBtn;

    @FindBy(xpath = "//a[@href='/registration']")
    private ExtendedWebElement registration;

    @FindBy(xpath = "//a[@href='/recover-password']")
    private ExtendedWebElement recoverPassword;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public boolean isTitleOpened() {
        return title.isElementPresent();
    }

    public FacebookLoginPage clickFbBtn() {
        fbBtn.click();
        return new FacebookLoginPage(getDriver());
    }

    public VkontakteLoginPage clickVkBtn() {
        vkBtn.click();
        return new VkontakteLoginPage(getDriver());
    }

    public GoogleLoginPage clickGgBtn() {
        ggBtn.click();
        return new GoogleLoginPage(getDriver());
    }

    public void typeUsername(String username){
        usernameInput.type(username);
    }

    public void typePassword(String password){
        passwordInput.type(password);
    }

    public CaptchaPage clickEnterBtn(){
        enterBtn.click();
        return new CaptchaPage(getDriver());
    }

}
