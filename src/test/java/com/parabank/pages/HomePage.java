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
}
