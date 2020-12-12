package customer;

import account.Account;
import account.AccountEnum;
import database.History;

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
    private Account account;
    private short customerPinCode;
    private AccountEnum accountEnum;

    public Customer(int customerId, String firstName, String lastName, Account account,
                    short customerPinCode, AccountEnum accountEnum) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.customerPinCode = customerPinCode;
        this.accountEnum = accountEnum;
    }

    public Customer() {
    }

    public AccountEnum getAccountType() {
        return accountEnum;
    }

    public void setAccountType(AccountEnum accountEnum) {
        this.accountEnum = accountEnum;
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
                ", accountType=" + accountEnum +
                '}';
    }

    public String toString3() {
        return "Welcome " + firstName + ' ' + lastName +
                "\nYour customerId: " + customerId +
                "\nYour pin code: " + customerPinCode + "\n" +
                "\nYour account information: " + account
                ;
    }

    public String customToString(int action, int action1, double amount) {
        return account.getAccountNumber() + "; " +
                accountEnum.getAccountType(action1).getDescription() + "; " +
                accountEnum.getAccountType(action).getDescription() + "; " +
                "amount: " + amount + "; " +
                "New Balance--> " + account.getBalance() + "; " +
                History.getDateNowFormat();
    }
}
