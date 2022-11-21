package com.nopcommerce.user;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import com.nopcommerce.data.UserDataMapper;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import reportConfig.ExtentTestManager;

public class Level_20_Manage_Data_Part_IV extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	private String firstName, lastName, emailAddress, validPassword;
	private String date, month, year;
	UserDataMapper userData;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);
		userData = UserDataMapper.getUserData();

		firstName = userData.getFirstName();
		lastName = userData.getLastName();
		emailAddress = userData.getEmailAddress() + generateFakeNumber() + "@fakeremail.com";
		validPassword = userData.getPassword();
		date = userData.getDate();
		month = userData.getMonth();
		year = userData.getYear();

	}

	@Test
	public void User_01_Register(Method method) {
		ExtentTestManager.startTest(method.getName(), "MVN-User_01_Register");
		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 01: Navigate to 'Register' page");
		log.info("Register - Step 01: Navigate to 'Register' page");
		registerPage = homePage.openRegisterPage();

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 02: Enter to Radio Button with value is Male");
		log.info("Register - Step 02: Enter to Radio Button with value is Male");
		registerPage.clickToRadioButonByLabel(driver, "Male");

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 03: Enter to FirstName texbox with value is '" + firstName + "'");
		log.info("Register - Step 03: Enter to FirstName texbox with value is '" + firstName + "'");
		registerPage.inputToTextboxByID(driver, "FirstName", firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 04: Enter to LastName texbox with value is '" + lastName + "'");
		log.info("Register - Step 04: Enter to LastName texbox with value is '" + lastName + "'");
		registerPage.inputToTextboxByID(driver, "LastName", lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 05: Select to Date dropdown with value is '" + date + "'");
		log.info("Register - Step 05: Select to Date dropdown with value is '" + date + "'");
		registerPage.inputToDropdownByName(driver, "DateOfBirthDay", date);

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 06: Enter to Month dropdow with value is '" + month + "'");
		log.info("Register - Step 06: Enter to Month dropdow with value is '" + month + "'");
		registerPage.inputToDropdownByName(driver, "DateOfBirthMonth", month);

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 07: Enter to Year dropdow with value is '" + year + "'");
		log.info("Register - Step 07: Enter to Year dropdow with value is '" + year + "'");
		registerPage.inputToDropdownByName(driver, "DateOfBirthYear", year);

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 08: Enter to Email texbox with value is '" + emailAddress + "'");
		log.info("Register - Step 08: Enter to Email texbox with value is '" + emailAddress + "'");
		registerPage.inputToTextboxByID(driver, "Email", emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 09: Enter to Checkbox with value is Newsletter");
		log.info("Register - Step 09: Enter to Checkbox with value is Newsletter");
		registerPage.clickToCheckboxByLabel(driver, "Newsletter");

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 10: Enter to Password texbox with value is '" + validPassword + "'");
		log.info("Register - Step 10: Enter to Password texbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "Password", validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - tep 11: Enter to Confirm Password texbox with value is '" + validPassword + "'");
		log.info("Register - Step 11: Enter to Confirm Password texbox with value is '" + validPassword + "'");
		registerPage.inputToTextboxByID(driver, "ConfirmPassword", validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 12: Click to 'Register' button");
		log.info("Register - Step 12: Click to 'Register' button");
		registerPage.clickToButtonByText(driver, "Register");

		ExtentTestManager.getTest().log(Status.INFO, "Register_MVN_Framework - Step 13: Verify register success message is displayed");
		log.info("Register - Step 13: Verify register success message is displayed");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

	}

	@Test
	public void User_02_Login(Method method) {
		ExtentTestManager.startTest(method.getName(), "MVN-User_02_Login");
		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 01: Navigate to 'Login' page");
		log.info("Login - Step 01: Navigate to 'Login' page");
		homePage = registerPage.clickToLogoutLink();
		loginPage = homePage.openLoginPage();

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 02: Enter to Email texbox with value is '" + emailAddress + "'");
		log.info("Login - Step 02: Enter to Email texbox with value is '" + emailAddress + "'");
		loginPage.inputToTextboxByID(driver, "Email", emailAddress);

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 03: Enter to Password texbox with value is '" + validPassword + "'");
		log.info("Login - Step 03: Enter to Password texbox with value is '" + validPassword + "'");
		loginPage.inputToTextboxByID(driver, "Password", validPassword);

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 04: Click to 'Login' button");
		log.info("Login - Step 04: Click to 'Login' button");
		loginPage.clickToButtonByText(driver, "Log in");
		homePage = PageGeneratorManager.getUserHomePage(driver);

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 05: Verify 'My Account' link is displayed");
		log.info("Login - Step 05: Verify 'My Account' link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_My_Account(Method method) {
		ExtentTestManager.startTest(method.getName(), "MVN-User_03_My_Account");
		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 01: Navigate to 'My Account' page");
		log.info("Login - Step 01: Navigate to 'My Account' page");
		customerInforPage = homePage.openMyAccountPage();

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 02: Verify 'Customer infor' page is displayed");
		log.info("Login - Step 02: Verify 'Customer infor' page is displayed");
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 03: Verify 'First name' is correctly");
		log.info("Login - Step 03: Verify 'First name' is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "FirstName"), firstName);

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 04: Verify 'Last name' is correctly");
		log.info("Login - Step 04: Verify 'Last name' is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "LastName"), lastName);

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 05: Verify 'Date of birth' is correctly with Date");
		log.info("Login - Step 05: Verify 'Date of birth' is correctly with Date");
		Assert.assertEquals(customerInforPage.getDropdownValueByName(driver, "DateOfBirthDay"), date);

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 06: Verify 'Date of birth' is correctly with Month");
		log.info("Login - Step 06: Verify 'Date of birth' is correctly with Month");
		Assert.assertEquals(customerInforPage.getDropdownValueByName(driver, "DateOfBirthMonth"), "2");

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 07: Verify 'Date of birth' is correctly with Year");
		log.info("Login - Step 07: Verify 'Date of birth' is correctly with Year");
		Assert.assertEquals(customerInforPage.getDropdownValueByName(driver, "DateOfBirthYear"), year);

		ExtentTestManager.getTest().log(Status.INFO, "Login_MVN_Framework - Step 08: Verify 'Email' is correctly");
		log.info("Login - Step 08: Verify 'Email' is correctly");
		Assert.assertEquals(customerInforPage.getTextboxValueByID(driver, "Email"), emailAddress);

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserAndDriver();
	}

}
