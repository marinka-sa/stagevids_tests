package com.stagevids.webdriver;
/**
 * Created by Marina Repetilo on 27.10.16.
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


public class testSignIn {
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
    public void notValidPasswordEmptyField() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");

        driver.findElement(By.className("btn-login")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("login_email")).sendKeys("marirepetilo1@gmail.com");

        driver.findElement(By.xpath(".//*[@id='formModal1']/input[3]")).click();

        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector("div[ng-show='errorMessageSignIn'"));
        System.err.println("--- text ---");
        System.err.println(errorMessage.getText());
        System.err.println("------------");
        Assert.assertEquals(errorMessage.getText(), "you are awesome, but login or password is incorrect");
    }

    @Test
    public void notValidEmailField() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");

        driver.findElement(By.className("btn-login")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("login_email")).sendKeys("ma");
        driver.findElement(By.id("passsignin")).sendKeys("mari89");

        driver.findElement(By.xpath(".//*[@id='formModal1']/input[3]")).click();

        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector("div[ng-show='showValidMessageUserName'"));
        System.err.println("--- text ---");
        System.err.println(errorMessage.getText());
        System.err.println("------------");
        Assert.assertEquals(errorMessage.getText(), "invalid sign in email");
    }


    @Test
    public void emailEmptyField() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");

        driver.findElement(By.className("btn-login")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("login_email")).sendKeys("");
        driver.findElement(By.id("passsignin")).sendKeys("mari89");

        driver.findElement(By.xpath(".//*[@id='formModal1']/input[3]")).click();

        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector("div[ng-show='showValidMessageUserName'"));
        System.err.println("--- text ---");
        System.err.println(errorMessage.getText());
        System.err.println("------------");
        Assert.assertEquals(errorMessage.getText(), "invalid sign in email");
    }

    @Test
    public void notValidEmailField1() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");

        driver.findElement(By.className("btn-login")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("login_email")).sendKeys("marirepetilo1@gmailcom");
        driver.findElement(By.id("passsignin")).sendKeys("mari89");

        driver.findElement(By.xpath(".//*[@id='formModal1']/input[3]")).click();

        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector("div[ng-show='showValidMessageUserName'"));
        System.err.println("--- text ---");
        System.err.println(errorMessage.getText());
        System.err.println("------------");
        Assert.assertEquals(errorMessage.getText(), "invalid sign in email");
    }

    @Test
    public void notValidEmailField2() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");

        driver.findElement(By.className("btn-login")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("login_email")).sendKeys("marirepetilo1gmail.com");
        driver.findElement(By.id("passsignin")).sendKeys("mari89");

        driver.findElement(By.xpath(".//*[@id='formModal1']/input[3]")).click();

        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector("div[ng-show='showValidMessageUserName'"));
        System.err.println("--- text ---");
        System.err.println(errorMessage.getText());
        System.err.println("------------");
        Assert.assertEquals(errorMessage.getText(), "invalid sign in email");
    }

    @Test
    public void ValidLogIn() throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");

        driver.findElement(By.className("btn-login")).click();

        Thread.sleep(1000);
        driver.findElement(By.id("login_email")).sendKeys("marirepetilo1@gmail.com");
        driver.findElement(By.id("passsignin")).sendKeys("testov21");

        driver.findElement(By.xpath(".//*[@id='formModal1']/input[3]")).click();
        Thread.sleep(1000);
        WebElement errorMessage = driver.findElement(By.cssSelector("div[ng-show='showValidMessageUserName'"));
        System.err.println("--- text ---");
        System.err.println(errorMessage.getText());
        System.err.println("------------");
        Assert.assertEquals(errorMessage.getText(), "");
        Thread.sleep(1000);
        try {
            driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a/div/div[1]")).click();
            driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/ul/li[2]/a")).click();
        }
        catch (Exception e) {
            System.err.println("Not Logged In!");
        }
    }

    @Test
    public void SignUp () throws InterruptedException {
        driver.manage().window().maximize();
        driver.get("https://qa.stagevids.com/");

        driver.findElement(By.className("btn-login")).click();

        Thread.sleep(1000);

        driver.findElement(By.xpath(".//*[@id='login_modal']/div/div/div[3]/div[2]/a")).click();
        Thread.sleep(1000);

        String currentTimeStamp = String.valueOf(new Timestamp(System.currentTimeMillis()).getTime());

        driver.findElement(By.id("username")).sendKeys("u" + currentTimeStamp);
        driver.findElement(By.id("password")).sendKeys("123456");
        driver.findElement(By.id("confirm")).sendKeys("123456");
        driver.findElement(By.id("email")).sendKeys("u" + currentTimeStamp + "@mail.com");
        driver.findElement(By.id("city")).sendKeys("Stambul");

        WebElement cbNew = driver.findElement(By.id("checkbox_new"));
        if (!cbNew.isSelected()) {
            driver.findElement(By.cssSelector("label[for='checkbox_new'")).click();
        }
        Assert.assertTrue(cbNew.isSelected());

        WebElement btnSubmit = driver.findElement(By.cssSelector("input[ng-click='register_submit()'"));
        if (btnSubmit.isEnabled()) {
            btnSubmit.click();
        }

        // TODO: LoggedIn status must be checked
//        WebElement userName = driver.findElement(By.xpath(".//*[@id='navbar']/ul/li[5]/a/div/div[1]"));
//        WebElement userName = driver.findElement(By.className("ng-binding"));
//        Assert.assertNotNull(userName.getText());
//        Assert.assertEquals(userName.getText(), "u" + currentTimeStamp);
    }

    @AfterClass // Runs this method after all the test methods in the current class have been run
    public void tearDown() {
        // Close all browser windows and safely end the session
        driver.close();
        driver.quit();
    }

}
