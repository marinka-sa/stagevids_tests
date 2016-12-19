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

    private void logOut() {
//        driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a/div/div[1]")).click();
//        driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/ul/li[2]/a")).click();
        WebElement logout = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a"));
//        navigationclick.click();
        if(logout.isEnabled() && logout.isDisplayed()) {
            logout.click();
            driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/ul/li[2]/a")).click();
        }
        else {
            System.out.println("Element 'dropdown' not found");
        }
    }

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        driver = new FirefoxDriver();
        String google_email = "marirepetilo1@gmail.com";
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

        logOut();
    }

    @Test
    public void SignInWithGoogle1() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ua/");
        driver.findElement(By.id("gb_70")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("Email")).sendKeys("marirepetilo1@gmail.com");
        driver.findElement(By.id("next")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Passwd")).sendKeys("prestige81");
        driver.findElement(By.id("signIn")).click();

        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/a[2]")).click();
        Thread.sleep(1000);
        logOut();
    }



    @Test
    public void SignInWithFacebook() throws InterruptedException  {
        driver.manage().window().maximize();
        driver.get("https://www.facebook.com/");
        driver.findElement(By.id("email")).sendKeys("+380506685116");
        driver.findElement(By.id("pass")).sendKeys("kakvezde!");
        driver.findElement(By.id("u_0_l")).click();
        Thread.sleep(1000);
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/a[1]")).click();
        Thread.sleep(1000);
//        driver.findElement(By.xpath(".//*[@id='u_0_4']/div[2]/div[1]/div[1]/button")).click();

//        System.out.println(driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a/div/div[1]")).getText());
//        driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/ul/li[2]/a")).click();
        logOut();
    }


    @AfterClass //-- Runs this method after all the test methods in the current class have been run
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }

}

