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

public class Testcase3 {

   WebDriver driver;
    @BeforeMethod
    public void setup(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.get("https://www.wikipedia.org/");
    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        driver.close();
    }

   @Test
   public void clickbutton() throws InterruptedException {
        WebElement wikipedia = driver.findElement(By.id("searchInput"));
        wikipedia.sendKeys("'selenuim webdriver'");
        WebElement search = driver.findElement(By.xpath("//i[@class='sprite svg-search-icon']"));
        Thread.sleep(2000);
        search.click();
        String actual=driver.getCurrentUrl();
       System.out.println(actual);
       String expexcted ="selenuim+webdriver%27&go=Go&ns0=1";

       Assert.assertTrue(actual.endsWith(expexcted));
       System.out.println( "actual is:"+actual);
       System.out.println("expected is: "+expexcted);

    }
}
