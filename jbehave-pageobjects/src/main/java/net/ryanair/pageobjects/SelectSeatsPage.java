package net.ryanair.pageobjects;

import java.util.List;

import net.ryanair.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SelectSeatsPage extends PageObject {	

	By by;
	
	@FindBy(xpath="(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[1]") 
	private WebElement selectFreeSeat1;

	@FindBy(xpath="(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[2]") 
	private WebElement selectFreeSeat2;

	@FindBy(xpath="(//span[@class='seat-click']/img[@class='icon-26 seat-person' and not(following-sibling::*)])[3]") 
	private WebElement selectFreeSeat3;

	@FindBy(xpath="//button[text()='Confirm']")	 
	private WebElement confirmButton;

	@FindBy(xpath="//button/span/translate/span[text()='Next']")	 
	private WebElement nextButton;

	@FindBy(xpath="//span[text()='Confirm']")
	private WebElement confirmSeatsButton ;

	@FindBy(xpath="//span[text()='Check out']")
	private WebElement checkOutButton;
	
	@FindBy(xpath="//div[@ng-click='closeThisDialog()']")
	private WebElement closeThisDialog;

	@FindBy(xpath="//div/a[text()='No, thanks']")
	private WebElement declinePriorityButton;
	
	@FindBy(xpath="//button[text()='No thanks']")
	private WebElement noThanksButton;

	public SelectSeatsPage(WebDriver driver) {		
		super(driver);
	}

	public boolean isInitialized() {		
		Utils utils= new Utils();
		by = By.xpath("//span[text()='Seat(s) selection']");		
		long time = 10;
		return(utils.isClickable(driver, by, time));		
	}	
	
	public void clickOnSeats() throws InterruptedException{
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.selectFreeSeat1);
		//clickConfirmSeatsButton();
		js.executeScript("arguments[0].click();", this.selectFreeSeat2);
		//clickConfirmSeatsButton();
		js.executeScript("arguments[0].click();", this.selectFreeSeat3);
		//clickConfirmSeatsButton();
	}
	public void clickNextButton(){
		this.nextButton.click();			
	}	

	public void clickConfirmSeatsButton(){
		List<WebElement> list = driver.findElements(By.xpath("//span[text()='Confirm']"));
		if (list.size()>0)
		    this.confirmSeatsButton.click();			
	}

	public void clickDeclinePriorityButton(){
		List<WebElement> list = driver.findElements(By.xpath("//div/a[text()='No, thanks']"));
		if (list.size()>0)
		this.declinePriorityButton.click();			
	}	

	public void clickNothanksButton(){
		List<WebElement> list = driver.findElements(By.xpath("//button[text()='No thanks']"));
		if (list.size()>0)
		this.noThanksButton.click();			
	}	
	public void clickCheckOutButton() throws InterruptedException{
		Thread.sleep(3000);
		Utils utils = new Utils();	
		if (utils.isClickable(driver,By.xpath("//span[text()='Check out']"),5))
			this.checkOutButton.click();
	}	
}
