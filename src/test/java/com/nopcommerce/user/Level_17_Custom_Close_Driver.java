package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_17_Custom_Close_Driver extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private String firstName, lastName, emailAddress, Password;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "TripleLee";
		lastName = "Hino";
		emailAddress = "TripleLee" + generateFakeNumber() + "@gmail.vn";
		Password = "123456";

		log.info("Re-Condition - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		log.info("Re-Condition - Step 02: Enter to FirstName texbox with value is '" + firstName + "'");
		registerPage.inputToFirstnameTextbox(firstName);

		log.info("Re-Condition - Step 03: Enter to LastName texbox with value is '" + lastName + "'");
		registerPage.inputToLastnameTextbox(lastName);

		log.info("Re-Condition - Step 04: Enter to Email texbox with value is '" + emailAddress + "'");
		registerPage.inputToEmailTextbox(emailAddress);

		log.info("Re-Condition - Step 05: Enter to Password texbox with value is '" + Password + "'");
		registerPage.inputToPasswordTextbox(Password);

		log.info("Re-Condition - Step 06: Enter to Confirm Password texbox with value is '" + Password + "'");
		registerPage.inputToConfirmPasswordTextbox(Password);

		log.info("Re-Condition - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Re-Condition - Step 08: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed.....AAAAA");

		log.info("Re-Condition - Step 09: Click to Logout link ");
		homePage = registerPage.clickToLogoutLink();

		log.info("Re-Condition - Step 10: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Re-Condition - Step 11: Enter to Email texbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Re-Condition - Step 12: Enter to Password texbox with value is '" + Password + "'");
		loginPage.inputToPasswordTextbox(Password);

		log.info("Re-Condition - Step 13: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void Search_01_Name() {
		
	}

	@Test
	public void Search_02_Address() {
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
 	}

}
