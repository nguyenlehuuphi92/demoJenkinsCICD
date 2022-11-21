package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserAddressPageObject;
import pageObjects.nopCommerce.user.UserCustomerInforPageObject;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;
import pageObjects.nopCommerce.user.UserMyProductReviewPageObject;
import pageObjects.nopCommerce.user.UserRegisterPageObject;
import pageObjects.nopCommerce.user.UserRewardPointPageObject;

public class Level_07_Switch_Page extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserRegisterPageObject registerPage;
	private UserLoginPageObject loginPage;
	private UserCustomerInforPageObject customerInforPage;
	 private UserAddressPageObject addressPage;
	 private UserMyProductReviewPageObject myProductReviewPage;
	 private UserRewardPointPageObject rewardPointPage;
	private String firstName, lastName, emailAddress, validPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);

		homePage = PageGeneratorManager.getUserHomePage(driver);

		firstName = "TripleLee";
		lastName = "Hino";
		emailAddress = "TripleLee" + generateFakeNumber() + "@gmail.vn";
		validPassword = "123456";
	}

	@Test
	public void User_01_Register() {
		System.out.println("Register Page - Step 01: Click to Register link");
		registerPage = homePage.openRegisterPage();

		System.out.println("Register Page - Step 02: input to required fields");
		registerPage.inputToFirstnameTextbox(firstName);
		registerPage.inputToLastnameTextbox(lastName);
		registerPage.inputToEmailTextbox(emailAddress);
		registerPage.inputToPasswordTextbox(validPassword);
		registerPage.inputToConfirmPasswordTextbox(validPassword);

		System.out.println("Register Page - Step 03: Click to Register button");
		registerPage.clickToRegisterButton();

		System.out.println("Register Page - Step 04: Verify Success Message");
		Assert.assertEquals(registerPage.getRegisterSuccessMessage(), "Your registration completed");

		System.out.println("Register Page - Step 05: Click to Logout link");
		homePage = registerPage.clickToLogoutLink();
	}

	@Test
	public void User_02_Login() {
		System.out.println("Login - Step 01: Click to Register link");
		loginPage = homePage.openLoginPage();

		System.out.println("Login - Step 02: Click to Login Button");
		loginPage.inputToEmailTextbox(emailAddress);
		loginPage.inputToPasswordTextbox(validPassword);

		homePage = loginPage.clickToLoginButton();
		System.out.println("Login - Step 03: Verify Succece Message");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}

	@Test
	public void User_03_Customer_Infor() {
		customerInforPage = homePage.openMyAccountPage();
		Assert.assertTrue(customerInforPage.isCustomerInforPageDisplayed());
	}

	@Test
	public void User_04_Switch_Page() {
		// Knowledge của page object
		// Một page A khi chuyển qua page B thì phải viết 1 hàm
		// (Action: open/ click/..... : click/ button/ image/....) Để mở page B  đó lên
		
		// Custormer Infor -> Address
		addressPage = customerInforPage.openAddressPage(driver);
		
		// Address -> My Product Review
		myProductReviewPage = addressPage.openMyProductReviewPage(driver);
		
		// My Product Review -> Reward Point
		rewardPointPage = myProductReviewPage.openRewardPointPage(driver);
		
		// Reward Point -> Address
		addressPage = rewardPointPage.openAddressPage(driver);
		
		// Address -> Reward Point
		rewardPointPage = addressPage.openRewardPointPage(driver);
		
		// Reward Point ->My Product Review
		myProductReviewPage = rewardPointPage.openMyProductReviewPage(driver);

		// My Product Review -> Address
		addressPage = myProductReviewPage.openAddressPage(driver);
		
		// Address	->	 Custormer Infor 
		addressPage = customerInforPage.openAddressPage(driver);
		
		customerInforPage = addressPage.openCustomerInforPage(driver);
		
		customerInforPage.openRewardPointPage(driver);
		
		rewardPointPage.openCustomerInforPage(driver);
		
		customerInforPage.openMyProductReviewPage(driver);
	}

	@Test
	public void User_05_Switch_Role() {
		// Role User -> Role Admin

		// Role Admin -> Role User
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
