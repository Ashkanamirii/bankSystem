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
public class Database {


    public static void database(HashMap<Integer, Banksystemet> hashMap){

        String csVFile = "src/bank/CustomerList.csv";
        String line;

        Banksystemet addAccount;
        StringTokenizer current;


        try(BufferedReader reader = new BufferedReader(new FileReader(csVFile))){

            while ((line = reader.readLine()) != null){
                current = new StringTokenizer(line);

                short customerID = Short.parseShort(current.nextToken(";"));
                String firstname = current.nextToken(";");
                String lastname = current.nextToken(";");
                double accountNumber = Double.parseDouble(current.nextToken(";"));
                double balance = Double.parseDouble(current.nextToken(";"));
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
