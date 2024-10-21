package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--main orangehrm-login-button']")
    WebElement loginBtn;

    @FindBy(xpath = "//input[@name='username']")
    WebElement usernameInput;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and @type='password']")
    WebElement passwordInput;

    public boolean isLoginPageDisplayed(){
        try{
            return loginBtn.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public  void openWebsite(){
        driver.get(ConfigReader.getProperties("application.url"));
    }

    public void doLogin(String username,String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        loginBtn.click();
    }
}
