
package question;

public class Operator {
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private int discountRate;
	private double talkingCharge;
	private double messageCost; 
	private double networkCharge;
	private int numTalking = 0;
	private int numMessages = 0;
	private double numInternet = 0;
	
	public Operator(int ID, int dicountRate, double talkingCharge, double messageCost, double networkCharge) {
		this.ID = ID;
		this.discountRate = dicountRate;
		this.messageCost = messageCost;
		this.networkCharge = networkCharge;
		this.talkingCharge = talkingCharge;
	}
	
	double calculateTalkingCost(int minute, Customer customer) {
		double newMinute = minute;
		double newDiscountRate = (100.0-(double)discountRate)/100.0;
		if ((customer.getAge() < 18) || (customer.getAge() > 65)) {		
			return newMinute*talkingCharge*newDiscountRate;			
		}
		else {
		return newMinute*talkingCharge;
		}
	}
	double calculateMessageCost(int quantity, Customer customer, Customer other) {
		double newQuantity = quantity;
		double newDiscountRate = (100.0-(double)discountRate)/100.0;
		if (customer.getOperator() == other.getOperator()) {
			return newQuantity*messageCost*newDiscountRate;
		}
		else {
			return newQuantity*messageCost;
		}		
	}
	double calculateNetworkCost(double amount) {
		return amount*networkCharge;
	}
	public int getNumTalking() {
		return numTalking;
	}

	public void setNumTalking(int numTalking) {
		this.numTalking = numTalking;
	}

	public int getNumMessages() {
		return numMessages;
	}

	public void setNumMessages(int numMessages) {
		this.numMessages = numMessages;
	}

	public double getNumInternet() {
		return numInternet;
	}

	public void setNumInternet(double numInternet) {
		this.numInternet = numInternet;
	}

	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

