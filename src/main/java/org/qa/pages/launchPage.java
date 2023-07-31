package org.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.base.BaseTest;

public class launchPage extends BaseTest{
	@FindBy (xpath = "//span[text()='Log In']")
	WebElement btnLogin;
	
	@FindBy (xpath = "(//a[@title='free crm home'])[1]")
	WebElement title;
	
	@FindBy (xpath = "//span[normalize-space()='sign up']")
	WebElement btnSignUp;
	
	@FindBy (xpath = "//h6[normalize-space()='Free CRM for every business']")
	WebElement lblFreeCRM;
	
	public launchPage() {
		PageFactory.initElements(driver, this);
		// TODO Auto-generated constructor stub
	}
	public LoginPage clickLoginbtn() {
		btnLogin.click();
		return new LoginPage();
	}

}
