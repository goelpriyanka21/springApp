package helperclasses;

import java.util.List;

public class Commute<E> {
	
	Integer rating; //"scale of 0-10"
	List<E> alldetails;
	String bestplacestohangout;
	
	public Commute(int rating, List<E> alldetails, String bestplacestohangout) {
		// TODO Auto-generated constructor stub
		
		this.rating=rating;
		this.alldetails= alldetails;
		this.bestplacestohangout= bestplacestohangout;
	}
	
}
