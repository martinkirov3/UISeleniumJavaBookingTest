package uitests;

import static org.testng.AssertJUnit.assertTrue;
import org.testng.annotations.Test;
import pageEvents.SearchPageEvents;
import pageEvents.HomePageEvents;
import pageEvents.ResultsPageEvents;

import utils.BaseTest;


public class SearchBooking extends BaseTest {
	
	
	@Test

/* Scenario:
	1. Navigate to the booking.com page
2. Execute a new search with the following parameters:
•	a. City: Malaga 
•	b. Check in/out dates: next week 
•	People: 2 adults and 1 child
3. Validate that at least one result is displayed
 */

	public void searchBooking() throws InterruptedException {
		HomePageEvents homePageEvents = new HomePageEvents();
		BaseTest.test.info("Searching the Search button");
		homePageEvents.verifySearchButton();
		homePageEvents.acceptTermsAndConditions();
				
		SearchPageEvents searchPageEvents = new SearchPageEvents();
		searchPageEvents.enterDestination();
		
		searchPageEvents.clickOnDates();
		System.out.println("Calendar is opened");
		
		searchPageEvents.selectCheckIn();
		searchPageEvents.selectCheckOut();
		
		searchPageEvents.clickOnGuests();
		searchPageEvents.addAdults();
		searchPageEvents.addChildren();
		
		searchPageEvents.clickOnSearchButton();
		boolean firstResult = ResultsPageEvents.isFirstResultDisplayed();
		System.out.println(firstResult);
		assertTrue(firstResult);
	}
}
