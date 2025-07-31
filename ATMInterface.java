
import java.util.Scanner;

public class ATMInterface {

    private double balance;
    private final int PIN = 1234;

    public ATMInterface() {
        this.balance = 1000.00; // initial balance
    }

    public void checkBalance() {
        System.out.println("Your current balance is: ₹" + balance);
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
            checkBalance();
        } else {
            System.out.println("Invalid deposit amount!");
        }
    }

    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
            checkBalance();
        } else {
            System.out.println("Insufficient balance or invalid amount!");
        }
    }

    public boolean validatePIN(int enteredPIN) {
        return enteredPIN == PIN;
    }

    public static void main(String[] args) {
        ATMInterface atm = new ATMInterface();
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter your PIN: ");
        int userPIN = scanner.nextInt();

        if (atm.validatePIN(userPIN)) {
            int choice;
            do {
                System.out.println("\n==== ATM Menu ====");
                System.out.println("1. Check Balance");
                System.out.println("2. Deposit Money");
                System.out.println("3. Withdraw Money");
                System.out.println("4. Exit");
                System.out.print("Choose an option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        atm.checkBalance();
                        break;
                    case 2:
                        System.out.print("Enter amount to deposit: ₹");
                        double depositAmount = scanner.nextDouble();
                        atm.deposit(depositAmount);
                        break;
                    case 3:
                        System.out.print("Enter amount to withdraw: ₹");
                        double withdrawAmount = scanner.nextDouble();
                        atm.withdraw(withdrawAmount);
                        break;
                    case 4:
                        System.out.println("Thank you for using the ATM. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }

            } while (choice != 4);
        } else {
            System.out.println("Incorrect PIN. Access denied.");
        }

        scanner.close();
    }
}