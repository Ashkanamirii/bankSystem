package bank;

import account.AccountType;
import account.Facade;
import account.SavingAccount;

import account.Account;

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
        Customer customer1 = new Customer();
        customer1.setCustomerId(11111);
        Facade facade = new Facade();
       // facade.makeDeposit(100 , customer1);

        // Irynas branch
        Customer customer = new Customer("Iryna", "Molkomsbacken 19, 12333, Farsta","198710230001", new Account());
        System.out.println(customer.toString());


        Login l = new Login();
    }
}