package helperclasses;

import java.util.List;

public class Commute<E> {
	
	int rating; //"scale of 0-10"
	List<E> alldetails;
	String bestplacestohangout;
	
	public Commute(int i, List<E> alldetails, String bestplacestohangout) {
		// TODO Auto-generated constructor stub
		
		this.rating=i;
		this.alldetails= alldetails;
		this.bestplacestohangout= bestplacestohangout;
	}
	
}
