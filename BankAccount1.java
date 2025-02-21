//task3

//question 6
//validate user input to ensure within acceptable 
import java.util.Scanner;

class BankAccount1 {
    private double balance;
    private String accountNumber;

    public BankAccount1(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            return true;
        }
        return false;
    }

    public String getAccountNumber() {
        return accountNumber;
    }
}

class UserInputValidator {
    private Scanner scanner;

    public UserInputValidator() {
        this.scanner = new Scanner(System.in);
    }

    public int getValidInt() {
        while (!scanner.hasNextInt()) {
            System.out.println("Invalid input. Please enter a number.");
            scanner.next();
        }
        return scanner.nextInt();
    }

    public double getValidDouble() {
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
        return scanner.nextDouble();
    }
}

public class ATMInterface {
    private BankAccount account;
    private UserInputValidator inputValidator;

    public ATMInterface(BankAccount account) {
        this.account = account;
        this.inputValidator = new UserInputValidator();
        runATM();
    }

    private void runATM() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            int choice = inputValidator.getValidInt();
            exit = processChoice(choice);
        }
    }

    private void displayMenu() {
        System.out.println("\nATM Machine - Account: " + account.getAccountNumber());
        System.out.println("1. Withdraw");
        System.out.println("2. Deposit");
        System.out.println("3. Check Balance");
        System.out.println("4. Exit");
        System.out.print("Choose an option: ");
    }

    private boolean processChoice(int choice) {
        switch (choice) {
            case 1:
                withdrawAmount();
                break;
            case 2:
                depositAmount();
                break;
            case 3:
                checkBalance();
                break;
            case 4:
                System.out.println("Thank you for using the ATM. Goodbye!");
                return true;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
        return false;
    }

    private void withdrawAmount() {
        System.out.print("Enter amount to withdraw: ");
        double amount = inputValidator.getValidDouble();
        if (amount <= 0) {
            System.out.println("Withdrawal amount must be greater than zero.");
        } else if (amount > account.getBalance()) {
            System.out.println("Insufficient balance. Your balance is: $" + account.getBalance());
        } else if (account.withdraw(amount)) {
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Withdrawal failed. Please try again.");
        }
    }

    private void depositAmount() {
        System.out.print("Enter amount to deposit: ");
        double amount = inputValidator.getValidDouble();
        if (amount <= 0) {
            System.out.println("Deposit amount must be greater than zero.");
        } else if (account.deposit(amount)) {
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Deposit failed. Please try again.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public static void main(String[] args) {
        BankAccount userAccount = new BankAccount("123456789", 1000.00);
        new ATMInterface(userAccount);
    }
}
