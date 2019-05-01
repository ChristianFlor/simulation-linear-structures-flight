package model;

import static org.junit.Assert.assertNotNull;

import org.junit.jupiter.api.Test;

class TimeTest {
	private Time t;
	private void setUpScenary1() {}
	@Test
	public void testTime(){
		
		setUpScenary1();
		
		try {
			t = new Time();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		assertNotNull("The Time Couldn't be created, its value is null", t != null);
		
	}

}
