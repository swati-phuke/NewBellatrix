package com.bellatrix.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bellatrix.stepDefination.HooksClass;

public class CartPage {
	private static final Logger LOG = Logger.getLogger(CartPage.class);
	@FindBy(css = "a[aria-label='Add “Falcon 9” to your cart']")
	WebElement addTocartBtn;

	public void clickOnAddTOCartBtn() {
		addTocartBtn.click();

	}

	@FindBy(css = "a[title='View cart']")
	WebElement view_Cart;

	public String getViewBTN() {
		String title = view_Cart.getText();
		return title;

	}

	public void clickOnViewBtn() {
		view_Cart.click();
	}

	public void scrollby() {
		HooksClass.driver.executeScript("window.scrollBy(0,2000)");
	}

	@FindBy(css = "th[class='product-name']")
	WebElement getProductTextName;

	public String productText() {
		String title = getProductTextName.getText();
		return title;
	}

	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(3) a:nth-child(1)")
	WebElement getProductName;

	public String product() {
		String title = getProductName.getText();
		return title;
	}

	@FindBy(css = "th[class='product-price']")
	WebElement priceText;

	public String priceText() {
		String title = priceText.getText();
		return title;

	}

	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(4) span:nth-child(1) bdi:nth-child(1)")
	WebElement price;

	public String price() {
		String title = price.getText();
		return title;

	}
	@FindBy(css = "th[class='product-quantity']")
	WebElement quantityText;

	public String quantityText() {
		String title = quantityText.getText();
		return title;

	}
	@FindBy(css = "#quantity_653f481b75789")
	WebElement quantity;

	public String quantity() {
		String title = quantity.getText();
		return title;

	}
	@FindBy(css = "th[class='product-subtotal']")
	WebElement subTotalText;

	public String subTotalText() {
		String title = subTotalText.getText();
		return title;

	}
	@FindBy(css = "tbody tr:nth-child(1) td:nth-child(6) span:nth-child(1) bdi:nth-child(1)")
	WebElement subTotal;

	public String subTotal() {
		String title = subTotal.getText();
		return title;

	}
	@FindBy(css = "tr[class='cart-subtotal'] th")
	WebElement cartsubTotal;

	public String cartsubTotal() {
		String title = cartsubTotal.getText();
		return title;

	}
	@FindBy(css = "tr[class='cart-subtotal'] bdi:nth-child(1)")
	WebElement cartsubTotalp;

	public String cartsubTotalp() {
		String title = cartsubTotalp.getText();
		return title;

	}
	@FindBy(css = "tr[class='tax-total'] th")
	WebElement vat;

	public String vat() {
		String title = vat.getText();
		return title;

	}
	@FindBy(css = "td[data-title='VAT']")
	WebElement vatprice;

	public String vatprice() {
		String title = vat.getText();
		return title;

	}
	@FindBy(css = "tr[class='order-total'] th")
	WebElement total;

	public String total() {
		String title = total.getText();
		return title;

	}
	@FindBy(css = "tr[class='order-total'] bdi:nth-child(1)")
	WebElement totalprice;

	public String totalprice() {
		String title = totalprice.getText();
		return title;

	}
	@FindBy( css = "a[title='View your shopping cart']")
	WebElement symboladdtocart;
	public void addcartMethod() {
		symboladdtocart.click();
	}
	
	
}