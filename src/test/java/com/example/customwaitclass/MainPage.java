package com.example.customwaitclass;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static com.example.customwaitclass.CustomWait.customWait;

// page_url = https://www.jetbrains.com/
public class MainPage {
    private final Logger LOG = LoggerFactory.getLogger(MainPage.class);

    @FindBy(css = "button[data-jetbrains-cookies-banner-action='ACCEPT_ALL']")
    public WebElement acceptCookies;

    @FindBy(xpath = "//div[@data-test='main-menu-item' and @data-test-marker = 'Developer Tools']")
    public WebElement toolsMenu;

    @FindBy(css = "a[href='/aqua/']")
    public WebElement findAqua;

    @FindBy(css = "a[href='https://www.jetbrains.com/shop/buy?item=C:N:QA:Y']")
    public WebElement buyAqua;

    @FindBy(css = "section[class='wt-section wt-section_bg_dark wt-section_theme_dark price-section'] > div > h2")
    private WebElement subscriptionPlans;

    // initializing all the web elements located by @FindBy annotation
    public MainPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public Boolean checkIfBuyButtonIsClickable() {
        // creating CustomWait object and checking if element on page is visible
        customWait(5).visible(subscriptionPlans);
        LOG.info("Download button check");
        return buyAqua.isEnabled();
    }
}