package helperclasses;

import java.util.List;

import javax.validation.constraints.Size;

public class RatingAndListOfEs<E> {
	public RatingAndListOfEs(int i, List<E> asList) {
		// TODO Auto-generated constructor stub
		
		this.rating=i;
		this.alldetails= asList;
	}
	int rating; //"scale of 0-10"
	
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
	List<E> alldetails;
}
