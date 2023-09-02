package com.parabank.pages;

import com.parabank.util.General;
import com.parabank.util.ParaBankString;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class BillPayPage extends BasePage{
    public BillPayPage(WebDriver driver) {
        super(driver);
    }

    //Payee Name
    public BillPayPage fillPayeeName(String payeeName){
        General.waitForDomStable();
        getWebElement(By.name("payee.name")).sendKeys(payeeName);
        return this;
    }
    //Address
    public BillPayPage fillAddress(String address){
        General.waitForDomStable();
        getWebElement(By.name("payee.address.street")).sendKeys(address);
        return this;
    }
    //City
    public BillPayPage fillCity(String city){
        General.waitForDomStable();
        getWebElement(By.name("payee.address.city")).sendKeys(city);
        return this;
    }

    //State
    public BillPayPage fillState(String state){
        General.waitForDomStable();
        getWebElement(By.name("payee.address.state")).sendKeys(state);
        return this;
    }
    //Zip Code
    public BillPayPage fillZipCode(double zipcode){
        General.waitForDomStable();
        getWebElement(By.name("payee.address.zipCode")).sendKeys(String.valueOf(zipcode));
        return this;
    }
    //Phone #
    public BillPayPage fillPhoneNumber(double phoneNo){
        General.waitForDomStable();
        getWebElement(By.name("payee.phoneNumber")).sendKeys(String.valueOf(phoneNo));
        return  this;
    }

    //Account
    public BillPayPage fillAccountNo(double accountNo){
        General.waitForDomStable();
        getWebElement(By.name("payee.accountNumber")).sendKeys(String.valueOf(accountNo));
        return this;
    }

    //Verify Account
    public BillPayPage fillVerifyAccount(double verifyAccount){
        General.waitForDomStable();
        getWebElement(By.name("verifyAccount")).sendKeys(String.valueOf(verifyAccount));
        return this;
    }
    //Amount
    public BillPayPage fillAmount(double amount){
        General.waitForDomStable();
        getWebElement(By.name("amount")).sendKeys(String.valueOf(amount));
        return this;
    }
    //Send payment
    public BillPayPage clickSendPaymentBtn(){
        General.waitForDomStable();
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    //From account
    public BillPayPage selectFromAc(int index){
        General.waitForDomStable();
        new Select(getWebElement(By.name("fromAccountId"))).selectByIndex(index);
        return this;
    }

    //Bill Payment Complete
    public boolean hasPaymenCpmplete(){
        General.waitForDomStable();
        return getWebElement(By.className("title")).getText().trim().contains(ParaBankString.BILL_PAYMENT_COMPLETE);
    }
}
