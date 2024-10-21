package com.automation.steps;

import com.automation.pages.BasePage;
import com.automation.pages.DashboardPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CommonSteps {
    BasePage basePage=new BasePage();
    @When("user click on admin on sidebar")
    public void userClickOnAdminOnSidebar() {
        basePage.goToAdminPage();
    }
    @When("user click on profile dropdown")
    public void userClickOnProfileDropdown() {
        basePage.clickOnProfileDropdown();
    }
    @Then("click on logout")
    public void clickOnLogout() {
        basePage.doLogout();
    }

    @When("user click on recruitment on sidebar")
    public void userClickOnRecruitmentOnSidebar() {
        basePage.goToRecruitmentPage();
    }

    @Then("verify user is logged in")
    public void verifyUserIsLoggedIn() {
        Assert.assertTrue(basePage.isLoggedIn());
    }
    @Then("verify success message is displayed")
    public void verifySuccessMessageIsDisplayed() {
        Assert.assertTrue(basePage.getToastMsg().contains("Successfully Saved"));
    }

}
