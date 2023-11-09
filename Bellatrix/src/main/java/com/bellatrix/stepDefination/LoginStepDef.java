package com.bellatrix.stepDefination;

import javax.swing.text.html.CSS;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bellatrix.pages.LoginPage;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginStepDef {
	private static final Logger LOG = Logger.getLogger(LoginStepDef.class);
	LoginPage page = PageFactory.initElements(HooksClass.driver, LoginPage.class);
	WaitFor wait = new WaitFor();
	@Given("Click on myaccount btn")
	public void click_on_my_account_btn() {
		page.clickOnmyaccount();
		
	}
	@Then("Breadcrum should display")
	public void breadcrum() {
		String breadcrum = page.getBreadcrum();
		Assert.assertEquals("Home > My account", breadcrum);
		LOG.info("Breadcrum display homepage to loginpage" + breadcrum);
	}
	
	@When("Fill required field without email")
	public void fill_required_field() {
     page.password("12345678");
     wait.implicitWait(3);
     page.clickOncheckbox();
     page.clickOnloginbtn();
	}
	@Then("Error msg should display")
	public void get_massage() {
		wait.implicitWait(3);
		String msg = page.emailErrmsg();
		LOG.error( "error msg" + msg);
	}
	
	@When("Fill all required fields")
	public void fill_all_field() {
		 page.username("phukeswati104@gmail.com");
		 page.password("S1w@a#t8");
	     page.clickOncheckbox();	
	}
	@Then("Login successfully")
	public void login_successfully() {
		page.clickOnloginbtn();
	}
	
	@When("Fill email with incorrect value")
	public void fill_incorrect_value() {
		page.username("!%^#234");
		page.password("S1w@a#t8");
		page.clickOncheckbox();
	}
	@Then("Error msg should displayed")
	public void display_errormsg() {
		String msg = page.emailErrmsg();
		Assert.assertEquals("The username !%^#234 is not registered on this site.",msg);
	}
	
	
}
