package main.java.com.maman12.q2;

import java.util.Objects;

// This class represents a No Service Charge Checking Account, which is a type of Checking Account.
public class NoServiceChargeChecking extends CheckingAccount {

    // Default minimum balance for the No Service Charge Checking account.
    private static final double DEFAULT_MIN_BALANCE = 1000;
    // Instance variable to store the minimum balance for the account.
    private double minBalance;

    // Constructor to create a NoServiceChargeChecking account with a default minimum balance.
    public NoServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double accountBalance) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
        // Set the minimum balance based on the account type.
        this.minBalance = this instanceof InterestChecking ? 5000 : DEFAULT_MIN_BALANCE;
    }

    // Constructor to create a NoServiceChargeChecking account with a custom minimum balance.
    public NoServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double accountBalance, double minBalance) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
        this.minBalance = minBalance;
    }

    @Override
    public void monthlyManagement() {
        // empty implementation
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
                ", Minimun Balance = " + minBalance + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        NoServiceChargeChecking other = (NoServiceChargeChecking) obj;
        return getAccountBalance() == other.getAccountBalance()
                && Objects.equals(getAccountNumber(), other.getAccountNumber())
                && Objects.equals(getAccountHolderName(), other.getAccountHolderName())
                && Objects.equals(getIdNumber(), other.getIdNumber())
                && this.minBalance == other.getMinBalance();
    }
}
