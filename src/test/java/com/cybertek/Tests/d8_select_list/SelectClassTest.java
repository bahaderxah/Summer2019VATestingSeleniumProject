package com.cybertek.Tests.d8_select_list;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;


import java.util.List;

import static java.lang.Thread.*;

public class SelectClassTest {

    @Test
    public void test() {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        // Locate the element with the select tag
        WebElement element = driver.findElement(By.id("state"));


        // Create Select object by passing the element from step 2 as constructor
        Select statelist = new Select(element);

        // returns all the available options from the dropdown list
        List<WebElement> options = statelist.getOptions();

        for (WebElement option : options) {
            System.out.println(option.getText());

        }

    }

    @Test
        public void selectAndVerifySelected() throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("http://practice.cybertekschool.com/dropdown");

        // create a select object.
        //1 locate the webelement with the select tag
        // create Select class object by passing that webelement as a constructor
        Select statelist = new Select(driver.findElement(By.id("state")));

        // verify that by default Select a State is selected
        // getFirstSelectedOption() --> returns what is currently selected, returns WEBELEMENT
        // getFirstSelectedOption().getText() --> returns the text of what is currently selected,

        String actualSelection = statelist.getFirstSelectedOption().getText();
        System.out.println("actualSelection = " + actualSelection);
        Assert.assertEquals(actualSelection,"Select a State");

        // Select
          Thread.sleep(1000);

        // SELECT USING VISIBLE TEXT
        // selectByVisibleText() --> selects using the visible text
        statelist.selectByVisibleText("Ohio");

          actualSelection = statelist.getFirstSelectedOption().getText();
          Assert.assertEquals(actualSelection,"Ohio");
          ​
        // SELECT USING INDEX
        // selectByIndex  --> selects using the index of the option, count starts from 0
           Thread.sleep(1000);
          statelist.selectByIndex(51);

          actualSelection= statelist.getFirstSelectedOption().getText();
          Assert.assertEquals(actualSelection,"Wyoming");

        // SELECT BY VALUE
        // selectByValue() --> selects by the value of the value attribute

         Thread.sleep(1000);
        statelist.deselectByValue("DC");
        actualSelection=statelist.getFirstSelectedOption().getText();
        Assert.assertEquals(actualSelection,"District of Columbia");


    }
}