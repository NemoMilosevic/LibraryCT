package com.libraryCT.us2_AddNewUser;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;


import java.util.concurrent.TimeUnit;

public class LibrarianAddNewUser {

    @Test
    public void addNewUser() {

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

        // Librarian clicks on Users module and then on "+Add User" button:
        WebElement usersModule = driver.findElement(By.xpath("//*[@id='menu_item']/li[2]/a/span[1]"));
        usersModule.click();
        WebElement addUserButton = driver.findElement(By.xpath("//*[@id='users']/div[1]/div[1]/span/a"));
        addUserButton.click();

        // Number of total users before adding a new one:
        WebElement totalUsersBeforeAdding = driver.findElement(By.id("tbl_users_info"));
        String before = totalUsersBeforeAdding.getText();

        // Librarian enters full name, password, email and address:
        WebElement fullNameBox = driver.findElement(By.name("full_name"));
        fullNameBox.sendKeys("Nemo Milosevic");
        WebElement passBar = driver.findElement(By.name("password"));
        passBar.sendKeys("Pass123");
        WebElement emailBar = driver.findElement(By.name("email"));
        emailBar.sendKeys("someone@something.com");
        WebElement addressBar = driver.findElement(By.id("address"));
        addressBar.sendKeys("10 Unknown Street, Apt #001, Unknown City, VA 22222");

        // Librarian clicks save changes:
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);

        // Number of total users after adding a new one:
        WebElement totalUsersAfterAdding = driver.findElement(By.id("tbl_users_info"));
        String after = totalUsersAfterAdding.getText();

        // Assert to check if new user was added:
        assertEquals(before,after);

        // Quit the browser:
        driver.quit();
    }
}

/*
            AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click “+Add User” button
When librarian enter full name, password, email and
address
And librarian click save changes
Then verify a new user is created
 */