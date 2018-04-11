package com.cenlar.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;

import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cenlar.qa.pages.ContactUsPage;
import com.cenlar.qa.pages.HomePage;
import com.cenlar.qa.util.TestUtil;

import CenlarBase.CenlarBase;

public class ContactUsPageTest extends CenlarBase {

	HomePage homePage = new HomePage();
	ContactUsPage contactUsPage = new ContactUsPage();
	TestUtil testUtil;

	@BeforeTest
	public void setUp() {
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		intialize();
	}

	@Test(priority = 1)
	public void clickOnSubServiceTest() {
		contactUsPage.clickOnSubServiceLink();
		String pageTitle = contactUsPage.getPageTitle();
		Assert.assertEquals(pageTitle, "Learn More About Subservicing | CENLAR");
	}

	@Test(priority = 2)
	public void clickonSubmitBtnTest() {
		contactUsPage.clickOnSubmit();
	}

	@Test(priority = 3)
	public void validateErrorTest() {
		boolean flag = contactUsPage.validatError();
		Assert.assertTrue(flag);
		
	}

	@Test(priority = 4)
	public void requiredFieldError1Test() {
		boolean flag = contactUsPage.requiredFieldError1();
		Assert.assertTrue(flag);
		

	}

	@Test(priority = 5)
	public void requiredFieldErrorTest() {
		boolean flag = contactUsPage.requiredError2();
		Assert.assertTrue(flag);
		
	}

	@AfterTest
	public void tearDown() {
		driver.quit();
	}

}
