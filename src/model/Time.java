package model;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class Time implements Comparable<Time>{
	
	private int hour;
	private int minute;
	private String format;
	
	public Time() {
		Random random = new Random(); 
		this.hour = random.nextInt(12)+1;
		this.minute = random.nextInt(60)+1;
		String[] dirs = {"AM","PM"};
		String rFormat = dirs[hour%2==0?0:1];
		this.format = rFormat;
	}
	public String toString() {
		return addZero(hour)+":"+addZero(minute)+" "+format;
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
	public int getHour() {
		return hour;
	}
	public void setHour(int hour) {
		this.hour = hour;
	}
	public int getMinute() {
		return minute;
	}
	public void setMinute(int minute) {
		this.minute = minute;
	}
	public String getFormat() {
		return format;
	}
	public void setFormat(String format) {
		this.format = format;
	}
	@Override
	public int compareTo(Time t) {
		int comparation =0;
		DateFormat objSDF = new SimpleDateFormat("HH:mm"); 
	    Date time_1;
	    Date time_2;
		try {
			
			time_1 = objSDF.parse(toString());
			time_2 = objSDF.parse(t.toString());
			comparation= time_1.compareTo(time_2);
		} catch (ParseException e) {
			e.printStackTrace();
		}  

		return comparation;
	}


}
