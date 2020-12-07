package account;

import bank.Customer;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class SavingAccount extends Account {
    double interestRate;

    public SavingAccount(long accountNumber, double balance, int customerID ) {
        super(accountNumber, balance, customerID);
        this.accountType= setAccountType();
    }

    @Override
    public AccountType setAccountType() {
        int accType = 1;
        return AccountType.getAccountType(accType);
    }


    public void calculateInterestRate(double interestRate) {
        this.interestRate = interestRate + (balance * interestRate / 100 / 365);

    }


    public void addInterest() {
        balance = balance + interestRate;
        interestRate = 0;
    }

}
