package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.HomePage;
import com.parabank.pages.OpenNewAccountPage;
import com.parabank.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class OpenNewAccountTestCase  extends BaseTest{

    @Test
    public void openAccountShouldSuccess(){
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        Assert.assertEquals(loginPage.getPageTitle(), ParaBankString.LOGIN_TITLE);
        HomePage homePage = loginPage.loginWithCredentials(getUsername(), getPassword());
        Assert.assertTrue(homePage.hasLogOutLink());
        OpenNewAccountPage openNewAccountPage = homePage.clickNewOpenAccountLink()
                .openNewAccountType(1)
                .clickOpenNewAccountButton();

        Assert.assertTrue(openNewAccountPage.hasNewAccountIdCreate());

    }

}
