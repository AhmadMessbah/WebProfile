package com.example.webprofile.model.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

public class WebScrape {

    public static void main(String[] args) {
        WebDriver driver = new HtmlUnitDriver();

        driver.get("https://www.google.com");

        WebElement element = driver.findElement(By.name("q"));

        element.sendKeys("");

        element.submit();

        System.out.println("Page title is: " + driver.getTitle());
        System.out.println("Page is: " + driver.getPageSource());

        driver.quit();
    }
}