package helperclasses;

import java.util.List;

public class RatingAndListOfEs<E> {
	
	int rating; //"scale of 0-10"
	List<E> alldetails;
	
	public RatingAndListOfEs(int rating, List<E> alldetails) {
		// TODO Auto-generated constructor stub
		
		this.rating=rating;
		this.alldetails= alldetails;
	}
	
	
	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public List<E> getAlldetails() {
		return alldetails;
	}

	public void setAlldetails(List<E> alldetails) {
		this.alldetails = alldetails;
	}
	
}
