package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class SimulationTest {

	private Simulation s;
	private int sizeFlights;
	private Flight[] flights;
	private void setUpScenary2() {
		sizeFlights=10;
	}
	private void setUpScenary3() {
		flights = new Flight[]{
				new Flight(new DateFlight(), new Time(), "AVIANCA", "AV0002", "CALI"),
				new Flight(new DateFlight(), new Time(), "WINGO", "AV0003", "BOGOTA"),
				new Flight(new DateFlight(), new Time(), "LAN", "AV0004", "MEDELLIN")};
		s = new Simulation(flights.length);
		s.setFlights(flights);
		
	}
	@Test
	public void testSimulation(){
		setUpScenary2();
		try {
			s = new Simulation(sizeFlights);
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
		
		assertNotNull("The Game Couldn't be created, its value is null", s != null);
	}
	@Test
	public void testGenerateSimulation(){
		setUpScenary2();
		try {
			s = new Simulation(sizeFlights);
			s.generateSimulation();
			assertNotNull("The Simulation Couldn't be created, its value is null", s != null);
			assertNotNull("The Flights Couldn't be created, its value is null",s.getFlights()!=null);
			for (int i = 0; i < s.getFlights().length; i++) {
				assertNotNull("The Date Couldn't be created, its value is null", s.getFlights()[0].getDate() != null);
				assertNotNull("The Time Couldn't be created, its value is null", s.getFlights()[0].getSchedule() != null);
				assertTrue("The name Airline is not empty", s.getFlights()[0].getNameAirline() != " ");
				assertTrue("The id Airline is not empty", s.getFlights()[0].getIdAirline() != " ");
				assertTrue("The destination city is not empty", s.getFlights()[0].getDestinationCity() != " ");
				assertTrue("The boarding gate is not empty", s.getFlights()[0].getBoardingGate() != " ");
			}
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByBoardingGate(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Boarding Gate");
			s.sortByBoardingGate();
	    	System.out.println(s.report());
	    	System.out.println("==================\nBefore to sort");
	    	System.out.println(s.report());
	    	assertTrue("The boarding gate is not empty", flights[0].getBoardingGate().compareTo(flights[1].getBoardingGate())<0 
	    			||flights[0].getBoardingGate().compareTo(flights[2].getBoardingGate())<0 
	    				||flights[1].getBoardingGate().compareTo(flights[2].getBoardingGate())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByNameAirline(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Name Airline");
			s.sortByNameAirline();
	    	System.out.println(s.report());
	    	assertTrue("The Name Airline is not empty", flights[0].getNameAirline().compareTo(flights[1].getNameAirline())<0 
	    			||flights[0].getNameAirline().compareTo(flights[2].getNameAirline())<0 
	    				||flights[1].getNameAirline().compareTo(flights[2].getNameAirline())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByDestinationCity(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Destination City");
			s.sortByDestinationCity();
	    	System.out.println(s.report());
	    	assertTrue("The Destination City is not empty", flights[0].getDestinationCity().compareTo(flights[1].getDestinationCity())<0 
	    			||flights[0].getDestinationCity().compareTo(flights[2].getDestinationCity())<0 
	    				||flights[1].getDestinationCity().compareTo(flights[2].getDestinationCity())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByIdAirline(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Id Airline");
			s.sortByIdAirline();
	    	System.out.println(s.report());
	    	assertTrue("The Id Airline is not empty", flights[0].getIdAirline().compareTo(flights[1].getIdAirline())<0 
	    			||flights[0].getIdAirline().compareTo(flights[2].getIdAirline())<0 
	    				||flights[1].getIdAirline().compareTo(flights[2].getIdAirline())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByDateFlight(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Date Flight");
			s.sortByDateFlight();
	    	System.out.println(s.report());
	    	assertTrue("The Date Flight is not empty", flights[0].getDate().compareTo(flights[1].getDate())<0 
	    			||flights[0].getDate().compareTo(flights[2].getDate())<0 
	    				||flights[1].getDate().compareTo(flights[2].getDate())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByTime(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Time");
			s.sortByTime();
	    	System.out.println(s.report());
	    	assertTrue("The Id Airline is not empty", flights[0].getSchedule().compareTo(flights[1].getSchedule())<0 
	    			||flights[0].getSchedule().compareTo(flights[2].getSchedule())<0 
	    				||flights[1].getSchedule().compareTo(flights[2].getSchedule())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
