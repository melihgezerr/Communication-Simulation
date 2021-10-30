
package question;

public class Bill {

	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private double limitingAmount;
	private double currentDebt = 0.0;
	
	public Bill(double limitingAmount) {
		this.limitingAmount = limitingAmount;
	}
	
	boolean check(double amount) {
		if (amount > limitingAmount) {
			return false;
		}
		else {
			return true;
		}
	}
	void add(double amount) {
		currentDebt += amount;
	}
	
	void pay(double amount) {
		if (amount>currentDebt)
			currentDebt = 0.0;
		else
			currentDebt -= amount;
	}
	
	void changeTheLimit(double amount) {
		limitingAmount = amount;
	}
	
	public double getLimitingAmount() {
		return limitingAmount;
	}
	
	public void setLimitingAmount(double limitingAmount) {
		this.limitingAmount = limitingAmount;
	}
	
	public double getCurrentDebt() {
		return currentDebt;
	}
	
	public void setCurrentDebt(double currentDebt) {
		this.currentDebt = currentDebt;
	}


	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

