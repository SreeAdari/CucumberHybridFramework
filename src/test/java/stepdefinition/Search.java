package stepdefinition;


import org.openqa.selenium.WebDriver;

import factory.DriverFactory;
import io.cucumber.java.en.*;
import junit.framework.Assert;
import pages.HomePage;
import pages.SearchPage;

public class Search {
	
	WebDriver driver;
	private HomePage homePage;
	private SearchPage searchPage;
	
	 
	@Given("User openes the application")
	public void User_openes_the_application() {
	    
		
			driver = DriverFactory.getDriver();
		
	}

	@When("User enters valid product {string} into the search box field")
	public void user_enters_valid_product_into_the_search_box_field(String validProduct) {
	   
	    homePage= new HomePage(driver);
		homePage.ValidProductSearch(validProduct);
	}

	@When("User clicks on search button")
	public void User_clicks_on_search_button() {
	  
		searchPage = homePage.searchButton();
	}

	@Then("User should get valid product displayed in search field")
	public void User_should_get_valid_product_displayed_in_search_field() {
	 
		Assert.assertTrue(searchPage.displayValidProductSearch());
      
	}
	@When("User enters invalid product {string} into search box field")
	public void User_enters_invalid_product_into_search_box_field(String invalidProduct) {
	 
		homePage= new HomePage(driver);
		homePage.inValidProductSearch(invalidProduct);
		
	}

	@Then("User should get a message about no product matching")
	public void User_should_get_a_message_about_no_product_matching() {
	   
		Assert.assertEquals("There is no product that matches the search criteria.",searchPage.warningMessage());
	}

	@When("User dont enter any product into search box field")
	public void User_dont_enter_any_product_into_search_box_field() {
		
		 homePage= new HomePage(driver);
	   
		//intentionally kept blank
	}


}
