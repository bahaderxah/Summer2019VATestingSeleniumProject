package com.cybertek.tests.homeworkTestCase4;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SelectClassTest1 {
    @Test
    public void test1(){
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        WebElement element = driver.findElement(By.id("state"));

        Select statelist = new Select(element);
        List<WebElement> options = statelist.getOptions();
        System.out.println(options.size());
       for (WebElement option:options){
           System.out.println(option.getText());
       }
    }

    @Test
    public void selectAndVerifySelected()throws InterruptedException{
        WebDriver driver=WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");
        Select statelist= new Select(driver.findElement(By.id("state")));
        String actualSelection=statelist.getFirstSelectedOption().getText();
        System.out.println("actualSelection = " + actualSelection);
        statelist.selectByVisibleText("Virginia");

         actualSelection=statelist.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection,"Virginia");
        Thread.sleep(2000);
        statelist.selectByIndex(2);
        actualSelection = statelist.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection,"Alaska");
         Thread.sleep(1000);
        statelist.selectByValue("HI");
        actualSelection=statelist.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection,"Hawaii");
    }
}
