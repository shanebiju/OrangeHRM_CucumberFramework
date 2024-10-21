package com.automation.pages;

import com.automation.utils.ConfigReader;
import com.automation.utils.DriverManager;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait wait;
    public BasePage(){
        driver= DriverManager.getDriver();
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Admin']")
    WebElement adminMenuItem;

    @FindBy(xpath = "//span[@class='oxd-text oxd-text--span oxd-main-menu-item--name' and text()='Recruitment']")
    WebElement recruitmentMenuItem;

    @FindBy(xpath="//span[@class='oxd-userdropdown-tab']")
    WebElement profileDropdown;

    @FindBy(xpath = "//a[@class='oxd-userdropdown-link' and text()='Logout']")
    WebElement logoutBtn;

    public void clickOnProfileDropdown(){profileDropdown.click();}
    public void goToAdminPage(){adminMenuItem.click();}
    public  void goToRecruitmentPage(){recruitmentMenuItem.click();}
    public void doLogout(){logoutBtn.click();}
    public boolean isLoggedIn(){
        try{
            return profileDropdown.isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    public String getToastMsg(){
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='oxd-toaster_1']/div")));
        WebElement toast=driver.findElement(By.xpath("//div[@id='oxd-toaster_1']/div"));
        return  toast.getText();
    }

}
