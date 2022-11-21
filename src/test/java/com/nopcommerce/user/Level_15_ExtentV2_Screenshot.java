package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;

public class Level_15_ExtentV2_Screenshot extends BaseTest {
	WebDriver driver;
	UserHomePageObject homePage;
	UserRegisterPageObject registerPage;
	UserLoginPageObject loginPage;
	UserCustomerInforPageObject customerInforPage;
	String firstName, lastName, emailAddress, validPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

//		homePage = PageGeneratorManager.getUserHomePage(driver);
//
//		firstName = "TripleLee";
//		lastName = "Hino";
//		emailAddress = "TripleLee" + generateFakeNumber() + "@gmail.vn";
//		validPassword = "123456";
	}

	@Test
	public void User_01_Register(Method method) {
//		ExtentManager.startTest(method.getName(), "User_01_Register");
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 01: Navigate to 'Register' page");
//		registerPage = homePage.openRegisterPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 02: Enter to FirstName texbox with value is '" + firstName + "'");
//		registerPage.inputToFirstnameTextbox(firstName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 03: Enter to LastName texbox with value is '" + lastName + "'");
//		registerPage.inputToLastnameTextbox(lastName);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 04: Enter to Email texbox with value is '" + emailAddress + "'");
//		registerPage.inputToEmailTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 05: Enter to Password texbox with value is '" + validPassword + "'");
//		registerPage.inputToPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 06: Enter to Confirm Password texbox with value is '" + validPassword + "'");
//		registerPage.inputToConfirmPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 07: Click to 'Register' button");
//		registerPage.clickToRegisterButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Register - Step 08: Verify register success message is displayed");
//		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed....AAA.");
//		ExtentManager.endTest();
	}

	@Test
	public void User_02_Login(Method method) {
//		ExtentManager.startTest(method.getName(), "User_02_Login");
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 01: Navigate to 'Login' page");
//		homePage = registerPage.clickToLogoutLink();
//		loginPage = homePage.openLoginPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 02: Enter to Email texbox with value is '" + emailAddress + "'");
//		loginPage.inputToEmailTextbox(emailAddress);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 03: Enter to Password texbox with value is '" + validPassword + "'");
//		loginPage.inputToPasswordTextbox(validPassword);
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 04: Click to 'Login' button");
//		homePage = loginPage.clickToLoginButton();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 05: Verify 'My Account' link is displayed");
//		Assert.assertFalse(homePage.isMyAccountLinkDisplayed());
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 06: Navigate to 'My Account' page");
//		customerInforPage = homePage.openMyAccountPage();
//
//		ExtentManager.getTest().log(LogStatus.INFO, "Login - Step 07: Verify 'Customer infor' page is displayed");
//		Assert.assertFalse(customerInforPage.isCustomerInforPageDisplayed());
//		ExtentManager.endTest();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
