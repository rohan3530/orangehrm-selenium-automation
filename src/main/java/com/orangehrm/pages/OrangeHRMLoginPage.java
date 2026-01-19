//package com.orangehrm.pages;
//
//import java.time.Duration;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//
//public class OrangeHRMLoginPage {
//
//    public WebDriver driver;
//
//    // Locators
//    public By usernameField = By.xpath("//*[@name='username']");
//    public By passwordField = By.xpath("//*[@name='password']");
//    public By loginButton = By.xpath("//button[@type='submit']");
//
//    public OrangeHRMLoginPage(WebDriver driver) {
//        this.driver = driver;
//    }
//    public void enterUsername(String username) {
//        driver.findElement(usernameField).sendKeys("Admin");
//    }
//
//    public void enterPassword(String password) {
//        driver.findElement(passwordField).sendKeys("admin123");
//    }
//
//    public void clickLogin() {
//        driver.findElement(loginButton).click();
//    }
//
//    public boolean isLoginPageDisplayed() {
//        return driver.findElement(loginButton).isDisplayed();
//    }
//    public void login(String username, String password) {
//    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//        wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
//       
//        enterUsername(username);
//        enterPassword(password);
//        clickLogin();
//}
//}

package com.orangehrm.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.orangehrm.utils.WaitUtils;

public class OrangeHRMLoginPage {

    WebDriver driver;
    WaitUtils waitUtils;

    // Locators
    private By usernameField = By.name("username");
    private By passwordField = By.name("password");
    private By loginButton = By.xpath("//button[@type='submit']");
    private By errorMessage = By.xpath("//p[contains(@class,'oxd-alert-content-text')]");


    // Constructor
    public OrangeHRMLoginPage(WebDriver driver) {
        this.driver = driver;
        waitUtils = new WaitUtils(driver);
    }

    // Enter username
    public void enterUsername(String username) {
        waitUtils.waitForVisibility(usernameField).sendKeys(username);
    }

    // Enter password
    public void enterPassword(String password) {
        waitUtils.waitForVisibility(passwordField).sendKeys(password);
    }

    // Click login button
    public void clickLogin() {
        waitUtils.waitForClickable(loginButton).click();
    }

    // Complete login action
    public void login(String username, String password) {
        enterUsername(username);
        enterPassword(password);
        clickLogin();
    }

    // Verify login page is displayed
    public boolean isLoginPageDisplayed() {
        return waitUtils.waitForVisibility(loginButton).isDisplayed();
    }
    
    public boolean isErrorMessageDisplayed() {
        return waitUtils.waitForVisibility(errorMessage).isDisplayed();
    }

}

