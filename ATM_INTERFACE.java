import java.util.Scanner;


public class ATM_INTERFACE
{
	// for the menu
	public static void menu()
	{
		// l=all the 4 menu options
		System.out.println("Enter 1-4 for the following options : ");
		System.out.println("1. Check balance");
		System.out.println("2. Withdraw");
		System.out.println("3. Deposit");
		System.out.println("4. Show transactions");
		System.out.println("5. Exit");
	}
	
	public static void main(String[] args) 
	{
		// scanner to read from the user
		Scanner scanner = new Scanner(System.in);
		
		// the number of accounts that can be accessed using this atm
		int numAccounts = 5;
		
		// array for accounts
		Account[] accounts = new Account[numAccounts];
		
		// create pins for the accounts
		final String pin[] = {"2312","2345","1178","7614","6519"};
		// create accounts
		for( int i=0; i<numAccounts; i++)
			accounts[i] = new Account();
		
		// ask id 
		System.out.print("Enter id to operate an account(0-" + (numAccounts-1) + ") : ");
		// read id
		int id = scanner.nextInt();
		
		// as long as wrong id entered
		while( id < 0 || id > numAccounts)
		{
			System.out.print("Enter id to operate an account(0-" + (numAccounts-1) + ") : ");
			id = scanner.nextInt();
		}
		
		// show welcome message 
		System.out.println("*********************Welcome to ATM Service*********************");
		
		// Authenticate the pin
		
		// ask for pin
		System.out.println("Enter pin : ");
		// if wrong pin
		if( !pin.equals(accounts[id].getPin()))
		{
			// show message wrong pin
			System.out.println("Wrong pin! Exiting ATM!");
			scanner.close();
			return;
		}
					
		// show message to display the customer name
		System.out.println("Customer name : " + accounts[id].getName());
		
		// run the program
		do
		{
			// to store choice
			int choice;
			
			// display menu
			menu();
			
			
			// check pin
			
			// ask choice
			System.out.print("Enter a choice : ");
			
			// read the choice
			choice = scanner.nextInt();
			
			// if choice to show balance
			if( choice == 1 )
			{
				// show balance
				System.out.printf("The balance is : %.2f\n",accounts[id].getBalance());
			}
			// if choice to withdraw
			else if( choice == 2 )
			{
				// the amount to withdraw
				double amount;
				
				// the amount to withdraw
				System.out.print("Enter an amount to withdraw : ");
				
				// get the amount
				amount = scanner.nextDouble();
				
				// if unable to withdraw
				if( !accounts[id].withdraw(amount))
					System.out.println("Insufficient funds!\n");
				// else if withdrew
				else
					System.out.println("Withdraw successfull! Collect Cash!\n");
				
			}// if choice to deposit
			else if( choice == 3 )
			{
				// the amount to deposit
				double amount;
				
				// ask amount
				System.out.print("Enter an amount to deposit : ");
				
				// read amount
				amount = scanner.nextDouble();
				
				// deposit amount
				accounts[id].deposit(amount);
				
				System.out.println("Deposit successfull!\n");
			}
			else if( choice == 4 )
			{
				// show transactions for this account
				accounts[id].showTransactions();
			}
			/// if choice to exit - break the do while loop
			else if( choice == 5 )
			{
				break;
			}
			else
			{	// print wrong choice message if wrong choice is entered
				System.out.println("Wrong choice entered.");
			}
			
		}
		while( true );
		scanner.close();
	}

}
