package com.automation.steps;

import com.automation.pages.AdminPage;
import com.automation.pages.BasePage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class AdminSteps{
    AdminPage adminPage=new AdminPage();
    @Then("verify user is on admin page")
    public void verifyUserIsOnAdminPage() {
        Assert.assertTrue(adminPage.isAdminPageDisplayed());
    }

    @When("user click on add button on admin page")
    public void userClickOnAddButtonOnAdminPage() {
        adminPage.clickOnAddBtn();
    }

    @Then("verify user is on add user page")
    public void verifyUserIsOnAddUserPage() {
        Assert.assertTrue(adminPage.isAddUserPageDisplayed());
    }

    @Then("enter new user details")
    public void enterNewUserDetails(){
        adminPage.enterUserDetail();
    }

    @When("user click save button on admin page")
    public void userClickSaveButtonOnAdminPage() {
        adminPage.clickSaveBtn();
    }

    @Then("verify user is on System Users page")
    public void verifyUserIsOnSystemUsersPage() {
        Assert.assertTrue(adminPage.isOnSystemUserPage());
    }

    @Then("user clicks on Search button on admin page")
    public void userClicksOnSearchButtonOnAdminPage(){
        adminPage.clickSaveBtn();
    }

    @Then("enter new user search details")
    public void enterNewUserSearchDetails() {
        adminPage.searchSystemUser();
    }

    @Then("delete the obtained user after search")
    public void deleteTheObtainedUserAfterSearch() {
        adminPage.deleteUser();
        //Assert.fail("test case failed");
    }
}
