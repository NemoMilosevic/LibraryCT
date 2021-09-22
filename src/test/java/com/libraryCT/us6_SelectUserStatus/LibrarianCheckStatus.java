package com.libraryCT.us6_SelectUserStatus;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LibrarianCheckStatus {

    @Test
    public void userStatus() {

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

        // Librarian clicks Users module and clicks Status dropdown menu:
        WebElement usersModule = driver.findElement(By.xpath("//*[@id='menu_item']/li[2]/a/span[1]"));
        usersModule.click();
        WebElement statusDropdown = driver.findElement(By.id("user_status"));
        statusDropdown.click();

        // Verify librarian have 2 options in dropdown menu (ACTIVE, INACTIVE):
        WebElement option1 = driver.findElement(By.xpath("//select[@id='user_status']/option[@value='ACTIVE']"));
        String name1 = option1.getText();
        WebElement option2 = driver.findElement(By.xpath("//select[@id='user_status']/option[@value='INACTIVE']"));
        String name2 = option2.getText();
        ArrayList<String> expectedResult = new ArrayList<>(Arrays.asList("ACTIVE", "INACTIVE"));
        ArrayList<String> actualResult = new ArrayList<>(Arrays.asList(name1,name2));
        assertEquals(expectedResult,actualResult);

        // Confirm that size of dropdown status menu options match:
        Select dropdownMenu = new Select(driver.findElement(By.id("user_status")));
        List<WebElement> dropdown = dropdownMenu.getOptions();
        assertEquals(2, dropdown.size());

        // Quit the browser:
        driver.quit();
    }
}
/*
            AC #1:
Given librarian is on the homePage
When librarian click Users module
And librarian click Status dropdown
Then verify there are 2 status options
 */