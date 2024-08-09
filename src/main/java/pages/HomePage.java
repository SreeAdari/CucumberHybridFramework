package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class HomePage {

	WebDriver driver;
	ElementUtils elementUtils;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);

	}

	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropMenu;

	@FindBy(linkText = "Login")
	private WebElement loginOption;

	@FindBy(linkText = "Register")
	private WebElement registation;

	@FindBy(xpath = "//div[@id='search']/input")
	private WebElement validProductSearch;

	@FindBy(xpath = "//span[contains(@class,'group-btn')]/button")
	private WebElement searchButton;

	@FindBy(xpath = "//div[@id='search']/input")
	private WebElement inValidProductSearch;

	public void clickOnmyAccount() {

		elementUtils.clickOnElement(myAccountDropMenu, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public LoginPage clickOnLoginOption() throws InterruptedException {
		elementUtils.clickOnElement(loginOption, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new LoginPage(driver);

	}

	public RegisterPage clickOnRegistrationOption() {
		elementUtils.clickOnElement(registation, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new RegisterPage(driver);
	}

	public void ValidProductSearch(String validProduct) {
		elementUtils.typeTextIntoElement(validProductSearch, validProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

	public SearchPage searchButton() {
		elementUtils.clickOnElement(searchButton, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		return new SearchPage(driver);
	}

	public void inValidProductSearch(String invalidProduct) {

		elementUtils.typeTextIntoElement(inValidProductSearch, invalidProduct, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);

	}

}
