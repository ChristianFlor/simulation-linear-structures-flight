package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.SecureRandom;

public class Simulation {
	// -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------
	public final static String PATH_AIRLINES="data/airlines.txt";
	public final static String PATH_CITIES="data/cities.txt";
	// -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------
	private int numberFlights;
	private Flight firstFlight;
	private ListAirlines firstAirlines;
	private ListCities firstCities;

	// -----------------------------------------------------------------
    // Builder
    // -----------------------------------------------------------------
	public Simulation(int number) {
		numberFlights = number;
	}
	
	// -----------------------------------------------------------------
    // Methods for add linked list
    // -----------------------------------------------------------------
	public void addFlight(DateFlight date, Time schedule, String nameAirline,String idAirline, String destinationCity) {
		int cont=0;
		Flight newFlight = new Flight(date,schedule, nameAirline, idAirline, destinationCity);
		if(firstFlight == null) {
			firstFlight = newFlight;
		}
		else {
			Flight current = firstFlight;
			while(current.getNext() != null && cont<numberFlights) {
				current = current.getNext();
				cont++;
			}
			current.setNext(newFlight);
			current.getNext().setPrev(current);
		}
	}
	
	public void addListAirlines(String name, int id) {
		ListAirlines b = new ListAirlines(name,id);
		if(firstAirlines == null){
			firstAirlines =b;
		}else{
			ListAirlines current = firstAirlines;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(b);
			current.getNext().setPrev(current);
		}
	}
	public void addListCities(String name, int id) {
		ListCities b = new ListCities(name,id);
		if(firstCities == null){
			firstCities =b;
		}else{
			ListCities current = firstCities;
			while(current.getNext() != null){
				current = current.getNext();
			}
			current.setNext(b);
			current.getNext().setPrev(current);
		}
	}
	// -----------------------------------------------------------------
    // Methods for search in linked list
    // -----------------------------------------------------------------
	
	public String searchListAirline(int n) {
		ListAirlines match = firstAirlines;
		ListAirlines current = firstAirlines;
		while(current!=null ) {
			if(current.getId()==n) {
				match = current;
			}
			current = current.getNext();
		}
		return match.getName();
	}
	
	public String searchListCities(int n) {
		ListCities match = firstCities;
		ListCities current = firstCities;
		while(current!=null) {
			if(current.getId()==n) {
				match = current;
			}
			current = current.getNext();
		}
		return match.getName();
	}
	public String searchFlightByAirline(String n) {
		Flight match = null;
		Flight current = firstFlight;
		while(current!=null && match==null) {
			if(current.getNameAirline().equalsIgnoreCase(n)) {
				match = current;
			}
			current = current.getNext();
		}
		return match.toString();
	}
	public String searchFlightByCode(String n) {
		Flight match = null;
		Flight current = firstFlight;
		while(current!=null && match==null) {
			if(current.getIdAirline().equalsIgnoreCase(n)) {
				match = current;
			}
			current = current.getNext();
		}
		return match.toString();
	}
	public String searchFlightByGate(String n) {
		int gate= Integer.parseInt(n);
		Flight match = null;
		Flight current = firstFlight;
		while(current!=null && match==null) {
			int currentGate=  Integer.parseInt(current.getBoardingGate());
			if(currentGate==gate) {
				match = current;
			}
			current = current.getNext();
		}
		return match.toString();
	}
	public String searchFlightByDestination(String n) {
		Flight match = null;
		Flight current = firstFlight;
		while(current!=null && match==null) {
			if(current.getDestinationCity().equalsIgnoreCase(n)) {
				match = current;
			}
			current = current.getNext();
		}
		return match.toString();
	}
	public String searchFlightByDate(String n) {
		Flight match = null;
		Flight current = firstFlight;
		while(current!=null && match==null) {
			if(current.getDate().toString().equalsIgnoreCase(n)) {
				match = current;
			}
			current = current.getNext();
		}
		return match.toString();
	}
	public String searchFlightByTime(String n) {
		Flight match = null;
		Flight current = firstFlight;
		while(current!=null && match==null) {
			if(current.getSchedule().toString().equalsIgnoreCase(n)) {
				match = current;
			}
			current = current.getNext();
		}
		return match.toString();
	}
	// -----------------------------------------------------------------
    // Methods for count the size of linked list
    // -----------------------------------------------------------------
	public int sizeOfListCities(){
		int size=0;
		ListCities current = firstCities;
		while(current != null){
			size++;
			current = current.getNext();
		}
		return size;
		
	}
	public int sizeOfListAirlines(){
		int size=0;
		ListAirlines current = firstAirlines;
		while(current != null){
			size++;
			current = current.getNext();
		}
		return size;
		
	}
	public int sizeOfListFlights(){
		int size=0;
		Flight current = firstFlight;
		while(current != null){
			size++;
			current = current.getNext();
		}
		return size;
		
	}
	// -----------------------------------------------------------------
    // Methods for return linked list
    // -----------------------------------------------------------------
	
