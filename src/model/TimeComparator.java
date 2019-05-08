package model;

import java.util.Comparator;

public class TimeComparator implements Comparator<Flight> {

	@Override
	public int compare(Flight o1, Flight o2) {

		int comparation = o1.getSchedule().compareTo(o2.getSchedule());
		return comparation;
	}

}
