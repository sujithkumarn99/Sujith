package com.crm.qa.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	//page factory or:
	@FindBy(name="username")	
	WebElement username;
	
	@FindBy(name="password")	
	WebElement password;
	
	@FindBy(xpath="//input[@type='submit']")////input[@type="submit"]
	WebElement loginBtn;
	
	@FindBy(xpath="//button[contains(text(),'Sign Up')]")
	WebElement signUpbtn;
	
	@FindBy(xpath="//img[contains(@class,'img-responsive')]")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(dr,this);
		
		
	}
	
	public String  validateLoginPageTitle() {
		return dr.getTitle();
	}
	
	public boolean validateCRMImage(){
		return crmLogo.isDisplayed();
		
	}
	public HomePage login(String uname,String pwd) {
		username.sendKeys(uname);
		password.sendKeys(pwd);
		
		//loginBtn.click();
		JavascriptExecutor js = (JavascriptExecutor) dr;
		js.executeScript("arguments[0].click();", loginBtn);
		
		return new HomePage();
	}
	
	
	
}
