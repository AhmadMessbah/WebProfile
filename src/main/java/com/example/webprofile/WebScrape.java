package com.example.webprofile;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebScrape {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("https://mftplus.com/teacher/login");

        WebElement fElement = driver.findElement(By.tagName("form"));
        WebElement uElement = driver.findElement(By.id("username"));
        WebElement pElement = driver.findElement(By.id("password"));

        uElement.sendKeys("09178505323");
        pElement.sendKeys("21261708");

        fElement.submit();

        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page is: " + driver.getPageSource());

        driver.get("https://mftplus.com/teacher/profile");
        System.out.println(driver.getTitle());

        driver.quit();
    }
}