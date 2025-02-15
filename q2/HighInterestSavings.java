package main.java.com.maman12.q2;

import java.util.Objects;

// This class represents a High-Interest Savings Account, which is a specific type of SavingsAccount.
public class HighInterestSavings extends SavingsAccount {
    // Default minimum balance and interest rate for the High Interest Savings account.
    private static final double DEFAULT_MIN_BALANCE = 300;
    private static final double DEFAULT_INTEREST_RATE = 5;
    // Instance variables to store the minimum balance and interest rate for the account.
    private double minBalance;
    private double interestRate;

    // Constructor to create a HighInterestSavings account with default values.
    public HighInterestSavings(String accountNumber, String accountHolderName, String idNumber, double accountBalance) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
        this.minBalance = DEFAULT_MIN_BALANCE;
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    // Constructor to create a HighInterestSavings account with custom minimum balance and interest rate.
    public HighInterestSavings(String accountNumber, String accountHolderName, String idNumber, double accountBalance, double minBalance, double interestRate) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    public double getMinBalance() {
        return minBalance;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    @Override
    public String toString() {
        return "Account Number = '" + getAccountNumber() + '\'' +
                ", Account Holder Name = '" + getAccountHolderName() + '\'' +
                ", ID Number = '" + getIdNumber() + '\'' +
                ", Account Balance = '" + getAccountBalance() + '\'' +
                ", Minimun Balance = " + minBalance + '\'' +
                ", Interest Rate = " + interestRate + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        HighInterestSavings other = (HighInterestSavings)obj;
        return getAccountBalance() == other.getAccountBalance()
                && Objects.equals(getAccountNumber(), other.getAccountNumber())
                && Objects.equals(getAccountHolderName(), other.getAccountHolderName())
                && Objects.equals(getIdNumber(), other.getIdNumber())
                && this.minBalance == other.getMinBalance()
                && this.interestRate == other.getInterestRate();
    }
}
