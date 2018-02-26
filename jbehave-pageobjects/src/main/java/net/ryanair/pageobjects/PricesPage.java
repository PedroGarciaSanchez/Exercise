package net.ryanair.pageobjects;

import java.util.concurrent.TimeUnit;

import net.ryanair.utils.Utils;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class PricesPage extends PageObject {	
	@FindBy(xpath="(//div[@class='core-btn-primary'])[1]")
	private WebElement firstPrice;	

	@FindBy(css="span.flights-table-fares__fare-radio")	     
	private WebElement standardFare;
	
	@FindBy(id="continue")
	private WebElement buttonContinue;

	@FindBy(xpath="//button[contains(.,'Ok, got it')]")
	private WebElement buttonOk;

	private static By by;		

	public PricesPage(WebDriver driver) {		
		super(driver);
	}

	public boolean isInitialized() {		
		Utils utils= new Utils();
		by = By.xpath("(//div[@class='core-btn-primary'])[1]");		
		long time = 10;
		return(utils.isPresent(driver, by, time));	
	}

	public void clickFirstPrice(){		
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.firstPrice);
	}
	public void clickStandardFare(){
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.standardFare);			
	}

	public void clickButtonContinue(){		
		Utils utils= new Utils();
		By by = By.id("continue");
		assertTrue(utils.isClickable(driver, by, 5));		


		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.buttonContinue);		
	}

	public void clickButtonOk(){
		JavascriptExecutor js = (JavascriptExecutor) driver;		
		js.executeScript("arguments[0].click();", this.buttonOk);		
	}
}
