package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utils.CommonUtils;
import utils.ElementUtils;

public class SearchPage {

	WebDriver driver;
	ElementUtils elementUtils;
	
	public SearchPage(WebDriver driver) {
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
		elementUtils = new ElementUtils(driver);
	}
	
	
	
	
	
	@FindBy(linkText="HP LP3065")
	private WebElement displayValidProduct;
	
	@FindBy(xpath="//input[@type='button']/following-sibling::p")
	private WebElement warningMessage;
	
	
	public boolean displayValidProductSearch() {
		
		return displayValidProduct.isDisplayed();
		}

	public String warningMessage() {
		
		return elementUtils.getTextFromElement(warningMessage, CommonUtils.EXPLICIT_WAIT_BASIC_TIME);
		
		
		
	}
}
