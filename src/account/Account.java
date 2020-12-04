package account;

import bank.Customer;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-30
 * Time:  13:58
 * Project: bankSystem
 * Copyright: MIT
 */
public abstract class Account implements Transaction {

    private Long accountNumber;
    protected double balance;
    private Customer customer;
    private Integer accountType;

    public Account(Long accountNumber, double balance, Customer customer, Integer accountType) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.customer = customer;
        this.accountType = accountType;
    }


    public Account() {}



