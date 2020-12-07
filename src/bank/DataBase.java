package bank;

import java.io.*;
import java.util.HashMap;
import java.util.StringTokenizer;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class DataBase {


    public DataBase(HashMap<Integer, Banksystemet> hashMap){

        String csVFile = "src/bank/CustomerList.csv";
        String line ="";

        Banksystemet addAccount;
        StringTokenizer current;


        try(BufferedReader br = new BufferedReader(new FileReader(csVFile))){

            while ((line = br.readLine()) != null){
                current = new StringTokenizer(line);

                String firstname = current.nextToken(",");
                String lastname = current.nextToken(",");
                int customerID = Integer.parseInt(current.nextToken(","));
                double accountNumber = Integer.parseInt(current.nextToken(","));
                double balance = Integer.parseInt(current.nextToken(","));
                addAccount = new Banksystemet(customerID, firstname, lastname, accountNumber, balance);
                hashMap.put(addAccount.getCustomerID(), addAccount);

               // System.out.println("Account: " + current[0] + " Accnr: " + current[1] + " Amount: " + current[2] + " Description: " + current[3] + " Balance: " + current[4] + " Timestamp: " + current[5] );
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
