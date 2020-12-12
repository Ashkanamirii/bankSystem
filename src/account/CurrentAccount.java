package account;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class CurrentAccount extends Account {


    public CurrentAccount(long accountNumber, double balance, String date) {
        super(accountNumber, balance, date);
    }

    @Override
    void showInfo() {
        System.out.println("CurrentAccount{" +
                "balance=" + balance +
                '}');
    }
}
