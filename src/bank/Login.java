package bank;

import account.Account;
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
    String personalNumber;
    Scanner input = new Scanner(System.in);
    int choice;
    boolean testId;
    boolean addCustomer;


    List<Customer> customers = new ArrayList<>();


    Login () {
        Customer c1 = new Customer("Iryna", "Molkomsbacken 19, 12333, Farsta","198710230001", new Account());
        customers.add(c1);

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
                for (Customer c: customers) {
                    System.out.println(c.toString());
                }
                System.out.println("Hejdå");
                break;
        }
    }

//    Kunna registrera ny användare (med ny id för varje ny användare, Id: 1, id: 2 osv)
    public void checkId (String personalNumber) {
        testId = true;

        for (Customer c : customers) {
            if (personalNumber.equals(c.getPersonalNumber())) {
                testId = false;
            }
        }
    }

    public void createCustomer() {
        input.nextLine();

        while (true) {
            System.out.println("Ange ditt personnummer (10 ciffror): ");
            String testExistingCustomer = input.nextLine().trim();
            checkId(testExistingCustomer);

            if (testId) {
                addCustomer = false;
                System.out.println("Välkommen " + customer.getName() ); // + Customer.getName() - varför fungerar inte detta??
                menu();

            } else {
                System.out.println("Du är redan kund hos oss. Vänligen logga in.");
                menu();
            }
            customers.add(customer);
            break;
        }

    }

        public void loadExistingCustomer() {
            input.nextLine();
            System.out.println("Ange ditt personnummer: ");
            String checkPersNr = input.nextLine().trim();

            for (Customer c : customers) {
                if (checkPersNr.equals(c.getPersonalNumber())) {
                    customer = c;
                }

                System.out.println("Välkommen " + customer.getName());
            }
        }

    //    Kunna skapa en ny konto (CurrentAccount och SavingAccount). Kontotyp för CurrentAccount = 1 och kontotyp för SavingAccount = 2. Ska kunna generera nya aAccNr för varje konto.
    //    OBS behöver skriva till fil utan bara logiken.
    //    private void createAccount() {


    }

