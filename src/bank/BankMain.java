package bank;

import account.AccountType;
import account.Facade;
import account.SavingAccount;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:20
 * Project: bankSystem
 * Copyright: MIT
 */
public class BankMain {


    public static void main(String[] args) {
        Facade welcomeMenu = new Facade();

        while (true) {
            welcomeMenu.welcomeDialogue();
        }
    }
}