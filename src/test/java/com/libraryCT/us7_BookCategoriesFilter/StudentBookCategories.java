package com.libraryCT.us7_BookCategoriesFilter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class StudentBookCategories {

    @Test
    public void bookCategories() {

        // Setting up WebDriver, navigating to LibraryCT homepage and maximizing the window:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().window().maximize();

        // Student enters valid email address and password, and clicks on sign in button:
        WebElement inputEmail = driver.findElement(By.id("inputEmail"));
        inputEmail.sendKeys("student94@library");
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("Sdet2022*");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.submit();

        // Student clicks on Books module and then clicks on Book Categories dropdown menu:
        WebElement booksModule = driver.findElement(By.xpath("//*[@id='menu_item']/li[1]/a/span[1]"));
        booksModule.click();
        WebElement bookCategories = driver.findElement(By.id("book_categories"));
        bookCategories.click();

        // Verify student is able to select Drama option:
        WebElement dramaOption = driver.findElement(By.xpath("//select[@id='book_categories']/option[7]"));
        dramaOption.click();
        System.out.println("Student selected option: " + dramaOption.getText());

        // Quit the browser:
        driver.quit();
    }
}
/*
        AC #2:
Given user is on the homePage
When user click Books module
And user click book category dropdown
Then verify user is able to select the “Drama” option
 */