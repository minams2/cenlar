package com.cenlar.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cenlar.qa.util.TestUtil;

import CenlarBase.CenlarBase;

public class ContactUsPage extends CenlarBase {
	static TestUtil testUtil;

	@FindBy(xpath = "//input[@id='gform_submit_button_3']")
	static 	WebElement submitBtn;
	@FindBy(xpath = "//*[@id='menu-item-30']/a")
	WebElement ContactUs;
	@FindBy(xpath = "//*[@id=\"menu-item-358\"]/a")
	WebElement SubService;

	public ContactUsPage() {
		PageFactory.initElements(driver, this);
	}

	public String getPageTitle() {

		return driver.getTitle();
	}

	public static void clickOnSubServiceLink() {
		// Actions action = new Actions(driver);
		// action.moveToElement(ContactUs).build().perform();
		// driver.findElement(By.xpath("//*[@id=\"menu-item-358\"]/a")).click();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('menu-item-358').children[0].click();");
		/*
		 * try { Thread.sleep(500); } catch (InterruptedException e) {
		 * e.printStackTrace(); }
		 * driver.findElement(By.xpath("//input[@id='gform_submit_button_3']")).click();
		 */
	}

	public static void clickOnSubmit() {
		testUtil.pageScroll();
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		driver.findElement(By.xpath("//input[@id='gform_submit_button_3']")).click();
		//submitBtn.click();
	}

	public static boolean validatError() {
		return driver.findElement(By.xpath("//div[@class='validation_error']")).isEnabled();

	}

	public boolean requiredFieldError1() {
		boolean flag1, flag2, flag3, flag4;
		String color1, color2, color3, color4;
		String color = "rgba(121, 0, 0, 1)";
		flag1 = driver.findElement(By.xpath("//label[contains(text(),'Name')]")).isEnabled();
		color1 = driver.findElement(By.xpath("//label[contains(text(),'Name')]")).getCssValue("color");

		if (color1.equals(color))
			flag1 = true;
		else
			flag1 = false;

		flag2 = driver.findElement(By.xpath("//label[contains(text(),'First')]")).isEnabled();
		color2 = driver.findElement(By.xpath("//label[contains(text(),'First')]")).getCssValue("color");
		if (color2.equals(color))
			flag2 = true;
		else
			flag2 = false;

		flag3 = driver.findElement(By.xpath("//label[contains(text(),'Last')]")).isEnabled();
		color3 = driver.findElement(By.xpath("//label[contains(text(),'Last')]")).getCssValue("color");
		if (color3.equals(color))
			flag3 = true;
		else
			flag3 = false;
		flag4 = driver.findElement(By.xpath("//*[@id='field_3_1']/div[2]")).isEnabled();
		color4 = driver.findElement(By.xpath("//*[@id='field_3_1']/div[2]")).getCssValue("color");
		if (color4.equals(color))
			flag4 = true;
		else
			flag4 = false;
		if ((flag1) && (flag2) && (flag3) && (flag4))
			return true;
		else
			return false;
	}

	/*
	 * public static void main(String[] args) { intialize();
	 * clickOnSubServiceLink(); clickOnSubmit(); validatError();
	 * System.out.println(requiredFieldError1()); }
	 */
	public boolean requiredError2() {
		boolean flag1, flag2, flag3, flag4;
		String color1, color2, color3, color4;
		String color = "rgba(121, 0, 0, 1)";
		WebElement element = driver.findElement(By.xpath("//*[@id='field_3_7']/div[2]"));
		TestUtil.pageScrollToView(element);
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
		flag1 = driver.findElement(By.xpath("//label[contains(text(),'Reason for Inquiry')]")).isEnabled();
		color1 = driver.findElement(By.xpath("//label[contains(text(),'Reason for Inquiry')]")).getCssValue("color");
		if (color1.equals(color))
			flag1 = true;
		else
			flag1 = false;

		flag2 = driver.findElement(By.xpath("//label[contains(text(),'This a business inquiry')]")).isEnabled();
		color2 = driver.findElement(By.xpath("//label[contains(text(),'This a business inquiry')]"))
				.getCssValue("color");
		if (color2.equals(color))
			flag2 = true;
		else
			flag2 = false;
		flag3 = driver.findElement(By.xpath("//label[contains(text(),'This a personal loan inquiry')]")).isEnabled();
		color3 = driver.findElement(By.xpath("//label[contains(text(),'This a personal loan inquiry')]"))
				.getCssValue("color");
		if (color3.equals(color))
			flag3 = true;
		else
			flag3 = false;
		flag4 = driver.findElement(By.xpath("//*[@id='field_3_7']/div[2]")).isEnabled();
		color4 = driver.findElement(By.xpath("//*[@id='field_3_7']/div[2]")).getCssValue("color");
		if (color4.equals(color))
			flag4 = true;
		else
			flag4 = false;
		if ((flag1) && (flag2) && (flag3) && (flag4))
			return true;
		else
			return false;
	}
}
