package bankFacade;

import account.Account;
import account.AccountEnum;
import customer.RegisterNewCustomer;
import customer.Customer;
import database.Database;
import database.History;
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
   protected Database dataDB = new Database();
    RegisterNewCustomer newCustomer;
    Customer customers;

    public Facade() {
        welcomeDialogue();
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


    public void welcomeDialogue() {

        newCustomer = new RegisterNewCustomer();
        customers = new Customer();


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
                newCustomer.registerNewCustomer();

            } else if (chosenOption.equals("1")) {

                System.out.println("Please enter your customerID:");
                int inputCustomerID = getInfoFromUser();

                System.out.println("Please enter your pin code:");
                int inputCustomerPinCode = getInfoFromUser();
                if (customers.findCustomer(inputCustomerID, inputCustomerPinCode) == null) {
                    System.out.println("Wrong customerID or pincode. Try again");
                    welcomeDialogue();
                } else {
                    Customer c = customers.findCustomer(inputCustomerID, inputCustomerPinCode);
                    newCustomer.blankspaces();
                    System.out.println("Welcome " + c.getFirstName() + " " + c.getLastName() + "\n");
                    System.out.println("Choose an account to make transactions");
                    System.out.println("1. Savings account");
                    System.out.println("2. Current account");
                    System.out.println("3. Close session");
                    int choice = getInfoFromUser();
                    if (choice == 1 || choice == 2) {
                    newCustomer.blankspaces();
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


    public void getChosenAccount(int inputCustomerID, int inputCustomerPinCode, int choice) {
        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getCustomerPinCode() == inputCustomerPinCode && customerFromDB.get(i).getCustomerId() == inputCustomerID) {
                if (customerFromDB.get(i).getAccountType().getAccountType() == 1 && choice == 1) {
                    Customer customer = customerFromDB.get(i);
                    displayMenu(customer.getAccount(), customer.getAccountType(), customer, customer.getFirstName(), customer.getLastName());
                } else if (customerFromDB.get(i).getAccountType().getAccountType() == 2 && choice == 2) {
                    Customer c = customerFromDB.get(i);
                    displayMenu(c.getAccount(), c.getAccountType(), c, c.getFirstName(), c.getLastName());
                }
            }
        }
    }


    public void displayMenu(Account account, AccountEnum accountType, Customer customer, String Firstname, String Lastname) {
        int temp = -1;
        while (temp != 0) {
            System.out.println("Welcome " + Firstname + " " + Lastname + "\n");
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
                    makeDeposit(amount, account, customer);
                    newCustomer.continueORquit();
                    break;

                case 2:
                    System.out.println("Please introduce the amount you want to withdraw");
                    amount = getAmountFromUser();
                    makeWithdraw(amount, account, customer);
                    newCustomer.continueORquit();
                    break;

                case 3:
                    System.out.println("Please introduce the amount you want to Transfer ");
                    amount = getAmountFromUser();
                    System.out.println("please enter the account number that you want to send money to");
                    long destinationAccount = (long) getAmountFromUser();
                    makeTransfer(amount, account, destinationAccount);
                    newCustomer.continueORquit();
                    break;

                case 4:
                  //  doit.blankspaces();
                    System.out.println("Transaction history:");
                    String filePathOut = "resources/CustomersHistory.csv";
                    List<String[]> customersInfoList = Database.read(filePathOut);
                    for (String[] s : customersInfoList) {
                        long accountNumber = Long.parseLong(s[0]);
                        if (accountNumber == account.getAccountNumber()) {
                            System.out.println("Accountnumber: " + s[0] + " | Accounttype:" + s[1] + " | Operation:" + s[2] + " | Amount:" + s[3] + " | New balance:" + s[4] + " | Datestamp:" + s[5] + "\n");
                           // System.out.println(Arrays.toString(s));
                        }
                    }
                    newCustomer.continueORquit();
                    break;

                case 5:
                    account.printBalance();
                    newCustomer.continueORquit();
                    break;

                case 6:
                    System.out.println("Do you want change pinCod?\n" +
                            "Please enter your new pin code! ");
                    Scanner scanner = new Scanner(System.in);
                    String newPinCode = scanner.next();
                    History.replaceSelected(String.valueOf(customer.getCustomerPinCode()), newPinCode);
                    newCustomer.continueORquit();
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
    // TODO: 2020-12-11  fix check balance method for withdraw, deposit and transfer

}

