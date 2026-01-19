//package com.orangehrm.tests; 14/01/2025
//
//import com.orangehrm.base.BaseTest;
//import org.testng.annotations.Test;
//
//public class OpenOrangeHRMTest extends BaseTest {
//
//    @Test
//    public void openOrangeHRM() {
//        launchApplication();
//        closeBrowser();
//    }
//}

package com.orangehrm.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.pages.OrangeHRMLoginPage;

public class OpenOrangeHRMTest extends BaseTest {

    @Test
    public void verifyOrangeHRMLoginPageIsOpened() {

        launchApplication();

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);

        Assert.assertTrue(
                loginPage.isLoginPageDisplayed(),
                "OrangeHRM Login Page is NOT displayed"
        );

        closeBrowser();
    }
}

