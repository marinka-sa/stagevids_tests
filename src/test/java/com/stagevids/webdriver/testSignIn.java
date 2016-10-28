package com.stagevids.webdriver;
/**
 * Created by Marina Repetilo on 27.10.16.
 */

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.junit.Assert.assertTrue;
import static org.testng.Assert.assertSame;

public class testSignIn {
    private WebDriver driver;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        // Create a new instance of the Firefox driver
        driver = new FirefoxDriver();
    }

    @Test
    public void signInPassTest()
    {
//        WebDriver driver = new FirefoxDriver();
//        driver.navigate().to("https://qa.stagevids.com/");

        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");

        driver.findElement(By.className("btn-login")).click();

        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

//        driver.findElement(By.id("login_email")).sendKeys("marirepetilo1@gmail.com");
        driver.findElement(By.id("login_email")).sendKeys("mari");

        driver.findElement(By.xpath(".//*[@id='formModal1']/input[3]")).click();
        driver.manage().timeouts().implicitlyWait(1000, TimeUnit.SECONDS);


//        String errorMessage = driver.findElement(By.xpath(".//*[@id='formModal1']/div[2]")).getText();
//        String errorMessage = driver.findElement(By.xpath(".//*[@id='formModal1']/div[1]")).getAttribute("innerHTML");

//        String errorMessage = driver.findElement(By.cssSelector("#formModal1 > div:nth-child(4)")).getText();
//        String errorMessage = driver.findElement(By.cssSelector("#formModal1 > div:nth-child(4)")).getAttribute("value");
        WebElement errorMessage = driver.findElement(By.xpath(".//*[@id='formModal1']/div[1]"));
//        String errorMessage = driver.findElement(By.className("dangerMessage")).getText();
        System.err.println("!!!!!!!");
        System.err.println(errorMessage);
        Assert.assertTrue(errorMessage.getAttribute("textContent") == "you are awesome, but login or password is incorrect");


//        Assert.assertTrue("Error message!",
//               driver.getTitle().startsWith("you are awesome, but login or password is incorrect "));
    }


    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
//        driver.close();
//        driver.quit();
    }

}
