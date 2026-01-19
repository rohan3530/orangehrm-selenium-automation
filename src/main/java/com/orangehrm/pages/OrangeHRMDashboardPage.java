package com.orangehrm.pages;

import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrangeHRMDashboardPage {

    public WebDriver driver;

    public By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public OrangeHRMDashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isDashboardDisplayed() {
    	
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(dashboardHeader));
    	
        return driver.findElement(dashboardHeader).isDisplayed();
    }
    
}
