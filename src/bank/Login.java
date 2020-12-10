//package bank;
//
//import account.Account;
//import account.SavingAccount;
//import account.AccountType;
//import bank.Customer;
//import account.Transaction;
//
//import javax.swing.*;
//import java.util.*;
//
///**
// * Created by Ashkan Amiri
// * Date:  2020-11-29
// * Time:  12:20
// * Project: bankSystem
// * Copyright: MIT
// */
//public class Login {
//    Customer customer;
//    Scanner input = new Scanner(System.in);
//    int choice;
//    boolean persNum_exists;
//    ArrayList<Customer> customerList;
//
//
//    Login() {
//        menu();
//
//    }
//
//    public void menu() {
//
//        System.out.println("Hej! Vad vill du göra?");
//        System.out.println("1. Skapa en ny kund");
//        System.out.println("2. Logga in som befintlig kund");
//        System.out.println("0. Avsluta programmet");
//
//        choice = input.nextInt();
//        switch (choice) {
//            case 1:
//                createCustomer();
//                break;
//            case 2:
//                loadExistingCustomer();
//                break;
//            case 0:
//                for (Customer c : customerList) {
//                    System.out.println(c.toString());
//                }
//                System.out.println("Hejdå");
//                break;
//        }
//    }
//
//    //    Kunna registrera ny användare (med ny id för varje ny användare, Id: 1, id: 2 osv)
//    public void checkPersonalNumber(String personalNumber) {
//        persNum_exists = false;
//
//        for (Customer c : customerList) {
//            if (personalNumber.equalsIgnoreCase(c.getPersonalNumber())) {
//                persNum_exists = true;
//                break;
//            }
//        }
//    }
//
//    private boolean checkId(String idString) {
//        for (Customer c : customerList) {
//            if (idString.equalsIgnoreCase(c.getPersonalNumber())) {
//                persNum_exists = true;
//            } else persNum_exists = false;
//        }
//        return persNum_exists;
//    }
//
//    public void createCustomer() {
//        try {
//            input.nextLine();
//            System.out.println("Ange ditt personnummer (10 ciffror): ");
//            String idString = input.nextLine().trim();
//
//            if (!(checkId(idString))) {
//                Customer newCustomer = new Customer();
//                newCustomer.setPersonalNumber(idString);
//                System.out.print("Ange ditt namn: ");
//                newCustomer.setName(input.nextLine());
//                System.out.print("Adress: ");
//                newCustomer.setAddress(input.nextLine());
//                // ToDo: generate customerId
//                newCustomer.setCustomerId(999);
//                // ToDo: generate account number
//                // Behöver det vara en ArrayList<Account> som parameter i konstruktorn?
//                newCustomer.toString();
//            } else
//                menu();
//
//        } catch (Exception e) {
//            System.out.println("Error message: " + e);
//        }
//    }
//
//
//    public void loadExistingCustomer() {
//        try {
//            input.nextLine();
//            System.out.println("Ange ditt personnummer: ");
//            String isCustomer = input.nextLine().trim();
//
//            for (Customer c : customerList) {
//                if (isCustomer.equalsIgnoreCase(c.getPersonalNumber())) {
//                    customer = c;
//                }
//                System.out.println("Välkommen " + customer.getName());
//                return ;
//            }
//
//        } catch (NullPointerException e) {
//            System.out.println("Cannot invoke \"bank.Customer.getName()");
//        }
//
//        catch (Exception e) {
//            System.out.println("Error message: " + e);
//        }
//    }
//
//    //    Kunna skapa en ny konto (CurrentAccount och SavingAccount). Kontotyp för CurrentAccount = 1 och kontotyp för SavingAccount = 2. Ska kunna generera nya aAccNr för varje konto.
//    //    OBS behöver skriva till fil utan bara logiken.
//
///*
//   public int generateSavingsAccountNumber() {
//        SavingAccount account = new SavingAccount(); // ska man lägga till en konstruktor som skapar en tom sparkonto?
//        int accountNumber = AccountNumberGenerator.getNewAccountNumber(); // generates random account number
//        accounts.put(accountNumber, account); // borde lägga till ett konto i hashMap med konto om den finns, om detta behövs
//
//        return accountNumber;
//    }
//
//    public int createSavingsAccount(String personalNumber) {
//
//        Customer customer = findByPersonalNumber(personalNumber);
//        return customer.generateSavingsAccountNumber(); // varför läses det inte in?
//
//    }
//
//    // This method can be changed to findById if we use id in all other places
//    public Customer findByPersonalNumber(String personNumber) {
//        List<Customer> customerList = getCustomerList(); // getCustomerList() borde finnas i databas klassen. Hämtar en lista med alla kunder
//        for (Customer c : customerList) {
//            if (c.getPersonalNumber().equalsIgnoreCase(personNumber)) {
//                return c;
//            }
//        }
//        return null;
//*/
//}
//
//
//
//
//
//
//
