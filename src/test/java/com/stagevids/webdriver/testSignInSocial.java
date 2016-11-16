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
    }

    @Test
    public void SignInWithGoogleFail() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://www.google.com.ua/");
        driver.findElement(By.id("gb_70")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Email")).sendKeys("marirepetilo1@gmail.com");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.name("Password")).sendKeys("prestige81");
        driver.findElement(By.xpath(".//*[@id='Passwd']")).sendKeys("prestige81");
        driver.findElement(By.id("signIn")).click();

        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/a[3]")).click();
        Thread.sleep(1000);
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


    }


    @Test
    public void SignInWithTwitter2Fail() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/a[3]")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='oauth_form']/fieldset[1]/div")).sendKeys("marirepetilo1@gmail.com");
//        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("kakvezde!");
//        driver.findElement(By.xpath(".//*[@id='allow']")) .click();

    }

    @Test
    public void SignInWithFacebook2() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/a[1]")).click();
        Thread.sleep(1000);
    }


    @Test
    public void SignInWithGoogle2() throws InterruptedException {
        driver.get("https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fwww.google.com.ua%2F&hl=ru#identifier");
        driver.findElement(By.id("Email")).sendKeys("marirepetilo1@gmail.com");
        driver.findElement(By.id("next")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Passwd")).sendKeys("prestige81");
        driver.findElement(By.id("signIn")).click();

        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/div/div/div[2]/a[2]")).click();
        Thread.sleep(1000);
//        driver.switchTo().window(driver.getWindowHandles()[1]);
//        driver.findElement(By.id("submit_approve_access"));

        //# id = "submit_approve_access"


//        driver.findElement(By.id("Email")).sendKeys("marirepetilo1@gmail.com");
//        driver.findElement(By.xpath(".//*[@id='Email']")) .sendKeys("marirepetilo1@gmail.com");

//        String mainWindowHandle = driver.getWindowHandle();
////        Set<String> oldWindowHandles = driver.getWindowHandles();
//        driver.waitForPopUp(selenium.getAllWindowNames()[1], Config.Wait);
//        selenium.selectWindow(selenium.getAllWindowNames()[1]);
//        driver.findElement(By.id("Email")).sendKeys("marirepetilo1@gmail.com");
//        driver.switchTo().window(mainWindowHandle);

//        driver.findElement(By.xpath(".//*[@id='account-chooser-link")).click();
//        driver.findElement(By.xpath(".//*[@id='account-chooser-add-account']")).click();
//        driver.findElement(By.id("next")).click();

//        driver.findElement(By.xpath(".//*[@id='Email']")) .sendKeys("marirepetilo1@gmail.com");
//        driver.findElement(By.xpath("  .//*[@id='next']")).click();
//        driver.findElement(By.xpath(".//*[@id='Passwd']")) .sendKeys("kakvezde!");


    }




    @AfterClass //-- Runs this method after all the test methods in the current class have been run
    public void tearDown() {
//        driver.close();
//        driver.quit();
    }

}

