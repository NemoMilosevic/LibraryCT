package com.libraryCT.us4_LogoutFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class LibrarianLogout {

    @Test
    public void librarianSignOut() {

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

        // Librarian clicks username (top right corner), and clicks Log Out:
        WebElement usernameModule = driver.findElement(By.xpath("//*[@id='user_avatar']"));
        usernameModule.click();
        WebElement logOutButton = driver.findElement(By.xpath("//*[@id='navbarCollapse']/ul[2]/li[1]/div/a"));
        logOutButton.click();

        // Verify librarian navigate back to login page:
        System.out.println("Login Page Name = " + driver.getTitle());

        // Quit the browser:
        driver.quit();
    }
}

/*
            AC #1:
Given user is on the homePage
When user click username on the right top corner
And user click Log Out
Then verify user navigate back to login page.
 */