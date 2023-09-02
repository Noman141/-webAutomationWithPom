package com.parabank.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CustomerLoginPage extends BasePage{
    public CustomerLoginPage(WebDriver driver) {
        super(driver);
    }

    //create methods for login
    //UserName Method
    public CustomerLoginPage fillUsername( String username ){
        WebElement webElement = getWebElement(By.name("username"));
        webElement.clear();
        webElement.sendKeys(username);
        return this;
    }

    //Password Method
    public CustomerLoginPage fillPassword( String password ){
        WebElement webElement = getWebElement(By.name("password"));
        webElement.sendKeys(password);
        return this;
    }

    //Login Button Method
    public HomePage clickLoginButton(){
        WebElement webElement = getWebElement(By.cssSelector("input.button"));
        webElement.click();
        return getInstance(HomePage.class);
    }

    //Login failed method
    public CustomerLoginPage loginFailed(){
        WebElement webElement = getWebElement(By.cssSelector("input.button"));
        webElement.click();
        return this;
    }

    // Test Case Method for login

    //Login without ID, Password
    public CustomerLoginPage doLoginWithoutCredentials(){
        return loginFailed();
    }

    //Login using Username Method
    public  CustomerLoginPage doLoginWithUserName(String username){
        return fillUsername(username)
                .loginFailed();
    }

    //Login using Password method
    public  CustomerLoginPage doLoginWithPassword(String password){
        return fillPassword(password)
                .loginFailed();
    }

    //Login with Credentials

    public HomePage loginWithCredentials(String username, String password){
        return fillUsername(username)
                .fillPassword(password)
                .clickLoginButton();
    }

    //Error

    public boolean hasError(){
        return getWebElements(By.className("error")).size() > 0;
    }



}
