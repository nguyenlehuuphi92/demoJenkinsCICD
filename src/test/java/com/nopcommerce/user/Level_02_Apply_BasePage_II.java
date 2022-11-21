//package com.nopcommerce.user;
//
//import java.util.Random;
//import java.util.concurrent.TimeUnit;
//
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//import org.testng.Assert;
//import org.testng.annotations.AfterClass;
//import org.testng.annotations.BeforeClass;
//import org.testng.annotations.Test;
//
//import commons.BasePage;
//
//public class Level_02_Apply_BasePage_II {
//	WebDriver driver;
//	String emailAddress;
//	BasePage basePage;
//	String projectPath = System.getProperty("user.dir");
//
//	@BeforeClass
//	public void beforeClass() {
//		System.setProperty("webdriver.gecko.driver", projectPath + "\\browserDrivers\\geckodriver.exe");
//		driver = new FirefoxDriver();
//
//		// Initial (Khởi tạo)
//		// Che giấu đi việc khởi tạo của 1 đối tượng	
//		basePage = BasePage.getBasePageObject();
//		
//		emailAddress = "TripleLee" + generateFakeNumber() + "@gmail.vn";
//		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
//		driver.get("https://demo.nopcommerce.com/");
//	}
//
//	@Test
//	public void TC_01_Register_Empty_Data() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='FirstName-error']"), "First name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='LastName-error']"), "Last name is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Email is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password is required.");
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "Password is required.");
//	}
//
//	@Test
//	public void TC_02_Register_Invalid_Email() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "TripleLee");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "Hino");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "kaka@3554&^#.com");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Email-error']"), "Wrong email");
//
//	}
//
//	@Test
//	public void TC_03_Register_Success() {
//		basePage.waitForElementClickable(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "Teo");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "lalaa");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "123456");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "123456");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getElementText(driver, "//div[@class='result']"), "Your registration completed");
//
//		basePage.waitForElementClickable(driver, "//a[@class='ico-logout']");
//		basePage.clickToElement(driver, "//a[@class='ico-logout']");
//
//	}
//
//	@Test
//	public void TC_04_Register_Existing_Email() {
//		basePage.wailForAllElementVisible(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "TeoTeo");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "mamababa");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", emailAddress);
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "777888");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "777888");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getElementText(driver, "//div[contains(@class,'message-error')]//li"), "The specified email already exists");
//	}
//
//	@Test
//	public void TC_05_Register_Password_Less_Than_6_Chars() {
//		basePage.wailForAllElementVisible(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "TeoTeo");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "mamababa");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "abcd@ttt.com");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "777");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "777");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='Password-error']"), "Password must meet the following rules:\nmust have at least 6 characters");
//
//	}
//
//	@Test
//	public void TC_06_Register_Invalid_Confirm_Password() {
//		basePage.wailForAllElementVisible(driver, "//a[@class='ico-register']");
//		basePage.clickToElement(driver, "//a[@class='ico-register']");
//
//		basePage.sendkeyToElement(driver, "//input[@id='FirstName']", "TeoTeo");
//		basePage.sendkeyToElement(driver, "//input[@id='LastName']", "mamababa");
//		basePage.sendkeyToElement(driver, "//input[@id='Email']", "abcd@ttt.com");
//		basePage.sendkeyToElement(driver, "//input[@id='Password']", "77777");
//		basePage.sendkeyToElement(driver, "//input[@id='ConfirmPassword']", "777999");
//
//		basePage.waitForElementClickable(driver, "//button[@id='register-button']");
//		basePage.clickToElement(driver, "//button[@id='register-button']");
//
//		Assert.assertEquals(basePage.getElementText(driver, "//span[@id='ConfirmPassword-error']"), "The password and confirmation password do not match.");
//
//	}
//
//	@AfterClass // Custom close browser/ driver
//	public void afterClass() {
//		driver.close();
//	}
//
//	public int generateFakeNumber() {
//		Random random = new Random();
//		return random.nextInt(9999);
//	}
//
//}
