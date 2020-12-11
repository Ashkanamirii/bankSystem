package account;

import bank.Customer;
import bank.Database;
import bank.History;

import java.util.List;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-30
 * Time:  13:58
 * Project: bankSystem
 * Copyright: MIT
 */
public abstract class Account {
    private long accountNumber;
    protected double balance;
    protected String date;


    public Account(long accountNumber, double balance, String date) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.date = date;
    }


    public void withDraw(double amount, Customer customer) {
        String target = String.valueOf(balance);
        String replacement = null;
        if (amount < balance) {
            balance = balance - amount;
            replacement = String.valueOf(balance);
            System.out.println("\nWithdrawing $" + amount);
        } else {
            System.out.println("\nYour balance is not enough to complete this transaction");
        }
        printBalance();
        History.replaceSelected(target, replacement);
        History.replaceSelected(date, History.getDateNowFormat());
        History.historyLog(customer , amount, AccountTypeEnum.WITHDRAW.getAccountType(),customer.getAccountType().getAccountType());
    }

    public void deposit(double amount,Customer customer) {
        String target = String.valueOf(balance);
        String replacement = null;
        if (amount > 0) {
            balance = balance + amount;
            replacement = String.valueOf(balance);
            System.out.println("\nDepositing $" + amount);
        } else {
            System.out.println("\nYour amount is incorrect");
        }
        printBalance();
        History.replaceSelected(target, replacement);
        History.replaceSelected(date, History.getDateNowFormat());
        History.historyLog(customer , amount, AccountTypeEnum.DEPOSIT.getAccountType(),customer.getAccountType().getAccountType());
    }

    public void transfer(double transferAmount, long destinationAcc ) {
        Database database = new Database();
        String target;
        String replacement;
        List<Customer> customerFromDB = database.addDataToCustomerList();
        double destinationBalance;

        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getAccount().accountNumber == accountNumber) {
                target = String.valueOf(balance);
                balance = balance - transferAmount;
                customerFromDB.get(i).getAccount().setBalance(balance);
                replacement = String.valueOf(balance);
                History.replaceSelected(target, replacement);
                History.replaceSelected(date, History.getDateNowFormat());
                History.historyLog(customerFromDB.get(i), transferAmount, AccountTypeEnum.TRANSFER.getAccountType(),customerFromDB.get(i).getAccountType().getAccountType());
            }
            if (customerFromDB.get(i).getAccount().accountNumber == destinationAcc) {
                target = String.valueOf(customerFromDB.get(i).getAccount().getBalance());
                destinationBalance = customerFromDB.get(i).getAccount().getBalance() + transferAmount;
                customerFromDB.get(i).getAccount().setBalance(destinationBalance);
                replacement = String.valueOf(destinationBalance);
                History.replaceSelected(target, replacement);
                History.replaceSelected(customerFromDB.get(i).getAccount().getDate(), History.getDateNowFormat());
                History.historyLog(customerFromDB.get(i) , transferAmount, AccountTypeEnum.TRANSFER.getAccountType(),customerFromDB.get(i).getAccountType().getAccountType());
            }
        }
        printBalance();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printBalance() {
        System.out.println("Your balance is now: $" + balance + "\n");
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    abstract void showInfo();

    @Override
    public String toString() {
        return "Account{" +
                "accountNumber=" + accountNumber +
                ", balance=" + balance +
                ", date='" + date + '\'' +
                '}';
    }
}


