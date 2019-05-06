package model;

public class ListAirlines {
	private String name;
	private int id;
	private ListAirlines next;
	private ListAirlines prev;
	
	public ListAirlines(String name, int id) {
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

	public ListAirlines getNext() {
		return next;
	}

	public void setNext(ListAirlines next) {
		this.next = next;
	}

	public ListAirlines getPrev() {
		return prev;
	}

	public void setPrev(ListAirlines prev) {
		this.prev = prev;
	}
	
}
