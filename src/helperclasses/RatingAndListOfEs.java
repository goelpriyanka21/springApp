package helperclasses;

import java.util.List;

public class RatingAndListOfEs<E> {
	public RatingAndListOfEs(int i, List<E> asList) {
		// TODO Auto-generated constructor stub
		
		this.rating=i;
		this.alldetails= asList;
	}
	int rating; //"scale of 0-10"
	List<E> alldetails;
}
