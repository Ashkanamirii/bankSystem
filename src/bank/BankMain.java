package bank;

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

        Customer customer = new Customer("Iryna", "Molkomsbacken 19, 12333, Farsta","198710230001", new Account());
        System.out.println(customer.toString());


        Login l = new Login();

    }
}