package com.libraryCT.us1_LoginFunction;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

public class UserLoginNegative {

    @Test
    public void userSignIn(){

        // Setting up WebDriver, navigating to LibraryCT homepage and maximizing the window:
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://library2.cybertekschool.com/login.html");
        driver.manage().window().maximize();

        // Given user is on the login page, user enters invalid email and pass, and clicks on sign in:
        WebElement inputEmail = driver.findElement(By.id("inputEmail"));
        inputEmail.sendKeys("invalidemail@user.com");
        WebElement inputPassword = driver.findElement(By.id("inputPassword"));
        inputPassword.sendKeys("invalidPassword");
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        WebElement signInButton = driver.findElement(By.xpath("//button[@type='submit']"));
        signInButton.submit();

        // Verify that the error message is "Sorry, Wrong Email or Password"
        String actualErrorMsg = driver.findElement(By.xpath("//*[@id='login-form']/div[2]/div[1]")).getText();
        String expectedErrorMsg = "Sorry, Wrong Email or Password";
        assertEquals(expectedErrorMsg,actualErrorMsg);

        // Quit the browser:
        driver.quit();
    }
}

/*
        AC #3 [negative]:
Given user is on the loginPage
When user enters invalid email address or password
And student click sign in button
Then verify the error message “Sorry, Wrong Email or Password”
 */