package net.ryanair.pageobjects;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SelectFlightPage extends PageObject {

	@FindBy(xpath="//img[@class='room-take-over__img']")
	private WebElement closeAdd;

	@FindBy(xpath="//div[@class='cookie-popup__close-btn']")
	private WebElement closeCookiesPopup;
	
	@FindBy(xpath="//input[@placeholder='Departure airport']")
	private WebElement from;
	
	@FindBy(xpath="//input[@placeholder='Destination airport']")
	private WebElement destiny;	

	@FindBy(id="flight-search-type-option-one-way")	
	private WebElement oneWayButton;	
	
	@FindBy(xpath="//div[@class='col-flight-search-right']/button")
	private WebElement continueButton;	

	@FindBy(xpath="//div[@class='dropdown-handle']")
	private WebElement passengersDropdown;	

	@FindBy(xpath="(//button[@type='button'])[3]")
	private WebElement adultsButton;

	@FindBy(xpath="(//button[@type='button'])[7]")
	private WebElement childrenButton;	

	@FindBy(xpath="//input[@type='text' and @name='dateInput0']")
	private WebElement dateDay;	

	@FindBy(xpath="//input[@type='text' and @name='dateInput1']")
	private WebElement dateMonth;	

	@FindBy(xpath="//span[contains(.,'s go!')]") 
	private WebElement letsgoButton;		


	public SelectFlightPage(WebDriver driver) {
		super(driver);
	}

	public boolean isInitialized() {
		return destiny.isDisplayed();
	}

	public void enterFrom(String from){
		this.from.clear();
		this.from.sendKeys(from);			
	}

	public void enterDestiny(String destiny){
		this.destiny.clear();
		this.destiny.sendKeys(destiny);		
	}
	public void clickContinueButton(){
		this.continueButton.click();			
	}
	public void clickAdultsButton(){
		this.adultsButton.click();			
	}
	public void clickChildrenButton(){
		this.childrenButton.click();			
	}
	public void clickLetsgoButton(){
		this.letsgoButton.click();			
	}
	public void clickOneWayButton(){
		this.oneWayButton.click();			
	}	
	public void clickPassengersDropdown(){
		this.passengersDropdown.click();
	}	
	public void enterDateDay(String date){
		this.dateDay.clear();
		this.dateDay.sendKeys(date);
	}
	public void enterDateMonth(String date){
		this.dateMonth.clear();
		this.dateMonth.sendKeys(date);
	}

	//	public void clickCloseAdd() {
	//		Utils utils = new Utils();
	//		if (utils.isClickable(driver,By.xpath("//img[@class='room-take-over__img']"),3))
	//			this.closeAdd.click();
	//	}

	public void closeCookiesPopup() {
		if(this.closeCookiesPopup.isDisplayed())
			this.closeCookiesPopup.click();
	}
}
