package stepdefinition;

import java.util.Date;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;
import utils.CommonUtils;

public class Register {

	WebDriver driver;
	 RegisterPage regPage;
	 HomePage homePage;
	 AccountSuccessPage accSuccPage;
	  CommonUtils commonUtils;
	

	@Given("User navigates to Registration page")
	public void User_navigates_to_registration_page() {

		 
		driver = DriverFactory.getDriver();
		homePage=new HomePage(driver);
		homePage.clickOnmyAccount();
	    regPage=homePage.clickOnRegistrationOption();
	}

	@When("User enters the details into below fields")
	public void User_enters_the_details_into_below_fields(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);


		
		regPage.firstName(dataMap.get("firstName"));
		regPage.lastName(dataMap.get("lastName"));
		commonUtils= new CommonUtils();
		regPage.email(commonUtils.getEmailWithTimeStamp());
		regPage.telephone(dataMap.get("telephone"));
		regPage.password(dataMap.get("password"));
		regPage.confirmPassword(dataMap.get("password"));

	}
	@When("User enters the details into below fields with duplicate email")
	public void User_enters_the_details_into_below_fields_with_duplicate_email(DataTable dataTable) {

		Map<String, String> dataMap = dataTable.asMap(String.class, String.class);

		regPage = new RegisterPage(driver);
		
		regPage.firstName(dataMap.get("firstName"));
		regPage.lastName(dataMap.get("lastName"));
		regPage.email(dataMap.get("email"));
		regPage.telephone(dataMap.get("telephone"));
		regPage.password(dataMap.get("password"));
		regPage.confirmPassword(dataMap.get("password"));
	}

	@When("User selects privacy policy")
	public void user_selects_privacy_policy() {
		
 regPage.agreeCheckBox();
		
	}

	@When("User clicks on continue button")
	public void user_clicks_on_continue_button() {

		accSuccPage=regPage.continueButton();
		
	}

	@Then("User account should get created successfully")
	public void user_account_should_get_created_successfully() throws InterruptedException {

		
		Assert.assertEquals("Your Account Has Been Created!",
				accSuccPage.accountRegistration());

	}

	@When("User selects Yes for Newsletter")
	public void user_selects_yes_for_newsletter() {

		regPage.newsLetterOption();
	}

	@Then("User should get proper warning message about duplicate email")
	public void User_should_get_proper_warning_message_about_duplicate_email() {

		Assert.assertTrue(regPage.warningMessageText()
				.contains("Warning: E-Mail Address is already registered!"));

	}

	@When("User dont enters any details into the page")
	public void User_dont_enters_any_details_into_the_page() {

		
		// intentionally kept blank
	}

	@Then("User should get proper warning messages for every mandatory field")
	public void User_should_get_proper_warning_messages_for_every_mandatory_field() {

		Assert.assertTrue(regPage.warningMessageText().contains("Warning: You must agree to the Privacy Policy!"));
		Assert.assertEquals("First Name must be between 1 and 32 characters!",regPage.validationMessageForFirstName());
		Assert.assertEquals("Last Name must be between 1 and 32 characters!",regPage.validationMessageForlastName());
		Assert.assertEquals("E-Mail Address does not appear to be valid!",regPage.validationMessageForEmail());
		Assert.assertEquals("Telephone must be between 3 and 32 characters!",regPage.validationMessageForTelephone());
		Assert.assertEquals("Password must be between 4 and 20 characters!",regPage.validationMessageForPassword());

	}
	
	

}
