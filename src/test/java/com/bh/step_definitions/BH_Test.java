package com.bh.step_definitions;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;

import com.bh.pages.BHHomePage;
import com.bh.pages.ResultPage;
import com.bh.pages.TestPages;
import com.bh.utilities.Config;
import com.bh.utilities.Driver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BH_Test {
	String email;
	TestPages tp = new TestPages();
	BHHomePage bhh = new BHHomePage();

	@Given("^The user navigates the BHUrl$")
	public void the_user_navigates_the_BHUrl() throws Throwable {
		Driver.getInstance().get(Config.getProperty("urlBH"));
	}

	@When("^The user goes to tmep email Url and create a temporary email$")
	public void the_user_goes_to_tmep_email_Url_and_create_a_temporary_email() throws Throwable {
		Driver.getInstance().get(Config.getProperty("urlTE"));
		TestPages tp = new TestPages();
		email = tp.tempEmail.getAttribute("value");
		System.out.println(email);
	}

	@When("^The user navigates back to BHUrl$")
	public void the_user_navigates_back_to_BHUrl() throws Throwable {

		Driver.getInstance().navigate().back();
	}

	@When("^The user goes to My Account and clicks the create a B&H Account$")
	public void the_user_goes_to_My_Account_and_clicks_the_create_a_B_H_Account() throws Throwable {

		Actions act = new Actions(Driver.getInstance());
		act.moveToElement(bhh.logInWait).perform();
		Thread.sleep(2000);
		bhh.myAccount.click();
	}

	@When("^The user fills out the form$")
	public void the_user_fills_out_the_form() throws Throwable {

		Driver.getInstance().switchTo().frame("loginframe");
		Thread.sleep(1000);
		bhh.firstName.sendKeys(Config.getProperty("fName"));
		bhh.lastName.sendKeys(Config.getProperty("lName"));
		bhh.emailElement.sendKeys(email);
		bhh.confirmEmail.sendKeys(email);
		bhh.password.sendKeys(Config.getProperty("password"));
		bhh.confirmPassword.sendKeys(Config.getProperty("password"));

	}

	// @When("^The user takes a screen-shot and store it$")
	// public void the_user_takes_a_screen_shot_and_store_it() throws Throwable
	// {
	// Write code here that turns the phrase above into concrete actions
	// throw new PendingException();
	// }

	@When("^The user clicks the register$")
	public void the_user_clicks_the_register() throws Throwable {
		Thread.sleep(3000);
		bhh.registerButton.click();
		System.out.println(Driver.getInstance().getTitle());
	}

	@When("^The user navigate to main page$")
	public void the_user_navigate_to_main_page() throws Throwable {
		String myTitle = "B&H Photo Video Digital Cameras, Photography, Camcorders";
		Assert.assertTrue(myTitle.equals(Driver.getInstance().getTitle()));
	}

	@When("^The user search for item ?Canon eos (\\d+)d mark iii?$")
	public void the_user_search_for_item_Canon_eos_d_mark_iii(int arg1) throws Throwable {
		Thread.sleep(2000);
		bhh.search.click();
		bhh.search.sendKeys(Config.getProperty("camera") + Keys.ENTER);
	}

	@Then("^The user captures the first price and decide whether it is morethan the budget and prints an advise$")
	public void the_user_captures_the_first_price_and_decide_whether_it_is_more_than_the_budget_and_prints_an_advise()
			throws Throwable {
		ResultPage result = new ResultPage();
		String firstPrice = result.price.getText().substring(1, 6).replace(",", "");
		// String firstPrice=result.getText().replace("$","").replace(",","");
		int myNumber = Integer.valueOf(Config.getProperty("budget"));
		int budgetNumber = Integer.valueOf(firstPrice);

		if (myNumber > budgetNumber) {
			;
			System.out.println("Don'tttt buy it, forget it, it is over the budget!");
		} else {
			System.out.println("Enjoy! Take good pictures");
		}

		System.out.println(firstPrice + " is within your budget. You can go ahead and purchase!");
	}

}
