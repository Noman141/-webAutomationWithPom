package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.FindTransactionsPage;
import com.parabank.pages.HomePage;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class FindTransactionsTestCase extends BaseTest{
    @Test
    public void findTransactionShouldSuccess(){
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        HomePage homePage = loginPage.loginWithCredentials(getUsername(),getPassword());
        Assert.assertTrue(homePage.hasLogOutLink());

        FindTransactionsPage findTransactionsPage = homePage.clickFindTransaction()
                .selectAcId(1)
                .fillFindDate("08-12-2023")
                .clickFindTransactionBtn();

        Assert.assertTrue(findTransactionsPage.hasTransactionreport());


    }
}
