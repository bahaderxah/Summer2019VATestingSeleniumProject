package com.cybertek.tests.locators_myhomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Testcase1 {
    WebDriver driver;
    @BeforeMethod
    public void setup() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.ebay.com");

    }

       @AfterMethod
       public void teardown() {
        driver.close();
        }

        @Test
    public void clickbutton(){
        WebElement ebay = driver.findElement(By.id("gh-ac"));
        ebay.sendKeys("bmw");
        WebElement search = driver.findElement(By.id("gh-btn"));
        search.click();
        WebElement printnumber=driver.findElement(By.xpath("//h1[@class='srp-controls__count-heading']"));
        System.out.println(printnumber.getText());

        }


    }


