package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.FundTransferPage;
import com.parabank.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FundTransferTestCase extends BaseTest {

    @Test
    public void fundTransferShouldSuccess(){
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        HomePage homePage = loginPage.loginWithCredentials(getUsername(), getPassword());
        Assert.assertTrue(homePage.hasLogOutLink());

        FundTransferPage fundTransferPage = homePage.clickFundTransferLink()
                .fillAmountField(1000)
                .selectFromAccount(1)
                .selectToAccount(1)
                .clickTransferButton();

        Assert.assertTrue(fundTransferPage.hasFundTransferSuccess());
    }
}
