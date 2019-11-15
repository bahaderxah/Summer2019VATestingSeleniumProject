package com.cybertek.Tests.csspractice;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Css {
    public static void main(String[] args) {


        WebDriver driver = WebDriverFactory.getDriver("chrome");
       driver.get("http://practice.cybertekschool.com/radio_buttons");


        WebElement red =driver.findElement(By.cssSelector("#red"));
        red.click();
        WebElement green= driver.findElement(By.cssSelector("html>body>div>div>#content > div > div:nth-child(9) > label"));
        System.out.println(green.getText());
    }
}