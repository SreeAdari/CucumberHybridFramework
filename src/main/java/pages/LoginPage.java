package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class LoginPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public LoginPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(id = "input-email")
	private WebElement emailTextField;

	@FindBy(name = "password")
	private WebElement passwordTextField;

	@FindBy(xpath = "//input[@value='Login']")
	private WebElement loginButton;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement validationMessage;

	public void emailField(String emailText) {
		
		elementUtils.typeTextIntoElement(emailTextField, emailText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void passwordField(String passwordText) {
		elementUtils.typeTextIntoElement(passwordTextField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String validationMessage() {
		return elementUtils.getTextFromElement(validationMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
	}

	public AccountPage loginButton() {
		elementUtils.clickOnElement(loginButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new AccountPage(driver);
	}

}
