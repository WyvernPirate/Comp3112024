package lab4;

import java.util.Scanner;

public class Tester {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter account type (Savings or Checking): ");
        String accountType = scanner.nextLine();

        System.out.println("Enter account number: ");
        int accountNumber = scanner.nextInt();

        System.out.println("Enter holder name: ");
        String holderName = scanner.nextLine();

        System.out.println("Enter initial balance: ");
        double initialBalance = scanner.nextDouble();

        BankAccount account;

        try {
            account = BankAccountFactory.createBankAccount(accountType, accountNumber, holderName, initialBalance);
            System.out.println("Account created successfully!");
        } catch (IllegalArgumentException e) {
            System.err.println("Error creating account: " + e.getMessage());
            return;
        }

        boolean continueOperations = true;

        while (continueOperations) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Deposit");
            System.out.println("2. Withdraw");
            System.out.println("3. Check balance");
            System.out.println("4. Calculate fees");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter deposit amount: ");
                    double depositAmount = scanner.nextDouble();
                    account.deposit(depositAmount);
                    break;
                case 2:
                    System.out.print("Enter withdrawal amount: ");
                    double withdrawalAmount = scanner.nextDouble();
                    account.withdraw(withdrawalAmount);
                    break;
                case 3:
                    System.out.println("Current balance: " + account.getBalance());
                    break;
                case 4:
                    System.out.println("Total fees: " + account.calculateFees());
                    break;
                case 5:
                    continueOperations = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }

        scanner.close();
    }
}