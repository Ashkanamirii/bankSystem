package bank;

import account.Account;
import account.SavingAccount;
import account.AccountType;
import bank.Customer;
import account.Transaction;

import javax.swing.*;
import java.util.*;

/**
 * Created by Ashkan Amiri
 * Date:  2020-11-29
 * Time:  12:20
 * Project: bankSystem
 * Copyright: MIT
 */
public class Login {
    Customer customer;
    int customerId;
    String name;
    String adress;
    String personalNumber;
    Scanner input = new Scanner(System.in);
    int choice;
    boolean persNum_exists;

    List<Customer> customerList = new ArrayList<>();


    Login() {


        //       Customer c1 = new Customer(1,"Iryna", "Molkomsbacken 19, 12333, Farsta","198710230001", new Account());
        //       customers.add(c1);

        menu();

    }

    public void menu() {

        System.out.println("Hej! Vad vill du göra?");
        System.out.println("1. Skapa en ny kund");
        System.out.println("2. Logga in som befintlig kund");
        System.out.println("0. Avsluta programmet");

        choice = input.nextInt();
        switch (choice) {
            case 1:
                createCustomer();
                break;
            case 2:
                loadExistingCustomer();
                break;
            case 0:
                for (Customer c : customerList) {
                    System.out.println(c.toString());
                }
                System.out.println("Hejdå");
                break;
        }
    }

    //    Kunna registrera ny användare (med ny id för varje ny användare, Id: 1, id: 2 osv)
    public void checkPersonalNumber(String personalNumber) {
        persNum_exists = false;

        for (Customer c : customerList) {
            if (personalNumber.equalsIgnoreCase(c.getPersonalNumber())) {
                persNum_exists = true;
                break;
            }
        }
    }

    public boolean ckeckId(String idString) {
        for (Customer c : customerList) {
            if (idString.equalsIgnoreCase(c.getPersonalNumber())) {
                persNum_exists = true;
            } else persNum_exists = false;
        }
        return persNum_exists;
    }

    public void createCustomer() {
        try {
            System.out.println("Ange ditt personnummer (10 ciffror): ");
            String idString = input.nextLine().trim();

            while (!(checkId(idString))) {
                personalNumber = idString;
                System.out.print("Ange ditt namn: ");
                name = input.nextLine();
                System.out.print("Adress: ");
                adress = input.nextLine();
                // ToDo: generate customerId
                customerId = 999;
                // ToDo: generate account number
                // Behöver det vara en ArrayList<Account> som parameter i konstruktorn?

                Customer newCustomer = new Customer(customerId, name, adress, personalNumber, accountsList);
                newCustomer.toString();
            }

        } catch (Exception e) {
            System.out.println("Error message: " + e);
        }
    }


    public void loadExistingCustomer() {
        try {
            input.nextLine();
            System.out.println("Ange ditt personnummer: ");
            String isCustomer = input.nextLine().trim();

            for (Customer c : customerList) {
                if (isCustomer.equalsIgnoreCase(c.getPersonalNumber())) {
                    customer = c;
                }
                return;
            }
            System.out.println("Välkommen " + customer.getName());

        }catch (Exception e) {
                System.out.println("Error message: " + e);
            }
    }

    //    Kunna skapa en ny konto (CurrentAccount och SavingAccount). Kontotyp för CurrentAccount = 1 och kontotyp för SavingAccount = 2. Ska kunna generera nya aAccNr för varje konto.
    //    OBS behöver skriva till fil utan bara logiken.


    public int generateSavingsAccountNumber() {
        SavingAccount account = new SavingAccount(); // ska man lägga till en konstruktor som skapar en tom sparkonto?
        int accountNumber = AccountNumberGenerator.getNewAccountNumber(); // generates random account number
        accounts.put(accountNumber, account); // borde lägga till ett konto i hashMap med konto om den finns, om detta behövs

        return accountNumber;
    }

    public int createSavingsAccount(String personalNumber) {

        Customer customer = findByPersonalNumber(personalNumber);
        return customer.generateSavingsAccountNumber(); // varför läses det inte in?

    }

    // This method can be changed to findById if we use id in all other places
    public Customer findByPersonalNumber(String personNumber) {
        List<Customer> customerList = getCustomerList(); // getCustomerList() borde finnas i databas klassen. Hämtar en lista med alla kunder
        for (Customer c : customerList) {
            if (c.getPersonalNumber().equalsIgnoreCase(personNumber)) {
                return c;
            }
        }
        return null;
    }
}






