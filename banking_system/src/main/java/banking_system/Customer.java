package banking_system;

import java.util.ArrayList;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class Customer {
	private static int idAssigner = 1000;
	private int customerId;
	private String Name;
	private int stateid;
	@JsonDeserialize(using=AccountsDeserializer.class)
	private ArrayList<CheckingAccount> checkingAccounts = new ArrayList<>();
	

	public ArrayList<CheckingAccount> getAccounts() {
		return checkingAccounts;
	}
	public void setAccounts(ArrayList<CheckingAccount> accounts) {
		checkingAccounts = accounts;
	}
	public int getStateid() {
		return stateid;
	}
	public void setStateid(int stateid) {
		this.stateid = stateid;
	}
	
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public int getCustomerId() {
		return stateid;
	}
	public void setCustomerId(int customerId) {
		this.stateid = customerId;
	}
	

	@Override
	public boolean equals(Object currentUser) { 
	
	if(currentUser == this) {
		return true;
	}
	 if (!(currentUser instanceof Customer)) { 
            return false; 
        } 
	  
	  Customer user = (Customer) currentUser;
	  return Name.equals(user.getName()) && Integer.compare(customerId, user.customerId) == 0
			 && Integer.compare(stateid, user.stateid) == 0;
	}
	public void createCustomerId() {
		setCustomerId(idAssigner++);
		idAssigner += 1;
	}
	
	


}
