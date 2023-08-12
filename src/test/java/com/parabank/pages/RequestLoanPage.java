package com.parabank.pages;

import com.parabank.util.General;
import com.parabank.util.ParaBankString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class RequestLoanPage extends BasePage{
    public RequestLoanPage(WebDriver driver) {
        super(driver);
    }

    //Loan Amount
    public RequestLoanPage fillLoanAmount(double loanamount){
        General.waitForDomStable();
        getWebElement(By.id("amount")).sendKeys(String.valueOf(loanamount));
        return this;
    }

    //Down Payment
    public RequestLoanPage fillDownPayment(double downpayment){
        getWebElement(By.id("downPayment")).sendKeys(String.valueOf(downpayment));
        return this;
    }

    //From account
    public RequestLoanPage selectFromAccount(int index){
        new Select(getWebElement(By.id("fromAccountId"))).selectByIndex(index);
        return this;
    }

    //Apply Now Button
    public  RequestLoanPage clickApplyNowBtn(){
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    //Loan Request Processed
    public boolean hasLoanReqProsessed(){
        General.waitForDomStable();
        return getWebElement(By.className("title")).getText().trim().contains(ParaBankString.LOAN_REQUEST_PROCESSED);
    }

}
