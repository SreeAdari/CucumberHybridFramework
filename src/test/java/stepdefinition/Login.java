package stepdefinition;

import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
import pages.AccountPage;
import pages.HomePage;
import pages.LoginPage;
import utils.CommonUtils;

public class Login {

    WebDriver driver;
    private LoginPage loginPage;
    AccountPage accPage;
    CommonUtils commonUtils;
    
    
	@Given("User navigates to login page")
	public void User_navigates_to_login_page() throws InterruptedException {

	   
		driver = DriverFactory.getDriver();
		HomePage homePage = new HomePage(driver);
		homePage.clickOnmyAccount();
		loginPage=homePage.clickOnLoginOption();
		
	}
	
	@When("^User enters valid email address (.+) into email field$")
	public void User_enters_valid_email_address_into_email_field(String emailText) {

		
		loginPage.emailField(emailText);
	}

	@And("^User had entered valid password (.+) into password field$")
	public void User_had_entered_valid_password_into_password_field(String passwordText) {

		loginPage.passwordField(passwordText);
	}

	

	@And("User clicks on login button")
	public void User_clicks_on_login_button() {

		accPage=loginPage.loginButton();
		  //Assert.fail();   // Intentionally failing because screenshot 
	}

	@Then("User should get logged in successfully")
	public void User_should_get_logged_in_successfully() {
		

		Assert.assertTrue(accPage.accountInformation());
	}

	@When("User enters invalid email address into email field")
	public void User_enters_invalid_email_address_into_email_field() {

		commonUtils= new CommonUtils();
		loginPage.emailField(commonUtils.getEmailWithTimeStamp());
		
	}

	@When("User enters invalid password {string} into password field")
	public void User_enters_invalid_password_into_password_field(String passwordText) {

		
		loginPage.passwordField(passwordText);
		
	}

	@Then("User should get proper warning message about credentials mismatch")
	public void User_should_get_proper_warning_message_about_credentials_mismatch() {
		
	

		Assert.assertTrue(loginPage.validationMessage()
				.contains("Warning: No match for E-Mail Address and/or Password."));
	}

	@When("User dont enter email id into the email field")
	public void User_dont_enter_email_id_into_the_email_field() {

		loginPage.emailField("");
		
	}

	@When("User dont enter password into the password field")
	public void User_dont_enter_password_into_the_password_field() {

		
		loginPage.passwordField("");
	}

}
