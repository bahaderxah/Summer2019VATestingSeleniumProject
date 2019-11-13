package com.cybertek.Tests.d2_webdriver_basics;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.WebDriver;

public class CallTheFactory {
    public static void main(String[] args) {
        WebDriver driver = WebDriverFactory.getDriver("chrome");
    }
}
