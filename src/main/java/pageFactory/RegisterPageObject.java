package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commons.BasePageFactory;

public class RegisterPageObject  extends BasePageFactory{
	private WebDriver driver;

	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id = "FirstName")
	private	WebElement firstNameTextbox;

	@FindBy(id = "LastName")
	private	WebElement lastNameTextbox;

	@FindBy(id = "Email")
	private	WebElement emailTextbox;

	@FindBy(id = "Password")
	private	WebElement passwordTextbox;

	@FindBy(id = "ConfirmPassword")
	private	WebElement confirmPasswordTextbox;

	@CacheLookup
	@FindBy(id = "register-button")
	private	WebElement registerButton;

	@FindBy(id = "FirstName-error")
	private	WebElement firstNameErrorMassage;

	@FindBy(id = "LastName-error")
	private	WebElement lastNameErrorMassage;

	@FindBy(id = "Email-error")
	private	WebElement emailErrorMassage;

	@FindBy(id = "Password-error")
	private	WebElement passwordErrorMassage;

	@FindBy(id = "ConfirmPassword-error")
	private	WebElement confirmPasswordErrorMassage;

	@FindBy(className = "result")
	private	WebElement registerSuccessMassage;

	@FindBy(className = "ico-logout")
	private	WebElement logoutLink;

	@FindBy(xpath  = "//div[contains(@class,'message-error')]//li")
	private	WebElement registerExistingEmail;
	
	public void clickToRegisterButton() {
		waitForElementClickable(driver, registerButton);
		clickToElement(driver, registerButton);
	}

	public String getErrorMessageAtFirstnameTextbox() {
		waitForElementVisible(driver, firstNameErrorMassage);
		return getElementText(driver, firstNameErrorMassage);
	}

	public String getErrorMessageAtLastnameTextbox() {
		waitForElementVisible(driver, lastNameErrorMassage);
		return getElementText(driver, lastNameErrorMassage);
	}

	public String getErrorMessageAtEmailTextbox() {
		waitForElementVisible(driver, emailErrorMassage);
		return getElementText(driver, emailErrorMassage);
	}

	public String getErrorMessageAtPasswordTextbox() {
		waitForElementVisible(driver, passwordErrorMassage);
		return getElementText(driver, passwordErrorMassage);
	}

	public String getErrorMessageAtConfirmPasswordTextbox() {
		waitForElementVisible(driver, confirmPasswordErrorMassage);
		return getElementText(driver, confirmPasswordErrorMassage);
	}

	public void inputToFirstnameTextbox(String fistName) {
		waitForElementVisible(driver, firstNameTextbox);
		sendkeyToElement(driver, firstNameTextbox, fistName);
	}

	public void inputToLastnameTextbox(String lastName) {
		waitForElementVisible(driver, lastNameTextbox);
		sendkeyToElement(driver, lastNameTextbox, lastName);
	}

	public void inputToEmailTextbox(String emailAddress) {
		waitForElementVisible(driver, emailTextbox);
		sendkeyToElement(driver, emailTextbox, emailAddress);
	}

	public void inputToPasswordTextbox(String password) {
		waitForElementVisible(driver, passwordTextbox);
		sendkeyToElement(driver, passwordTextbox, password);
	}

	public void inputToConfirmPasswordTextbox(String confirmPassword) {
		waitForElementVisible(driver, confirmPasswordTextbox);
		sendkeyToElement(driver, confirmPasswordTextbox, confirmPassword);
	}

	public String getRegisterSuccessMessage() {
		waitForElementVisible(driver, registerSuccessMassage);
		return getElementText(driver, registerSuccessMassage);
	}

	public void clickToLogoutLink() {
		waitForElementClickable(driver, logoutLink);
		clickToElement(driver, logoutLink);
	}

	public String getErrorExistingEmailMessage() {
		waitForElementVisible(driver, registerExistingEmail);
		return getElementText(driver, registerExistingEmail);
	}

	
	
	
	
}
