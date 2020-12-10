package account;

import bank.Customer;
import bank.Database;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ashkan Amiri
 * Date:  2020-12-07
 * Time:  11:24
 * Project: bankSystem
 * Copyright: MIT
 */
public class Facade {

    List<Customer> customerFromDB = new ArrayList<>();
    private Database dataDB = new Database();


    public void makeDeposit(double amount, Account account) {
        account.deposit(amount);
    }

    public void makeWithdraw(double amount, Account account) {
        account.withDraw(amount);
    }

    public void makeTransfer(double amount, Account fromAccount, Account toAccount) {
        fromAccount.transfer(amount, fromAccount, toAccount);
    }

    public void welcomeDialogue() {

        try {
            // dataDB.database(listCustomer);
            customerFromDB = dataDB.addDataToCustomerList();

        } catch (Exception e) {
            System.out.println("Could not find file. ");
            e.printStackTrace();
        }

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Your Bank! \n Please press your desired option: \n (1)login | (2)register ");
        while (scan.hasNext()) {
            String chosenOption = scan.next();
            if (chosenOption.equals("2")) {
                //registerNewCustomer();

            } else if (chosenOption.equals("1")) {

                System.out.println("Please enter your customerID:");
                int inputCustomerID = scan.nextInt();

                System.out.println("Please enter your pin code:");
                int inputCustomerPinCode = scan.nextInt();

                System.out.println("1. Savings account");
                System.out.println("2. Current account");
                System.out.println("Choose account: ");
                int choice = scan.nextInt();

                if (customerFromDB.size() == 0) {
                    System.out.println("Empty list");
                }

                // todo måste man veta vilken account som gäller efter login !!!!

                for (int i = 0; i <= customerFromDB.size(); i++) {
                    if (customerFromDB.get(i).getCustomerPinCode() == inputCustomerPinCode && customerFromDB.get(i).getCustomerId() == inputCustomerID) {
                        if (customerFromDB.get(i).getAccountType().getAccountType() == 1 && choice == 1) {
                            Customer c = customerFromDB.get(i);
                            displayMenu(c.getFirstName(), c.getAccount());
                        } else if (customerFromDB.get(i).getAccountType().getAccountType() == 2 && choice == 2) {
                            Customer c = customerFromDB.get(i);
                            displayMenu(c.getFirstName(), c.getAccount());
                        }
                    }
                }

            }
        }
    }


    public void displayMenu(String name, Account account) {
        //    System.out.println("Welcome back " + customer.getName());
        int temp = -1;
        while (temp != 0) {
            System.out.println("Welcome" + name);
            System.out.println("Please choose from the menu");
            System.out.println("1: make a deposit");
            System.out.println("2: withdraw");
            System.out.println("3: make a transfer");
            System.out.println("4: check your transactions' history");
            System.out.println("5: check your balance");
            System.out.println("6: update your personal information");
            System.out.println("0: log out");

            temp = getInfoFromUser();
            double amount;
            switch (temp) {
                case 1:
                    System.out.println("Please introduce the amount you want to deposit");
                    amount = getAmountFromUser();
                    makeDeposit(amount, account);
                    break;

                case 2:
                    System.out.println("Please introduce the amount you want to withdraw");
                    amount = getAmountFromUser();
                    makeWithdraw(amount, account);
                    break;

                case 3:
                    System.out.println("Please introduce the amount you want to Transfer and where");
                    amount = 1000;
                    Long destinationAcc;
                    makeTransfer(amount,account,account);
                    break;

                case 4:
                    //facade.displayHistory(customer);
                    break;

                case 5:
                    account.getBalance();
                    break;

                case 6:
                    //facade.updatePersonalInfo(customer);
                    break;

                case 0:
                    System.out.println("Session closed");
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid option");
                    break;
            }
        }
    }

    public int getInfoFromUser() {
        int input = -2;
        while (input == -2) {
            try {
                Scanner s = new Scanner(System.in);
                input = s.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Just numbers allowed. Please try again \n");
            }
        }
        return input;
    }

    public double getAmountFromUser() {
        double amount = -2;
        while (amount == -2) {
            try {
                Scanner s = new Scanner(System.in);
                amount = s.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Just numbers allowed. Try again");
            }
        }
        return amount;
    }

    //    public void processTransfer(Account fromAccount) {
//        double transferAmount;
//        boolean isValidOption = true;
//        Account originAccount = null;
//        Account destinationAccount = null;
//        Scanner scanTrans = new Scanner(System.in);
//        while (isValidOption == false) {
//            System.out.println("If you want to transfer from current account to savings account \n" +
//                    "press 1.\n" + "If you want to transfer from savings account to current account \n" +
//                    "pres 2.\n" + "If you want to exit this menu \n" + "press 3");
//            String chosenOption = scanTrans.next();
//            if (chosenOption.equals("1")) {
//                originAccount = fromAccount;
//                destinationAccount = customer.getSavingsAccount();
//
//            } else if (chosenOption.equals("2")) {
//                originAccount = customer.getSavingsAccount();
//                destinationAccount = customer.getCurrentAccount();
//
//            } else if (chosenOption.equals("3")) {
//                return;
//
//            } else {
//                System.out.println("Invalid option");
//                isValidOption = false;
//            }
//        }
//        System.out.println("Please introduce the amount you wish to transfer");
//        transferAmount = getAmountFromUser();
//        makeTransfer(transferAmount, originAccount, destinationAccount);
//    }
    public static void main(String[] args) {
        Facade welcomeMenu = new Facade();

        while (true) {
            welcomeMenu.welcomeDialogue();
        }
    }

}

