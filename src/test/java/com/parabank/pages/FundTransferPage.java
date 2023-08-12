package com.parabank.pages;

import com.parabank.util.General;
import com.parabank.util.ParaBankString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FundTransferPage extends BasePage{
    public FundTransferPage(WebDriver driver) {
        super(driver);
    }

    // Fill Transfer Amount field
    public FundTransferPage fillAmountField( double amount ){
        General.waitForDomStable();
        getWebElement(By.id("amount")).sendKeys(String.valueOf(amount)); //String value conversion to int
        return this;

    }

    //Select From Account
    public  FundTransferPage selectFromAccount(int index){
        new Select(getWebElement(By.id("fromAccountId"))).selectByIndex(index);
        return this;
    }

    //Select To Account
    public FundTransferPage selectToAccount(int index){
        new Select(getWebElement(By.id("toAccountId"))).selectByIndex(index);
        return this;
    }

    // Click transfer button

    public  FundTransferPage clickTransferButton(){
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    // transfer success
    public boolean hasFundTransferSuccess(){
        return getWebElement(By.className("title")).getText().trim().contains(ParaBankString.TRANSFER_SUCCESS);
    }

}
