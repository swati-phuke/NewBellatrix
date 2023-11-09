package com.bellatrix.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bellatrix.utilities.WaitFor;

public class CheckoutPage {
	private static final Logger LOG = Logger.getLogger(CheckoutPage.class);
	WaitFor wait = new WaitFor();
	//ul[class='nav-menu'] li[class='page_item page-item-7 current_page_item'] a
	@FindBy(css="div:nth-child(2)>ul:nth-child(1)>li:nth-child(4)>a:nth-child(1)")
	WebElement checkout;
	public void clickOncheckout() {
		checkout.click();
	}
	@FindBy(css="input#billing_first_name")
	WebElement name;
	public void sendname(String name1) {
		name.sendKeys(name1);
	}
	@FindBy(css="input#billing_last_name")
	WebElement lastname;
	public void sendlastname(String name1) {
		name.sendKeys(name1);
	}
	
	@FindBy(css = "li:nth-child(3) strong:nth-child(1)")
	WebElement streetmsg;

	public String massage() {
		String title = streetmsg.getText();
		LOG.error("street name is required feed ");
		return title;

	}
	@FindBy(css = "li[data-id='billing_city'] ")
	WebElement townmsg;

	public String  townmassage() {
		String title = streetmsg.getText();
		LOG.error("town name is required feed ");
		return title;

	}
	@FindBy(css="button#place_order")
	WebElement placeorderbtn;
	public void placeOrderbtnOnclick() {
		placeorderbtn.click();
		
	}
	
	
	
}
