package com.bellatrix.stepDefination;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.bellatrix.pages.CartPage;
import com.bellatrix.pages.HomePage;
import com.bellatrix.utilities.WaitFor;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class CartStepDef {
	
	private static final Logger LOG = Logger.getLogger(CartStepDef.class);
	CartPage page = PageFactory.initElements(HooksClass.driver, CartPage.class);
	HomePage homepage = PageFactory.initElements(HooksClass.driver, HomePage.class);
	WaitFor wait = new WaitFor();
	@Given("Search product in search box")
	public void search_product_in_search_box() {
	  homepage.searchBox("Falcon 9");
	  
	}

	@When("Click on Add to cart btn1")
	public void click_on_add_to_cart_btn() {
		
		wait.implicitWait(1);
		page.scrollby();
		
      page.clickOnAddTOCartBtn();
	    
	}

	@Then("View cart btn successfully displayed")
	public void display_view_cart_btn() { 
	String title =	page.getViewBTN();
	LOG.info("Button Name"+title);
	System.out.println("Button Name :"+ title);
		
	} 
	
	@Given("Search the product in search box")
	public void search_product1_in_search_box() {
			  homepage.searchBox("Falcon 9");
	}
	@When("Click on add to cart btn")
	public void click_on_add_to_cart_btn1() {
		wait.implicitWait(1);
		page.scrollby();
		
      page.clickOnAddTOCartBtn();
	    
	}
	@And ("Click on View cart btn")
	public void clickOnViewBtn() {
		 page.clickOnViewBtn();
	}
	
	@Then("Product should display in cart")
	public void productShouldDisplayInCart() {
	 
	String text = page.productText();
	String productName = page.product();
	LOG.info(text+"= "+productName );
	
	}
	
	@Given("Search product1 in search box")
	public void search_Product1_in_Search_box() {
			  homepage.searchBox("Falcon 9");
	}
	@When("Click on add to cart button")
	public void click_On_Add_to_Cart_Btn1() {
		wait.implicitWait(3);
		page.scrollby();
		
      page.clickOnAddTOCartBtn();
	    
	}
	@Then("Product quantity should display in cart")
	public void click_on_view_cart_btn_and_display_price() {
	String text = page.quantityText();
	String productName = page.quantity();
	LOG.info(text+"= "+productName );
	
	}
	
	@Given("Search Product in searchbox")
	public void search_Product2_in_Search_box() {
			  homepage.searchBox("Falcon 9");
	}
	@When("Click on add to cart button2")
	public void click_On_Add_to_Cart_Btn2() {
		wait.implicitWait(3);
		page.scrollby();
		page.clickOnAddTOCartBtn();
	    
	}
	@Then("Product subtotal should display in cart")
	public void productSubtotalDisplay() {
    String text = page.subTotalText();
	String productName = page.subTotal();
	LOG.info(text+"= "+productName );
	
	}
	
	String subprice;
	String vatprice;
	String price;
	String total;
	@Given("Get value of subtotal and vat")
	public void get_value_of_subtotal_and_vat() {
	homepage.searchBox("Falcon 9");
	page.scrollby();
		page.clickOnAddTOCartBtn();
		wait.implicitWait(1);
		page.clickOnViewBtn();
		page.scrollby();
		 subprice = page.cartsubTotalp();
		vatprice = page.vatprice();
	}
	@When("Add subtotal and vat")
public void add_subtotal_and_vat() {
	 price = subprice+vatprice;
	 total = page.totalprice();
	}
	@Then("Subtotal and vat should equal with Total")
	public void compare_subtotal_and_vat_with_total() {
		 total = page.totalprice();
		Assert.assertEquals(total, price);
		
	}
	

}
