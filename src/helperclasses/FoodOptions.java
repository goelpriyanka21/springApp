package helperclasses;

import java.util.List;

public class FoodOptions<E> {
	int rating; //"scale of 0-10"
	List<E> alldetails;
	int qualityrating;
	
	public FoodOptions(int rating, List<E> alldetails, int qualityrating) {
		// TODO Auto-generated constructor stub
		
		this.rating=rating;
		this.alldetails= alldetails;
		this.qualityrating= qualityrating;
	}
}
