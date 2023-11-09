package com.bellatrix.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
	private static final Logger LOG = Logger.getLogger(LoginPage.class);
	@FindBy(css = "div:nth-child(2)>ul>li:nth-child(6)>a[href=\"https://demos.bellatrix.solutions/my-account/\"]\r\n"
			+ "")
	WebElement myaccoutbtn;

	public void clickOnmyaccount() {
		myaccoutbtn.click();
	}

	@FindBy(css = "nav.woocommerce-breadcrumb")
	WebElement breadcrum;

	public String getBreadcrum() {
		String title = breadcrum.getText();
		return title;
	}

	@FindBy(css = "input#username")
	WebElement username;

	public void username(String name) {
		username.sendKeys(name);

	}
	@FindBy(css = "input#password")
	WebElement password;

	public void password(String name) {
		password.sendKeys(name);

	}
	@FindBy(css = "input#rememberme")
	WebElement checkbox;

	public void clickOncheckbox() {
		checkbox.click();;

	}
	@FindBy(css ="button.woocommerce-button.button.woocommerce-form-login__submit")
	WebElement loginbtn;
	public void clickOnloginbtn() {
		loginbtn.click();
	}
	
	@FindBy(css ="ul.woocommerce-error li")
	WebElement errorpassword;
	public String passwordErr() {
		String msg = errorpassword.getText();
		return msg;
	}
	@FindBy(css ="ul.woocommerce-error li")
	WebElement erroremail;
	public String emailErrmsg() {
		String msg = erroremail.getText();
		return msg;
	}
	
	
}
