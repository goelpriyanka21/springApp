package helperclasses;

import java.util.List;

public class Commute<E> {
	public Commute(int i, List<E> asList, String bestplacestohangout) {
		// TODO Auto-generated constructor stub
		
		this.rating=i;
		this.alldetails= asList;
		this.bestplacestohangout= bestplacestohangout;
	}
	int rating; //"scale of 0-10"
	List<E> alldetails;
	String bestplacestohangout;
}
