package com.cybertek.Tests.d3_webelement_class;


import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import static java.lang.Thread.sleep;

// open browser
//go to http://practice.cybertekschool.com/forgot_password
//enter any email
//click on Retrieve password
//verify that url changed to http://practice.cybertekschool.com/email_sent
//
public class VerifyURLChanged {

    public static void main(String[] args) throws InterruptedException {
        // open browser
        WebDriver driver = WebDriverFactory.getDriver("chrome");
        //go to http://practice.cybertekschool.com/forgot_password
        driver.get(" http://practice.cybertekschool.com/forgot_password");
        //enter any email
        WebElement emailInput = driver.findElement(By.name("email"));

        // sendkeys --> enters given text
        emailInput.sendKeys("adiralkunkka@email.com");

        //click on Retrieve password

        WebElement retrievePassword = driver.findElement(By.id("form_submit"));
        retrievePassword.click();

        //verify that url changed to http://practice.cybertekschool.com/email_sent
        String expected = "http://practice.cybertekschool.com/email_sent";
          String actual = driver.getCurrentUrl();
        Thread.sleep(3000);
          if (expected.equals(actual)){
              System.out.println("PASS");
          } else {
              System.out.println("FAIL");
          }
        java.lang.Thread.sleep(3000);
        // close the browser
        driver.quit();

    }
}
