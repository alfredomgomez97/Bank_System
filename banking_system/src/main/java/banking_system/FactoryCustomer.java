package banking_system;

import java.util.ArrayList;


public class FactoryCustomer {
	private Customer customer;
	private static int Idgenerator = 100000;
	
	public Customer createCustomer(String name, int stateId,ArrayList<Account> expectedAccounts) {
		customer = new Customer();
		customer.setName(name);
		customer.setAccounts(expectedAccounts);
		customer.setStateid(stateId);
		customer.setCustomerId(generateId());
		return customer;
		
	}
	public int generateId() {
		Idgenerator+=1;
		return Idgenerator;
		
	}
}
