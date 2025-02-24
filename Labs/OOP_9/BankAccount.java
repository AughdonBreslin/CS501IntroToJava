package OOP_9;

/**
 * @author: aughb
 * @class: CS501 - Intro to Java
 * @description:
 * @created: 2/11/2025, Tuesday
 **/
public class BankAccount {
    private double balance;  // Private field (cannot be accessed directly)

    // Constructor
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Balance cannot be negative.");
            this.balance = 0;
        }
    }

    // Getter method to access balance (Read-only)
    public double getBalance() {
        return balance;
    }

    // Setter method with validation (Controlled modification)
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited: $" + amount);
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }

    // Withdraw method with validation
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Withdrawn: $" + amount);
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }
}
 class Main{
    public static void main(String[] args) {
        BankAccount myAccount = new BankAccount(1000);  // Encapsulated object

        // Accessing balance through the getter
        System.out.println("Current Balance: $" + myAccount.getBalance());

        // Depositing money using the setter
        myAccount.deposit(500);
        System.out.println("Updated Balance: $" + myAccount.getBalance());

        // Trying an invalid deposit
        myAccount.deposit(-100);  // Should not be allowed

        // Withdrawing money using a controlled method
        myAccount.withdraw(300);
        System.out.println("Final Balance: $" + myAccount.getBalance());

        // Trying to access balance directly (Not allowed)
//         myAccount.balance = 5000;  // Compilation error: balance is private
    }
}
