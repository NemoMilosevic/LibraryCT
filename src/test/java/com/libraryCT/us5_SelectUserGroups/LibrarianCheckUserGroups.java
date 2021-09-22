package com.libraryCT.us5_SelectUserGroups;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class LibrarianCheckUserGroups {

    @Test
    public void userGroups() {

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

        // Librarian clicks Users module and clicks User Group dropdown:
        WebElement usersModule = driver.findElement(By.xpath("//*[@id='menu_item']/li[2]/a/span[1]"));
        usersModule.click();
        WebElement userGroupDropdown = driver.findElement(By.id("user_groups"));
        userGroupDropdown.click();

        // Verify librarian have 3 options in dropdown menu (ALL, Librarian, Students):
        WebElement option1 = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='null']"));
        String name1 = option1.getText();
        WebElement option2 = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='2']"));
        String name2 = option2.getText();
        WebElement option3 = driver.findElement(By.xpath("//select[@id='user_groups']/option[@value='3']"));
        String name3 = option3.getText();
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("ALL", "Librarian", "Students"));
        ArrayList<String> actualResult = new ArrayList<>(Arrays.asList(name1,name2,name3));
        assertEquals(expectedResult,actualResult);

        // Confirm that size of dropdown menu options match:
        Select dropdownMenu = new Select(driver.findElement(By.id("user_groups")));
        List<WebElement> dropdown = dropdownMenu.getOptions();
        assertEquals(3, dropdown.size());

        // Quit the browser:
        driver.quit();


    }
}
/*
            AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click user group dropdown
Then verify librarian have 3 options
 */