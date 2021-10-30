
package question;

public class Customer {
	
	//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE
	private int ID;
	private int age;
	private double limitingAmount;
	private String name;
	private Operator operator;
	private Bill bill;
	private double moneyPaid = 0;
	private int timeTalked = 0;
	private int quantitiyMessaged = 0;
	private double quantityConnected = 0;
	
	public Customer(int ID, String name, int age, Operator operator, double limitingAmount) {
		this.ID = ID;
		this.name = name;
		this.age = age;
		this.operator = operator;
		this.limitingAmount = limitingAmount;
		this.bill = new Bill(limitingAmount);
		
	}
	
	void talk(int minute, Customer other) {
		if (other.ID == this.ID) {
			;
		}
		else if (bill.check((bill.getCurrentDebt() + operator.calculateTalkingCost(minute, this)))) {
			bill.setCurrentDebt(bill.getCurrentDebt()+operator.calculateTalkingCost(minute, this));
			this.operator.setNumTalking(this.operator.getNumTalking() + minute);
			other.operator.setNumTalking(other.operator.getNumTalking() + minute);
			this.setTimeTalked(this.getTimeTalked()+minute);
			other.setTimeTalked(other.getTimeTalked()+minute);
		}
	}
	
	void message(int quantity, Customer other) {
		if (bill.check(bill.getCurrentDebt() + operator.calculateMessageCost(quantity, this, other))) {
			bill.setCurrentDebt(bill.getCurrentDebt()+operator.calculateMessageCost(quantity, this, other));
			this.operator.setNumMessages(this.operator.getNumMessages()+quantity);
			this.setQuantitiyMessaged(this.getQuantitiyMessaged()+quantity);
			
		}
	}
	
	void connection(double amount) {
		if (bill.check(bill.getCurrentDebt()+operator.calculateNetworkCost(amount))) {
			bill.setCurrentDebt(bill.getCurrentDebt()+operator.calculateNetworkCost(amount));
			this.operator.setNumInternet(this.operator.getNumInternet()+amount);
			this.setQuantityConnected(this.getQuantityConnected()+amount);
		}	
	}

	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}
	
	
	public Operator getOperator() {
		return operator;
	}
	
	public void setOperator(Operator operator) {
		this.operator = operator;
	}
	
	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public double getLimitingAmount() {
		return limitingAmount;
	}

	public void setLimitingAmount(double limitingAmount) {
		this.limitingAmount = limitingAmount;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getMoneyPaid() {
		return moneyPaid;
	}

	public void setMoneyPaid(double moneyPaid) {
		this.moneyPaid = moneyPaid;
	}

	public int getTimeTalked() {
		return timeTalked;
	}

	public void setTimeTalked(int timeTalked) {
		this.timeTalked = timeTalked;
	}

	public int getQuantitiyMessaged() {
		return quantitiyMessaged;
	}

	public void setQuantitiyMessaged(int quantitiyMessaged) {
		this.quantitiyMessaged = quantitiyMessaged;
	}

	public double getQuantityConnected() {
		return quantityConnected;
	}

	public void setQuantityConnected(double quantityConnected) {
		this.quantityConnected = quantityConnected;
	}
	
	
	
	//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
}

