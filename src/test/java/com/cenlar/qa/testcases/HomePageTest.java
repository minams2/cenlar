package com.cenlar.qa.testcases;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.AssertJUnit;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.cenlar.qa.pages.HomePage;
import com.cenlar.qa.util.RetryAnalyzer;

import CenlarBase.CenlarBase;
import net.bytebuddy.jar.asm.commons.AnalyzerAdapter;

public class HomePageTest extends CenlarBase {
	HomePage homePage = new HomePage();


	@BeforeTest
	public void setUp() {
		intialize();
	}

	@Test(priority=1)
	public void verifyPageTitleTest() {
		String pageTitle = homePage.getPageTitle();
		Assert.assertEquals(pageTitle, "Home Page | CENLAR");
		Logger log =Logger.getLogger(HomePageTest.class);
		log.info("*****************launching homepage*****************");
		log.warn("this is warning message");
		log.fatal("fatal");
		log.debug("++++++++++++++debug message+++++++++++++++++++++++");

	}

	
	@AfterTest
	public void tearDown() {
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.quit();
	}
}
