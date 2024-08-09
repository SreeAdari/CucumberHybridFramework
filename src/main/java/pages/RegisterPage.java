
package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class RegisterPage {

	WebDriver driver;
	ElementUtils elementUtils;

	public RegisterPage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}

	@FindBy(id = "input-firstname")
	private WebElement firstNameField;

	@FindBy(id = "input-lastname")
	private WebElement lastNameField;

	@FindBy(id = "input-email")
	private WebElement emailField;

	@FindBy(id = "input-telephone")
	private WebElement telephoneField;

	@FindBy(id = "input-password")
	private WebElement passwordField;

	@FindBy(id = "input-confirm")
	private WebElement confirmPasswordField;

	@FindBy(name = "agree")
	private WebElement agree;

	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;

	@FindBy(xpath = "//input[@name='newsletter' and @value='1']")
	private WebElement newsLetterOption;

	@FindBy(xpath = "//div[contains(@class,'alert-dismissible')]")
	private WebElement warningMessagForDuplicateEmail;

	@FindBy(xpath = "//input[@name='firstname']/following-sibling::div")
	private WebElement validationMessageForFirstName;

	@FindBy(xpath = "//input[@name='lastname']/following-sibling::div")
	private WebElement validationMessageForlastName;

	@FindBy(xpath = "//input[@name='email']/following-sibling::div")
	private WebElement validationMessageForEmail;

	@FindBy(xpath = "//input[@name='telephone']/following-sibling::div")
	private WebElement validationMessageForTelephone;

	@FindBy(xpath = "//input[@name='password']/following-sibling::div")
	private WebElement validationMessageForPassword;

	public void firstName(String firstNameText) {
		elementUtils.typeTextIntoElement(firstNameField, firstNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void lastName(String lastNameText) {
		elementUtils.typeTextIntoElement(lastNameField, lastNameText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void email(String emailFieldText) {
		elementUtils.typeTextIntoElement(emailField, emailFieldText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
	}

	public void telephone(String telephoneText) {
		elementUtils.typeTextIntoElement(telephoneField, telephoneText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void password(String passwordText) {
		elementUtils.typeTextIntoElement(passwordField, passwordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void confirmPassword(String confirmPasswordText) {
		elementUtils.typeTextIntoElement(confirmPasswordField, confirmPasswordText, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public void agreeCheckBox() {

		elementUtils.clickOnElement(agree, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public AccountSuccessPage continueButton() {
		elementUtils.clickOnElement(continueButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

		return new AccountSuccessPage(driver);
	}

	public void newsLetterOption() {
		elementUtils.clickOnElement(newsLetterOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String warningMessageText() {
		return elementUtils.getTextFromElement(warningMessagForDuplicateEmail, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String validationMessageForFirstName() {

		return elementUtils.getTextFromElement(validationMessageForFirstName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String validationMessageForlastName() {

		return elementUtils.getTextFromElement(validationMessageForlastName, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String validationMessageForEmail() {

		return elementUtils.getTextFromElement(validationMessageForEmail, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String validationMessageForTelephone() {

		return elementUtils.getTextFromElement(validationMessageForTelephone, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public String validationMessageForPassword() {

		return elementUtils.getTextFromElement(validationMessageForPassword, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

}
