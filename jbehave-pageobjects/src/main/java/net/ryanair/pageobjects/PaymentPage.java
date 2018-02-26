package net.ryanair.pageobjects;


import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PaymentPage extends PageObject {

	@FindBy(xpath="//button/span[text()='Log in']")
	private WebElement loginButton;	

	@FindBy(xpath="//input[@placeholder='Email address']")
	private WebElement emailAdress;

	@FindBy(name="password")
	private WebElement password;

	@FindBy(xpath="//translate/span[text()='Log in']")
	private WebElement login2Button;

	@FindBy(xpath="(//div[@class='form-field payment-passenger-title form-invalid' or @class='form-field payment-passenger-title']/div)[1]/select")
	private WebElement firstPassengerTitle;

	@FindBy(xpath="(//div[@class='form-field payment-passenger-title form-invalid' or @class='form-field payment-passenger-title']/div)[2]/select")
	private WebElement secondPassengerTitle;

	//First passenger - First name
	@FindBy(xpath="(//input[@placeholder='e.g. John'])[1]")
	private WebElement firstPassengerFirstName;

	//First passenger - Surname
	@FindBy(xpath="(//input[@placeholder='e.g. Smith'])[1]")
	private WebElement firstPassengerSurname;

	//Second passenger - First name
	@FindBy(xpath="(//input[@placeholder='e.g. John'])[2]")
	private WebElement secondPassengerFirstName;

	//Second passenger - Surname
	@FindBy(xpath="(//input[@placeholder='e.g. Smith'])[2]")
	private WebElement secondPassengerSurname;

	//First passenger - First name
	@FindBy(xpath="(//input[@placeholder='e.g. John'])[3]")
	private WebElement thirdName;

	//First passenger - Surname
	@FindBy(xpath="(//input[@placeholder='e.g. Smith'])[3]")
	private WebElement thirdSurname;

	@FindBy(xpath="//select[@name='phoneNumberCountry']")
	private WebElement phoneNumberCountry;

	@FindBy(xpath="//input[@name='phoneNumber']")
	private WebElement phoneNumber;

	@FindBy(xpath="//input[@name='cardNumber']")
	private WebElement cardNumber;

	@FindBy(xpath="//select[@name='cardType']")
	private WebElement cardType;

	@FindBy(xpath="//select[@name='expiryMonth']")
	private WebElement expiryMonth;

	@FindBy(xpath="//select[@name='expiryYear']")
	private WebElement expiryYear;

	@FindBy(xpath="//input[@name='securityCode']")
	private WebElement securityCode;

	@FindBy(xpath="//input[@name='cardHolderName']")
	private WebElement cardHolderName;

	@FindBy(xpath="//input[@name='billingAddressAddressLine1']")
	private WebElement billingAddressAddressLine1;

	@FindBy(xpath="//input[@name='billingAddressAddressLine2']")
	private WebElement billingAddressAddressLine2;

	@FindBy(xpath="//input[@name='billingAddressCity']")
	private WebElement billingAddressCity;

	@FindBy(xpath="//input[@name='billingAddressPostcode']")
	private WebElement billingAddressPostcode;

	@FindBy(xpath="//select[@name='billingAddressCountry']")
	private WebElement billingAddressCountry;

	@FindBy(xpath="(//span[@class='core-checkbox-label--icon']/core-icon/div)[7]")
	private WebElement agree;

	@FindBy(xpath="//button[text()='Pay Now']")	 
	private WebElement payNowButton;


	public PaymentPage(WebDriver driver) {
		super(driver);
	}
	//
	public boolean isInitialized() {
		return loginButton.isDisplayed();
	}
	public void clickLoginButton(){
		this.loginButton.click();
	}
	public void enterEmail(String emailAdress) {
		//this.emailAdress.clear();
		this.emailAdress.sendKeys(emailAdress);		
	}

	public void enterPassword(String password) {
		this.password.clear();
		this.password.sendKeys(password);		
	}

	public void enterFirstPassengerTitle(String firstPassengerTitle){
		try{
			new Select(this.firstPassengerTitle).selectByVisibleText(firstPassengerTitle);
		}catch(org.openqa.selenium.StaleElementReferenceException ex){
			new Select(this.firstPassengerTitle).selectByVisibleText(firstPassengerTitle);
		}
		// NOTE:
			//             With the upper line I get a "StaleElementReferenceException",so I catch it and repeat the operation. I use this 
		//             in other selects
		//             Second workaround: it works too (I also use this in other Selects).
		//				Actions actions = new Actions(driver);
		//				actions.moveToElement(this.firstPassengerTitle);
		//				actions.click();
		//				actions.sendKeys(firstPassengerTitle);
		//				actions.sendKeys(Keys.ENTER);		
		//				actions.build().perform();
	}

	public void enterFirstPassengerFirstName(String firstPassengerFirstName) throws InterruptedException{
		Thread.sleep(3000);
		// This works sometimes...
//		WebDriverWait wait = new WebDriverWait(driver, 10);
//		wait.until(ExpectedConditions.stalenessOf(login2Button));		
		this.firstPassengerFirstName.sendKeys(firstPassengerFirstName);
	}

	public void enterFirstPassengerSurname(String firstPassengerSurname){		
		this.firstPassengerSurname.sendKeys(firstPassengerSurname);
	}

	public void enterSecondPassengerTitle(String secondPassengerTitle){
		try{
			new Select(this.secondPassengerTitle).selectByVisibleText(secondPassengerTitle);
		}catch(org.openqa.selenium.StaleElementReferenceException ex){
			new Select(this.secondPassengerTitle).selectByVisibleText(secondPassengerTitle);
		}	
	}

	public void enterSecondPassengerFirstName(String secondPassengerFirstName){		
		this.secondPassengerFirstName.sendKeys(secondPassengerFirstName);
	}

	public void enterSecondPassengerSurname(String secondPassengerSurname){		
		this.secondPassengerSurname.sendKeys(secondPassengerSurname);
	}

	public void enterThirdName(String thirdName){		
		this.thirdName.sendKeys(thirdName);
	}

	public void enterThirdSurname(String thirdSurname){		
		this.thirdSurname.sendKeys(thirdSurname);
	}

	public void enterPhoneNumberCountry(String phoneNumberCountry){
		Actions actions = new Actions(driver);
		actions.moveToElement(this.phoneNumberCountry);
		actions.click();
		actions.sendKeys(phoneNumberCountry);
		actions.sendKeys(Keys.ENTER);		
		actions.build().perform();
	}

	public void enterPhoneNumber(String phoneNumber){
		this.phoneNumber.sendKeys(phoneNumber);
	}

	public void enterCardNumber(String cardNumber){
		this.cardNumber.sendKeys(cardNumber);		
	}

	public void enterCardType(String cardType){
		try{
			new Select(this.cardType).selectByVisibleText("MasterCard");
		}catch(org.openqa.selenium.StaleElementReferenceException ex){
			new Select(this.cardType).selectByVisibleText("MasterCard");
		}
	}

	public void enterExpiryMonth(String expiryMonth){
		Actions actions = new Actions(driver);
		actions.moveToElement(this.expiryMonth);
		actions.click();
		actions.sendKeys(expiryMonth);
		actions.sendKeys(Keys.ENTER);		
		actions.build().perform();
	}

	public void enterExpiryYear(String expiryYear){
		Actions actions = new Actions(driver);
		actions.moveToElement(this.expiryYear);
		actions.click();
		actions.sendKeys(expiryYear);
		actions.sendKeys(Keys.ENTER);		
		actions.build().perform();
	}

	public void enterSecurityCode(String securityCode){
		this.securityCode.sendKeys(securityCode);
	}

	public void enterCardHolder(String cardHolder){
		this.cardHolderName.sendKeys(cardHolder);
	}

	public void enterBillingAddress1(String billingAddressAddressLine1){
		this.billingAddressAddressLine1.sendKeys(billingAddressAddressLine1);
	}

	public void enterBillingAddress2(String billingAddressAddressLine2){
		this.billingAddressAddressLine2.sendKeys(billingAddressAddressLine2);
	}

	public void enterBillingAddressCity(String billingAddressCity){
		this.billingAddressCity.sendKeys(billingAddressCity);
	}

	public void enterBillingAddressPostcode(String billingAddressPostcode){
		this.billingAddressPostcode.sendKeys(billingAddressPostcode);
	}

	public void clickAgreeButton(){
		this.agree.click();			
	}

	public void clickPayNowButton(){
		this.payNowButton.click();			
	}

	public void clickLogin2Button() {
		this.login2Button.click();		
	}     
}
