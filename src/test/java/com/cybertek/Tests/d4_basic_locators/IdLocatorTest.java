package com.cybertek.Tests.d4_basic_locators;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class IdLocatorTest {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();

        driver.get("http://practice.cybertekschool.com/multiple_buttons");

        WebElement element= driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/button[1]"));

        String txt = element.getText();
        System.out.println("txt = " + txt);

        element.click();
        Thread.sleep(3000);
        driver.quit();
    }
}
