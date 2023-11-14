package com.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FirstSeleniumTest {

    WebDriver driver;

    // before - setUp
    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
//        driver.get("https://www.google.com");             // open browser without history
        driver.navigate().to("https://www.google.com"); // analog but open browser with history
    }

    // test
    @Test
    public void openGoogleTest() {
        System.out.println("Web site has been opened!");
    }

    // after - tearDown
    @AfterMethod(enabled = false)       // window will not close automatically
    public void tearDown() {
        driver.quit();                  // all tabs & close browser
        driver.close();                 // close only a current tab
    }
}
