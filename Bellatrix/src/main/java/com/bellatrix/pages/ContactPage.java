package com.bellatrix.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.bellatrix.stepDefination.HooksClass;
import com.bellatrix.utilities.WaitFor;
import com.fasterxml.jackson.core.sym.Name;

public class ContactPage {
	private static final Logger LOG = Logger.getLogger(ContactPage.class);
	WaitFor wait = new WaitFor();
	@FindBy(css = "input#wpforms-3347-field_1")
	WebElement firstname;

	public void firstNameMethod(String name) {
		firstname.sendKeys(name);
	}

	@FindBy(css = "ul[class='nav-menu'] li[class='page_item page-item-3342'] a")
	WebElement contacForm;

	public void contactForm() {
		contacForm.click();
	}

	@FindBy(css = "input#wpforms-3347-field_1-last")
	WebElement lastname;

	public void lastName(String name1) {
		lastname.sendKeys(name1);

	}

	@FindBy(css = "input#wpforms-3347-field_2")
	WebElement email;

	public void email(String name1) {
		email.sendKeys(name1);

	}

	@FindBy(css = "input#wpforms-3347-field_3_1")
	WebElement bronze;

	public void bronzeOnclick() {
		bronze.click();

	}

	@FindBy(css = "input#wpforms-3347-field_4_1")
	WebElement session1;

	public void session1Onclick() {
		session1.click();

	}

	@FindBy(css = "input#wpforms-3347-field_5_1")
	WebElement yes;

	public void yesOnclick() {
		yes.click();

	}

	@FindBy(css = "html>body>div>div>div>div>main>article>div>div>form>div:nth-child(4)>button.wpforms-submit")
	WebElement submit;
	

	public void submitOnclick() {
		//TestBase.driver.switchTo().frame(0);
		//TestBase.driver.findElement(By.xpath("//button[@id='wpforms-submit-3347']")).click();
		HooksClass.driver.switchTo().parentFrame();
		wait.implicitWait(8);
		
submit.click();
	}
	

	@FindBy(css = "//div[@class=\"recaptcha-checkbox-border\"]")
	WebElement captcha;

	public void captchaOnclick() {
		HooksClass.driver.switchTo().frame(0);
		HooksClass.driver.findElement(By.xpath("//div[@class=\"recaptcha-checkbox-border\"]")).click();
		
		

	}

	@FindBy(css = "label#g-recaptcha-hidden-error")
	WebElement errormsg;

	public String massage() {
		String title = errormsg.getText();
		return title;

	}
	@FindBy(css = "div#wpforms-confirmation-3347")
	WebElement contactmsg;
	public String contactmsg() {
		String msg = contactmsg.getText();
		return msg;
	}
}
