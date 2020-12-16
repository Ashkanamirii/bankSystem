package bankFacade;

import account.Account;
import account.AccountEnum;
import customer.Customer;
import customer.RegisterOperation;
import database.Database;
import database.History;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-12-07
 * Time:  11:24
 * Project: bankSystem
 * Copyright: MIT
 */
public class Facade {

    List<Customer> customerFromDB = new ArrayList<>();
    protected Database dataDB = new Database();
    RegisterOperation registerOperation;

    public Facade() {
        welcomeDialogue();
    }

    public void welcomeDialogue() {
        registerOperation = new RegisterOperation();

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
                makeNewCustomer();
            } else if (chosenOption.equals("1")) {
                System.out.println("Please enter your customerID:");
                int inputCustomerID = getInfoFromUser();
                System.out.println("Please enter your pin code:");
                int inputCustomerPinCode = getInfoFromUser();
                if (checkInputInfo(inputCustomerID, inputCustomerPinCode) == null) {
                    System.out.println("Wrong customerID or pincode. Try again");
                    welcomeDialogue();
                } else {
                    Customer c = checkInputInfo(inputCustomerID, inputCustomerPinCode);
                    registerOperation.blankspaces();
                    System.out.println("Welcome " + c.getFirstName() + " " + c.getLastName() + "\n");
                    System.out.println(c.getSalary());
                    System.out.println("Choose an account to make transactions");
                    System.out.println("1. Savings account");
                    System.out.println("2. Current account");
                    System.out.println("2. Credit account");
                    System.out.println("3. Close session");
                    int choice = getInfoFromUser();
                    if (choice == 1 || choice == 2) {
                        registerOperation.blankspaces();
                        getChosenAccount(inputCustomerID, inputCustomerPinCode, choice);
                    } else if (choice == 3) {
                        System.out.println("Closing session");
                        System.exit(0);
                    } else
                        System.out.println("Invalid option. Try again");
                }

            } else
                System.out.println("Invalid option. Press 1 to login. Press 2 to register as a new customer");
        }
    }

    public void displayMenu(Customer customer) {
        int temp = -1;
        while (temp != 0) {
            System.out.println("Welcome " + customer.getFirstName() + " " + customer.getLastName() + "\n");
            System.out.println("Please choose from the menu");
            System.out.println("1: " + AccountEnum.getAccountType(3).getDescription());
            System.out.println("2: " + AccountEnum.getAccountType(4).getDescription());
            System.out.println("3: " + AccountEnum.getAccountType(5).getDescription());
            System.out.println("4: " + AccountEnum.getAccountType(6).getDescription());
            System.out.println("5: " + AccountEnum.getAccountType(7).getDescription());
            System.out.println("6: " + AccountEnum.getAccountType(8).getDescription());
            System.out.println("0: " + AccountEnum.getAccountType(9).getDescription());


            temp = getInfoFromUser();
            double amount;
            switch (temp) {
                case 1:
                    System.out.println("Please introduce the amount you want to deposit");
                    amount = getAmountFromUser();
                    makeDeposit(amount, customer.getAccount(), customer);
                    registerOperation.continueORquit();
                    break;

                case 2:
                    System.out.println("Please introduce the amount you want to withdraw");
                    amount = getAmountFromUser();
                    makeWithdraw(amount, customer.getAccount(), customer);
                    registerOperation.continueORquit();
                    break;

                case 3:
                    System.out.println("Please introduce the amount you want to Transfer ");
                    amount = getAmountFromUser();
                    System.out.println("please enter the account number that you want to send money to");
                    long destinationAccount = (long) getAmountFromUser();
                    makeTransfer(amount, customer.getAccount(), destinationAccount);
                    registerOperation.continueORquit();
                    break;

                case 4:
                    registerOperation.blankspaces();
                    System.out.println("Transaction history:");
                    String filePathOut = "resources/CustomersHistory.csv";
                    List<String[]> customersInfoList = Database.readDataFromFile(filePathOut);
                    for (String[] s : customersInfoList) {
                        long accountNumber = Long.parseLong(s[0]);
                        if (accountNumber == customer.getAccount().getAccountNumber()) {
                            System.out.println("Accountnumber: " + s[0] + " | Accounttype:" + s[1] +
                                    " | Operation:" + s[2] + " | Amount:" + s[3] + " | New balance:" + s[4]
                                    + " | Datestamp:" + s[5] + "\n");
                        }
                    }
                    registerOperation.continueORquit();
                    break;

                case 5:
                    customer.getAccount().printBalance();
                    registerOperation.continueORquit();
                    break;

                case 6:
                    System.out.println("Do you want change pinCod?\n" +
                            "Please enter your new pin code! ");
                    String newPinCode = String.valueOf(getInfoFromUser());
                    History.replaceSelected(String.valueOf(customer.getCustomerPinCode()), newPinCode);
                    registerOperation.continueORquit();
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

    public void makeDeposit(double amount, Account account, Customer customer) {
        account.deposit(amount, customer);
    }

    public void makeWithdraw(double amount, Account account, Customer customer) {
        account.withDraw(amount, customer);
    }

    public void makeTransfer(double amount, Account fromAccount, long toAccount) {
        fromAccount.transfer(amount, toAccount);
    }

    public void makeNewCustomer() {
        registerOperation.registerNewCustomer();
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

    public Customer checkInputInfo(int inputCustomerID, int inputCustomerPinCode) {
        customerFromDB = dataDB.addDataToCustomerList();

        if (customerFromDB.size() == 0) {
            System.out.println("Empty list");
        }
        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getCustomerPinCode() == inputCustomerPinCode
                    && customerFromDB.get(i).getCustomerId() == inputCustomerID)
                if (customerFromDB.get(i).getAccountEnum().getAccountType() == 1) {
                    Customer c = customerFromDB.get(i);
                    return c;
                } else
                    return null;
        }
        return null;
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

    public void getChosenAccount(int inputCustomerID, int inputCustomerPinCode, int choice) {
        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getCustomerPinCode()
                    == inputCustomerPinCode && customerFromDB.get(i).getCustomerId() == inputCustomerID) {
                if (customerFromDB.get(i).getAccountEnum().getAccountType() == 1 && choice == 1) {
                    Customer customerSavingAccInfo = customerFromDB.get(i);
                    displayMenu(customerSavingAccInfo);
                } else if (customerFromDB.get(i).getAccountEnum().getAccountType() == 2 && choice == 2) {
                    Customer customerCurrentAccInfo = customerFromDB.get(i);
                    displayMenu(customerCurrentAccInfo);
                }
            }
        }
    }

    private boolean checkApprovalBalanceReq(double balanceReq, Customer customer) {

        if(customer.getSalary() >= 50000 & balanceReq <= 100000){
            return true;
    }else if (customer.getSalary() >= 30000 & balanceReq <= 50000){
            return true;
    }else if (customer.getSalary() >= 10000 & balanceReq <= 20000){
            return true;
        }else
        return false;
    }
}

