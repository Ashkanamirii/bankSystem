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
    String personalNumber; // används som customer ID
    Account accountNr;

    public Customer(String name, String address, String personalNumber, Account accountNr) {
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

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                ", accountNr=" + accountNr +
                '}';
    }
}
