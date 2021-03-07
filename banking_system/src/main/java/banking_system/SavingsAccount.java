package banking_system;

public class SavingsAccount extends Account{
	private float interest;
	private float interestAccrude;
	private String accountType = "SAVINGS";
	
	
	public float getInterest() {
		return interest;
	}


	public void setInterest(float interest) {
		this.interest = interest;
	}


	public float getInterestAccrude() {
		return interestAccrude;
	}


	public void setInterestAccrude(float interestAccrude) {
		this.interestAccrude = interestAccrude;
	}


	@Override
	public void withdrawBalance(float amount) {
		float currentBalance = getBalance();
		if (currentBalance < amount) {
			System.out.println("Error: Savings account cannot be overdrawn");
		}else {
			setBalance(getBalance()-amount);
		}
		
		
	}


	public String getAccountType() {
		return accountType;
	}
	
	
	
	
}
