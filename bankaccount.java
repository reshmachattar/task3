//task3
//question 4
//create a class to represent user bank account which store account balence.
import java.util.Scanner;

class bankaccount {
    private double balance;

    public bankaccount(double initialBalance) {
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
}

public class ATMInterface {
    private BankAccount account;
    private Scanner scanner;

    public ATMInterface(double initialBalance) {
        this.account = new BankAccount(initialBalance);
        this.scanner = new Scanner(System.in);
        runATM();
    }

    private void runATM() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.next();
            }
            int choice = scanner.nextInt();
            exit = processChoice(choice);
        }
        scanner.close();
    }

    private void displayMenu() {
        System.out.println("\nATM Machine");
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
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        if (account.withdraw(amount)) {
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private void depositAmount() {
        System.out.print("Enter amount to deposit: ");
        while (!scanner.hasNextDouble()) {
            System.out.println("Invalid input. Please enter a valid amount.");
            scanner.next();
        }
        double amount = scanner.nextDouble();
        if (account.deposit(amount)) {
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Enter a valid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + account.getBalance());
    }

    public static void main(String[] args) {
        new bankaccount(1000.00);
    }
}
