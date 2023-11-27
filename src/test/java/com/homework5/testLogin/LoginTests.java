package com.homework5.testLogin;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            driver.findElement(By.xpath("//a[.='Log out']")).click();
        }
    }

    @Test
    public void loginTest() {
        driver.findElement(By.cssSelector("[href='/login']")).click();

        driver.findElement(By.name("Email")).click();
        driver.findElement(By.name("Email")).sendKeys("beckham@gmail.com");

        driver.findElement(By.name("Password")).click();
        driver.findElement(By.name("Password")).sendKeys("davidbeckham");

        driver.findElement(By.cssSelector("#RememberMe")).click();

        driver.findElement(By.cssSelector(".login-button")).click();


        String actualText = driver.findElement(By.cssSelector("a.account[href='/customer/info']")).getText();
        String expectedText = "beckham@gmail.com";
        Assert.assertEquals(actualText, expectedText);
    }


}
