package com.cenlar.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import CenlarBase.CenlarBase;

public class HomePage extends CenlarBase {

	WebElement contactus;

	public String getPageTitle() {

		return driver.getTitle();

	}

}