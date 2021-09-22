package com.libraryCT.us3_AddNewBook;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianAddNewBook {

    @Test
    public void addNewBook() {

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

        // Librarian clicks on Books module and then on "+Add Book" button:
        WebElement booksModule = driver.findElement(By.xpath("//*[@id='menu_item']/li[3]/a/span[1]"));
        booksModule.click();
        WebElement addBookButton = driver.findElement(By.xpath("//*[@id='books']/div[1]/div[1]/span/a"));
        addBookButton.click();

        // Number of total books before adding a new one:
        WebElement totalBooksBeforeAdding = driver.findElement(By.id("tbl_books_info"));
        String before = totalBooksBeforeAdding.getText();

        // Librarian enters book name, ISBN, year, author and description:
        WebElement bookName = driver.findElement(By.name("name"));
        bookName.sendKeys("Some Awesome Book");
        WebElement isbn = driver.findElement(By.name("isbn"));
        isbn.sendKeys("12345");
        WebElement year = driver.findElement(By.name("year"));
        year.sendKeys("1985");
        WebElement author = driver.findElement(By.xpath("//*[@id=\"add_book_form\"]/div[1]/div/div[2]/div[1]/div/input"));
        author.sendKeys("Some Author");
        WebElement description = driver.findElement(By.id("description"));
        description.sendKeys("Drama");

        // Librarian clicks save changes:
        driver.findElement(By.xpath("//*[@id='add_book_form']/div[2]/button[2]")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // Number of total books after adding a new one:
        WebElement totalBooksAfterAdding = driver.findElement(By.id("tbl_books_info"));
        String after = totalBooksAfterAdding.getText();

        // Assert to check if new book was added:
        assertEquals(before,after);

        // Quit the browser:
        driver.quit();
    }
}

/*
            AC #1:
Given librarian is on the homePage
When librarian click Books module
And librarian click “+Add Book” button
When librarian enter BookName, ISBN, Year, Author, and Description
And librarian click save changes
Then verify a new book is added
 */