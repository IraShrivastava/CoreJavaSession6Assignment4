package assignment6;	//package declaration
class BankATMException extends Exception		//custom exception class
{
	public BankATMException(String errorMessage)
	{
		super(errorMessage);
	}
}
class BankATM
{
	int atmId;
	String bankName;
	String location;
	double balance;
	void withdraw(double amount) throws BankATMException
	{
		double checkBalance;
		checkBalance=balance-amount;
		if((checkBalance<10000)&&(checkBalance>0))		// Raise exception if balance of ATM goes below 10000
		{
			throw new BankATMException("Balance is less than 10000");
		}
		else if(amount>balance)		// Don't allow withdraw of amount if the amount entered is greater than the available balance
		{
			System.out.println("Insufficient Balance Can't Withdraw "+amount);
			System.out.println("Total ATM Balance: "+balance);
		}
		else		// Update balance if withdraw is successful
		{
			balance=balance-amount;
			System.out.println("Successfully Withdrawn "+amount);
			System.out.println("Total ATM Balance= "+balance);
		}
	}
	void deposit(double amount)
	{							// Update the balance when deposit is successful
		balance+=amount;
		System.out.println("Successfully Deposited "+amount);
		System.out.println("Total ATM Balance= "+balance);
	}
}
public class Assignment6_4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try
		{
			BankATM b1 = new BankATM();
			System.out.println("Depositing 40000");
			b1.deposit(50000);
			System.out.println("-------------------------------------");
			BankATM b2 = new BankATM();
			System.out.println("Withdrawing 30000");
			b2.withdraw(40000);
			System.out.println("-------------------------------------");
			BankATM b3 = new BankATM();
			System.out.println("Withdrawing 7000");
			b3.withdraw(8000);
			System.out.println("-------------------------------------");
		}
		catch(BankATMException e)
		{
			System.out.println(e.toString());
		}
	}

}
