package com.parabank.testcases;

import com.parabank.pages.CustomerLoginPage;
import com.parabank.pages.HomePage;
import com.parabank.pages.UpdateContactInfoPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UpdateContactInfoTestCase extends BaseTest{

    @Test
    public void contactInfoShouldSuccess(){
        CustomerLoginPage loginPage = page.getInstance(CustomerLoginPage.class);
        HomePage homePage = loginPage.loginWithCredentials(getUsername(),getPassword());
        Assert.assertTrue(homePage.hasLogOutLink());
        UpdateContactInfoPage updateContactInfoPage = homePage.clickUpdateContactInfoLink()
                .fillFirstName("Jahid")
                .fillLastName("Noman")
                .fillAddress("kamrpara")
                .fillCity("Dhaka")
                .fillState("Sass")
                .fillZipCode(120)
                .fillPhoneNumber(01225100000)
                .clickUpdateProfileBtn();
        Assert.assertTrue(updateContactInfoPage.hasProfileUpdated());

    }
}
