package com.cybertek.Tests.d5_xpath;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class XpathTestDemoClass {
    public static void main(String[] args) {
        WebDriver driver= WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        driver.get("http://practice.cybertekschool.com/multiple_buttons");

    WebElement link = driver.findElement(By.xpath("//button[@class=\"btn btn-primary\"][1]"));

        System.out.println(link.getText());
    }

}
