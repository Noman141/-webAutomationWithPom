package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class OpenNewAccountPage extends BasePage{
    public OpenNewAccountPage(WebDriver driver) {
        super(driver);
    }

    // Select Account Type method
    public OpenNewAccountPage openNewAccountType(int index){
        new Select(getWebElement(By.id("type"))).selectByIndex(index);
        return this;
    }

    //Select Ammount Transfer

    public OpenNewAccountPage transferAmount(int index){
        new Select(getWebElement(By.id("fromAccountId"))).selectByIndex(index);
        return this;
    }

    //Click open new account button
    public  OpenNewAccountPage clickOpenNewAccountButton(){
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    // Check New Account ID

    public boolean hasNewAccountIdCreate(){
        return getWebElements(By.id("newAccountId")).size() >0;
    }



}
