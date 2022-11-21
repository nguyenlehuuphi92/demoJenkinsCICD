package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.common.Common_01_Register_End_User;

import commons.BaseTest;
import commons.PageGeneratorManager;
import pageObjects.nopCommerce.user.UserHomePageObject;
import pageObjects.nopCommerce.user.UserLoginPageObject;

public class Level_16_Share_Data_A extends BaseTest {
	private WebDriver driver;
	private UserHomePageObject homePage;
	private UserLoginPageObject loginPage;
	private String emailAddress, validPassword;

	@Parameters("browser")
	@BeforeClass
	public void beforeClass(String browserName) {
		driver = getBrowserDriver(browserName);
		homePage = PageGeneratorManager.getUserHomePage(driver);

		emailAddress = Common_01_Register_End_User.emailAddress;
		validPassword = Common_01_Register_End_User.Password;

		log.info("Re-Condition - Step 01: Navigate to 'Login' page");
		loginPage = homePage.openLoginPage();

		log.info("Re-Condition - Step 02: Enter to Email texbox with value is '" + emailAddress + "'");
		loginPage.inputToEmailTextbox(emailAddress);

		log.info("Re-Condition - Step 03: Enter to Password texbox with value is '" + validPassword + "'");
		loginPage.inputToPasswordTextbox(validPassword);

		log.info("Re-Condition - Step 04: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
	}

	@Test
	public void Search_01_Empty_Data() {
	
	}

	@Test
	public void Search_02_Relative_Product_Name() {
	
	}
	
	@Test
	public void Search_03_Absolute_Product_Name() {
	
	}
	
	@Test
	public void Search_04_Paraent_Category() {
	
	}
	
	@Test
	public void Search_05_Incorrect_Manufactorer() {
	
	}

	@Test
	public void Search_06_Correct_Manufactorer() {
	
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
