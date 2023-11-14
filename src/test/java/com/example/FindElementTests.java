package com.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

public class FindElementTests {

    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.get("https://telranedu.web.app/login");
        // maximize window browser
        driver.manage().window().maximize();
        // wait for all elements on the page to load before starting the test
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void findElementByTagTest() {

        // find element by tag
        WebElement element = driver.findElement(By.tagName("h1"));
        System.out.println(element.getText());

        WebElement element1 = driver.findElement(By.tagName("a"));
        System.out.println(element1.getText());

        // find list of elements by tag
        List<WebElement> elements = driver.findElements(By.tagName("a"));
        System.out.println(elements.size());

    }

    @Test
    public void findElementTest() {
        // id
        WebElement root = driver.findElement(By.id("root"));
        System.out.println(root.getText());
        System.out.println("=============================");

        // classname
        WebElement login = driver.findElement(By.className("login_login__3EHKB"));
        System.out.println(login.getText());
        System.out.println("=============================");

        // name
        WebElement email = driver.findElement(By.name("email"));
        System.out.println(email.getAttribute("name"));

        // linkText
        driver.findElement(By.linkText("LOGIN"));

        //partialLinkText
        driver.findElement(By.partialLinkText("LOG"));
    }

    @Test
    public void findElementByCssTest() {
//        tag --> tag
//        driver.findElement(By.tagName("h1"));
        driver.findElement(By.cssSelector("h1"));

        // id --> #id
//        driver.findElement(By.id("root"));
        driver.findElement(By.cssSelector("#root"));

//        classname --> .class
//        driver.findElement(By.className("login_login__3EHKB"));
        driver.findElement(By.cssSelector(".login_login__3EHKB"));

        // [attribute='value']
//        driver.findElement(By.name("email"));
        driver.findElement(By.cssSelector("[name='email']"));

        // contains --> *
        driver.findElement(By.cssSelector("[placeholder*='ssw']"));

        // start --> ^
        driver.findElement(By.cssSelector("[placeholder^='Pas']"));

        // end to --> $
        driver.findElement(By.cssSelector("[placeholder$='word']"));
    }

    @Test
    public void findElementByXPath() {
        // xpath --> //*[@attribute='value']

//         tag --> //tag
//        driver.findElement(By.tagName("h1"));
        driver.findElement(By.xpath("//h1"));

        // id --> //*[@id='value']
//        driver.findElement(By.id("root"));
        driver.findElement(By.xpath("//div[@id='root']"));

//         classname --> //*[@class='value']
//        driver.findElement(By.className("login_login__3EHKB"));
        driver.findElement(By.xpath("//div[@class='login_login__3EHKB']"));

        // contains --> //*[contains(., 'Text')]
        driver.findElement(By.xpath("//button[contains(.,'Registration')]"));

        // start --> //*[starts-with(@attribute, '...')]
        driver.findElement(By.xpath("//button[starts-with(@name,'reg')]"));
    }

    @Test
    public void xpathParentTest() {
        // parent
        WebElement element = driver.findElement(By.xpath("//h1/parent::*"));
        System.out.println(element.getText());
        System.out.println("===============================");
        WebElement element1 = driver.findElement(By.xpath("//h1/parent::div"));
        System.out.println(element1.getText());
        System.out.println("===============================");
        WebElement element2 = driver.findElement(By.xpath("//h1/.."));
        System.out.println(element2.getText());

        // ancestor
        WebElement ancestor = driver.findElement(By.xpath("//h1/ancestor::*"));
        System.out.println(ancestor.getText());
        System.out.println("===============================");
        // following-sibling
        WebElement followingSibling = driver.findElement(By.xpath("//h1/following-sibling::a"));
        System.out.println(followingSibling.getText());

        WebElement followingSibling1= driver.findElement(By.xpath("//h1/following-sibling::a[3]"));
        System.out.println(followingSibling1.getText());
    }
}






















