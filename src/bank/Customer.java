package bank;

import account.Account;
import account.AccountTypeEnum;

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
    private AccountTypeEnum accountTypeEnum;

    public Customer(int customerId, String firstName, String lastName, Account account,
                    short customerPinCode, AccountTypeEnum accountTypeEnum) {
        this.customerId = customerId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.account = account;
        this.customerPinCode = customerPinCode;
        this.accountTypeEnum = accountTypeEnum;
    }

    public Customer() {
    }

    public AccountTypeEnum getAccountType() {
        return accountTypeEnum;
    }

    public void setAccountType(AccountTypeEnum accountTypeEnum) {
        this.accountTypeEnum = accountTypeEnum;
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
                ", accountType=" + accountTypeEnum +
                '}';
    }

    public String customToString(int action, int action1,double amount) {
        return account.getAccountNumber() + "; " +
                AccountTypeEnum.getAccountType(action1).getDescription() + "; " +
                AccountTypeEnum.getAccountType(action).getDescription() + "; " +
                "amount: " + amount + "; " +
                "New Balance--> "+account.getBalance() + "; " +
                History.getDateNowFormat();
    }
}