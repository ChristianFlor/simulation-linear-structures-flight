package model;

public class ListCities {
	private String name;
	private int id;
	private ListCities next;
	private ListCities prev;
	
	public ListCities(String name,int id) {
		this.name = name;
		this.id= id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ListCities getNext() {
		return next;
	}

	public void setNext(ListCities next) {
		this.next = next;
	}

	public ListCities getPrev() {
		return prev;
	}

	public void setPrev(ListCities prev) {
		this.prev = prev;
	}
	
}
