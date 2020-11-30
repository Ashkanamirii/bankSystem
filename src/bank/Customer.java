package bank;

import account.Account;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:20
 * Project: bankSystem
 * Copyright: MIT
 */
public class Customer {
    String name;
    String address;
    long personalNumber; // används som customer ID
    Account accountNr;

    public Customer(String name, String address, long personalNumber, Account accountNr) {
        this.name = name;
        this.address = address;
        this.personalNumber = personalNumber;
        this.accountNr = accountNr;
    }

    public Customer() {}

    public Account getAccountNr() {
        return accountNr;
    }

    public void setAccountNr(Account accountNr) {
        this.accountNr = accountNr;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

}
