package banking_system;

import java.util.ArrayList;
import java.util.HashMap;


public class AccountantController {
	
		private static HashMap<Integer,Customer> allCustomers = new HashMap<>();
		private static HashMap<Integer,Account> allAccounts = new HashMap<>();
		private FactoryCustomer factoryCustomer = new FactoryCustomer();
		
		public static HashMap<Integer, Customer> getAllCustomers() {
			return allCustomers;
		}

		public static void setAllCustomers(HashMap<Integer, Customer> allCustomers) {
			AccountantController.allCustomers = allCustomers;
		}

		public static HashMap<Integer, Account> getAllAccounts() {
			return allAccounts;
		}

		public static void setAllAccounts(HashMap<Integer, Account> allAccounts) {
			AccountantController.allAccounts = allAccounts;
		}

		public Customer createCustomer(String name, int stateId,ArrayList<Account> expectedAccounts) {
			Customer customerCreated = factoryCustomer.createCustomer(name, stateId, expectedAccounts);
			allCustomers.put(customerCreated.getCustomerId(), customerCreated);
			return customerCreated;
			
		}
		
		public Account createAccount(String accountType,Customer customer ) {
			String CheckingAccount = "Checking";
			String SavingsAccount = "Savings";
			Account account;
			if(accountType.equals(CheckingAccount)) {
				account = new CheckingAccount();
				account.setAccountId(account.idGenerator());
				customer.getAccounts().add(account);
				allAccounts.put(account.getAccountId(), account);
				return account;
			}else if(accountType.equals(SavingsAccount)) {
				account = new SavingsAccount();
				account.setAccountId(account.idGenerator());
				customer.getAccounts().add(account);
				allAccounts.put(account.getAccountId(), account);
				return account;
			}
			return null;
		}
		
		public Customer getCustomer(Customer customer) {
			return allCustomers.get(customer.getCustomerId());
		}
		public Account getAccount(Integer accountId) {
			return allAccounts.get(accountId);
		}
		public void removeAccount(Account account) {
			allAccounts.remove(account.getAccountId());
			for(Integer id:allCustomers.keySet()) {
			 allCustomers.get(id).getAccounts().remove(account);
			}
		}
		public void removeCustomer(Customer customer) {
			allCustomers.remove(customer.getCustomerId());
		}
		
}
