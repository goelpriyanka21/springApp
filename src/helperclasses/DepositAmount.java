package helperclasses;

import javax.validation.constraints.Digits;

public class DepositAmount {
	@Digits(fraction = 0, integer = 10)
	public int depositamount;
	public Boolean onemonthrent;

	public DepositAmount(int i, boolean b) {
		// TODO Auto-generated constructor stub
		this.depositamount=i;
		this.onemonthrent=b;
		
	}
	}