package main.java.com.maman12.q2;

import java.util.ArrayList;

// This class serves as the main program to demonstrate the functionality of various bank account types.
public class main {
    public static void main(String[] args) throws IllegalBalanceException {

        // Create an ArrayList to hold instances of BankAccount.
        ArrayList<BankAccount> bankAccounts = new ArrayList<>();

        // Populate the ArrayList with different types of bank accounts.
        bankAccounts.add(new ServiceChargeChecking("233445", "Yos Shmosh", "33444", 7000));
        bankAccounts.add(new NoServiceChargeChecking("0099873", "Yofi Meod", "44556", 5600));
        bankAccounts.add(new InterestChecking("567523", "Idan Shlomi", "77888", 2245));
        bankAccounts.add(new SavingsAccount("111112", "Artik Banana", "0099988", 32500));
        bankAccounts.add(new HighInterestSavings("9988444", "Ashir Meod", "112384", 556789));

        // Extract individual bank accounts for easier reference.
        BankAccount serviceChargeChecking = bankAccounts.get(0);
        BankAccount noServiceChargeChecking = bankAccounts.get(1);
        BankAccount interestChecking = bankAccounts.get(2);
        BankAccount savingsAccount = bankAccounts.get(3);
        BankAccount highInterestSavings = bankAccounts.get(4);

        // Print the initial state of each bank account.
        printAccounts(serviceChargeChecking, noServiceChargeChecking, interestChecking, savingsAccount, highInterestSavings);

        // Demonstrate deposit and withdraw operations on different accounts.
        serviceChargeChecking.depositMoney(700);
        System.out.println("\n\n\nBalance after 700 deposit to SCC Account: " + serviceChargeChecking.getAccountBalance());
        // Example of an exception throw during a withdrawal operation.
        serviceChargeChecking.withdraw(8000);
        System.out.println("\nBalance after 8000 withdraw from SCC Account: " + serviceChargeChecking.getAccountBalance());

        noServiceChargeChecking.depositMoney(2200);
        System.out.println("\nBalance after 2200 deposit to NSCC Account: " + noServiceChargeChecking.getAccountBalance());
        noServiceChargeChecking.withdraw(100);
        System.out.println("\nBalance after 100 withdraw from NSCC Account: " + noServiceChargeChecking.getAccountBalance());

        interestChecking.depositMoney(20000);
        System.out.println("\nBalance after 20000 deposit to Interest Checking Account: " + interestChecking.getAccountBalance());
        interestChecking.withdraw(15000);
        System.out.println("\nBalance after 15000 withdraw from Interest Checking Account: " + interestChecking.getAccountBalance());

        savingsAccount.depositMoney(25300);
        System.out.println("\nBalance after 25300 deposit to Savings Account: " + savingsAccount.getAccountBalance());
        savingsAccount.withdraw(153);
        System.out.println("\nBalance after 153 withdraw from Savings Account: " + savingsAccount.getAccountBalance());

        highInterestSavings.depositMoney(350000);
        System.out.println("\nBalance after 350000 deposit to High Interest Savings Account: " + highInterestSavings.getAccountBalance());
        highInterestSavings.withdraw(120000);
        System.out.println("\nBalance after 120000 withdraw from High Interest Savings Account: " + highInterestSavings.getAccountBalance());


        // Print account balances before monthly management.
        System.out.println("\n\n\nAccounts balances before monthly management:\n");
        System.out.println("Service Charge Account: " + serviceChargeChecking.getAccountBalance());
        System.out.println("No Service Charge Account: " + noServiceChargeChecking.getAccountBalance());
        System.out.println("Interest Checking Account: " + interestChecking.getAccountBalance());
        System.out.println("Savings Account: " + savingsAccount.getAccountBalance());
        System.out.println("High Interest Savings Account: " + highInterestSavings.getAccountBalance());

        // Perform monthly management on each account.
        serviceChargeChecking.monthlyManagement();
        noServiceChargeChecking.monthlyManagement();
        interestChecking.monthlyManagement();
        savingsAccount.monthlyManagement();
        highInterestSavings.monthlyManagement();

        // Print account balances after monthly management.
        System.out.println("\n\n\nAccounts balances after monthly management:\n");
        printBalances(serviceChargeChecking, noServiceChargeChecking, interestChecking, savingsAccount, highInterestSavings);
    }

    // Helper method to print detailed information about each bank account.
    private static void printAccounts(BankAccount a, BankAccount b, BankAccount c, BankAccount d, BankAccount e) {
        System.out.println("Service Charge Checking Account:\n" + a);
        System.out.println("No Service Charge Checking Account:\n" + b);
        System.out.println("Interest Checking Account:\n" + c);
        System.out.println("Savings Account:\n" + d);
        System.out.println("High Interest Savings Account:\n" + e);
    }

    // Helper method to print only the account balances for each bank account.
    private static void printBalances(BankAccount a, BankAccount b, BankAccount c, BankAccount d, BankAccount e) {
        System.out.println("Service Charge Account: " + a.getAccountBalance());
        System.out.println("No Service Charge Account: " + b.getAccountBalance());
        System.out.println("Interest Checking Account: " + c.getAccountBalance());
        System.out.println("Savings Account: " + d.getAccountBalance());
        System.out.println("High Interest Savings Account: " + e.getAccountBalance());
    }
}
