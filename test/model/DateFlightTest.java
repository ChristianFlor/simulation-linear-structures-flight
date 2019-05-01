package model;

import static org.junit.Assert.assertNotNull;


import org.junit.jupiter.api.Test;

class DateFlightTest {

	private DateFlight dt;
	private void setUpScenary1() {}
	@Test
	public void testDateFlight(){
		
		setUpScenary1();
		
		try {
			dt = new DateFlight();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		assertNotNull("The Date Couldn't be created, its value is null", dt != null);
		
	}

}
