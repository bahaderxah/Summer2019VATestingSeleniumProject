package com.cybertek.tests.homeworkTestCase4;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class TestCase1 {
    WebDriver driver;
    Actions  actions;

    @BeforeMethod
    public void setupMethod(){
        driver= WebDriverFactory.getDriver("chrome");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://qa1.vytrack.com");
        actions= new Actions(driver);
    }

    @AfterMethod
    public void teardownMethod()  throws InterruptedException  {
        Thread.sleep(2000);

    }
    @Test
    public void test1()throws InterruptedException {
        driver.get("https://qa1.vytrack.com/user/login");
        driver.findElement(By.id("prependedInput")).sendKeys("storemanager85");
        driver.findElement(By.id("prependedInput2")).sendKeys("UserUser123");
        driver.findElement(By.id("_submit")).click();


        WebElement source = driver.findElement(By.xpath("(//span)[27]"));
        WebElement target = driver.findElement(By.xpath("//span[text()='Calendar Events']"));
        actions.moveToElement(target).perform();
        target.click();

        Thread.sleep(5000);
        WebElement element= driver.findElement(By.xpath("//table/tbody/tr[14]/td[9]"));
        actions.moveToElement(element).build().perform();
        Thread.sleep(3000);
        WebElement view= driver.findElement(By.xpath("//a[@title='View']"));
        actions.moveToElement(view).build().perform();
        Thread.sleep(3000);
//
//        Assert.assertTrue(view.isDisplayed(),"View");
//        System.out.println("View is available: "+view.isDisplayed());
//        WebElement edit= driver.findElement(By.xpath("//a[@title='Edit']"));
//        actions.moveToElement(edit).build().perform();
//        Thread.sleep(3000);
//        Assert.assertTrue(edit.isDisplayed(),"Edit");
//        System.out.println("Edit is available: "+edit.isDisplayed());
//        WebElement delete=driver.findElement(By.xpath(" //a[@title='Delete']"));
//        actions.moveToElement(delete).build().perform();
//        Thread.sleep(3000);
//        Assert.assertTrue(delete.isDisplayed(),"Delete");
//        System.out.println("Delete is available: "+delete.isDisplayed());
    }
}