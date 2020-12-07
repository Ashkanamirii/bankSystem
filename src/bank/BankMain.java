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

    String name;
    Customer customer;




    public void addAccount() {
    }


    public void addCustomer() {
    }

    public static void main(String[] args) {
     //   Customer customer1 = new Customer();1
   //     customer1.setCustomerId(11111);
   //     Facade facade = new Facade();

        Scanner userinput = new Scanner(System.in);
        HashMap<Integer, Banksystemet> listCustomer = new HashMap<>();
        int customerIDuserinput;
        double accountNR;
        boolean nextinput = true;
        Database dataDB = new Database();

        // facade.makeDeposit(100 , customer1);
        try {
            dataDB.database(listCustomer);

        } catch (Exception e) {
            System.out.println("Could not find file. ");
            e.printStackTrace();
        }

       try {
            System.out.print("Enter your customerID:");
            customerIDuserinput = userinput.nextInt();

            try{
                System.out.print("Enter your accountNR:");
                accountNR = userinput.nextDouble();

                if (accountNR == listCustomer.get(customerIDuserinput).getAccountNumber()){
                    listCustomer.get(customerIDuserinput).toString2();
                }


            } catch (NullPointerException | InputMismatchException e){
                System.out.println("Invalid accountNR. ");
            }




       } catch (NullPointerException | InputMismatchException e) {
           System.out.println("Invalid customer ID. ");
       }
    }
}