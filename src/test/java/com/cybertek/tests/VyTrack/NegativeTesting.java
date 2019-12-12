package com.cybertek.tests.VyTrack;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NegativeTesting {
    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        driver.get("https://qa2.vytrack.com/user/login");
        Thread.sleep(2000);
        WebElement username = driver.findElement(By.id("prependedInput"));
        username.sendKeys("gulmire");
        Thread.sleep(2000);
        WebElement password = driver.findElement(By.name("_password"));
        password.sendKeys("123456");
        WebElement login = driver.findElement(By.tagName("button"));
        Thread.sleep(2000);
        login.click();
        Thread.sleep(2000);
        WebElement warming = driver.findElement(By.xpath("//*[@id=\"login-form\"]/fieldset/div[1]/div"));
        System.out.println( warming.isDisplayed());
        Thread.sleep(2000);
        driver.close();

    }
}
