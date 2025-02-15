package main.java.com.maman12.q2;

import java.util.Objects;

// This class represents an Interest Checking Account, which is a type of No Service Charge Checking account.
public class InterestChecking extends NoServiceChargeChecking {

    // Default interest rate for the InterestChecking account.
    private static final double DEFAULT_INTEREST_RATE = 3;

    // Instance variable to store the interest rate for the account.
    private double interestRate;

    // Constructor to create an InterestChecking account with a default interest rate.
    public InterestChecking(String accountNumber, String accountHolderName, String idNumber, double accountBalance) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
        this.interestRate = DEFAULT_INTEREST_RATE;
    }

    // Constructor to create an InterestChecking account with a custom interest rate.
    public InterestChecking(String accountNumber, String accountHolderName, String idNumber, double accountBalance, double interestRate) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
        this.interestRate = interestRate;
    }

    public double getInterestRate() {
        return interestRate;
    }

    // Throws an exception if the provided interest rate is not positive.
    public void setInterestRate(double interestRate) {
        try {
            if(interestRate > 0)
                this.interestRate = interestRate;
            else
                throw new Exception("Interest rate is not positive");
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    // Calculate the interest amount based on the current account balance and interest rate.
    public double calcInterestRate() {
        return getAccountBalance() * (interestRate / 100.0);
    }

    // Override the monthlyManagement method to add interest to the account balance.
    @Override
    public void monthlyManagement() {
        setAccountBalance(getAccountBalance() + calcInterestRate());
    }

    @Override
    public String toString() {
        return "Account Number = '" + getAccountNumber() + '\'' +
                ", Account Holder Name = '" + getAccountHolderName() + '\'' +
                ", ID Number = '" + getIdNumber() + '\'' +
                ", Account Balance = '" + getAccountBalance() + '\'' +
                ", Interest Rate = " + interestRate + "\n";
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj)
            return true;
        if(obj == null || this.getClass() != obj.getClass())
            return false;
        InterestChecking other = (InterestChecking) obj;
        return getAccountBalance() == other.getAccountBalance()
                && Objects.equals(getAccountNumber(), other.getAccountNumber())
                && Objects.equals(getAccountHolderName(), other.getAccountHolderName())
                && Objects.equals(getIdNumber(), other.getIdNumber())
                && this.interestRate == other.getInterestRate();
    }
}