package model;

import java.util.Random;

public class Flight implements Comparable<Flight> {
	private DateFlight date;
	private Time schedule;
	private String nameAirline;
	private String idAirline;
	private String destinationCity;
	private String boardingGate;
	private Flight next;
	private Flight prev;
	
	public Flight(DateFlight date, Time schedule, String nameAirline,String idAirline, String destinationCity) {
		Random random = new Random();
		this.date = date;
		this.schedule = schedule;
		this.nameAirline = nameAirline;
		this.idAirline = idAirline;
		this.destinationCity = destinationCity;
		this.boardingGate =  random.nextInt(20)+1+"";
	}
	public String toString() {
		String msg= " \n";
		msg+= date.toString()+ "\t"+schedule.toString()+"\t"+getNameAirline()+"\t"+getIdAirline()+"\t"+getDestinationCity()+"\t"+getBoardingGate();
		return msg;
	}
	public DateFlight getDate() {
		return date;
	}
	public void setDate(DateFlight date) {
		this.date = date;
	}
	public Time getSchedule() {
		return schedule;
	}
	public void setSchedule(Time schedule) {
		this.schedule = schedule;
	}
	public String getNameAirline() {
		return nameAirline;
	}
	public void setNameAirline(String nameAirline) {
		this.nameAirline = nameAirline;
	}
	public String getIdAirline() {
		return idAirline;
	}
	public void setIdAirline(String idAirline) {
		this.idAirline = idAirline;
	}
	public String getDestinationCity() {
		return destinationCity;
	}
	public void setDestinationCity(String destinationCity) {
		this.destinationCity = destinationCity;
	}
	public String getBoardingGate() {
		return boardingGate;
	}
	public void setBoardingGate(String boardingGate) {
		this.boardingGate = boardingGate;
	}

	
	public Flight getNext() {
		return next;
	}
	public void setNext(Flight next) {
		this.next = next;
	}
	public Flight getPrev() {
		return prev;
	}
	public void setPrev(Flight prev) {
		this.prev = prev;
	}
	@Override
	public int compareTo(Flight otherFlight) {
		
		int comparation = date.compareTo(otherFlight.date);
		return comparation;
	}


}
