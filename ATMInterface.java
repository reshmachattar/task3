//design the user interface for the Atm including option such aswithdrowing depositing and cheaking the balence
 import java.util.Scanner;



class ATMInterface {
    
 private double balance = 1000.00; 
    private Scanner scanner;

    public  ATMInterface() {
        scanner = new Scanner(System.in);
        runATM();
    }

    private void runATM() {
        while (true) {
            System.out.println("\nATM Machine");
            System.out.println("1. Withdraw");
            System.out.println("2. Deposit");
            System.out.println("3. Check Balance");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            
            switch (choice) {
                case 1:
                    withdraw();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    checkBalance();
                    break;
                case 4:
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void withdraw() {
        System.out.print("Enter amount to withdraw: ");
        double amount = scanner.nextDouble();
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid amount or insufficient balance.");
        }
    }

    private void deposit() {
        System.out.print("Enter amount to deposit: ");
        double amount = scanner.nextDouble();
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Enter a valid amount.");
        }
    }

    private void checkBalance() {
        System.out.println("Current Balance: $" + balance);
    }

    public static void main(String[] args) {
        new ATMInterface();
    }
}

