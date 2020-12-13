package customer;

import account.Account;
import account.AccountEnum;
import bankFacade.Facade;
import database.Database;
import database.History;
import database.RegisterCustomer;
import bankFacade.Facade;

import java.util.ArrayList;
import java.util.List;

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
    private long account2;
    private double balance;
    private short customerPinCode;
    private AccountEnum accountEnum;
    private String accountTypeNewuser;

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

    public void setAccountTypeNewuser(String accountTypeNewuser){
        this.accountTypeNewuser = accountTypeNewuser;
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

    public void setBalance(double balance) { this.balance = balance;}

    public void setAccount2(long account2) {
        this.account2 = account2;
    }

    List<Customer> customerFromDB = new ArrayList<>();
    protected Database dataDB = new Database();

    public Customer findCustomer(int inputCustomerID, int inputCustomerPinCode) {
        customerFromDB = dataDB.addDataToCustomerList();

        if (customerFromDB.size() == 0) {
            System.out.println("Empty list");
        }
        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getCustomerPinCode() == inputCustomerPinCode && customerFromDB.get(i).getCustomerId() == inputCustomerID)
                if (customerFromDB.get(i).getAccountType().getAccountType() == 1) {
                    Customer c = customerFromDB.get(i);
                    return c;
                } else
                    return null;
        }
        return null;
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
        for(int clear = 0; clear < 1000; clear++) {
            System.out.println("\b") ;
        }
        RegisterCustomer.addNewUserToList(customerId, customerPinCode, firstName, lastName, account2, balance, accountTypeNewuser);
        return "Welcome " + firstName + ' ' + lastName +
                "\nYour customerID: " + customerId +
                "\nYour pin code: " + customerPinCode + "\n" +
                "\nYour " + accountTypeNewuser + " account number is: " +  account2;

    }

    public String toString4() {
        RegisterCustomer.addNewUserToList(customerId, customerPinCode, firstName, lastName, account2, balance, accountTypeNewuser);
        return "Your " + accountTypeNewuser + " account number is: " +  account2;

    }

    public String customToString2(int customerId, short customerPinCode, String firstName, String lastName, long accountnr, Double balance1, String accountTypeNewuser) {
        return customerId + ";" + customerPinCode + ";" + firstName + ";" + lastName + ";" + accountnr + ";" + balance1 + ";" + accountTypeNewuser + ";" +
                History.getDateNowFormat();
    }

    public String customToString(int action, int action1, double amount) {
        return account.getAccountNumber() + "; " +
                accountEnum.getAccountType(action1).getDescription() + "; " +
                accountEnum.getAccountType(action).getDescription() + "; " +
                amount + "; " +
                account.getBalance() + "; " +
                History.getDateNowFormat();
    }
}
