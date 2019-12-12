package com.cybertek.tests.locators_myhomework;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Wikiassignment {
    WebDriver driver;

    @BeforeMethod
    public void setup() throws InterruptedException {
       driver= WebDriverFactory.getDriver("chrome");
       driver.get("https://www.wikipedia.org/");
       driver.manage().window().maximize();
       Thread.sleep(2000);
        driver.findElement(By.id("searchInput")).sendKeys("redsox");
       driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    }
    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(2000);
        driver.close();
    }
    @Test
    public void testwiki () {

         List<WebElement> search= driver.findElements(By.className("suggestion-link"));
        int searchOptions = search.size();
        System.out.println(search);

        String firstOption = search.get(0).getText();
        System.out.println(firstOption);
        if(searchOptions > 1){
            Assert.assertTrue(searchOptions > 1);
            Assert.assertTrue(firstOption.startsWith("Boston Red Sox"));
            System.out.println(firstOption.startsWith("Boston Red Sox"));
        }
        
    }
}
