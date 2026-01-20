//package com.orangehrm.tests;
//
//import org.testng.Assert;
//import org.testng.annotations.Listeners;
//import org.testng.annotations.Test;
//
//import com.orangehrm.base.BaseTest;
//import com.orangehrm.listeners.TestListener;
//import com.orangehrm.pages.OrangeHRMDashboardPage;
//import com.orangehrm.pages.OrangeHRMLoginPage;
//
//@Listeners(TestListener.class)
//public class LoginTest extends BaseTest {
//
//    @Test
//    public void verifyValidLogin() {
//        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);
//        loginPage.login("Admin", "admin123");
//
//        OrangeHRMDashboardPage dashboardPage =
//                new OrangeHRMDashboardPage(driver);
//
//        Assert.assertTrue(
//                dashboardPage.isDashboardDisplayed(),
//                "Login failed – Dashboard not visible"
//        );
//        //Assert.assertTrue(false, "Force fail to test screenshot");
//    }
//
//    @Test
//    public void verifyInvalidLogin() {
//        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);
//        loginPage.login("Admin", "wrongPassword");
//
//        Assert.assertTrue(
//                loginPage.isErrorMessageDisplayed(),
//                "Error message not displayed for invalid login"
//        );
//    }
//}

package com.orangehrm.tests; // Git Test

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.orangehrm.base.BaseTest;
import com.orangehrm.listeners.TestListener;
import com.orangehrm.pages.OrangeHRMDashboardPage;
import com.orangehrm.pages.OrangeHRMLoginPage;
import com.orangehrm.utils.CSVUtils;

@Listeners(TestListener.class)
public class LoginTest extends BaseTest {

    @DataProvider(name = "loginData")
    public Object[][] loginData() {
        return CSVUtils.getCSVData(
                "src/test/resources/testdata/loginData.csv"
        );
    }

    @Test(dataProvider = "loginData")
    public void verifyLogin(String username, String password, String expectedResult) {

        OrangeHRMLoginPage loginPage = new OrangeHRMLoginPage(driver);
        loginPage.login(username, password);

        if (expectedResult.equalsIgnoreCase("PASS")) {

            OrangeHRMDashboardPage dashboardPage =
                    new OrangeHRMDashboardPage(driver);

            Assert.assertTrue(
                    dashboardPage.isDashboardDisplayed(),
                    "Login failed – Dashboard not visible"
            );

        } else {

            Assert.assertTrue(
                    loginPage.isErrorMessageDisplayed(),
                    "Error message not displayed for invalid login"
            );
        }
    }
}

