package com.cybertek.tests.d1_basic_navigation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class OpenBrowserDemo {



        public static void main(String[] args) throws InterruptedException {

            WebDriverManager.chromedriver().setup();
            WebDriver driver = new ChromeDriver();
            // open a website
            driver.get("https://cybertekschool.com/");
            // this is not from selenium, it is from java
            // it pauses the program
            Thread.sleep(1000);
            driver.navigate().to("https://amazon.com/");
        }
    }

