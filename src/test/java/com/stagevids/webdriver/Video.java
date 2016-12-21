package com.stagevids.webdriver;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

/**
 * Created by ra on 08.12.16.
 */
public class Video {
    private WebDriver driver;

    @BeforeClass // Runs this method before the first test method in the current class is invoked
    public void setUp() {
        driver = new FirefoxDriver();
    }

    @Test
    public void video_360() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");
        Thread.sleep(1000);
        driver.findElement(By.xpath(".//*[@id='navtabs']/div/div/div[1]/a[3]")).click();




    }












    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
//         Close all browser windows and safely end the session
        driver.close();
        driver.quit();
    }
}

