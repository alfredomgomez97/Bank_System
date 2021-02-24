package banking_system;

import java.util.ArrayList;


public class FactoryCustomer {
	private Customer customer;
	private static int Idgenerator = 100000;
	
	public Customer createCustomer(String name, int stateId,ArrayList<Account> Accounts) {
		customer = new Customer(generateId(), name, stateId, Accounts);
		return customer;
		
	}
	public int generateId() {
		Idgenerator+=1;
		return Idgenerator;
		
	}
}
