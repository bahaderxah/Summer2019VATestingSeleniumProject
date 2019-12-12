package com.cybertek.tests.locators_myhomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Testcase2 {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);



    }
    @AfterMethod
    public void teardown(){
        driver.close();
    }

    @Test
    public void clickbutton(){
        driver.get("https://www.amazon.com");
        WebElement amazon  = driver.findElement(By.xpath("//input[@type='text']"));
        amazon.sendKeys("javabook");

        driver.get("https://www.ebay.com");
        WebElement ebay  = driver.findElement(By.id("gh-ac"));
        ebay.sendKeys("computer");

        WebElement amazonsearch =driver.findElement(By.xpath("//input[@type='submit']"));
        amazonsearch.click();
        WebElement ebaysearch = driver.findElement(By.xpath("//input[@type='submit']"));
        ebaysearch.click();

        String expected="computer | eBay";
        String  actual=driver.getTitle();

        Assert.assertTrue(actual.contains(expected));
        System.out.println("actual is "+actual);
        System.out.println("expected is "+expected);
     }
}