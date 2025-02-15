package main.java.com.maman12.q2;

import java.util.Objects;

// This class represents a Service Charge Checking Account, which is a type of Checking Account.
public class ServiceChargeChecking extends CheckingAccount {

    // Default monthly fee for the ServiceChargeChecking account.
    private static final int DEFAULT_MONTHLY_FEE = 30;
    // Instance variable to store the monthly fee for the account.
    private int monthlyFee;

    // Constructor to create a ServiceChargeChecking account with a default monthly fee.
    public ServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double accountBalance) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
        this.monthlyFee = DEFAULT_MONTHLY_FEE;
    }

    // Constructor to create a ServiceChargeChecking account with a custom monthly fee.
    public ServiceChargeChecking(String accountNumber, String accountHolderName, String idNumber, double accountBalance, int monthlyFee) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
        this.monthlyFee = monthlyFee;
    }

    public int getMonthlyFee() {
        return monthlyFee;
    }

    public void setMonthlyFee(int monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    // Override the monthlyManagement method to deduct the monthly fee from the account balance.
    @Override
    public void monthlyManagement() {
            setAccountBalance(getAccountBalance() - monthlyFee);
    }

    @Override
    public String toString() {
        return "Account Number = '" + getAccountNumber() + '\'' +
                ", Account Holder Name = '" + getAccountHolderName() + '\'' +
                ", ID Number = '" + getIdNumber() + '\'' +
                ", Account Balance = '" + getAccountBalance() + '\'' +
                ", Monthly Fee = " + monthlyFee + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        ServiceChargeChecking other = (ServiceChargeChecking)obj;
        return getAccountBalance() == other.getAccountBalance()
                && Objects.equals(getAccountNumber(), other.getAccountNumber())
                && Objects.equals(getAccountHolderName(), other.getAccountHolderName())
                && Objects.equals(getIdNumber(), other.getIdNumber())
                && this.monthlyFee == other.getMonthlyFee();
    }
}
