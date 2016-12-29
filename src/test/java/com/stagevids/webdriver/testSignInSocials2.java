package com.stagevids.webdriver;
/**
 * Created by ra on 21.11.16.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;

public class testSignInSocials2 {
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
    public void SignInWithTwitter2Fail() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("//i[@class=\"fa fa-twitter\"]")).click();
        Thread.sleep(1000);
        String parentHandle = driver.getWindowHandle();
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }

        driver.findElement(By.id("username_or_email")).sendKeys("marirepetilo1@gmail.com");
        driver.findElement(By.xpath(".//*[@id='password']")).sendKeys("kakvezde!");
        driver.findElement(By.xpath(".//*[@id='allow']")) .click();
        driver.switchTo().window(parentHandle);
    }

    @Test
    public void SignInWithFacebook2() throws InterruptedException {
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get("https://qa.stagevids.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//i[@class=\"fa fa-facebook\"]")).click();
        Thread.sleep(1000);
        String parentHandle = driver.getWindowHandle();
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }
        driver.findElement(By.id("email")).sendKeys("+380506685116");
        driver.findElement(By.id("pass")).sendKeys("kakvezde!");
        driver.findElement(By.id("u_0_2")).click();
        driver.switchTo().window(parentHandle);
    }


    @Test
    public void SignInWithGoogle2() throws InterruptedException {
//        driver.get("https://accounts.google.com/ServiceLogin?sacu=1&continue=https%3A%2F%2Fwww.google.com.ua%2F&hl=ru#identifier");
//        driver.findElement(By.id("Email")).sendKeys("marirepetilo1@gmail.com");
//        driver.findElement(By.id("next")).click();
//        Thread.sleep(1000);
//        driver.findElement(By.id("Passwd")).sendKeys("prestige81");
//        driver.findElement(By.id("signIn")).click();

        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        driver.findElement(By.xpath("\n" +
                "//i[@class=\"fa fa-google-plus\"]")).click();
        Thread.sleep(1000);

        // --- Switch window --- //
        String parentHandle = driver.getWindowHandle();
        for(String childHandle : driver.getWindowHandles()){
            if (!childHandle.equals(parentHandle)){
                driver.switchTo().window(childHandle);
            }
        }

        driver.findElement(By.id("Email")).sendKeys("marirepetilo1@gmail.com");
        driver.findElement(By.id("next")).click();
        Thread.sleep(1000);
        driver.findElement(By.id("Passwd")).sendKeys("prestige81");
        driver.findElement(By.id("signIn")).click();
        Thread.sleep(1000);

        // TODO: needs check - element is visible and clickable?
//        driver.findElement(By.id("submit_approve_access")).click();

        driver.switchTo().window(parentHandle);
        // --- end Switch --- //

        // TODO: you should input username here, if it's necessary

//        driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a/div/div[2]/img")).click();
//        driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a/div/div[1]")).click();
//        driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/ul/li[2]/a")).click();

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
