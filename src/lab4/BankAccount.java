package lab4;

import java.util.*;
import java.io.*;

abstract class BankAccount {

    // private attributes
    private int accNum;
    private String holdName;
    private double balance = 0;
    private int transactionCount = 0;

    // parameterized constructor
    public BankAccount(int accountNumber, String holderName, double balance) {
        this.accNum = accountNumber;
        this.holdName = holderName;
        this.balance = balance;
        this.transactionCount = 0;
    }

    // get methods
    public int getAccNum() {
        return accNum;
    }

    public String getHoldName() {
        return holdName;
    }

    public double getBalance() {
        return balance;
    }

    public int getTransactionCount() {
        return transactionCount;
    }

    // set methods
    public void setAccNum(int accNum) {
        this.accNum = accNum;
    }

    public void setHoldName(String holdName) {
        this.holdName = holdName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void incrementTransactionCount() {
        transactionCount++;
    }

    // method for calculating total fees
    public abstract double calculateFees();

    // method for withdrawing money
    protected void withdraw(double amount) {
        if (this.balance >= amount) {
            this.balance -= amount;
            this.transactionCount++;
            double fees = calculateFees();
            this.balance -= fees;
        } else {
            System.out.println("Insufficient funds.");
        }
    }

    protected void deposit(double amount) {
        balance += amount;
        incrementTransactionCount();
        double fees = calculateFees();
        balance -= fees;
    }

    protected void checkBalance() {
        incrementTransactionCount();
        double fees = calculateFees();
        balance -= fees;
    }
}

class SavingsAccount extends BankAccount {

    private double intRate;

    public SavingsAccount(int accNum, String holdName, double balance, double intRate) {
        super(accNum, holdName, balance);
        this.intRate = intRate;
    }

    public double getIntRate() {
        return intRate;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() >= amount) {
            setBalance(getBalance() - amount);
            incrementTransactionCount();
        } else {
            System.out.println("Insufficient funds.");
        }
    }
}

class static CheckingAccount extends BankAccount {

    private double overdraftLimit;
    private double transactionFee;
    private double monthlyFee = 50;

    public CheckingAccount(int accNum, String holdName, double balance, double overdraftLimit) {
        super(accNum, holdName, balance);
        this.overdraftLimit = overdraftLimit;
        this.transactionFee = 0.5;
    }

    public double getOverdraftLimit() {
        return overdraftLimit;
    }

    @Override
    public void withdraw(double amount) {
        if (getBalance() + overdraftLimit >= amount) {
            setBalance(getBalance() - amount);
            incrementTransactionCount();
        } else {
            System.out.println("Overdraft limit exceeded.");
        }
    }

    @Override
    public double calculateFees() {
        double totalFees = getTransactionCount() * transactionFee;
        if (getTransactionCount() > 10) {
            totalFees += monthlyFee; // apply monthly fee if transcation count exceeded 10
        }
        return totalFees;
    }
}

class BankAccountFactory {

    public static BankAccount createBankAccount(String accountType, int accountNumber, String holderName,
            double initialBalance) {
        if (accountType.equalsIgnoreCase("Savings")) {
            // default interest rate of 2%
            return new SavingsAccount(accountNumber, holderName, initialBalance, 0.02);
        } else if (accountType.equalsIgnoreCase("Checking")) {
            // default overdraft limit of 500
            return new CheckingAccount(accountNumber, holderName, initialBalance, 500);
        } else {
            throw new IllegalArgumentException("Invalid account type.");
        }
    }

    public static void createAccountsFromFile(String filename) {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                StringTokenizer tokenizer = new StringTokenizer(line, ",");
                if (tokenizer.countTokens() != 4) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }
                try {
                    String accountType = tokenizer.nextToken();
                    int accountNumber = Integer.parseInt(tokenizer.nextToken());
                    String holderName = tokenizer.nextToken();
                    double initialBalance = Double.parseDouble(tokenizer.nextToken());
                    BankAccount account = createBankAccount(accountType, accountNumber, holderName, initialBalance);
                    System.out.println("Created account: " + account);

                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                } catch (IllegalArgumentException e) {
                    System.out.println("Error creating account: " + e.getMessage());
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + e.getMessage());
        }
    }

}