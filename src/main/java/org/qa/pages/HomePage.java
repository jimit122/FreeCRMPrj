package org.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.base.BaseTest;

public class HomePage extends BaseTest{
	@FindBy(xpath = "//div[@class='header item']")
	WebElement lblHeader;
	@FindBy(xpath = "//a[@href='/contacts']")
	WebElement linkContacts;
	@FindBy(xpath = "//i[@class='building icon']")
	WebElement linkCompanies;
	@FindBy(xpath = "//i[@class='money icon']")
	WebElement linkDeals;
	@FindBy(xpath = "//i[@class='file icon']")
	WebElement linkDocuments;
	
	public WebElement getHeader() {
		return lblHeader;
	}
	public WebElement getDealsLink() {
		return linkDeals;
	}
	public WebElement getContactsLink() {
		return linkContacts;
	}
	public WebElement getCompaniesLink() {
		return linkCompanies;
	}
	public WebElement getDocumentsLink() {
		return linkDocuments;
	}
	public HomePage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}

}
