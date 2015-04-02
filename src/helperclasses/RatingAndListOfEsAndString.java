package helperclasses;

import java.util.List;

public class RatingAndListOfEsAndString<E> {
	public RatingAndListOfEsAndString(int i, List<E> asList, String anyotherissues) {
		// TODO Auto-generated constructor stub
		
		this.rating=i;
		this.alldetails= asList;
		this.anyotherissues= anyotherissues;
	}
	int rating; //"scale of 0-10"
	List<E> alldetails;
	String anyotherissues;
}
