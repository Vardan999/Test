package com.company.swaglabs.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static com.company.swaglabs.action.WrapActions.visibilityOf;


public class Header {
    private WebDriver driver;

    @FindBy(className = "app_logo")
    private WebElement logo;
    @FindBy(id = ("react-burger-menu-btn"))
    private WebElement menuBar;
    @FindBy(className = "shopping_cart_link")
    private WebElement shopContainer;
    @FindBy(id = "inventory_sidebar_link")
    private WebElement allItems;

    public Header(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;

    }

    public void clickOnMenuBar() {
        this.menuBar.click();
    }

    public boolean menuBarIsVisibility() {
        if (visibilityOf(menuBar)) {
            return true;
        }
        return false;
    }

    public void clickOnShopContainer() {
        this.shopContainer.click();
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getAllItems() {
        return allItems;
    }

}

