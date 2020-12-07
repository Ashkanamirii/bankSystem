package bank;

import account.Account;

import java.util.ArrayList;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:20
 * Project: bankSystem
 * Copyright: MIT
 */
public class Customer {
    int customerId;
    String name;
    String address;
    String personalNumber; // används som customer ID
    ArrayList<Account> accounts;

    public Customer(int customerId, String name, String address, String personalNumber, ArrayList<Account> accounts) {
        this.customerId = customerId;
        this.name = name;
        this.address = address;
        this.personalNumber = personalNumber;
        this.accounts = new ArrayList<Account>();
    }

    public Customer() {}

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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
