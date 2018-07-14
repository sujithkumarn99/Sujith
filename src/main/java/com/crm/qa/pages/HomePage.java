package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class HomePage extends TestBase{

	@FindBy(xpath="html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]/font")
	WebElement userNameLable;
	
	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactLink;
	
	@FindBy(xpath="//a[contains(text(),'New Contact')]")
	WebElement newContactLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals']")
	WebElement delasLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks']")
	WebElement tasksLink;
	
	//Initializing the page object
	
	public HomePage() {
		PageFactory.initElements(dr, this);
	}
	
	public String verifyHomePagetitle() {
		return dr.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return userNameLable.isDisplayed();
	}
	
	public ContactsPage clickOnContactslink() {
		contactLink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickOnDealslink() {
		delasLink.click();
		return new DealsPage();
	}
	
	public TasksPage clickOnTaskslink() {
		contactLink.click();
		return new TasksPage();
	}
	 public void clickOnNewContactLink() {
		 Actions action=new Actions(dr);		 
		 action.moveToElement(contactLink).build().perform();
		 newContactLink.click();
	 }
	
	
}
