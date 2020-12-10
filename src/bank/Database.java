package bank;

import account.AccountType;
import account.CurrentAccount;
import account.SavingAccount;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-29
 * Time:  12:21
 * Project: bankSystem
 * Copyright: MIT
 */
public class Database {

    public static List<String[]> read(String file) {
        List<String[]> data = new LinkedList<>();
        String dataRow;
        try (BufferedReader inputReader = new BufferedReader((new FileReader(file)))) {
            while ((dataRow = inputReader.readLine()) != null) {
                String[] dataRecords = dataRow.split(";");
                data.add(dataRecords);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Could not find file");
        } catch (IOException e) {
            System.out.println("could not read file");
        }
        return data;
    }

    public List<Customer> addDataToCustomerList(){
        String csVFile = "src/bank/CustomerList.csv";
        List<String[]> newAccountHolders = read(csVFile);
        List<Customer> customerList = new ArrayList<>();
        for (String[] accountHolder : newAccountHolders) {
            Customer customer = new Customer();
            int customerID = Integer.parseInt(accountHolder[0]);
            customer.setCustomerId(customerID);
            short customerPinCode = Short.parseShort(accountHolder[1]);
            customer.setCustomerPinCode(customerPinCode);
            String firstName = accountHolder[2];
            customer.setFirstName(firstName);
            String lastName = accountHolder[3];
            customer.setLastName(lastName);
            int accountNumber = Integer.parseInt(accountHolder[4]);
            double balance = Double.parseDouble(accountHolder[5]);
            String accountType = accountHolder[6];
            if (accountType.equals("Saving")) {
                customer.setAccountType(AccountType.getAccountType(1));
                customer.setAccount(new SavingAccount(accountNumber, balance));

            } else if (accountType.equals("Current")) {
                customer.setAccountType(AccountType.getAccountType(2));
                customer.setAccount(new CurrentAccount(accountNumber, balance));
            } else {
                System.out.println(" Error AccountType");
            }
            customerList.add(customer);
        }
        return customerList;
    }
}
