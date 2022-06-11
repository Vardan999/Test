package com.company.swaglabs.utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CustomWebElement {
    private WebDriver driver;
    private static WebDriverWait wait;

    public CustomWebElement(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(3));
    }


    public static boolean isDisplayed(WebElement webElement) {
        try {
            wait.until(ExpectedConditions.visibilityOf(webElement));
            return webElement.isDisplayed();
        } catch (Exception e) {
            System.out.println(e + webElement.getText() + "is not displayed");
            return false;
        }
    }

    public static void click(WebElement webElement) {
        isDisplayed(webElement);
        try {
            wait.until(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void fill(WebElement webElement, String field) {
        isDisplayed(webElement);
        try {
            webElement.clear();
            webElement.sendKeys(field);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}