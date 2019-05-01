package model;

import java.util.Comparator;

public class IdAirlineComparator implements Comparator<Flight>{

	public int compare(Flight o1, Flight o2) {
		int comparation=0;
		String city1=o1.getIdAirline();
		String city2=o2.getIdAirline();
		if(city1.compareTo(city2)<0){
			comparation=-1;
		}else if(city1.compareTo(city2)>0){
			comparation=1;
		}else{
			comparation=0;
		}
		return comparation;
	}
}
