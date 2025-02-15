package main.java.com.maman12.q2;

// This abstract class represents a Checking Account, which is a type of BankAccount.
public abstract class CheckingAccount extends BankAccount {

    public CheckingAccount(String accountNumber, String accountHolderName, String idNumber, double accountBalance) {
        super(accountNumber, accountHolderName, idNumber, accountBalance);
    }

    // Method to write a check for a specified amount, deducting the amount from the account balance.
    // Throws an exception if the account balance is insufficient.
    public void writeCheck(double amount) {
        try {
            // Check if there is enough money in the account to write the check.
            if(getAccountBalance() < amount)
                throw new IllegalBalanceException("Not enough money in the account in order to write the check");
            else
                setAccountBalance(getAccountBalance() - amount);
        } catch (IllegalBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}