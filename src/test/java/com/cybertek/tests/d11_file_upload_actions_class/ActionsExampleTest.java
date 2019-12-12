package com.cybertek.tests.d11_file_upload_actions_class;

import com.cybertek.utilities.WebDriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class ActionsExampleTest {

    WebDriver driver;

    @BeforeMethod
    public void setupMethod() {
        driver = WebDriverFactory.getDriver("chrome");
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(365000, TimeUnit.DAYS );
    }
    @AfterMethod
    public void teardownMethod() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
    /* go to page http://practice.cybertekschool.com/hovers
        hover over the first image  // Not click
        verify text view profile is displayed
    * */
    @Test
    public void hoverTest() throws InterruptedException {
        driver.get("http://practice.cybertekschool.com/hovers");
        WebElement img1 =driver.findElement(By.tagName("img"));
        // Actions --> class that contains all the user interactions
        Actions actions =new Actions(driver);
        Thread.sleep(2000);
        // moveToElement() --> moves the mouse on top of the given element
        // perform() --> complete the action, using everytime
        actions.moveToElement(img1).perform();
        Assert.assertTrue(driver.findElement(By.linkText("View profile")).isDisplayed());
    }
    @Test
    public void dragdroptest() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        // source00> we will drag this element
        WebElement source=driver.findElement(By.id("draggable"));
        // target --> we drop here
        WebElement target=driver.findElement(By.id("droptarget"));
        Actions actions =new Actions(driver);
        Thread.sleep(2000);
        // dragAndDrop --> drags the source to target
        actions.dragAndDrop(source, target).perform();
    }
    @Test
    public void dragdropbychainingtest() throws InterruptedException {
        driver.get("https://demos.telerik.com/kendo-ui/dragdrop/index");
        // source00> we will drag this element
        WebElement source=driver.findElement(By.id("draggable"));
        // target --> we drop here
        WebElement target=driver.findElement(By.id("droptarget"));
        Actions actions =new Actions(driver);
        // We can chain multiple actions
        // at the end we call the build().perform()
        // build--> is used to chain the actions.
        actions.moveToElement(source).clickAndHold().moveToElement(target).release().build().perform();
    }
}
