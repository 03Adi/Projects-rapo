import java.util.ArrayList;
import java.util.Scanner;

class Account {
    private String name;
    private String pin;
    private double balance;
    private ArrayList<String> transactions;

    public Account(String name, String pin, double balance) {
        this.name = name;
        this.pin = pin;
        this.balance = balance;
        this.transactions = new ArrayList<>();
        this.transactions.add("Account created with balance: " + balance);
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > balance) {
            return false;
        } else {
            balance -= amount;
            transactions.add("Withdrawn: " + amount + ", New balance: " + balance);
            return true;
        }
    }

    public void deposit(double amount) {
        balance += amount;
        transactions.add("Deposited: " + amount + ", New balance: " + balance);
    }

    public void showTransactions() {
        System.out.println("Transaction history for " + name + ":");
        for (String transaction : transactions) {
            System.out.println(transaction);
        }
    }
}

public class ATMINTERFACE {
    // Display the menu
    public static void menu() {
        System.out.println("Enter 1-5 for the following options: ");
        System.out.println("1. Check balance");
        System.out.println("2. Withdraw");
        System.out.println("3. Deposit");
        System.out.println("4. Show transactions");
        System.out.println("5. Exit");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numAccounts = 5;
        Account[] accounts = new Account[numAccounts];
        final String[] pins = {"2312", "2345", "1178", "7614", "6519"};
        final String[] names = {"aditya", "sam", "prakhar", "charu", "surbhi"};

        for (int i = 0; i < numAccounts; i++) {
            accounts[i] = new Account(names[i], pins[i], 1000.00); // Initializing with $1000 balance
        }

        System.out.print("Enter id to operate an account (0-" + (numAccounts - 1) + "): ");
        int id = scanner.nextInt();

        while (id < 0 || id >= numAccounts) {
            System.out.print("Invalid id. Enter id to operate an account (0-" + (numAccounts - 1) + "): ");
            id = scanner.nextInt();
        }

        System.out.println("********************* Welcome to ATM Service *********************");

        System.out.print("Enter pin: ");
        String enteredPin = scanner.next();

        if (!enteredPin.equals(accounts[id].getPin())) {
            System.out.println("Wrong pin! Exiting ATM!");
            scanner.close();
            return;
        }

        System.out.println("Customer name: " + accounts[id].getName());

        while (true) {
            menu();
            System.out.print("Enter a choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.printf("The balance is: %.2f\n", accounts[id].getBalance());
                    break;
                case 2:
                    System.out.print("Enter an amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    if (!accounts[id].withdraw(withdrawAmount)) {
                        System.out.println("Insufficient funds!\n");
                    } else {
                        System.out.println("Withdraw successful! Collect Cash!\n");
                    }
                    break;
                case 3:
                    System.out.print("Enter an amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    accounts[id].deposit(depositAmount);
                    System.out.println("Deposit successful!\n");
                    break;
                case 4:
                    accounts[id].showTransactions();
                    break;
                case 5:
                    System.out.println("Exiting ATM. Have a nice day!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Wrong choice entered.");
            }
        }
    }
}
