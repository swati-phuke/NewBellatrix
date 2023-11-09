package com.bellatrix.stepDefination;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.bellatrix.pages.CheckoutPage;
import com.bellatrix.pages.ContactPage;
import com.bellatrix.pages.HomePage;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CheckoutStepDef {
	private static final Logger LOG = Logger.getLogger(ContactStepDef.class);
	CheckoutPage page = PageFactory.initElements(HooksClass.driver, CheckoutPage.class);
	HomePage page1 = PageFactory.initElements(HooksClass.driver, HomePage.class);
	WaitFor scroll = new WaitFor();
	@Given("Click on checkout button")
	public void click_on_checkout_btn() {
		page.clickOncheckout();
		LOG.info("Checkout form is open successfully");
	}
	
	@Given("Open the checkout form")
	public void open_checkout_form() {
		page.clickOncheckout();
	}
	@When("fill the form and skip some required field")
	public void fill_required_field() {
		
	page1.searchBox("Falcon 9");
		HooksClass.driver.executeScript("window.scrollBy(0,1000)");
		scroll.implicitWait(5);
		//scroll.scrollby();
		page.sendname("swati");
		page.sendlastname("Phuke");
		scroll.scrollby();
		scroll.implicitWait(4);
		page.placeOrderbtnOnclick();
		
	}
	@Then("should  display error msg")
	public void display_error_msg() {
		scroll.implicitWait(3);
	String info =	page.massage();
	LOG.info(info);
	System.out.println(info);
	}

}
