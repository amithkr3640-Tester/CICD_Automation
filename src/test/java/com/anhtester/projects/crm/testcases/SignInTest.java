/*
 * Copyright (c) 2022 Anh Tester
 * Automation Framework Selenium
 */

package com.anhtester.projects.crm.testcases;

import com.anhtester.common.BaseTest;
import com.anhtester.dataprovider.DataProviderManager;
import com.anhtester.projects.crm.pages.Dashboard.DashboardPageCRM;
import com.anhtester.projects.crm.pages.SignIn.SignInPageCRM;
import io.qameta.allure.Epic;
import io.qameta.allure.Feature;
import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.util.Hashtable;

import static com.anhtester.keywords.WebUI.*;

@Epic("Regression Test CRM")
@Feature("Sign In Test")
public class SignInTest extends BaseTest {

    //Using library DataProvider with read Hashtable
    @Test(priority = 1, description = "TC01_signInWithDataProvider", dataProvider = "getSignInDataHashTable", dataProviderClass = DataProviderManager.class)
    public void signInWithDataProvider(Hashtable<String, String> data) {
        new SignInPageCRM().signIn(data);

    }

    @Test(priority = 2, description = "TC02_signInWithAdminRole")
    public void signInWithAdminRole() {
        DashboardPageCRM dashboardPage = new SignInPageCRM().signInWithAdminRole();
        verifyElementPresent(dashboardPage.menuDashboard, 15, "The menu Dashboard does not exist.");

    }

    @Test(priority = 3, description = "TC03_signInWithClientRole")
    public void signInWithClientRole() {
        new SignInPageCRM().signInWithClientRole();
        verifyContains(getPageTitle(), "Dashboard | RISE CRM");

    }

    @Test(priority = 4, description = "TC04_loginPerfexCRM")
    public void loginPerfexCRM() {
        openWebsite("https://crm.anhtester.com/admin/authentication");
        clearAndFillText(By.xpath("//input[@id='email']"), "admin@example.com");
        clearAndFillText(By.xpath("//input[@id='password']"), "123456");
        clickElement(By.xpath("//button[normalize-space()='Login']"));
        verifyEquals(getPageTitle(), "Dashboard");

    }

}
