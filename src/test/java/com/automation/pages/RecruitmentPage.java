package com.automation.pages;

import com.automation.utils.ConfigReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class RecruitmentPage extends BasePage{
    @FindBy(xpath = "//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")
    WebElement title;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary']")
    WebElement addBtn;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-firstname']")
    WebElement firstNameInput;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active orangehrm-lastname']")
    WebElement lastNameInput;

    @FindBy(xpath = "//input[@class='oxd-input oxd-input--active' and @placeholder='Type here']")
    WebElement emailInput;

    @FindBy(xpath = "//input[@class='oxd-file-input']")
    WebElement browse;

    @FindBy(xpath = "//button[@class='oxd-button oxd-button--medium oxd-button--secondary orangehrm-left-space']")
    WebElement saveBtn;

    @FindBy(xpath = "//h6[text()='Application Stage']")
    WebElement candidateProfileHeading;

    @FindBy(xpath = "//input[@placeholder='Type for hints...']")
    WebElement candidateNameSearchInput;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement searchBtn;

    @FindBy(xpath = "//div[@class='oxd-autocomplete-option']/span")
    WebElement suggestions;

    @FindBy(xpath = "//div[@class='oxd-table-cell oxd-padding-cell']/div")
    List<WebElement> singleCandidateRow;

    public boolean isRecruitmentPageDisplayed(){
        return title.getText().equals("Recruitment");
    }

    public  void clickOnAddBtn(){addBtn.click();}

    public  void clickOnSave(){saveBtn.click();}

    public void enterCandidateDetails(){
        firstNameInput.sendKeys(ConfigReader.getProperties("candidate.firstname"));
        lastNameInput.sendKeys(ConfigReader.getProperties("candidate.lastname"));
        emailInput.sendKeys(ConfigReader.getProperties("candidate.email"));
        browse.sendKeys("D:\\Chrome Downloads\\_OOPS ASSIGNMENT 2.pdf");
    }


    public void waitForCandidateProfile(){wait.until(ExpectedConditions.visibilityOf(candidateProfileHeading));}

    public void candidateSearchDetails(){
        candidateNameSearchInput.sendKeys(ConfigReader.getProperties("candidate.firstname"));
        suggestions.click();
    }

    public void searchCandidates(){
        searchBtn.click();
    }

    public boolean getFilteredCandidateName(){
        String name=singleCandidateRow.get(2).getText();
        return  name.equals(ConfigReader.getProperties("candidate.name"));
    }
}
