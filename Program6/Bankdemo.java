package bankdemo;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Bankdemo {

	public static void main(String[] args) {
		Scanner sc= new Scanner(System.in);
		//create one account
		Account acc=new Account(100,"Esha",5000);
		while(true) {
			try {
				System.out.println("\nbanking  menu");
				System.out.println("1.Deposit");
				System.out.println("2.Withdraw");
				System.out.println("3.Show balance");
				System.out.println("4.Exit");
		        System.out.println("Enter your choice");
		int choice=sc.nextInt();
		switch(choice)
		{
		case 1:
			System.out.println("Enter amount to be deposited");
			acc.deposit(sc.nextDouble());
		    break;
		case 2:
			System.out.println("Enter amount to withdraw");
			acc.withdraw(sc.nextDouble());
		    break;
		case 3:
			acc.showBalance();
			break;
		case 4:
			System.out.println("Thankyou for banking");
		    sc.close();
		    System.exit(0);
		default:System.out.println("Invalid choice");
		}
	}
			catch(InputMismatchException e) {
				System.out.println("Invalid Input , please enter numbers only");
				sc.nextLine();
			}
			catch (InsufficientBalanceException e)
			{
				System.out.println("Error"+e.getMessage());
			}
			catch (ArithmeticException e)
			{
				System.out.println("Error"+e.getMessage());
			}
			catch (Exception e)
			{
				System.out.println("Unexpected Error"+e);
			}
		}
	}

}
