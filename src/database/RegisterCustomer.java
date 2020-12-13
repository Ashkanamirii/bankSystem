package database;

import account.Account;
import customer.Customer;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterCustomer {

    public static void addNewUserToList(int customerId, short customerPinCode, String firstName, String lastName, long accountnr, Double balance1, String accountTypeNewUser) {
        Customer newCustomer = new Customer();
        String filePathOut = "resources/CustomerList.csv";
        String textToAppend = newCustomer.customToString2(customerId, customerPinCode, firstName, lastName, accountnr, balance1, accountTypeNewUser);
        try (FileWriter fileWriter = new FileWriter(filePathOut, true);
             PrintWriter printWriter = new PrintWriter(fileWriter)) {
            printWriter.println(textToAppend);  //New line
        } catch (FileNotFoundException e) {
            System.out.println("File could not be found");
        } catch (IOException e) {
            System.out.println("Could not write to file");
            e.printStackTrace();
        } catch (Exception e) {
            System.out.println("File error");
        }
    }
}
