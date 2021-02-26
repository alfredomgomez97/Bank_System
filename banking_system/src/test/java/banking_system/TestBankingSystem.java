package banking_system;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TestBankingSystem {
	private FactoryCustomer factoryCustomer;
	private AccountantController controller;
	private CheckingAccount account;
	private CustomerSerializer customerSerializer;
	private String savedData;
	private String firstCustomerName;
	private ArrayList<Account> customerAccounts;
	private int id = 1234;
	private Customer expectedCustomer;
	

	@Before
	public void setUp()  {
	factoryCustomer = new FactoryCustomer();
	controller = new AccountantController();
	customerAccounts = new ArrayList<>();
	savedData = "./savedData.json";
	customerSerializer = new CustomerSerializer(savedData);
	account = new CheckingAccount();
	customerAccounts.add(account);
	expectedCustomer = factoryCustomer.createCustomer(firstCustomerName, id, customerAccounts);
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
	Customer expectedCustomerFromHashMap = controller.createCustomer(expectedName, expectedId, expectedAccounts);
	//Act & Assert
	assertTrue(expectedCustomerFromHashMap.equals(controller.getCustomer(expectedCustomerFromHashMap)));
	}
	
	@Test 
	public void TestThatACustomerHasACheckingAccount() {
	
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
	ArrayList<Account> expectedAccounts = new ArrayList<>();
	//act
	
	Account expectedAccount =  controller.createAccount("Checking", expectedCustomer);
	controller.getAccount(expectedAccount.getAccountId()).depositBalance(expectedBalance);
	float actualBalance = controller.getAccount(expectedAccount.getAccountId()).getBalance();
	Assert.assertEquals(expectedBalance,actualBalance,0.0f);
	}
	@Test
	public void TestThatTheDepositMethodUpdatesTheCustomersSavingsBalance() {
	//Arrange
	float expectedBalance = 20.00f;
	Account expectedAccount = controller.createAccount("Savings", expectedCustomer);
	//act
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
	//Act
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
	//Act
	Account expectedAccount = controller.createAccount("Checking", expectedCustomer);
	controller.getAccount(expectedAccount.getAccountId()).depositBalance(Balance);
	controller.getAccount(expectedAccount.getAccountId()).withdrawBalance(balanceWithdrawn);	
	float actualBalance = controller.getAccount(expectedAccount.getAccountId()).getBalance();
	//Assert
	Assert.assertEquals(expectedBalance,actualBalance,0.0f);
	}
	@Test
	public void TestRemoveCheckingAccountFromCustomer() {
	String accountType = "Checking";
	Account cheackingAccount = controller.createAccount(accountType, expectedCustomer);	
	//Act
	controller.removeAccount(cheackingAccount);
	boolean statement = controller.getAllAccounts().containsKey(expectedCustomer.getCustomerId());
	//Assert
	assertFalse(statement);
	}
	
	@Test
	public void TestTheSerializationAndDeserializationOfACustomer() {
	//Arrange 
	String expectedName = "Elon";
	expectedCustomer.setName(expectedName);
	customerSerializer.serialize(expectedCustomer);
	//Act
	Customer deserializedCustomer = customerSerializer.deserialize();
	String actualName = deserializedCustomer.getName();
	//Assert
	assertEquals(expectedName,actualName);
	}

}
