package net.ryanair.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageObject {
	protected WebDriver driver; 
	public PageObject(WebDriver driver){
		this.driver = driver; 
		// To initialize the elements of the Page Object
		PageFactory.initElements(driver, this); 
	}
}
