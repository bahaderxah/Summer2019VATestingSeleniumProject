package com.cybertek.Tests.VyTrack;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class login {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa2.vytrack.com/user/login");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println(driver.getTitle());
        Thread.sleep(1000);
        driver.findElement(By.id("prependedInput")).sendKeys("user7");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.xpath("//*[@class='btn btn-uppercase btn-primary pull-right']")).click();

        String url = driver.getCurrentUrl();
        if (url.equals("https://qa2.vytrack.com/")) {
            System.out.println("PASS");

        } else {
            System.out.println("FAIL");
        }


        driver.quit();


    }
}
