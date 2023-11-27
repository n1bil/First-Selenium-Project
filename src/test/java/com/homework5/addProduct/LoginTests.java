package com.homework5.addProduct;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTests extends TestBase {

    @BeforeMethod
    public void ensurePrecondition() {
        if (!isElementPresent(By.cssSelector("[href='/login']"))) {
            driver.findElement(By.cssSelector("[href='/login']")).click();

            driver.findElement(By.name("Email")).click();
            driver.findElement(By.name("Email")).sendKeys("beckham@gmail.com");

            driver.findElement(By.name("Password")).click();
            driver.findElement(By.name("Password")).sendKeys("davidbeckham");

            driver.findElement(By.cssSelector("#RememberMe")).click();

            driver.findElement(By.cssSelector(".login-button")).click();
        }
    }

    @Test
    public void loginTest() {
        driver.findElement(By.xpath("//img[@alt='Picture of 14.1-inch Laptop']")).click();

        driver.findElement(By.id("add-to-cart-button-31")).click();

        driver.findElement(By.xpath("//span[@class='cart-label' and text()='Shopping cart']")).click();

        String actualText = driver.findElement(By.cssSelector("a.product-name[href='/141-inch-laptop']")).getText();
        String expectedText = "14.1-inch Laptop";
        Assert.assertEquals(actualText, expectedText);
    }

}
