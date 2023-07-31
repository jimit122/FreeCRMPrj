package org.qa.pages;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.qa.base.BaseTest;

public class LoginPage extends BaseTest{
@FindBy (name = "email")
WebElement txtUserName;
@FindBy (name = "password")
WebElement txtPassword;
@FindBy (xpath = "//div[text()='Login']")
WebElement btnLogin;
@FindBy (xpath = "//div[@class='ui negative message']")
WebElement txtErrorMessage;

public LoginPage() {
	PageFactory.initElements(driver, this);
	// TODO Auto-generated constructor stub
}
public HomePage validLoginToCRM(String username, String password) {
	txtUserName.sendKeys(username);
	txtPassword.sendKeys(password);
	btnLogin.click();
	return new HomePage();
}
public void invalidLoginToCRM(String username, String password) {
	txtUserName.sendKeys(username);
	txtPassword.sendKeys(password);
	btnLogin.click();
	assertEquals(txtErrorMessage.getText().contains("Some went wrong..."), true);
	assertEquals(txtErrorMessage.isDisplayed(), true);
}

}
