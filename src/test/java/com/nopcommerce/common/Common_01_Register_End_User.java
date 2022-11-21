package com.nopcommerce.common;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Common_01_Register_End_User extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private String firstName, lastName;
	public static String emailAddress, Password;

	@Parameters("browser")
	@BeforeTest(description = "Create New common User For all Classes Test")
	public void Register(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "TripleLee User A";
		lastName = "Hino";
		emailAddress = "TripleLeeUserA" + generateFakeNumber() + "@gmail.vn";
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
		verifyEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		log.info("Re-Condition - Step 09: Click to Logout link ");
		homePage = registerPage.clickToLogoutLink();
	}

	@AfterTest
	public void afterTest() {
		driver.close();
	}

}
