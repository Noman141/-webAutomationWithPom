package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountOverviewPage extends BasePage{
    public AccountOverviewPage(WebDriver driver) {
        super(driver);
    }

    //Account ID
    public AccountOverviewPage clickAccountId(){
        getWebElement(By.linkText("13566")).click();
        return this;
    }


}
