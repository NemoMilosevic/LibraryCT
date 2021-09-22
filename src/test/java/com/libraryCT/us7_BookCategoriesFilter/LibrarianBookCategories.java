package com.libraryCT.us7_BookCategoriesFilter;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianBookCategories {

    @Test
    public void bookCategories() {

        // Setting up WebDriver, navigating to LibraryCT homepage and maximizing the window:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().window().maximize();

        // Librarian enters valid email address and password, and clicks on sign in button:
        WebElement inputEmail = driver.findElement(By.id("inputEmail"));
        inputEmail.sendKeys("librarian47@library");
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("Sdet2022*");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.submit();

        // Librarian clicks on Books module and then clicks on Book Categories dropdown menu:
        WebElement booksModule = driver.findElement(By.xpath("//*[@id='menu_item']/li[3]/a/span[1]"));
        booksModule.click();
        WebElement bookCategories = driver.findElement(By.id("book_categories"));
        bookCategories.click();

        // Verify there are 21 options in the dropdown menu:
        Select dropdownMenu = new Select(driver.findElement(By.id("book_categories")));
        List<WebElement> dropdown = dropdownMenu.getOptions();
        assertEquals(21, dropdown.size());

        // Quit the browser:
        driver.quit();
    }
}
/*
            AC #1:
Given user is on the homePage
When user click Books module
And user click book category dropdown
Then verify there are 21 options
 */