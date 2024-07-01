package com.example.customwaitclass;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Duration;

public class CustomWait {
    // creating Logger object
    private final Logger LOG = LoggerFactory.getLogger(CustomWait.class);
    // creating WebDriverWait object
    private WebDriverWait wait;
    // creating int object that holds wait time
    private int secondsToWait;

    public CustomWait(int sec) {
        // setting attribute for a new object of a class
        this.secondsToWait = sec;
        // after function initializing new WebDriverWait object would be created
        wait = new WebDriverWait(MainPageTest.getDriver(), Duration.ofSeconds(sec));
    }

    // after function initializing new CustomWait object created
    public static CustomWait customWait(int sec) {
        return new CustomWait(sec);
    }

    public WebElement visible(WebElement element) {
        LOG.info("Waiting for " + secondsToWait + " seconds until element would be visible " + element.toString());
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}