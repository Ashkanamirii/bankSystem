package account;

import bank.Customer;
import bank.Database;

import java.util.*;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-12-07
 * Time:  11:24
 * Project: bankSystem
 * Copyright: MIT
 */
public class Facade {

    List<Customer> customerFromDB = new ArrayList<>();
    private Database dataDB = new Database();

    public Facade() {
        welcomeDialogue();
    }


    public void makeDeposit(double amount, Account account) {
        account.deposit(amount);
    }

    public void makeWithdraw(double amount, Account account) {
        account.withDraw(amount);
    }

    public void makeTransfer(double amount, Account fromAccount, Account toAccount, AccountType accounttype) {
        fromAccount.transfer(amount, fromAccount, toAccount, accounttype);
    }

    public void welcomeDialogue() {

        try {
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
                registerNewCustomer();

            } else if (chosenOption.equals("1")) {

                System.out.println("Please enter your customerID:");
                int inputCustomerID = scan.nextInt();

                System.out.println("Please enter your pin code:");
                int inputCustomerPinCode = scan.nextInt();
                findCustomer(inputCustomerID, inputCustomerPinCode);

                System.out.println("Choose an account to make transactions");
                System.out.println("1. Savings account");
                System.out.println("2. Current account");
                int choice = scan.nextInt();
                getChosenAccount(inputCustomerID, inputCustomerPinCode, choice);

                if (customerFromDB.size() == 0) {
                    System.out.println("Empty list");
                }
            }
        }
    }

    public void findCustomer(int inputCustomerID, int inputCustomerPinCode) {

        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getCustomerPinCode() == inputCustomerPinCode && customerFromDB.get(i).getCustomerId() == inputCustomerID)
                if (customerFromDB.get(i).getAccountType().getAccountType() == 1) {
                    System.out.println("Welcome back " + customerFromDB.get(i).getFirstName() + " " + customerFromDB.get(i).getLastName());


                } else if (customerFromDB.get(i).getCustomerPinCode() != inputCustomerPinCode && customerFromDB.get(i).getCustomerId() != inputCustomerID) {

                    System.out.println("Customer not found. Please try again");
                    welcomeDialogue();
                }
        }
    }

    public void getChosenAccount(int inputCustomerID, int inputCustomerPinCode, int choice) {
        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getCustomerPinCode() == inputCustomerPinCode && customerFromDB.get(i).getCustomerId() == inputCustomerID) {
                if (customerFromDB.get(i).getAccountType().getAccountType() == 1 && choice == 1) {
                    Customer c = customerFromDB.get(i);
                    displayMenu(c.getAccount(), c.getAccountType());
                } else if (customerFromDB.get(i).getAccountType().getAccountType() == 2 && choice == 2) {
                    Customer c = customerFromDB.get(i);
                    displayMenu(c.getAccount(), c.getAccountType());
                }
            }
        }
    }

    public void registerNewCustomer() {
        try {

            Scanner input = new Scanner(System.in);
            System.out.println("Please state your name: ");
            String name = input.nextLine().trim();
            System.out.println("Please state your last name: ");
            String lastName = input.nextLine().trim();

            // ToDo: the condition is not working. Try to fix it
            if (!findByName(name, lastName)) {

                Customer newCustomer = new Customer();

             //   newCustomer.setCustomerId(generateRandomNumber(100, 1));
                newCustomer.setCustomerId(customerFromDB.size()/2 +1);
                newCustomer.setFirstName(name);
                newCustomer.setLastName(lastName);
                newCustomer.setCustomerPinCode((short) generateRandomNumber(9000, 1000));
                newCustomer.setAccount(new CurrentAccount(generateRandomNumber(27400000, 27300000), 0));
                newCustomer.setAccountType(AccountType.CURRENT_ACCOUNT);


                customerFromDB.add(newCustomer);

                System.out.println();
                System.out.println(newCustomer.toString3());
                System.out.println();

                displayMenu(newCustomer.getAccount(), AccountType.CURRENT_ACCOUNT);

            } else {
                System.out.println("You are an existing customer. Please login.");
                welcomeDialogue();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    //the method generates a random number (ID, PIN, account number)
    public int generateRandomNumber(int upperbound, int lowerbound) {

        Random rand = new Random();
        return rand.nextInt(upperbound - lowerbound) + lowerbound;
    }

    public boolean findByName(String name, String lastName) {
        boolean customer = false;
        for (Customer c : customerFromDB) {
            if (c.getFirstName().equalsIgnoreCase(name) && c.getLastName().equalsIgnoreCase(lastName)) {
                customer = true;
            } else customer = false;

        }
        return customer;
    }

    public void displayMenu(Account account, AccountType accounttype) {
        int temp = -1;
        while (temp != 0) {
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
                    System.out.println("Please introduce the amount you want to Transfer");
                    amount = getAmountFromUser();
                    makeTransfer(amount, account, account, accounttype);
                    break;

                case 4:
                    //facade.displayHistory(customer);
                    break;

                case 5:
                    account.printBalance();
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
}

