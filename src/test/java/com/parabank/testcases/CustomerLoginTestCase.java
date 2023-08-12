package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.HomePage;
import com.parabank.util.ParaBankString;
import org.testng.Assert;
import org.testng.annotations.Test;

public class CustomerLoginTestCase extends BaseTest{

    @Test
    public void verifyURLTitle(){
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        Assert.assertEquals(loginPage.getPageTitle(), ParaBankString.LOGIN_TITLE);
    }

    @Test
    public void loginShouldFailedWithoutCredentials(){
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class)
                .doLoginWithoutCredentials();
        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void loginShouldFailedWithoutPassword(){
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class)
                        .doLoginWithUserName(getUsername());
        Assert.assertTrue(loginPage.hasError());
    }

    @Test
    public void SuccessfulLogin(){
         HomePage homePage = page.getInstance(CustomerLoginPage.class)
                .loginWithCredentials(getUsername() ,getPassword());
         Assert.assertTrue(homePage.hasLogOutLink());
    }
}
