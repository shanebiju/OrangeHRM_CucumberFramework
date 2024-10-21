package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.RandomGenerator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class AdminPage extends BasePage {
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement title;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addBtn;

    @FindBy(xpath = "//h6[text()='Add User']")
    WebElement addUserTag;

    @FindBy(xpath = "//i[@class='oxd-icon bi-caret-down-fill oxd-select-text--arrow']")
    WebElement userRoleDropdown;

    @FindBy(xpath = "//div[@class='oxd-select-option']/span[text()='ESS']")
    WebElement essSpan;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement employeeNameInput;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']/span")
    WebElement employeeNameDropdown;

    @FindBy(xpath = "//div[@class='oxd-select-text oxd-select-text--active']")
    List<WebElement> roleAndStatusDropdown;

    @FindBy(xpath = "//div[@class='oxd-select-option']/span[text()='Enabled']")
    WebElement enabledDropdown;

    @FindBy(xpath = "//label[@class='oxd-label oxd-input-field-required' and text()='Username']/../following-sibling::div/input")
    WebElement userName;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and @type='password']")
    List<WebElement> passwordInputs;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement saveBtn;

    @FindBy(xpath = "//h5[text()='System Users']")
    WebElement systemUserTag;

    @FindBy(xpath = "//label[@class='oxd-label' and text()='Username']/../following-sibling::div/input")
    WebElement systemUserSearch;

    @FindBy(xpath = "//button[@class='oxd-icon-button oxd-table-cell-action-space']")
    WebElement deleteUserBtn;

    @FindBy(xpath = "//button[text()=' Yes, Delete ']")
    WebElement confirmDelete;

    public boolean isAdminPageDisplayed(){
        return title.getText().equals("Admin");
    }

    public void deleteUser(){
        deleteUserBtn.click();
        confirmDelete.click();
    }
    public boolean isOnSystemUserPage(){
        try{
            return systemUserTag.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public void clickSaveBtn(){saveBtn.click();}

    public void clickOnAddBtn(){addBtn.click();}
    public boolean isAddUserPageDisplayed(){
        try{
            return addUserTag.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void enterUserDetail(){
        userRoleDropdown.click();
        essSpan.click();
        employeeNameInput.sendKeys(ConfigReader.getProperties("employee.name"));
        employeeNameDropdown.click();
        roleAndStatusDropdown.get(1).click();
        enabledDropdown.click();
        ConfigReader.setProperty("newuser.name", RandomGenerator.generateRandomUsername(6));
        ConfigReader.setProperty("newuser.password",RandomGenerator.generateRandomPassword(10));
        userName.sendKeys(ConfigReader.getProperties("newuser.name"));
        for(WebElement passwordInput:passwordInputs){
            passwordInput.sendKeys(ConfigReader.getProperties("newuser.password"));
        }
    }
    public void searchSystemUser(){
        systemUserSearch.sendKeys(ConfigReader.getProperties("newuser.name"));
        userRoleDropdown.click();
        essSpan.click();
        employeeNameInput.sendKeys(ConfigReader.getProperties("employee.name"));
        employeeNameDropdown.click();
        roleAndStatusDropdown.get(1).click();
        enabledDropdown.click();
    }


}
