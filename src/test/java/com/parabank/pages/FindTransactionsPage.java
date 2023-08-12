package com.parabank.pages;

import com.parabank.util.General;
import com.parabank.util.ParaBankString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class FindTransactionsPage extends BasePage{
    public FindTransactionsPage(WebDriver driver) {
        super(driver);
    }

    //Select Account ID
    public FindTransactionsPage selectAcId(int index){
        General.waitForDomStable();
        new Select(getWebElement(By.id("accountId"))).selectByIndex(index);
        return this;
    }

    //Find by Date
    public FindTransactionsPage fillFindDate(String findDate){
        General.waitForDomStable();
        getWebElement(By.id("criteria.onDate")).sendKeys(findDate);
        return this;
    }


    //Find transactions

    public  FindTransactionsPage clickFindTransactionBtn(){
        General.waitForDomStable();
        getWebElement(By.className("button")).click();
        return this;
    }

    //Transaction Results
    public boolean hasTransactionreport(){
        General.waitForDomStable();
        System.out.println(getWebElement(By.className("title")).getText().trim());
        return getWebElement(By.className("title")).getText().trim().contains(ParaBankString.TRANSACTION_RESULTS);
    }

}
