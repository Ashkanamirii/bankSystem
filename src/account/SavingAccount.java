package account;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class SavingAccount extends Account {
    double interestRate = 2;

    public SavingAccount(long accountNumber, double balance,String date) {
        super(accountNumber, balance,date);
    }

    public void calculateInterestRate() {
        this.interestRate = interestRate + (balance * interestRate / 100 / 365);
    }
    public void addInterest() {
        balance = balance + interestRate;
    }

}