	public Flight[] getFlightsToArray() {
		Flight[] flights;
		flights = new Flight[numberFlights];
		int c = 0;
		Flight current = firstFlight;
		 	while(current!=null) {
		 		flights[c]= current;
		 		current = current.getNext();
		 		c++;
		 	}
		return flights;
	}
	
	// -----------------------------------------------------------------
    // Methods of model solution
    // -----------------------------------------------------------------
	
	public void generateSimulation(){
		SecureRandom r = new SecureRandom();
		load(PATH_AIRLINES);
		load(PATH_CITIES);
		String nameAirline="";
		String destinationCity ="";
		String id="";
		for (int i = 0; i <getNumberFlights() ; i++) {
			
			nameAirline = searchListAirline(r.nextInt(32));
			destinationCity = searchListCities(r.nextInt(67));
			String in= nameAirline.substring(0, 2);
			id= in+(r.nextInt(100000));
			addFlight(new DateFlight(), new Time(), nameAirline, id, destinationCity);
			
		}
		sortByDate2();
	}
	

	public void load(String path) {
		try{
			BufferedReader lector = new BufferedReader(new FileReader(path));
			String linea= lector.readLine();
			int cont=0;
			int cont2=0;
			while (linea!= null ){
				if(path.equals(PATH_AIRLINES)) {
					cont++;
					addListAirlines(linea,cont);
				}else if(path.equals(PATH_CITIES)) {
					cont2++;
					addListCities(linea,cont2);
				}
				linea = lector.readLine();
			}
			lector.close();
		}catch (Exception e){
			//String r= "Error reading the file";
		}
	}

	public String flightInString() {
		String list = "";
		Flight current = firstFlight;
		while(current != null) {
			list += current.toString();
			current = current.getNext();
		}
		return list;
	}
	// -----------------------------------------------------------------
    // Methods for sort linked list
    // -----------------------------------------------------------------
	
