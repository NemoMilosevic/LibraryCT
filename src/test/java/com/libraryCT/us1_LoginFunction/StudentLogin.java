package com.libraryCT.us1_LoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class StudentLogin {

    @Test
    public void studentSignIn(){

        // Setting up WebDriver, navigating to LibraryCT homepage and maximizing the window:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().window().maximize();

        // Given student is on login page, verify URL is "https://library2.cybertekschool.com/login.html":
        String actualUrl = "https://library2.cybertekschool.com/login.html";
        assertEquals(driver.getCurrentUrl(),actualUrl);

        // Student enters valid email address and password, and clicks on sign in button:
        WebElement inputEmail = driver.findElement(By.id("inputEmail"));
        inputEmail.sendKeys("student94@library");
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("Sdet2022*");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.submit();

        // Verify that there are 2 models on the page:
        List<String> expectedModules = new ArrayList<>(Arrays.asList("Books", "Borrowing Books"));
        String books = driver.findElement(By.linkText("Books")).getText();
        String borrowingBooks = driver.findElement(By.linkText("Borrowing Books")).getText();
        List<String> actualModules =  new ArrayList<>(Arrays.asList(books, borrowingBooks));
        assertEquals(expectedModules,actualModules);

        // Quit the browser:
        driver.quit();
    }
}

/*
            AC#2:
Given student is on the loginPage
Then verify that the URL is
“https://library2.cybertekschool.com/login.html”
When student enters valid email address and password
And student click sign in button
Then verify that there are 2 models on the page
 */