package com.bellatrix.stepDefination;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.bellatrix.pages.CartPage;
import com.bellatrix.pages.ContactPage;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ContactStepDef {
	private static final Logger LOG = Logger.getLogger(ContactStepDef.class);
	ContactPage page = PageFactory.initElements(HooksClass.driver, ContactPage.class);
	
	
	WaitFor scroll = new WaitFor();
	@Given("Click on contact button")
	public void openContactForm() {
		page.contactForm();
		
	}
	@Then("Contact form display successfully")
	public void displayContactForm() {
		
	}
	
	
@Given("Open the contact form")
public void open_the_contact_form() {
  page.contactForm();  
}

@When("Fill the form incomplete")
public void fill_info_in_field_and_leave_one_blank_field() throws InterruptedException {
	page.firstNameMethod("swati");
	page.lastName("Phuke");
	page.email("phukeswati!02@gmail.com");
	scroll.scrollby();
	page.bronzeOnclick();
	
	page.session1Onclick();
	scroll.scrollby();
	page.yesOnclick();
	
	Thread.sleep(2000);
	
	page.submitOnclick();
    
}

@Then("Form should not submit")
public void click_on_sumit_and_check_massage_that_fill_required_field() throws InterruptedException {
	
   String msg = page.massage();
   System.out.println(msg);
   
}

@Given("Open the contact form1")
public void open_the_contact_formpage() {
  page.contactForm();  
}

@When("Fill the form completely")
public void fill_info_in_field_() throws InterruptedException {
	page.firstNameMethod("swati");
	page.lastName("Phuke");
	page.email("phukeswati!02@gmail.com");
	scroll.scrollby();
	page.bronzeOnclick();
	
	page.session1Onclick();
	
	page.yesOnclick();
	
	scroll.scrollby();;
	scroll.implicitWait(1);
	page.captchaOnclick();
	
}

@Then("Form should submit successfully")

public void click_on_submit_button() throws InterruptedException {
	page.submitOnclick();
}

@When("Fill the form with incorrect information")
public void fill_info() {
	page.firstNameMethod("1234");
	page.lastName("2@#$");
	page.email("@34556");
	page.bronzeOnclick();
	page.session1Onclick();
	page.yesOnclick();
	scroll.scrollby();
	scroll.implicitWait(1);
	page.captchaOnclick();
}







}
