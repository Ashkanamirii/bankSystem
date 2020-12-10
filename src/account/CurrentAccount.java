package account;

import bank.Customer;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class CurrentAccount extends Account {


    public CurrentAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    @Override
    void showInfo() {
        System.out.println("CurrentAccount{" +
                "balance=" + balance +
                '}');
    }
}
