package com.bellatrix.pages;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import org.springframework.core.type.filter.AbstractClassTestingTypeFilter;
import org.testng.Assert;

import com.bellatrix.stepDefination.HooksClass;
import com.bellatrix.utilities.WaitFor;

import groovy.util.logging.Log;

public class HomePage {
	private static final Logger LOG = Logger.getLogger(HomePage.class);
	@FindBy(css = "https://demos.bellatrix.solutions/")
	WebElement Searchurl;

	public void url() {
		Searchurl.click();

	}

	@FindBy(css = "nav>div:nth-child(2)>ul>li>a[href=\"https://demos.bellatrix.solutions/\"]")
	WebElement homepage;

	public void clickOnHomePage() {
		homepage.click();
	}

	@FindBy(css = "input#woocommerce-product-search-field-0")
	WebElement searchcomponant;

	public void searchBox(String productName) {

		searchcomponant.sendKeys(productName);
		searchcomponant.sendKeys(Keys.RETURN);
	}

	@FindBy(css = "h2[class*=title]")
	List<WebElement> listOFProduct;

	public List<String> getProductList() {
		List<String> title = new ArrayList<String>();
		for (WebElement productTitle : listOFProduct) {
			String text = null;
			try {
				text = (productTitle.getText());
				// i can apply the explicit wait for handle stale exception
				// wait code is write in utilyti package.

			} catch (StaleElementReferenceException e) {

				WaitFor.staleElement(productTitle);
				text = productTitle.getText();
			}
			title.add(text);
		}
		return title;

	}

	@FindBy(css = "form:nth-child(2) > select:nth-child(1)")
	List<WebElement> drop_Down_List;

	public List<String> getDropDownList() {
		List<String> title = new ArrayList<String>();
		for (WebElement titles : drop_Down_List) {
			title.add(titles.getText());

		}
		return title;

	}

	@FindBy(css = "form:nth-child(2) > select:nth-child(1)")
	WebElement drop_Down_List1;

	public void clickOnDropDownList() throws InterruptedException {
		Thread.sleep(4000);
		drop_Down_List1.click();
	}

	public void handleDropDownList(String value) {
		Select select = new Select(drop_Down_List1);
		if (select.isMultiple()) {
			LOG.info("true");
		} else {

		}
		select.selectByValue(value);
		LOG.info("==================================================");
	}

	@FindBy(css = "li>a[href=\"https://demos.bellatrix.solutions/product/proton-m/\"]:nth-child(2)")
	WebElement readMoreBtn;

	public void clickOnReadMoreBtn() {
		readMoreBtn.click();
	}

	@FindBy(css = "div[class='woocommerce-product-details__short-description'] p")
	WebElement readMorebtn_discription;

	public String getInfoaboutProduct() {
		String info = readMorebtn_discription.getText();

		System.out.println(info);
		return info;
	}

	@FindBy(css = "ul.products.columns-4 li")
	List<WebElement> getPrice;

	/*
	 * public List<String> getPriceLowToHigh() { List<String> title = new
	 * ArrayList<String>(); for (WebElement productTitle : getPrice) {
	 * title.add(productTitle.getText()) ; }
	 * 
	 * return title; }
	 */
	public void sortPriceList() {
		List<Long> priceList = new ArrayList();
		try {
			for (WebElement p : getPrice) {
				priceList.add(Long.valueOf(p.getText()));

			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		for (int i = 0; i < priceList.size() - 1; i++) {
			if (priceList.get(i) < priceList.get(i + 1)) {

			}
			Assert.fail("sort by price: low to high");
		}
	}
}
