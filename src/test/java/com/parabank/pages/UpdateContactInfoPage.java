package com.parabank.pages;

import com.parabank.util.General;
import com.parabank.util.ParaBankString;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class UpdateContactInfoPage extends BasePage{
    public UpdateContactInfoPage(WebDriver driver) {
        super(driver);
    }

    //Fill First Name
    public UpdateContactInfoPage fillFirstName(String fName){
        General.waitForDomStable();
        getWebElement(By.id("customer.firstName")).sendKeys(fName);
        return this;
    }
    //Fill Last Name
    public  UpdateContactInfoPage fillLastName(String lName){
        getWebElement(By.id("customer.lastName")).sendKeys(lName);
        return this;
    }
    // Fill Address
    public UpdateContactInfoPage fillAddress(String address){
        getWebElement(By.id("customer.address.street")).sendKeys(address);
        return this;
    }
    // Fill City
    public UpdateContactInfoPage fillCity(String city){
        getWebElement(By.id("customer.address.city")).sendKeys(city);
        return this;
    }
    // Fill State
    public UpdateContactInfoPage fillState(String state){
        getWebElement(By.id("customer.address.state")).sendKeys(state);
        return this;
    }
    // Fill Zip Code
    public UpdateContactInfoPage fillZipCode(int zipcode){
        getWebElement(By.id("customer.address.zipCode")).sendKeys(String.valueOf(zipcode));
        return this;
    }
    //Fill Phone Number
    public UpdateContactInfoPage fillPhoneNumber(double phoneNumber){
        getWebElement(By.id("customer.phoneNumber")).sendKeys(String.valueOf(phoneNumber));
        return this;
    }

    //Update Profile Button
    public UpdateContactInfoPage clickUpdateProfileBtn(){
        getWebElement(By.cssSelector("input.button")).click();
        return this;
    }

    //profile Updated
    public boolean hasProfileUpdated(){
        General.waitForDomStable();
        return getWebElement(By.className("title")).getText().trim().contains(ParaBankString.PROFILE_UPDATE_SUCCESS);
    }

}
