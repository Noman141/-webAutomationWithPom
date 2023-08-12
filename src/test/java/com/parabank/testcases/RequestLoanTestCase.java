package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.HomePage;
import com.parabank.pages.RequestLoanPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RequestLoanTestCase extends BaseTest{
    @Test
    public void requestLoanShouldSuccess(){
       CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        HomePage homePage = loginPage.loginWithCredentials(getUsername(),getUsername());
        Assert.assertTrue(homePage.hasLogOutLink());

        RequestLoanPage requestLoanPage = homePage.clickRequestLoanLink()
                .fillLoanAmount(200)
                .fillDownPayment(100)
                .selectFromAccount(0)
                .clickApplyNowBtn();
        Assert.assertTrue(requestLoanPage.hasLoanReqProsessed());
    }
}
