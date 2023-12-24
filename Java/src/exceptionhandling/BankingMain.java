// Implementation of Exception Handling techniques in Java.

package exceptionhandling;
import java.util.Scanner;

public class BankingMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Creating a bank account with an initial balance
        BankAccount account = new BankAccount("123456789", 1000.0);

        try {
            // Performing transactions with exception handling
            account.displayBalance();

            System.out.print("Enter the amount to deposit: Rs.");
            double depositAmount = scanner.nextDouble();
            account.deposit(depositAmount);

            System.out.print("Enter the amount to withdraw: Rs.");
            double withdrawAmount = scanner.nextDouble();
            account.withdraw(withdrawAmount);

            // Attempting a withdrawal that may throw InsufficientFundsException
            account.withdraw(1500.0);

        } catch (InsufficientFundsException e) {
            // Handling specific exception for insufficient funds
            System.err.println("Exception caught: " + e.getMessage());
        } catch (Exception e) {
            // Catching a more general exception (will catch any unhandled exceptions)
            System.err.println("Unhandled exception caught: " + e.getMessage());
        } finally {
            // Finally block will always be executed
            System.out.println("Ending the transaction.");
        }

        // Closing the scanner
        scanner.close();
    }
}