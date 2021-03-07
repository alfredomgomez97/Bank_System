package banking_system;

public class CheckingAccount extends Account{
	
	private String accountType = "CHECKING";
	private int monthlyWithdrawLimit = 6;
	
	
	@Override
	public void withdrawBalance(float amount) {
		if (monthlyWithdrawLimit!=0) {
			monthlyWithdrawLimit = monthlyWithdrawLimit - 1;
			setBalance(getBalance() - amount);
		}else {
			System.out.println("You've reached your monthly limit");
		}
	}


	public String getAccountType() {
		return accountType;
	}
	
	
	
}
