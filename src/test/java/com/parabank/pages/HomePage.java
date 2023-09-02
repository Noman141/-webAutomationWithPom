package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //Check Logout
    public boolean hasLogOutLink(){
        return getWebElements(By.linkText("Log Out")).size() >0 ;
    }

    //Open New Account

    public OpenNewAccountPage clickNewOpenAccountLink(){
        getWebElement(By.linkText("Open New Account")).click();
        return getInstance(OpenNewAccountPage.class);
    }

    //Fund Transfer
    public FundTransferPage clickFundTransferLink(){
        getWebElement(By.linkText("Transfer Funds")).click();
        return getInstance(FundTransferPage.class);
    }

    //Update Contact Info
    public UpdateContactInfoPage clickUpdateContactInfoLink(){
        getWebElement(By.linkText("Update Contact Info")).click();
        return getInstance(UpdateContactInfoPage.class);
    }

    //Request Loan
    public RequestLoanPage clickRequestLoanLink(){
        getWebElement(By.linkText("Request Loan")).click();
        return getInstance(RequestLoanPage.class);
    }
    //Account Overview
    public AccountOverviewPage clickAccountPageLink(){
        getWebElement(By.linkText("Accounts Overview")).click();
        return getInstance(AccountOverviewPage.class);
    }

    //Bill Pay
    public BillPayPage clickBillPayLink(){
        getWebElement(By.linkText("Bill Pay")).click();
        return getInstance(BillPayPage.class);
    }
    //Find Transactions
    public FindTransactionsPage clickFindTransaction(){
        getWebElement(By.linkText("Find Transactions")).click();
        return getInstance(FindTransactionsPage.class);
    }
}
