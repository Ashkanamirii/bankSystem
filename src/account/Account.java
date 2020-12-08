package account;

import bank.Customer;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-30
 * Time:  13:58
 * Project: bankSystem
 * Copyright: MIT
 */
public abstract class Account {
    private long accountNumber;
    protected double balance;
    private int customerID;
    protected AccountType accountType;


    public Account(long accountNumber, double balance, int customerID) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customerID = customerID;
    }

    public void withDraw(double amount) {
        if (amount < balance){
        balance = balance - amount;
            System.out.println("Withdrawing $" + amount);
        }else {
            System.out.println("Your balance is not enough to complete this transaction");
        }
        printBalance();
    }

    public void deposit(double amount){
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("Depositing $" + amount);
        } else{
            System.out.println("Your amount is incorrect");
        }
        printBalance();
    }

    public void transfer (Account from, Account to, double amount)
    {
        from.withDraw(amount);
        to.deposit(amount);
    }

    public void transfer(double transferAmount,Account send,Account recieve) {

        if(send.balance > transferAmount && transferAmount > 0) {
            send.balance -= transferAmount;

            recieve.balance += transferAmount;

        } else if(transferAmount <= 0) {

            System.out.println("Invalid amount to transfer.  Transaction cancelled.");

        } else {

            System.out.println("Transferring account balance is insufficient to transfer funds.");

        }

    }

    public void transfer(String toWhere, double amount){
        if (amount < balance){
            balance = balance - amount;
            System.out.println("Transferring $" + amount + " to " + toWhere);
        }else {
            System.out.println("Your balance is not enough to complete this transaction");
        }
        printBalance();
    }
    public void printBalance (){
        System.out.println("Your balance is now: $" + balance);
    }

    public abstract AccountType setAccountType();


    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", customerID=" + customerID +
                ", accountType=" + accountType +
                '}';
    }
}


