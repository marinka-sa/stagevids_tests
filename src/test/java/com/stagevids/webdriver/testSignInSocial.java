package com.stagevids.webdriver;

/**
 * Created by Marina on 02.11.16.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.sql.Timestamp;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;


public class testSignInSocial {
    private WebDriver driver;

    public void GetCurrentTimeStamp( String[] args )
    {
        java.util.Date date= new java.util.Date();
        System.out.println(new Timestamp(date.getTime()));
    }

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        driver = new FirefoxDriver();
    }


    @Test
    public void SignInWithTwitter() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://twitter.com/");
        driver.findElement(By.id("signin-email")).sendKeys("MarinaRepetilo");
        driver.findElement(By.id("signin-password")).sendKeys("kakvezde!");
        driver.findElement(By.xpath(".//*[@id='front-container']/div[2]/div[2]/form/table/tbody/tr/td[2]/button")).click();

        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/a[3]")).click();
        Thread.sleep(1000);
    }
    









    @AfterClass //-- Runs this method after all the test methods in the current class have been run
    public void tearDown() {
//        -- Close all browser windows and safely end the session
        driver.close();
        driver.quit();
    }

}

