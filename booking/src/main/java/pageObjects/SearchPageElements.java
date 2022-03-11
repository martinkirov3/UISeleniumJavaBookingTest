package pageObjects;

public interface SearchPageElements {
	String destination = "ss";
	String dates = "//span[contains(@class, 'sb-date-field__icon-btn')]";
	String selectCheckIn = "//table[@class='bui-calendar__dates']//tr[@class='bui-calendar__row']/td[contains(@class, 'bui-calendar__date--today')]/parent::tr/following-sibling::tr/td[1]"; ///parent::tr/following-sibling::tr/td[0]"; ///parent::tr/following-sibling::tr[1]/td[1]";
	String selectCheckOut = "//table[@class='bui-calendar__dates']//tr[@class='bui-calendar__row']/td[contains(@class, 'bui-calendar__date--today')]/parent::tr/following-sibling::tr[2]/td[1]"; ///parent::tr/following-sibling::tr[2]/td[2]";
	String guests = "//span[@class='xp__guests__count']";
	String adults = "//div[contains(@class, 'sb-group__field-adults')]//span[@class='bui-stepper__display']";
	String children = "//div[contains(@class, 'sb-group-children')]//span[@class='bui-stepper__display']";
	String addAdults = "//div[contains(@class, 'sb-group__field-adults')]//button[contains(@class, 'bui-stepper__add-button')]";
	String addChildren = "//div[contains(@class, 'sb-group-children')]//button[contains(@class, 'bui-stepper__add-button')]";
	String age = "//select[@name='age']";
	String ageSelect = "//select[@name='age']";
	String rooms = "//div[contains(@class, 'sb-group__field-rooms')]//span[@class='bui-stepper__display']";
	String addRooms = "//div[contains(@class, 'sb-group__field-rooms')]//button[contains(@class, 'bui-stepper__add-button')]";
	String searchButton = "//button[@class='sb-searchbox__button ']";
	
}
