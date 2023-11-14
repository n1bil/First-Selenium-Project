package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class HMTest3 {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://demowebshop.tricentis.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByCssSelectorTest() {
        // first element
        driver.findElement(By.cssSelector(".title"));
        // second element
        driver.findElement(By.cssSelector("#nivo-slider"));
        // third element
        driver.findElement(By.cssSelector(".topic-html-content-header"));
        // fourth element
        driver.findElements(By.cssSelector(".topic-html-content-body"));
        // fifth element
        driver.findElement(By.cssSelector("#newsletter-subscribe-block"));
        // sixth element
        driver.findElement(By.cssSelector("[name='NewsletterEmail']"));
        // seventh element
        driver.findElement(By.cssSelector("#subscribe-loading-progress"));
        // eighth element
        driver.findElements(By.cssSelector(".poll-options"));
        // ninth element
        driver.findElement(By.cssSelector(".customer-service"));
        // tenth element
        driver.findElement(By.cssSelector(".footer-poweredby"));
    }

    @Test
    public void findElementByxPathTest() {
        // first element
        driver.findElement(By.xpath("//div[@class='title']"));
        // second element
        driver.findElement(By.xpath("//div[@id='nivo-slider']"));
        // third element
        driver.findElement(By.xpath("//h2[@class='topic-html-content-header']"));
        // fourth element
        driver.findElements(By.xpath("//div[@class='topic-html-content-body']"));
        // fifth element
        driver.findElement(By.xpath("//div[@class='newsletter-subscribe-block']"));
        // sixth element
        driver.findElement(By.xpath("//input[@name='NewsletterEmail']"));
        // seventh element
        driver.findElement(By.xpath("//span[@id='subscribe-loading-progress']"));
        // eighth element
        driver.findElements(By.xpath("//ul[@class='poll-options']"));
        // ninth element
        driver.findElement(By.xpath("//div[@class='column customer-service']"));
        // tenth element
        driver.findElement(By.xpath("//div[@class='footer-poweredby']"));
    }

}
