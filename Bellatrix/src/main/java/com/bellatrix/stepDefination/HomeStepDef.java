package com.bellatrix.stepDefination;

import static org.testng.Assert.assertThrows;

import java.io.IOException;
import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.devtools.v113.page.Page;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.bellatrix.keyword.Keyword;
import com.bellatrix.pages.HomePage;
import com.bellatrix.utilities.FileUtil;
import com.bellatrix.utilities.WaitFor;

import groovyjarjarantlr4.v4.parse.ANTLRParser.throwsSpec_return;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class HomeStepDef {
	WaitFor wait = new WaitFor();
	private static final Logger LOG = Logger.getLogger(HomeStepDef.class);

	Keyword keyword = new Keyword();
	HomePage page = PageFactory.initElements(HooksClass.driver, HomePage.class);
	
	String ProductName;

	@Given("Row number {int}")
	public void rowNum(int row) throws IOException {
		FileUtil excel = new FileUtil();
		String[] data = excel.getRowFromExcel(
				"C:/Users/DELL/eclipse-workspace/Test/Bellatrix/src/test/resources/BellatrixProductName.xlsx",
				"ProductName", row);
		this.ProductName = data[1];
	}

	@When("Retrive data from excel sheet")
	public void enter_Product_Name() {
		page.searchBox(ProductName);
	}

	@Then("Verify product title must contain product name")
	public void get_ProductTitle() {
		List<String> title = page.getProductList();
		
		for (String ProductTitle : title) {
			Assert.assertTrue(ProductTitle.contains(ProductName));
			LOG.info("Required product list successfully display ="+ ProductTitle);

		}
	
	}
	

	@Given("Application is launched completely")
	public void application_launched_is_complatly() {
		// keyword.launchURL("https://demos.bellatrix.solutions");

	}

	@When("User searches Falcon in searchComponent")

	public void user_searches_falcon_in_search_component() {
		page.searchBox("Flacon");
	}

	@Then("All result must contain Falcon word in product title")
	public void all_result_must_contain_falcon_word_in_product_title() {
		List<String> title = page.getProductList();
		
		for (String productName : title) {
			
			Assert.assertTrue(productName.contains("Falcon"));
			LOG.info(productName);

		}
		
		}
	
	
	@Given("The user on the website with dropDown list")
	public void see_drop_down_list() throws InterruptedException {
		
	}
	@When("The user click on the dropDown list")
	public void click_on_drop_down_list() throws InterruptedException {
		page.clickOnDropDownList();
	}

	@And("The user select option sort by price:low to high from dropDown list")
	public void selectDropDownOption() {
		page.handleDropDownList("price");
		
	}
	@Then("The user should see the corrosponding contain for sort by price: low to high")
	public void verifyProductPriceLowToHigh() {
		page.sortPriceList();
		
	}
	
	@Given("Open the homePage")
	public void search_the_product() {
		page.clickOnHomePage();

	}

	@Then("Get information about product")
	public void click_on_readmore_buttton_and_get_information_about_product() throws Exception {
		HooksClass.driver.executeScript("window.scrollBy(0,500)");
		wait.implicitWait(3);
		page.clickOnReadMoreBtn();
		wait.implicitWait(3);
		String description = page.getInfoaboutProduct();
		
		LOG.info(description);

	}
	
	@Given("Open myntra")
	public void open() {
		HooksClass.driver.get("https://www.myntra.com/");
		throw new ArrayIndexOutOfBoundsException();
	}

	
	

	}


