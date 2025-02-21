//task3
//question 3
//implement method for such option such as (withdrow amount)deposite amount and cheaking the balence 
import java.util.Scanner;
 class  withdraw {
    private double balance;
    private Scanner scanner;

    public withdraw (double initialBalance) {
        this.balance = initialBalance;
        this.scanner = new Scanner(System.in);
        runATM();
    }

    private void runATM() {
        boolean exit = false;
        while (!exit) {
            displayMenu();
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
        double amount = scanner.nextDouble();
        if (isValidAmount(amount) && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrawn: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private void depositAmount() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (isValidAmount(amount)) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Enter a valid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Your current balance is: $" + balance);
    }

    private boolean isValidAmount(double amount) {
        return amount > 0;
    }

    public static void main(String[] args) {
        new withdraw (1000.00);
    }
}

