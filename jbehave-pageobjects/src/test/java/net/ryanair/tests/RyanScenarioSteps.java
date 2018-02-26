package net.ryanair.tests;

import static org.junit.Assert.assertTrue;
import junit.framework.Assert;
import net.ryanair.pageobjects.PaymentPage;
import net.ryanair.pageobjects.PricesPage;
import net.ryanair.pageobjects.SelectFlightPage;
import net.ryanair.pageobjects.SelectSeatsPage;

import org.jbehave.core.annotations.AfterScenario;
import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

public class RyanScenarioSteps extends DriverManage {

	//Start the driver
	public RyanScenarioSteps(){
		super();
	}

	@Given("I make a booking from “DUB” to “SXF” on 12/03/2018 for 2 adults and 1 child")
	public void selectFlight() throws InterruptedException {

		driver.get("https://www.ryanair.com/ie/en/");	

		//FLIGHTS	
		SelectFlightPage selectFlight = new SelectFlightPage(driver);
		assertTrue(selectFlight.isInitialized());
		selectFlight.enterFrom("Madrid");
		selectFlight.clickOneWayButton();
		selectFlight.enterDestiny("Dublin");
		selectFlight.closeCookiesPopup();		
		//		selectFlight.clickCloseAdd();				
		selectFlight.clickOneWayButton();		
		selectFlight.clickContinueButton();
		selectFlight.clickPassengersDropdown();
		selectFlight.clickAdultsButton();
		selectFlight.clickChildrenButton();
		selectFlight.enterDateDay("15");
		selectFlight.enterDateMonth("11");
		selectFlight.clickLetsgoButton();

		//PRICES

		PricesPage selectPrice = new PricesPage(driver);	
		assertTrue(selectPrice.isInitialized());		
		selectPrice.clickFirstPrice();
		selectPrice.clickStandardFare();
		selectPrice.clickButtonContinue();
		selectPrice.clickButtonOk();

		//SEATS SELECTION

		SelectSeatsPage selectSeats = new SelectSeatsPage(driver);	   
		assertTrue(selectSeats.isInitialized());
		selectSeats.clickOnSeats();
		selectSeats.clickNextButton();
		selectSeats.clickConfirmSeatsButton();
		selectSeats.clickDeclinePriorityButton();
		selectSeats.clickCheckOutButton();	 
		//selectSeats.clickNothanksButton();
	}


	@When("I pay for booking with card details 5555 5555 5555 5557, 10/18 and 265")
	public void paymentProcess() throws InterruptedException {

		PaymentPage paymentPage = new PaymentPage(driver);
		assertTrue(paymentPage.isInitialized());
		
		//LOG IN
		paymentPage.clickLoginButton();	 
		paymentPage.enterEmail("pedrogarcia4@gmail.com");
		paymentPage.enterPassword("PruRyan8");
		paymentPage.clickLogin2Button();

		//PASSENGER DETAILS
		   
		paymentPage.enterFirstPassengerFirstName("Pedro");	 
		paymentPage.enterFirstPassengerTitle("Mr");	
		paymentPage.enterFirstPassengerSurname("Garcia");

		paymentPage.enterSecondPassengerFirstName("Pedro");
		paymentPage.enterSecondPassengerTitle("Mr");	    
		paymentPage.enterSecondPassengerSurname("Garcia");

		paymentPage.enterThirdName("Pedro");
		paymentPage.enterThirdSurname("Garcia");

		//Contact Details
		paymentPage.enterPhoneNumberCountry("a");
		paymentPage.enterPhoneNumber("12345678");	    

		//Payment method
		paymentPage.enterCardNumber("5555555555555557");
		paymentPage.enterCardType("MasterCard");	    
		paymentPage.enterExpiryMonth("1");
		paymentPage.enterExpiryYear("2");
		paymentPage.enterSecurityCode("123");
		paymentPage.enterCardHolder("Pedro Garcia");

		//Billing Address
		paymentPage.enterBillingAddress1("Address 1");
		paymentPage.enterBillingAddress2("Address 2");
		paymentPage.enterBillingAddressCity("My city");
		paymentPage.enterBillingAddressPostcode("12345");

		//Pay
		paymentPage.clickAgreeButton();	
		paymentPage.clickPayNowButton();
	}


	@Then("I should get payment declined message")
	public void getDeclinedMessage() {
		// Note:
		// Here i should catch the message with "isDisplayed()", but payment process is not working.
		// When I click on "Pay" button, the page clears all fields of the card section that were already filled
		// and asks me to fill them again. I've commented the driver.close() line in @AfterScenario so 
		// it can be seen
	}

	@AfterScenario
	public void clean() {		
		//driver.close();
	}

}
