package com.cenlar.qa.pages;

import java.io.File;
import java.io.IOException;
import org.apache.commons.io.FileUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cenlar.qa.util.TestUtil;

import CenlarBase.CenlarBase;

public class BusinessLogin extends CenlarBase {

	@FindBy(id = "textfield_user_name")
	WebElement username;
	@FindBy(id = "textfield_user_password")
	WebElement password;
	@FindBy(id = "button_login")
	WebElement loginBtn;

	public BusinessLogin() {
		PageFactory.initElements(driver, this);
	}

	public void clickOnBusinessLogin() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById(\"menu-item-717\").children[0].click(); ");

	}

	public String getPageTitle() {
		return driver.getTitle();
	}

	public boolean validateBusinessLogin(String uname, String pwd) {
		Boolean flag;
		String msg = "Username and/or Password incorrect.";
		driver.findElement(By.id("textfield_user_name")).sendKeys(uname);
		driver.findElement(By.id("textfield_user_password")).sendKeys(pwd);
		driver.findElement(By.id("button_login")).submit();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String invalidmsg = (String) js
				.executeScript(" return document.getElementById(\"content\").children[0].innerText;");

		if (invalidmsg.equals(msg))
			flag = true;
		else
			flag = false;
		return true;
	}

}
