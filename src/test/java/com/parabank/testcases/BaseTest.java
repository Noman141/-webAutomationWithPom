package com.parabank.testcases;

import com.parabank.pages.BasePage;
import com.parabank.pages.Page;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;

public class BaseTest {
    WebDriver driver;
    Page page;
    private Properties properties; // declare & create object Properties

    //Create constructor for find properties path
    public BaseTest(){

        try {
            String fillPath = System.getProperty("user.dir")+"/src/test/resources/config.properties"; //find the path
            properties = new Properties();
            FileInputStream inputStream = new FileInputStream(fillPath); //Read properties
            properties.load(inputStream);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
   @BeforeMethod
    public void setUpBrowser(){

       //Multiple Browser setup
       String browserName = properties.getProperty("browserName");
       if(Objects.equals(browserName,"chrome")){
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
       } else if (Objects.equals(browserName,"firefox")) {
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();
       } else if (Objects.equals(browserName, "chromeHeadLess")) {
           WebDriverManager.chromedriver().setup();
           ChromeOptions options = new ChromeOptions();
           options.addArguments("--headless");
           driver = new ChromeDriver(options);
       } else if (Objects.equals(browserName, "firefoxHeadLess")) {
           WebDriverManager.firefoxdriver().setup();
           FirefoxOptions options = new FirefoxOptions();
           options.addArguments("--headless");
           driver = new FirefoxDriver(options);
       } else {
           System.out.println("Please provide your browser name");
       }


        driver.get("https://parabank.parasoft.com/parabank/index.htm");
        driver.manage().window().maximize();

        page = new BasePage(driver);
    }

    // Get dynamic user ID & Password
    public String getUsername(){
        return properties.getProperty("username");
    }

    public String getPassword(){
        return properties.getProperty("password");
    }


    //Server quit
    @AfterMethod
    public void dearDown(){
        driver.quit();
    }
}
