package account;

import bank.Customer;
import bank.Database;
import bank.History;

import java.sql.Array;
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
                //registerNewCustomer();

            } else if (chosenOption.equals("1")) {

                System.out.println("Please enter your customerID:");
                int inputCustomerID = getInfoFromUser();

                System.out.println("Please enter your pin code:");
                int inputCustomerPinCode = getInfoFromUser();
                if (findCustomer(inputCustomerID, inputCustomerPinCode) == null) {
                    System.out.println("Wrong customerID or pincode. Try again");
                    welcomeDialogue();
                } else {
                    Customer c = findCustomer(inputCustomerID, inputCustomerPinCode);
                    System.out.println("Welcome " + c.getFirstName() + " " + c.getLastName());
                    System.out.println("Choose an account to make transactions");
                    System.out.println("1. Savings account");
                    System.out.println("2. Current account");
                    System.out.println("3. Close session");
                    int choice = getInfoFromUser();
                    if (choice == 1 || choice == 2) {
                        getChosenAccount(inputCustomerID, inputCustomerPinCode, choice);
                    } else if (choice == 0) {
                        System.out.println("Closing session");
                        System.exit(0);
                    } else
                        System.out.println("Invalid option. Try again");
                }

            } else
                System.out.println("Invalid option. Press 1 to login. Press 2 to register as a new customer");
        }
    }

    public Customer findCustomer(int inputCustomerID, int inputCustomerPinCode) {
        if (customerFromDB.size() == 0) {
            System.out.println("Empty list");
        }
        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getCustomerPinCode() == inputCustomerPinCode && customerFromDB.get(i).getCustomerId() == inputCustomerID)
                if (customerFromDB.get(i).getAccountType().getAccountType() == 1) {
                    Customer c = customerFromDB.get(i);
                    return c;
                } else
                    return null;
        }
        return null;
    }

    public void getChosenAccount(int inputCustomerID, int inputCustomerPinCode, int choice) {
        for (int i = 0; i < customerFromDB.size(); i++) {
            if (customerFromDB.get(i).getCustomerPinCode() == inputCustomerPinCode && customerFromDB.get(i).getCustomerId() == inputCustomerID) {
                if (customerFromDB.get(i).getAccountType().getAccountType() == 1 && choice == 1) {
                    Customer customer = customerFromDB.get(i);
                    displayMenu(customer.getAccount(), customer.getAccountType(), customer);
                } else if (customerFromDB.get(i).getAccountType().getAccountType() == 2 && choice == 2) {
                    Customer c = customerFromDB.get(i);
                    displayMenu(c.getAccount(), c.getAccountType(), c);
                }
            }
        }
    }

    public void displayMenu(Account account, AccountTypeEnum accountType, Customer customer) {
        int temp = -1;
        while (temp != 0) {
            System.out.println("Please choose from the menu");
            System.out.println(AccountTypeEnum.getAccountType(3).getDescription());
            System.out.println(AccountTypeEnum.getAccountType(4).getDescription());
            System.out.println(AccountTypeEnum.getAccountType(5).getDescription());
            System.out.println(AccountTypeEnum.getAccountType(6).getDescription());
            System.out.println(AccountTypeEnum.getAccountType(7).getDescription());
            System.out.println(AccountTypeEnum.getAccountType(8).getDescription());
            System.out.println(AccountTypeEnum.getAccountType(9).getDescription());

            temp = getInfoFromUser();
            double amount;
            switch (temp) {
                case 1:
                    System.out.println("Please introduce the amount you want to deposit");
                    amount = getAmountFromUser();
                    makeDeposit(amount, account, customer);
                    break;

                case 2:
                    System.out.println("Please introduce the amount you want to withdraw");
                    amount = getAmountFromUser();
                    makeWithdraw(amount, account, customer);
                    break;

                case 3:
                    System.out.println("Please introduce the amount you want to Transfer ");
                    amount = getAmountFromUser();
                    System.out.println("please enter the account number that you want to send money to");
                    long destinationAccount = (long) getAmountFromUser();
                    makeTransfer(amount, account, destinationAccount);
                    break;

                case 4:
                    String filePathOut = "resources/CustomersHistory.csv";
                    List<String[]> customersInfoList = Database.read(filePathOut);
                    for (String[] s : customersInfoList) {
                        long accountNumber = Long.parseLong(s[0]);
                        if (accountNumber == account.getAccountNumber()) {
                            System.out.println(Arrays.toString(s));
                        }
                    }
                    break;

                case 5:
                    account.printBalance();
                    break;

                case 6:
                    System.out.println("Do you want change pinCod?\n" +
                            "Please enter your new pin code! ");
                    Scanner scanner = new Scanner(System.in);
                    String newPinCode = scanner.next();
                    History.replaceSelected(String.valueOf(customer.getCustomerPinCode()), newPinCode);
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

