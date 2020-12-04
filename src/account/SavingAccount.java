package account;

import bank.Customer;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class SavingAccount extends Account implements Transaction {
    double interestRate;

    public SavingAccount(Long accountNumber, double balance, Customer customer, Integer accountType, double interestRate) {
        super(accountNumber, balance, customer, accountType);
        this.interestRate = interestRate;
    }

    public SavingAccount(double interestRate) {
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        balance = balance - amount;
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
    }

    public void calculateInterestRate() {
        interestRate = interestRate + (balance * interestRate / 100 / 365);

    }

    public void addInterest() {
        balance = balance + interestRate;
        interestRate = 0;
    }

}
