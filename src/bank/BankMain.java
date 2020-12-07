package bank;

import account.AccountType;
import account.Facade;
import account.SavingAccount;

import account.Account;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:20
 * Project: bankSystem
 * Copyright: MIT
 */
public class BankMain {
    String name;
    Customer customer;



    public void addAccount() {
    }


    public void addCustomer() {
    }

    public static void main(String[] args) {
     //   Customer customer1 = new Customer();
     //   customer1.setCustomerId(11111);
     //   Facade facade = new Facade();
       // facade.makeDeposit(100 , customer1);

        // Irynas branch

        ArrayList<Account> myAccounts = new ArrayList<>();

        Customer customer = new Customer(1,"Iryna", "Molkomsbacken 19, 12333, Farsta","198710230001", myAccounts);
        System.out.println(customer.toString());

        Account account1 = new Account(123456789, 3000, customer) {
            @Override
            public AccountType setAccountType() {
                int accType = 2;
                return AccountType.getAccountType(accType);            }
        };

        myAccounts.add(account1);

        ArrayList <Customer> customers = new ArrayList<>();


        Login l = new Login();


    }
}