package com.stagevids.webdriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.sql.Timestamp;

/**
 * Created by ra on 23.11.16.
 */

public class Artists {
    private WebDriver driver;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void Follow() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/artists");
    }


    @Test
    public void ArtistClick() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/artists");
        WebElement artist = driver.findElement(
                By.xpath("html/body/div[1]/div/div/div[2]/div/div[2]/div[3]/div/div[2]/div[2]/div[9]/a[1]/h5"));
        String artistName = artist.getText();
        System.out.println(artistName);
        artist.click();
        Thread.sleep(1000);
        Assert.assertEquals(
                driver.findElement(By.xpath("html/body/div[1]/div/div/div[2]/div/div[1]/div[2]/div[2]/div[2]/h1")).getText().toLowerCase(),
                artistName.toLowerCase()
        );
    }
































    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
//         Close all browser windows and safely end the session
        driver.close();
        driver.quit();
    }





}
