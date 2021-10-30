
package question;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {


	public static void main(String args[]) {

		Customer[] customers;
		Operator[] operators;

		int C, O, N;

		File inFile = new File(args[0]);  // args[0] is the input file
		File outFile = new File(args[1]);  // args[1] is the output file
		PrintStream outstream1;
		try {
			outstream1 = new PrintStream(outFile);
		}catch(FileNotFoundException e2) {
			e2.printStackTrace();
			return;
		}
		Scanner reader;
		try {
			reader = new Scanner(inFile);
		} catch (FileNotFoundException e) {
			System.out.println("Cannot find input file");
			return;
		}

		C = reader.nextInt();
		O = reader.nextInt();
		N = reader.nextInt();

		customers = new Customer[C];
		operators = new Operator[O];

		//DO_NOT_EDIT_ANYTHING_ABOVE_THIS_LINE

		int customerID = 0;
		int operatorID = 0;

		for (int i=0; i<N; i++) {
			int operation = reader.nextInt();

			if (operation == 1) { //Creating a new Customer
				String customerName = reader.next();
				int custAge = reader.nextInt();
				int opIndex = reader.nextInt();
				double limAmount = reader.nextDouble();
				customers[customerID] = new Customer(customerID, customerName, custAge, operators[opIndex], limAmount);
				customerID++;
			}
			if (operation == 2) { //Creating a new Operator 
				double talkCharge = reader.nextDouble();
				double messCost = reader.nextDouble();
				double netwCharge = reader.nextDouble();
				int discRate = reader.nextInt();
				operators[operatorID] = new Operator(operatorID, discRate, talkCharge, messCost, netwCharge);
				operatorID++;
			}
			if (operation == 3) { //A customer talks to another customer 
				int firstCustomerID = reader.nextInt();
				int secondCustomerID = reader.nextInt();
				int time = reader.nextInt();
				customers[firstCustomerID].talk(time, customers[secondCustomerID]);
			}
			if (operation == 4) { //A customer sends message to another customer
				int firstCustomerID = reader.nextInt();
				int secondCustomerID = reader.nextInt();
				int quantity = reader.nextInt();
				customers[firstCustomerID].message(quantity, customers[secondCustomerID]);
			}
			if (operation == 5) { //A customer connects to the internet
				int firstCustomerID = reader.nextInt();
				double amount = reader.nextDouble();
				customers[firstCustomerID].connection(amount);
			}
			if (operation == 6) { //A customer pays his/her bills
				int firstCustomerID = reader.nextInt();
				double amount = reader.nextDouble();
				if (amount>customers[firstCustomerID].getBill().getCurrentDebt()) {
					customers[firstCustomerID].setMoneyPaid(customers[firstCustomerID].getMoneyPaid()+customers[firstCustomerID].getBill().getCurrentDebt());
					customers[firstCustomerID].getBill().pay(amount);
				}
				else {
					customers[firstCustomerID].setMoneyPaid(customers[firstCustomerID].getMoneyPaid()+amount);
					customers[firstCustomerID].getBill().pay(amount);

				}			
			}
			if (operation == 7) { //A customer changes his/her operator
				int firstCustomerID = reader.nextInt();
				int opID = reader.nextInt();
				customers[firstCustomerID].setOperator(operators[opID]);
			}
			if (operation == 8) { //A customer changes his/her Bill limit
				int firstCustomerID = reader.nextInt();
				double newLimit= reader.nextDouble();
				if (customers[firstCustomerID].getBill().getCurrentDebt()<newLimit)
					customers[firstCustomerID].getBill().changeTheLimit(newLimit);
			}
		}
		int talkerID = 0;
		int messagerID = 0;  // these are for customers.
		int connecterID = 0;

		for (int c=1; c<C; c++) { // finds the customer that talked most, sent messages most etc.
			if (customers[c].getTimeTalked() > customers[talkerID].getTimeTalked()) {
				talkerID = c;
			}
			if (customers[c].getQuantitiyMessaged() > customers[messagerID].getQuantitiyMessaged()) {
				messagerID = c;
			}
			if (customers[c].getQuantityConnected() > customers[connecterID].getQuantityConnected()) {
				connecterID = c;
			}
		}

		for (int o=0; o<operators.length;o++) {
			outstream1.print("Operator "+o+" : "+ operators[o].getNumTalking()+" "+ operators[o].getNumMessages()+" "+ String.format("%.2f", operators[o].getNumInternet())+"\n" ); // internet convert
		}
		for (int c=0; c<customers.length;c++) {
			outstream1.print("Customer "+c+" : "+String.format("%.2f", customers[c].getMoneyPaid())+" "+String.format("%.2f", customers[c].getBill().getCurrentDebt())+"\n");
		}
		outstream1.print(customers[talkerID].getName()+" : "+customers[talkerID].getTimeTalked()+"\n");
		outstream1.print(customers[messagerID].getName()+" : "+customers[messagerID].getQuantitiyMessaged()+"\n");
		outstream1.print(customers[connecterID].getName()+" : "+String.format("%.2f", customers[connecterID].getQuantityConnected())+"\n");

		reader.close();
		outstream1.close();
		//DO_NOT_EDIT_ANYTHING_BELOW_THIS_LINE
	} 
}

