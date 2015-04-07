package helperclasses;

import java.util.List;

public class RatingAndListOfEsAndString<E> {
	int rating; //"scale of 0-10"
	List<E> alldetails;
	String anyotherissues;
	
	
	public RatingAndListOfEsAndString(int rating, List<E> alldetails, String anyotherissues) {
		// TODO Auto-generated constructor stub
		
		this.rating=rating;
		this.alldetails= alldetails;
		this.anyotherissues= anyotherissues;
	}
}
