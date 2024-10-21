package com.automation.steps;

import com.automation.pages.RecruitmentPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class RecruitmentSteps {
    RecruitmentPage recruitmentPage=new RecruitmentPage();
    @Then("verify user is on recruitment page")
    public void verifyUserIsOnRecruitmentPage() throws InterruptedException {
        Assert.assertTrue(recruitmentPage.isRecruitmentPageDisplayed());
    }

    @Then("click on add button on recruitment page")
    public void clickOnAddButtonOnRecruitmentPage() {
        recruitmentPage.clickOnAddBtn();
    }

    @Then("enter candidate creation details")
    public void enterCandidateCreationDetails() {
        recruitmentPage.enterCandidateDetails();
    }

    @Then("user click save button on recruitment page")
    public void userClickSaveButtonOnRecruitmentPage() {
        recruitmentPage.clickOnSave();
    }


    @Then("wait for candidate profile to load")
    public void waitForCandidateProfileToLoad() {
        recruitmentPage.waitForCandidateProfile();
    }

    @Then("enter candidate search details")
    public void enterCandidateSearchDetails(){
        recruitmentPage.candidateSearchDetails();
    }

    @When("user clicks search button")
    public void userClicksSearchButton() {
        recruitmentPage.searchCandidates();

    }

    @Then("verify candidate is retrieved")
    public void verifyCandidateIsRetrieved() {
        Assert.assertTrue(recruitmentPage.getFilteredCandidateName());
    }

}
