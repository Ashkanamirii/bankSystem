package account;

import customer.Customer;
import database.Database;
import database.History;
import java.text.DecimalFormat;
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
        String oldBalance = String.valueOf(balance);
        String newBalance = null;
        if (amount < balance) {
            balance = balance - amount;
            DecimalFormat decimalFormat = new DecimalFormat("0.#####");
            String amountToPrint = decimalFormat.format(Double.valueOf(amount));
            newBalance = String.valueOf(balance);
            System.out.println("\nWithdrawing $" + amountToPrint);
        } else {
            System.out.println("\nYour balance is not enough to complete this transaction");
        }
        printBalance();
        History.replaceSelected(oldBalance, newBalance);
        History.replaceSelected(date, History.getDateNowFormat());
        History.historyLog(customer, amount, AccountEnum.WITHDRAW.getAccountType(),
                customer.getAccountEnum().getAccountType());
    }

    public void deposit(double amount,Customer customer) {
        String oldBalance = String.valueOf(balance);
        String newBalance = null;
        if (amount > 0) {
            balance = balance + amount;
            DecimalFormat decimalFormat = new DecimalFormat("0.#####");
            String amountToPrint = decimalFormat.format(Double.valueOf(amount));
            System.out.println(amountToPrint);
            newBalance = String.valueOf(balance);
            System.out.println("\n----------------------------------\n");
            System.out.println("Depositing $" + amountToPrint);
        } else {
            System.out.println("\nYour amount is incorrect");
        }
        printBalance();
        History.replaceSelected(oldBalance, newBalance);
        History.replaceSelected(date, History.getDateNowFormat());
        History.historyLog(customer, amount, AccountEnum.DEPOSIT.getAccountType(),
                customer.getAccountEnum().getAccountType());
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
                History.historyLog(customerFromDB.get(i), transferAmount, AccountEnum.TRANSFER.getAccountType(),
                        customerFromDB.get(i).getAccountEnum().getAccountType());
            }
            if (customerFromDB.get(i).getAccount().accountNumber == destinationAcc) {
                target = String.valueOf(customerFromDB.get(i).getAccount().getBalance());
                destinationBalance = customerFromDB.get(i).getAccount().getBalance() + transferAmount;
                customerFromDB.get(i).getAccount().setBalance(destinationBalance);
                replacement = String.valueOf(destinationBalance);
                History.replaceSelected(target, replacement);
                History.replaceSelected(customerFromDB.get(i).getAccount().getDate(), History.getDateNowFormat());
                History.historyLog(customerFromDB.get(i), transferAmount, AccountEnum.TRANSFER.getAccountType(),
                        customerFromDB.get(i).getAccountEnum().getAccountType());
            }
        }
        printBalance();
    }

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void printBalance() {
        for(int clear = 0; clear < 1000; clear++) {
            System.out.println("\b") ;
        }
        DecimalFormat decimalFormat = new DecimalFormat("0.#####");
        String balanceToPrint = decimalFormat.format(Double.valueOf(balance));
        System.out.println("Your balance is now: $" + balanceToPrint + "\n");
        System.out.println("----------------------------------\n");
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "\nAccountNumber: " + accountNumber +
                "\nBalance: " + balance
                ;
    }
}


