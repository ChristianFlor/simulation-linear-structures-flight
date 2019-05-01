package model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Simulation {
	public final static String PATH_AIRLINES="data/airlines.txt";
	public final static String PATH_CITIES="data/cities.txt";
	private int numberFlights;
	
	private Flight[] flights;
	private List <String> airlines;
	
	private List <String> cities;

	public Simulation(int numberFlights) {
	
		flights = new Flight[numberFlights];
		airlines = new ArrayList<String>();
		cities = new ArrayList<String>();
		
	}
	public String report() {
		String msg="";
		for (int i = 0; i < flights.length; i++) {
			msg+=flights[i].toString();
		}
		return msg;
	}
	public void load(String path) {
		try{
			BufferedReader lector = new BufferedReader(new FileReader(path));
			String linea= lector.readLine();
			
			while (linea!= null ){
				if(path.equals(PATH_AIRLINES)) {
					airlines.add(linea);
				}else if(path.equals(PATH_CITIES)) {
					cities.add(linea);
				}
				linea = lector.readLine();
			}
			lector.close();
		}catch (Exception e){
			//String r= "Error reading the file";
		}
	}
	public void generateSimulation(){
		Random random = new Random();
		SecureRandom r = new SecureRandom();
		load(PATH_AIRLINES);
		load(PATH_CITIES);
		String nameAirline=" ";
		String destinationCity =" ";
		String id="";
		for (int i = 0; i < flights.length; i++) {
			
			nameAirline = airlines.get(random.nextInt(32));
			destinationCity = cities.get(random.nextInt(67));
			String in= nameAirline.substring(0, 2);
			id= in+(r.nextInt(100000));
			flights[i] = new Flight(new DateFlight(), new Time(), nameAirline, id, destinationCity);
		}
		sortByDateFlight();
	}

	public void sortByBoardingGate(){
		for (int i = 0; i < flights.length-1; i++) {
			int minGate= Integer.parseInt(flights[i].getBoardingGate());
			int minPosition = i;
			for (int j = i; j < flights.length; j++) {
				int currentGate = Integer.parseInt(flights[j].getBoardingGate());
				if(currentGate<minGate) {
					minGate= currentGate;
					minPosition=j;
				}
			}
			Flight temp= flights[minPosition];
			flights[minPosition]=flights[i];
			flights[i]=temp;
		}
		
	}
	public void sortByNameAirline(){
		int i,j;
		String auxS;	

		for (i = 1; i < flights.length; i++){
			auxS = flights[i].getNameAirline();
			j = i - 1;
			while ( (j >= 0) && flights[j].getNameAirline().compareTo(auxS)>0) {	
				flights[j+1].setNameAirline(flights[j--].getNameAirline());
				flights[j+1].setNameAirline(auxS);
			}
		}	
	}

	public void sortByDestinationCity(){
		for(int i = 0; i < flights.length - 1; i++){
            for(int j = 0; j < flights.length - 1; j++){
            	String minCity = flights[j].getDestinationCity();
            	String currentCity =flights[j+1].getDestinationCity();
            	if((currentCity.compareTo(minCity))<0) {
                    flights[j+1].setDestinationCity(minCity);
                    flights[j].setDestinationCity(currentCity);
        		}
            }
		}
	}
	public void sortByIdAirline(){
		Comparator<Flight> studentComparator = new IdAirlineComparator();
		Arrays.sort(flights, studentComparator);
		
	}	
	public void sortByDateFlight(){
		Arrays.sort(flights);
	}
	
	public void sortByTime(){
		Comparator<Flight> studentComparator = new TimeComparator();
		Arrays.sort(flights, studentComparator);
	}
	
	
	public int getNumberFlights() {
		return numberFlights;
	}

	public void setNumberFlights(int numberFlights) {
		this.numberFlights = numberFlights;
	}

	public Flight[] getFlights() {
		return flights;
	}

	public void setFlights(Flight[] flights) {
		this.flights = flights;
	}
	
	
}
