package banking_system;

public class Account {
	private int AccountId;
	private float balance = 0.0f;
	private static int idAssigner = 100000;
	
	
	public int getAccountId() {
		return AccountId;
	}
	public void setAccountId(int accountId) {
		AccountId = accountId;
	}
	public static int getIdAssigner() {
		return idAssigner;
	}
	public static void setIdAssigner(int idAssigner) {
		Account.idAssigner = idAssigner;
	}
	public float getBalance() {
		return balance;
	}
	public void setBalance(float balance) {
		this.balance = balance;
	}
	public void withdrawBalance(float amount) {
	}
	public void depositBalance(float amount) {
		balance = balance + amount;
	}
	
	public int idGenerator() {
		int idGenerated = getIdAssigner();
		int idUpdate = getIdAssigner() + 1;
		setIdAssigner(idUpdate);
		return idGenerated;
	}
}
