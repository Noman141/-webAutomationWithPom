package com.parabank.testcases;

import com.parabank.pages.BillPayPage;
import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class BillPayTestCase extends BaseTest{
    @Test
    public void billPayShouldSuccess(){
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        HomePage homePage = loginPage.loginWithCredentials(getUsername(),getPassword());
        Assert.assertTrue(homePage.hasLogOutLink());

        BillPayPage billPayPage = homePage.clickBillPayLink()
                .fillPayeeName("Jahid")
                .fillAddress("Dhaka")
                .fillCity("Dhaka")
                .fillState("djbsj")
                .fillZipCode(1231)
                .fillPhoneNumber(123655855)
                .fillAccountNo(1232)
                .fillVerifyAccount(1232)
                .fillAmount(120)
                .selectFromAc(1)
                .clickSendPaymentBtn();
        Assert.assertTrue(billPayPage.hasPaymenCpmplete());
    }
}
