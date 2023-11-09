package com.bellatrix.utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;

import com.bellatrix.stepDefination.HooksClass;

public class WaitFor {
	static FluentWait<WebDriver> wait ;
	static {
		wait = new FluentWait<WebDriver>(HooksClass.getDriver());
		wait.withTimeout(Duration.ofSeconds(60));
	}
	public static void staleElement(WebElement element) {
		wait.until(ExpectedConditions.stalenessOf(element));
		
	}
	public static void waitMethod(WebElement webelement) {
		wait.until(ExpectedConditions.elementToBeClickable(webelement)).click();
	}

	public void implicitWait(int a) {
		HooksClass.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(a));
	}
	public void scrollby( ) {
		HooksClass.driver.executeScript("window.scrollBy(0,1700)");
	}
}
