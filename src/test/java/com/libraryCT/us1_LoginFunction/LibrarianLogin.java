package com.libraryCT.us1_LoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LibrarianLogin {

    @Test
    public void librarianSignIn() {

        // Setting up WebDriver, navigating to LibraryCT homepage and maximizing the window:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().window().maximize();

        // Given librarian is on the login page, verify that the title is "Login-Library":
        assertEquals(driver.getTitle(),"Login - Library");

        /*System.out.println("driver.getTitle() = " + driver.getTitle());
        String actualTitle = driver.getTitle();
        String expectedTitle = "Login - Library";
        if (actualTitle.equals(expectedTitle)){
            System.out.println("Correct Title");
        }else{
            System.out.println("Incorrect Title");
        }*/

        // Librarian enters valid email address and password, and clicks on sign in button:
        WebElement inputEmail = driver.findElement(By.id("inputEmail"));
        inputEmail.sendKeys("librarian47@library");
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("Sdet2022*");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.submit();

        // Verify that there are 3 models on the page:
        List<String> expectedModules = new ArrayList<>(Arrays.asList("Dashboard", "Users", "Books"));
        String dashboard = driver.findElement(By.linkText("Dashboard")).getText();
        String users = driver.findElement(By.linkText("Users")).getText();
        String books = driver.findElement(By.linkText("Books")).getText();
        List<String > actualModules = new ArrayList<>(Arrays.asList(dashboard, users, books));
        assertEquals(expectedModules,actualModules);

        /*
        if (expectedModules.equals(actualModules)){
            System.out.println("Test Passed");
        }else{
            System.out.println("Test Failed");
        }
*/

        // Quit the browser:
        driver.quit();

    }
}

/*
            AC #1:
Given librarian is on the loginPage
Then verify that the title is “Login - Library”
When librarian enters valid email address and password
And librarian click sign in button
Then verify that there are 3 models on the page

 */