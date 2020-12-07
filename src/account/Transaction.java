package account;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:20
 * Project: bankSystem
 * Copyright: MIT
 */
public interface Transaction {
     void withdraw(double amount);
     void deposit(double amount);
}
