package com.nopcommerce.user;

import java.util.Random;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageFactory.HomePageObject;
import pageFactory.LoginPageObject;
import pageFactory.RegisterPageObject;


public class Level_05_Page_Factory_Login extends BaseTest {
	private WebDriver driver;
	private String firstName, lastName, invalidEmail, notFoundEmail, existingEmail, validPassword, invalidPassword;
	private HomePageObject homePage;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = new HomePageObject(driver);

		firstName = "TripleLee";
		lastName = "Hino";
		invalidEmail = "Lee@" + generateFakeNumber() + "@gmail.vn";
		existingEmail = "TripleLee" + generateFakeNumber() + "@gmail.vn";
		notFoundEmail = "Hino" + generateFakeNumber() + "@gmail.net";
		validPassword = "123456";
		invalidPassword = "654321";

		System.out.println("Re-Condition - Step 01: Click to Register link");
		homePage.clickToRegisterLink();

		registerPage = new RegisterPageObject(driver);

		System.out.println("Re-Condition - Step 02: input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(existingEmail);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Re-Condition - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Re-Condition - Step 04: Verify Success Message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Re-Condition - Step 05: Click to Logout link");
		registerPage.clickToLogoutLink();
		homePage = new HomePageObject(driver);

	}

	@Test
	public void Login_01_Empty_Data() {
		System.out.println("Login - Step 01: Click to Register link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login - Step 02: Click to Login Button");
		loginPage.clickToLoginButton();

		System.out.println("Login - Step 03: Verify Error Message");
		Assert.assertEquals(loginPage.getErrorMesssageAtEmailTextbox(), "Please enter your email");

	}

	@Test
	public void Login_02_Invalid_Email() {
		System.out.println("Login - Step 01: Click to Register link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login - Step 02: Click to Login Button");
		loginPage.inputToEmailTextbox(invalidEmail);
		loginPage.clickToLoginButton();

		System.out.println("Login - Step 03: Verify Error Message");
		Assert.assertEquals(loginPage.getErrorMesssageAtEmailTextbox(), "Wrong email");

	}

	@Test
	public void Login_03_Not_Found_Email() {
		System.out.println("Login - Step 01: Click to Register link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login - Step 02: Click to Login Button");
		loginPage.inputToEmailTextbox(notFoundEmail);
		loginPage.clickToLoginButton();

		System.out.println("Login - Step 03: Verify Error Message");
		Assert.assertEquals(loginPage.getErrorMesssageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nNo customer account found");

	}

	@Test
	public void Login_04_Existing_Email_Empty_Password() {
		System.out.println("Login - Step 01: Click to Register link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login - Step 02: Click to Login Button");
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox("");
		loginPage.clickToLoginButton();

		System.out.println("Login - Step 03: Verify Error Message");
		Assert.assertEquals(loginPage.getErrorMesssageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_05_Existing_Email_Incorrect_Password() {
		System.out.println("Login - Step 01: Click to Register link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login - Step 02: Click to Login Button");
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(invalidPassword);
		loginPage.clickToLoginButton();

		System.out.println("Login - Step 03: Verify Error Message");
		Assert.assertEquals(loginPage.getErrorMesssageUnsuccessfull(), "Login was unsuccessful. Please correct the errors and try again.\nThe credentials provided are incorrect");

	}

	@Test
	public void Login_06_Valid_Email_Password() {
		System.out.println("Login - Step 01: Click to Register link");
		homePage.clickToLoginLink();

		loginPage = new LoginPageObject(driver);

		System.out.println("Login - Step 02: Click to Login Button");
		loginPage.inputToEmailTextbox(existingEmail);
		loginPage.inputToPasswordTextbox(validPassword);
		loginPage.clickToLoginButton();

		System.out.println("Login - Step 03: Verify Succece Message");
		homePage = new HomePageObject(driver);

		Assert.assertTrue(homePage.isMyAccountLinkDisplay());

	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

	public int generateFakeNumber() {
		Random random = new Random();
		return random.nextInt(9999);
	}

}
