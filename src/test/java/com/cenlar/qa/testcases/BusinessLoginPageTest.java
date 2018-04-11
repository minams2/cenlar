package com.cenlar.qa.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.cenlar.qa.pages.BusinessLogin;
import com.cenlar.qa.pages.ContactUsPage;
import com.cenlar.qa.pages.HomePage;
import com.cenlar.qa.util.TestUtil;

import CenlarBase.CenlarBase;

public class BusinessLoginPageTest extends CenlarBase {
	HomePage homePage = new HomePage();
	ContactUsPage contactUsPage = new ContactUsPage();
	BusinessLogin businessLoginPage = new BusinessLogin();

	TestUtil testUtil;

	@BeforeTest
	public void setUp() {
		intialize();
	}

	@Test(priority = 1)
	public void clickOnBusinessLoginTest() {
		businessLoginPage.clickOnBusinessLogin();
		String pageTitle = businessLoginPage.getPageTitle();
		Assert.assertEquals(pageTitle, "Loan Administration : Log In");

	}

	@Test(priority = 2, dataProvider = "getBusinessLoginData")
	public void validateBusinessLoginTest(String usrname, String pass) {
		boolean flag = businessLoginPage.validateBusinessLogin(usrname, pass);

		Assert.assertTrue(flag, "Login Not SuccessFul");
		
	}

	@DataProvider
	public Object[][] getBusinessLoginData() {
		Object[][] data = TestUtil.getTestData();
		return data;
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}
}
