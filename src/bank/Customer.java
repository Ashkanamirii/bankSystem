package bank;

import account.Account;
import account.AccountType;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-29
 * Time:  12:20
 * Project: bankSystem
 * Copyright: MIT
 */


public class Customer {
    private int customerId;
    private String firstName;
    private String lastName;
    private Account account ;
    private short customerPinCode;
    private AccountType accountType;

    public Customer(int customerId, String firstName, String lastName, Account account,
                    short customerPinCode, AccountType accountType) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.customerPinCode = customerPinCode;
        this.accountType = accountType;
    }

    public Customer() {
    }

    public AccountType getAccountType() {
        return accountType;
    }

    public void setAccountType(AccountType accountType) {
        this.accountType = accountType;
    }

    public short getCustomerPinCode() {
        return customerPinCode;
    }

    public void setCustomerPinCode(short customerPinCode) {
        this.customerPinCode = customerPinCode;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", account=" + account +
                ", customerPinCode=" + customerPinCode +
                ", accountType=" + accountType +
                '}';
    }
}
