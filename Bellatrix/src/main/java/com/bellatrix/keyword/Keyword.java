package com.bellatrix.keyword;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.bellatrix.stepDefination.HooksClass;

import java.util.ArrayList;
import java.util.List;
public class Keyword  {
	
	public void launchURL(String url) {
		HooksClass.getDriver().get(url);
	}

	public void enterText(WebElement e, String textToEnter) {
		e.sendKeys(textToEnter);
	}

	/**
	 * this method will be return only one WebElement
	 * 
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */

	public WebElement getWebElement(String locatorType, String locatorValue) {
		// locator Type mean - css,x-path,id,etc. locatorValue means = actual value,
		if (locatorType.equalsIgnoreCase("id")) {
			return HooksClass.driver.findElement(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return HooksClass.driver.findElement(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("cssSelector")) {
			return HooksClass.driver.findElement(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			return HooksClass.driver.findElement(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			return HooksClass.driver.findElement(By.tagName(locatorValue));
		} else {
			return null;
		}
	}
	/**
	 * This Method will be return List of WebElement
	 * @param locatorType
	 * @param locatorValue
	 * @return
7	 */

	public List<WebElement> getWebElements(String locatorType, String locatorValue) {
		if (locatorType.equalsIgnoreCase("id")) {
			return HooksClass.driver.findElements(By.id(locatorValue));
		} else if (locatorType.equalsIgnoreCase("xpath")) {
			return HooksClass.driver.findElements(By.xpath(locatorValue));
		} else if (locatorType.equalsIgnoreCase("cssSelector")) {
			return HooksClass.driver.findElements(By.cssSelector(locatorValue));
		} else if (locatorType.equalsIgnoreCase("className")) {
			return HooksClass.driver.findElements(By.className(locatorValue));
		} else if (locatorType.equalsIgnoreCase("tagName")) {
			return HooksClass.driver.findElements(By.tagName(locatorValue));
		} else {
			return null;
		}

	}

	public void enterTexts(String locatorType, String locatorValue, String textToEnter) {
		getWebElement(locatorType, locatorValue).sendKeys(textToEnter);
	}

	public void click(String locatorType, String locatorValue) {
		getWebElement(locatorType, locatorValue).click();
	}

	/**
	 * this method return only one text
	 * 
	 * @param locatorType
	 * @param LocatorValue
	 * @return
	 */
	public String getText(String locatorType, String locatorValue) {
		return getWebElement(locatorType, locatorValue).getText();

	}
	/**
	 * This Method will be return list of Text.
	 * @param locatorType
	 * @param locatorValue
	 * @return
	 */

	public List<String> getTexts(String locatorType,String locatorValue) {
		List<WebElement>data =getWebElements(locatorType, locatorValue); 
		List<String>  stringdata = new ArrayList<>();
		for (WebElement element : data) {
			stringdata.add(element.getText());
			
		}
		return stringdata;
	}
	/**
	 * this method will be split xpath or locator 
	 * @param locator
	 * @param TextToenter
	 */
	
	public void enterText(String locator, String TextToenter) {
		String parts[] = locator.split("##");
		enterTexts( parts[0],parts[1],TextToenter);
	}
	public void click(String locator) {
		String parts[] = locator.split("##");
		click(parts[0],parts[1]);
		
	}
	// if some method is not longer use in this case we can deprecat this method 
	//Deprecate mean  "No longer use".note= method is not directly delete.eg
	/**
	 * This method returns the text of specified web element.
	 * This method is no longer in use. Instead you can use{@code getText(String locatorType,String locatorValue)}
	 * @param locator
	 * @return
	 */
	@Deprecated
	public List<String> getTexts(String locator){
		String[] parts = locator.split("##");
		return getTexts(parts[0],parts[1]);
		
	}
	public void applyAssertTrue(String ProductName ,String webelement) {
		Assert.assertTrue(webelement.contains(ProductName));
	}

}
