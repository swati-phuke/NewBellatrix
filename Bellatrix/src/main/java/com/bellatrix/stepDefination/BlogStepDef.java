package com.bellatrix.stepDefination;

import org.apache.http.impl.cookie.PublicSuffixDomainFilter;
import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;

import com.bellatrix.pages.BlogPage;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class BlogStepDef {
	WaitFor wait = new WaitFor();
	BlogPage page = PageFactory.initElements(HooksClass.driver, BlogPage.class);
	private static final Logger LOG = Logger.getLogger(BlogStepDef.class);
	@Given("Click on blog page")
	public void click_On_blog_Page() {
		page.clickOnblogbtn();
		LOG.info("Successfully open blog page");
	}
	
	@Given("click on blog page")
	public void click_on_blog_Page() {
		page.clickOnblogbtn();
	}
	@Then("click on manufacturer link")
	public void click_on_manufacture_link() {
		page.clicklink();
		LOG.info("successfully open manufacturer link of proton-k");
	}
	
	
	@Given("click on blogs page")
	public void click_on_blogs_Page() {
		page.clickOnblogbtn();
	}
	@Then("click on manufacturer link of Falcon")
	public void click_on_manufacture_link_falcon() {
		HooksClass.driver.executeScript("window.scrollBy(0,3500)");
		wait.implicitWait(5);
		page.clicklinkFalcon();
		LOG.info("successfully open manufacturer link of Falcon");
	}
	
	
	@Given("Open blog pages")
	public void click_on_proton() {
		page.clickOnblogbtn();;
		
	}
	@When("Click on Proton-k rocket")
	public void write_comment() {
		page.clickprotonName();
		HooksClass.driver.executeScript("window.scrollBy(0,5000)");
		wait.implicitWait(5);
		page.comment_sendkeys("Proton is best product");
		
	}
	@Then("fill the required fiels for comment post")
	public void fill_required_comment() {
		page.name_sendkeys("swati");
		page.email_sendkeys("phukeswati12@gmail.com");
		page.postComments();
		
	}
	@Then("get error msg")
	public void get_error_msg() {
	String text = page.geterrmsg();
	LOG.error(text);
	System.out.println("error msg"+ text);
	}


}
