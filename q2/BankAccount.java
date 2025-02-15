package main.java.com.maman12.q2;

import java.util.Objects;

// This is an abstract class representing a generic BankAccount.
public abstract class BankAccount {

    private String accountNumber;
    private String accountHolderName;
    private String idNumber;
    private double accountBalance;

    public BankAccount(String accountNumber, String accountHolderName, String idNumber, double accountBalance) {
        this.accountNumber = accountNumber;
        this.accountHolderName = accountHolderName;
        this.idNumber = idNumber;
        this.accountBalance = accountBalance;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(double accountBalance) {
        this.accountBalance = accountBalance;
    }

    // Deposit money into the account, throwing an exception if the amount is not positive.
    public void depositMoney(double amount) throws IllegalBalanceException {
        try {
            if(amount <= 0)
                throw new IllegalBalanceException("amount of money to deposit is not positive");
            else
                accountBalance += amount;
        } catch (IllegalBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Withdraw money from the account, considering specific conditions for certain account types.
    public void withdraw(double amount) {
        try {
            if(this instanceof NoServiceChargeChecking) {
                double minBalance = ((NoServiceChargeChecking)this).getMinBalance();
                if(this.accountBalance - amount < minBalance) {
                    return;
                }
            }
            // Check if the withdrawal amount exceeds the account balance.
            if(amount > accountBalance)
                throw new IllegalBalanceException("Insufficient balance");
            else
                accountBalance -= amount;
        } catch(IllegalBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Abstract method representing monthly management operations specific to each account type.
    public abstract void monthlyManagement();

    @Override
    public String toString() {
        return "Account Number = '" + accountNumber + '\'' +
                ", Account Holder Name = '" + accountHolderName + '\'' +
                ", ID Number = '" + idNumber + '\'' +
                ", Account Balance = " + accountBalance + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        BankAccount other = (BankAccount)obj;
        return Double.compare(accountBalance, other.accountBalance) == 0
                && Objects.equals(accountNumber, other.accountNumber)
                && Objects.equals(accountHolderName, other.accountHolderName)
                && Objects.equals(idNumber, other.idNumber);
    }
}
