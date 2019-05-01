package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class DateFlight implements Comparable<DateFlight>{
	private int date;
	private int month;
	private int year;
	public DateFlight() {
		Random random = new Random(); 
		this.date = random.nextInt(30)+1;
		this.month =random.nextInt(12)+1;
		this.year = random.nextInt(5)+2015;
	}
	public String toString() {
		return year+"-"+addZero(month)+"-"+addZero(date);
	}
	public String addZero(int n) {
		String msg="";
		if(n<10) {
			msg="0"+n;
		}else {
			msg=""+n;
		}
		return msg;
	}
	public int getDate() {
		return date;
	}
	public void setDate(int date) {
		this.date = date;
	}
	public int getMonth() {
		return month;
	}
	public void setMonth(int month) {
		this.month = month;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String compare() {
		return year+"-"+month+"-"+date;
	}
	@Override
	public int compareTo(DateFlight o){
		int comparation = 0;
		SimpleDateFormat objSDF = new SimpleDateFormat("yyyy-MM-dd"); 
	    Date dt_1;
	    Date dt_2;
		try {
			dt_1 = objSDF.parse(compare());
			dt_2 = objSDF.parse(o.compare());
			comparation=dt_1.compareTo(dt_2);
		} catch (ParseException e) {
			e.printStackTrace();
		}  
	   
		return comparation;
	}
}

