package org.qa.test;

import static org.testng.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.qa.base.BaseTest;
import org.qa.base.Utility;
import org.qa.data.UserTestData;
import org.qa.pages.HomePage;
import org.qa.pages.LoginPage;
import org.qa.pages.launchPage;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.AfterMethod;


import com.google.common.annotations.VisibleForTesting;

import dev.failsafe.internal.util.Assert;

public class LoginPageTest extends BaseTest{
	@BeforeMethod
	public void initLaunchPage() {
		BaseTest.initBrowser();
	}
	@DataProvider 
	public UserTestData[] getLoginData() {
		List<UserTestData> obj = Utility.JsonDataReader();
		UserTestData[] userTestData = new UserTestData[obj.size()];
		return obj.toArray(userTestData);
		//return Utility.readTestData("Login");
	}
	@Test (dataProvider = "getLoginData")
	public void clickLogin(UserTestData userData) {
		launchPage launchPage = new launchPage();
		LoginPage loginPage = launchPage.clickLoginbtn();
		System.out.println("JSON Object parsing worked :" + userData.getFirstname());
		if (userData.getUsername().equals("guest8nikunj@gmail.com")) {
			HomePage homePage = loginPage.validLoginToCRM(userData.getUsername(), userData.getPassword());
			assertEquals(homePage.getHeader().isDisplayed(), true);
		}	
		else {
			//loginPage.invalidLoginToCRM(username, password);
			
		}
	}

	@AfterMethod
	public void quitBrowser() {
		BaseTest.quit();
	}
	
	
}
