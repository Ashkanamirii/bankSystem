package account;

import bank.Customer;

/**
 * Created by Ashkan Amiri
 * Date:  2020-12-07
 * Time:  11:24
 * Project: bankSystem
 * Copyright: MIT
 */
public class Facade {

    public void makeDeposite(int amount, Customer id){
        Customer customer = new Customer();
        customer.setCustomerId(10);
        SavingAccount savingAccount = new SavingAccount(111,10000, customer);
        savingAccount.deposit(amount);
    }
}
