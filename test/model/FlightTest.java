package model;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

class FlightTest {

	private Flight f;
	private void setUpScenary1() {}
	@Test
	public void testFlihgt(){
		
		setUpScenary1();
		
		try {
			f = new Flight(new DateFlight(), new Time(), "Avianca", "AV0002", "CALI");
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		assertNotNull("The Flight Couldn't be created, its value is null", f != null);
		
	}

}
