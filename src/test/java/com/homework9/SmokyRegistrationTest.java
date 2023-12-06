package com.homework9;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SmokyRegistrationTest extends TestBase {

    @Test(dataProvider = "readDataFromCSV", groups = "smoke")
    public void smokyRegistrationTest(String firstName, String lastName, String email, String password) {
        driver.findElement(By.cssSelector("#gender-male")).click();
        driver.findElement(By.id("FirstName")).sendKeys(firstName);
        driver.findElement(By.id("LastName")).sendKeys(lastName);
        driver.findElement(By.id("Email")).sendKeys(email);
        driver.findElement(By.id("Password")).sendKeys(password);
        driver.findElement(By.id("ConfirmPassword")).sendKeys(password);
        driver.findElement(By.id("register-button")).click();
    }

    @DataProvider
    private Iterator<Object[]> readDataFromCSV() throws IOException {
        List<Object[]> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("src/test/resources/data.csv"))) {
            String line = reader.readLine();
            while (line != null) {
                String[] split = line.split(",");
                Object[] data = new Object[]{split[0], split[1], split[2], split[3]};
                list.add(data);
                line = reader.readLine();
            }
        }
        return list.iterator();
    }

}
