package com.bellatrix.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BlogPage {
	private static final Logger LOG = Logger.getLogger(BlogPage.class);
	@FindBy(css = "div:nth-child(2)>ul>li:nth-child(2)>a[href=\"https://demos.bellatrix.solutions/blog/\"]")
	WebElement blogBtn;
	public void clickOnblogbtn() {
		blogBtn.click();
	}
	@FindBy(css = "td>a[href=\"https://www.wikiwand.com/en/Khrunichev_State_Research_and_Production_Space_Center")
	WebElement link;
	public void clicklink() {
		
		link.click();
	}
	@FindBy(css = "td>a[href=\"https://www.wikiwand.com/en/SpaceX\"]")
	WebElement linkFalcon;
	public void clicklinkFalcon() {
		
		linkFalcon.click();
	}
	@FindBy(css = "span>a[href=\"https://demos.bellatrix.solutions/2018/04/06/proton-rocket-family/\"]")
	WebElement protonName;
	public void clickprotonName() {
		
		protonName.click();
	}
	
	@FindBy(css = "textarea#comment")
		WebElement commentbox;
		public void comment_sendkeys(String name) {
			
			commentbox.sendKeys(name);
		}
		@FindBy(css = "input#email")
		WebElement commentname;
		public void name_sendkeys(String name2) {
			
			commentname.sendKeys(name2);
		}
		@FindBy(css = "input#email")
		WebElement commentEmail;
		public void email_sendkeys(String name2) {
			
			commentEmail.sendKeys(name2);
		}
		@FindBy(css = "input#submit")
		WebElement postComment;
		public void postComments() {
			
			postComment.click();
	}
		@FindBy(css = "div[class='wp-die-message'] p:nth-child(1)")
		WebElement errmsgcomment;
		public String geterrmsg() {
			String msg = errmsgcomment.getText();
			return msg;
		}

}
