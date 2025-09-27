package bankdemo;

public class Account
{
	private int accountNo;
	private String name;
	private double balance;
	
	public Account( int accountNo, String name, double balance )
	{
		this.accountNo=accountNo;
		this.name=name;
		this.balance=balance;
		
	}
	void deposit(double amount ) 
	{
		if(amount<=0)
		{
			throw new ArithmeticException(" Deposit amount must be above zero");
			
		}
		balance=balance+amount;
		System.out.println("Deposited amount:"+amount);
		
	}
	void withdraw(double amount) throws InsufficientBalanceException
	{
		if(amount<=0)
		{
			throw new ArithmeticException("You cannot withdraw zero or negative");
		}
		else if(amount>balance) {
			throw new InsufficientBalanceException("Insufficient Balance");
		}
		balance=balance-amount;
		System.out.println("Amount withdrawed"+amount);
		System.out.println("the remaining balance :" +balance );
		
	}
void showBalance() {
	System.out.println("Account no"+accountNo);
	System.out.println("Name"+name);
	System.out.println("BALANCE: "+ balance);
}
}
