
package stepDefinitions;
import io.cucumber.java.en.*;



import org.openqa.selenium.WebDriver;


import base.TestBase;
import factory.DriverFactory;

import pages.*;

public class StepDefinitions {

	WebDriver driver;
	TestBase testbase = new TestBase();
	LoginPage loginPage;
	HomePage homePage;
	MenuPage menuPage;

	@Given("I open the browser")
	public void i_open_the_browser() {
		String browser = System.getProperty("browser", "chrome");
		driver = testbase.init_driver(browser);
		DriverFactory.setDriver(driver);
	} 

	@And("I navigate to {string}")
	public void i_navigate_to(String url) {
		driver.get(url);
		loginPage = new LoginPage(driver);
	}

	@When("I enter username {string}")
	public void i_enter_username(String user) {
		loginPage.enterUsername(user);
	}

	@When("I enter password {string}")
	public void i_enter_password(String pass) {
		loginPage.enterPassword(pass);
	}

	@When("I click the login button")
	public void i_click_the_login_button() {
		homePage = loginPage.clickLogin();
	}

	@Then("I should see the dashboard page")
	public void i_should_see_the_dashboard_page() {
		homePage.verifyDashboard();
	}

	@When("I click the Sauce labs Backpack item to cart")
	public void i_click_the_sauce_labs_backpack_iem_to_cart() {
		homePage.clickaddtocart();

	}

	@Then("I remove the the same item in cart")
	public void I_remove_the_same_item_in_cart() {
		homePage.viewyourcart();
		homePage.removeitem();
	}

	@When("I navigate to Menu page")
	public void i_navigate_to_Menu_page() {
		menuPage = homePage.goToMenuoptions();
	}

	@Then("I should see the Menu details")
	public void i_should_see_the_Menu_details() {
		menuPage.verifyMenuPage();
	}

	@When("I Click AllItems in Menu option")
	public void i_click_allitems_in_menu_option() {
		menuPage.clickAllitems();
	}


	@Then("I logout successfully")
	public void i_logout_successfully() {
		menuPage.logout();
		DriverFactory.closeDriver();
	}
}