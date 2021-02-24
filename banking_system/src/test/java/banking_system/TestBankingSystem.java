package banking_system;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBankingSystem {
	FactoryCustomer factoryCustomer;
	AccountantController controller;
	Account account;
	

	@Before
	public void setUp()  {
	factoryCustomer = new FactoryCustomer();
	controller = new AccountantController();	
	}

	@Test
	public void TestCreateACustomerFromController() {
	//Arrange
	String expectedName = "John";
	int expectedId = 12345;
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	//Act
	Customer actualCustomer = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	boolean statement = false;
	//Assert
	if(actualCustomer instanceof Customer) {statement = true;}
	assertTrue(statement);
	}
	
	@Test
	public void TestGetCustomerFromHashMapCollectionOfCustomers() {
	//Arrange
	String expectedName = "John";
	int expectedId = 12345;
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	Customer expectedCustomer = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	//Act & Assert
	assertTrue(expectedCustomer.equals(controller.getCustomer(expectedCustomer)));
	}
	
	@Test 
	public void TestThatACustomerHasACheckingAccount() {
	//Arrange
	String expectedName = "John";
	int expectedId = 12345;
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	//Act
	Customer expectedCustomer = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	Account actualAccount = controller.createAccount("Checking", expectedCustomer);
	//Assert
	boolean statement = false;
	if(controller.getAccount(actualAccount.getAccountId()) instanceof CheckingAccount) {statement = true;}
	assertTrue(statement);
	}
	
	@Test
	public void TestThatTheDepositMethodUpdatesTheCustomersCheckingBalance() {
	//Arrange
	float expectedBalance = 20.00f;
	String expectedName = "John";
	int expectedId = 12345;
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	//act
	Customer expectedCustomer = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	Account expectedAccount =  controller.createAccount("Checking", expectedCustomer);
	controller.getAccount(expectedAccount.getAccountId()).depositBalance(expectedBalance);
	float actualBalance = controller.getAccount(expectedAccount.getAccountId()).getBalance();
	Assert.assertEquals(expectedBalance,actualBalance,0.0f);
	}
	@Test
	public void TestThatTheDepositMethodUpdatesTheCustomersSavingsBalance() {
	//Arrange
	float expectedBalance = 20.00f;
	String expectedName = "John";
	int expectedId = 12345;
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	//act
	Customer expectedCustomer = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	Account expectedAccount = controller.createAccount("Savings", expectedCustomer);
	controller.getAccount(expectedAccount.getAccountId()).depositBalance(expectedBalance);
	float actualBalance = controller.getAccount(expectedAccount.getAccountId()).getBalance();
	Assert.assertEquals(expectedBalance,actualBalance,0.0f);
	}
	@Test
	public void TestTheWithdrawBalanceFromCustomersSavingsAccounts() {
	//Arrange
	float Balance = 20.00f;
	float balanceWithdrawn = 4.00f;
	float expectedBalance = 16.00f;
	String expectedName = "John";
	int expectedId = 12345;
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	//Act
	Customer expectedCustomer = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	Account expectedAccount = controller.createAccount("Savings", expectedCustomer);
	controller.getAccount(expectedAccount.getAccountId()).depositBalance(Balance);
	controller.getAccount(expectedAccount.getAccountId()).withdrawBalance(balanceWithdrawn);	
	float actualBalance = controller.getAccount(expectedAccount.getAccountId()).getBalance();
	//Assert
	Assert.assertEquals(expectedBalance,actualBalance,0.0f);
	}
	@Test
	public void TestTheWithdrawBalanceFromCustomersCheckingAccounts() {
	//Arrange
	float Balance = 20.00f;
	float balanceWithdrawn = 4.00f;
	float expectedBalance = 16.00f;
	String expectedName = "John";
	int expectedId = 12345;
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	//Act
	Customer expectedCustomer = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	Account expectedAccount = controller.createAccount("Checking", expectedCustomer);
	controller.getAccount(expectedAccount.getAccountId()).depositBalance(Balance);
	controller.getAccount(expectedAccount.getAccountId()).withdrawBalance(balanceWithdrawn);	
	float actualBalance = controller.getAccount(expectedAccount.getAccountId()).getBalance();
	//Assert
	Assert.assertEquals(expectedBalance,actualBalance,0.0f);
	}
	@Test
	public void TestRemoveCheckingAccountFromCustomer() {
	String expectedName = "John";
	String accountType = "Checking";
	int expectedId = 12345;
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	Customer expectedCustomer = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	Account cheackingAccount = controller.createAccount(accountType, expectedCustomer);	
	//Act
	controller.removeAccount(cheackingAccount);
	boolean statement = controller.getAllAccounts().containsKey(expectedCustomer.getCustomerId());
	//Assert
	assertFalse(statement);
	}
	@Test
	public void RemoveCustomerFromTheSystem() {
		
	}
	

}
