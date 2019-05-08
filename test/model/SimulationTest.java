package model;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

class SimulationTest {

	private Simulation s;
	private int sizeFlights;
	private void setUpScenary2() {
		sizeFlights=10;
	}
	private void setUpScenary3() {
		int n=3;
		s = new Simulation(n);
		s.generateSimulation();
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
			assertNotNull("The Flights Couldn't be created, its value is null",s.getFirstAirlines()!=null);
			for (int i = 0; i < s.getFlightsToArray().length; i++) {
				assertNotNull("The Date Couldn't be created, its value is null", s.getFlightsToArray()[0].getDate() != null);
				assertNotNull("The Time Couldn't be created, its value is null", s.getFlightsToArray()[0].getSchedule() != null);
				assertTrue("The name Airline is not empty", s.getFlightsToArray()[0].getNameAirline() != " ");
				assertTrue("The id Airline is not empty", s.getFlightsToArray()[0].getIdAirline() != " ");
				assertTrue("The destination city is not empty", s.getFlightsToArray()[0].getDestinationCity() != " ");
				assertTrue("The boarding gate is not empty", s.getFlightsToArray()[0].getBoardingGate() != " ");
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
			s.sortByGate();
	    	System.out.println(s.flightInString());
	    	System.out.println("==================\nBefore to sort");
	    	System.out.println(s.flightInString());
	    	assertTrue("The boarding gate is not empty", s.getFlightsToArray()[0].getBoardingGate().compareTo(s.getFlightsToArray()[1].getBoardingGate())<0 
	    			||s.getFlightsToArray()[0].getBoardingGate().compareTo(s.getFlightsToArray()[2].getBoardingGate())<0 
	    				||s.getFlightsToArray()[1].getBoardingGate().compareTo(s.getFlightsToArray()[2].getBoardingGate())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByNameAirline(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Name Airline");
			s.sortByAirline();
	    	System.out.println(s.flightInString());
	    	assertTrue("The Name Airline is not empty", s.getFlightsToArray()[0].getNameAirline().compareTo(s.getFlightsToArray()[1].getNameAirline())<0 
	    			||s.getFlightsToArray()[0].getNameAirline().compareTo(s.getFlightsToArray()[2].getNameAirline())<0 
	    				||s.getFlightsToArray()[1].getNameAirline().compareTo(s.getFlightsToArray()[2].getNameAirline())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByDestinationCity(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Destination City");
			s.sortByDestination();
	    	System.out.println(s.flightInString());
	    	assertTrue("The Destination City is not empty", s.getFlightsToArray()[0].getDestinationCity().compareTo(s.getFlightsToArray()[1].getDestinationCity())<0 
	    			||s.getFlightsToArray()[0].getDestinationCity().compareTo(s.getFlightsToArray()[2].getDestinationCity())<0 
	    				||s.getFlightsToArray()[1].getDestinationCity().compareTo(s.getFlightsToArray()[2].getDestinationCity())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByIdAirline(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Id Airline");
			s.sortByCode();
	    	System.out.println(s.flightInString());
	    	assertTrue("The Id Airline is not empty", s.getFlightsToArray()[0].getIdAirline().compareTo(s.getFlightsToArray()[1].getIdAirline())<0 
	    			||s.getFlightsToArray()[0].getIdAirline().compareTo(s.getFlightsToArray()[2].getIdAirline())<0 
	    				||s.getFlightsToArray()[1].getIdAirline().compareTo(s.getFlightsToArray()[2].getIdAirline())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void testSortByDateFlight(){
		setUpScenary3();
		try {
			System.out.println("==================\nSorted by Date Flight");
			s.sortByDate();
	    	System.out.println(s.flightInString());
	    	assertTrue("The Date Flight is not empty", s.getFlightsToArray()[0].getDate().compareTo(s.getFlightsToArray()[1].getDate())<0 
	    			||s.getFlightsToArray()[0].getDate().compareTo(s.getFlightsToArray()[2].getDate())<0 
	    				||s.getFlightsToArray()[1].getDate().compareTo(s.getFlightsToArray()[2].getDate())<0);
	    	
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
	    	System.out.println(s.flightInString());
	    	assertTrue("The Id Airline is not empty", s.getFlightsToArray()[0].getSchedule().compareTo(s.getFlightsToArray()[1].getSchedule())<0 
	    			||s.getFlightsToArray()[0].getSchedule().compareTo(s.getFlightsToArray()[2].getSchedule())<0 
	    				||s.getFlightsToArray()[1].getSchedule().compareTo(s.getFlightsToArray()[2].getSchedule())<0);
	    	
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		}
	}
}
