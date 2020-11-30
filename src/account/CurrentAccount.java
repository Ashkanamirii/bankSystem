package account;

import bank.Customer;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class CurrentAccount extends Account implements Transaction {


    public CurrentAccount(Long accountNumber, double balance, Customer customer, Integer accountType) {
        super(accountNumber, balance, customer, accountType);
    }


    @Override
    public void withDraw(double amount) {
        balance = balance - amount;
    }

    @Override
    public void deposit(double amount) {
        balance = balance + amount;
    }
}
