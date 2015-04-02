package helperclasses;

import java.util.List;

public class FoodOptions<E> {
	public FoodOptions(int i, List<E> asList, int qualityrating) {
		// TODO Auto-generated constructor stub
		
		this.rating=i;
		this.alldetails= asList;
		this.qualityrating= qualityrating;
	}
	int rating; //"scale of 0-10"
	List<E> alldetails;
	int qualityrating;
}