	public void bubbleSort() {
		if(firstFlight != null) {
			Flight temp = firstFlight;
			int counter = 0;
			int size = sizeOfListAirlines();
			while(temp != null) {
				Flight current = firstFlight;
				int counter2 = 0;
				while(current.getNext() != null && counter2 < size-counter) {
					if(current.getNameAirline().compareTo(current.getNext().getNameAirline()) >= 0) {
						if(firstFlight == current) firstFlight = current.getNext();
						Flight next = current.getNext().getNext();
						Flight prev = current.getPrev();
						if(next != null) next.setPrev(current);
						if(prev != null) prev.setNext(current.getNext());
						current.getNext().setNext(current);
						current.getNext().setPrev(prev);
						current.setPrev(current.getNext());
						current.setNext(next);
					} else {
						current = current.getNext();
					}
					counter2++;
				}
				counter++;
				temp = temp.getNext();
			}
		}
	}
	public void sortByDestination() {
		// TODO Use of bubble sort
		if(firstFlight != null) {
			Flight temp = firstFlight;
			int counter = 0;
			int size = sizeOfListAirlines();
			while(temp != null) {
				Flight current = firstFlight;
				int counter2 = 0;
				while(current.getNext() != null && counter2 < size-counter) {
					if(current.getDestinationCity().compareTo(current.getNext().getDestinationCity()) > 0) {
						if(firstFlight == current) firstFlight = current.getNext();
						Flight next = current.getNext().getNext();
						Flight prev = current.getPrev();
						if(next != null) next.setPrev(current);
						if(prev != null) prev.setNext(current.getNext());
						current.getNext().setNext(current);
						current.getNext().setPrev(prev);
						current.setPrev(current.getNext());
						current.setNext(next);
					} else {
						current = current.getNext();
					}
					counter2++;
				}
				counter++;
				temp = temp.getNext();
			}
		}
	}
	public void sortByGate() {
		// TODO Use of insertion sort
		if(firstFlight.getNext() != null) {
			Flight current = firstFlight.getNext();
			while(current != null) {
				Flight temp = current;
				while(temp.getPrev() != null) {
					if(Integer.parseInt(temp.getBoardingGate()) < Integer.parseInt(temp.getPrev().getBoardingGate())) {
						if(temp.getPrev() == firstFlight) firstFlight = temp;
						Flight next = temp.getNext();
						Flight prev = temp.getPrev().getPrev();
						if(next != null) next.setPrev(temp.getPrev());
						if(prev != null) prev.setNext(temp);
						temp.setNext(temp.getPrev());
						temp.getPrev().setPrev(temp);
						temp.getPrev().setNext(next);
						temp.setPrev(prev);
					} else {
						temp = temp.getPrev();
					}
				}
				current = current.getNext();
			}
		}
		
	}
	public void sortByDate2() {
		// TODO Use of insertion sort
		if(firstFlight.getNext() != null) {
			Flight current = firstFlight.getNext();
			while(current != null) {
				Flight temp = current;
				while(temp.getPrev() != null) {
					if(temp.getDate().compareTo(temp.getPrev().getDate()) < 0) {
						if(temp.getPrev() == firstFlight) firstFlight = temp;
						Flight next = temp.getNext();
						Flight prev = temp.getPrev().getPrev();
						if(next != null) next.setPrev(temp.getPrev());
						if(prev != null) prev.setNext(temp);
						temp.setNext(temp.getPrev());
						temp.getPrev().setPrev(temp);
						temp.getPrev().setNext(next);
						temp.setPrev(prev);
					} else {
						temp = temp.getPrev();
					}
				}
				current = current.getNext();
			}
		}
		
	}
	public void sortByTime2() {
		// TODO Use of insertion sort
		if(firstFlight.getNext() != null) {
			Flight current = firstFlight.getNext();
			while(current != null) {
				Flight temp = current;
				while(temp.getPrev() != null) {
					if(temp.getSchedule().compareTo(temp.getPrev().getSchedule()) < 0) {
						if(temp.getPrev() == firstFlight) firstFlight = temp;
						Flight next = temp.getNext();
						Flight prev = temp.getPrev().getPrev();
						if(next != null) next.setPrev(temp.getPrev());
						if(prev != null) prev.setNext(temp);
						temp.setNext(temp.getPrev());
						temp.getPrev().setPrev(temp);
						temp.getPrev().setNext(next);
						temp.setPrev(prev);
					} else {
						temp = temp.getPrev();
					}
				}
				current = current.getNext();
			}
		}
		
	}
	public void sortByCode() {
		// TODO use of selection sort
		Flight current = firstFlight;
		while(current != null) {
			Flight temp = current.getNext();
			Flight min = current;
			while(temp != null) {
				if(temp.getIdAirline().compareTo(min.getIdAirline()) <= 0 ) {
					min = temp;
				}
				temp = temp.getNext();
			}
			boolean firstIt = false;
			if(min != current) {
				Flight next1 = current.getNext();
				Flight previous1 = current.getPrev();
				
				Flight next2 = min.getNext();
				Flight previous2 = min.getPrev();
				
				if(min == current.getNext()	) {
					if(previous1 != null) previous1.setNext(min);
					else {
						firstFlight = min;
						firstIt = true;
					}
					current.setNext(next2);
					current.setPrev(min);
					if(next2 != null) next2.setPrev(current);
					min.setNext(current);
					min.setPrev(previous1);
				} else {
					if(next1 != null) next1.setPrev(min);
					if(previous1 != null) previous1.setNext(min);
					else {
						firstFlight = min;
						firstIt = true;
					}
					
					min.setNext(next1);
					min.setPrev(previous1);
					
					if(next2 != null) next2.setPrev(current);
					if(previous2 != null) previous2.setNext(current);
					
					current.setNext(next2);
					current.setPrev(previous2);
				}
				current = min;
			}	
			if(firstIt) {
				current = firstFlight.getNext();
			} else {
				current = current.getNext();
			}
		}
	}
	
	// -----------------------------------------------------------------
    // Methods Atributes
    // -----------------------------------------------------------------
	public int getNumberFlights() {
		return numberFlights;
	}

	public void setNumberFlights(int numberFlights) {
		this.numberFlights = numberFlights;
	}

	public Flight getFirstFlight() {
		return firstFlight;
	}
	public void setFirstFlight(Flight firstFlight) {
		this.firstFlight = firstFlight;
	}
	public ListAirlines getFirstAirlines() {
		return firstAirlines;
	}
	public void setFirstAirlines(ListAirlines firstAirlines) {
		this.firstAirlines = firstAirlines;
	}
}
