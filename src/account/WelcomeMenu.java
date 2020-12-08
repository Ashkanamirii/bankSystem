package account;
import bank.Banksystemet;
import bank.Database;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeMenu {
    
    /*LocalDateTime timeDateToday = LocalDateTime.now(); Kommer att användas för att registrera 
    tid för sista inloggning och transactioner? Kan finnas också varje metod. Ta bort om oanvänt*/


   private HashMap<Integer, Banksystemet> listCustomer = new HashMap<>();
   private Database dataDB = new Database();
    
    public void welcomeDialogue() {

        try {
            dataDB.database(listCustomer);

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
                    int customer = scan.nextInt();

                    System.out.println("Please enter your pin code:");
                    int customerPinCode = scan.nextInt();

                    if (customerPinCode == listCustomer.get(customer).getCustomerPinCode()) {
                        displayMenu(customer);

                    } else {
                        System.out.print("Wrong customerID or pincode! Try Again! \n ");
                        welcomeDialogue();

                        }
            } else {
                System.out.println("Option not valid");
            }
        }
    }

    public void displayMenu(int customerID){
    //    System.out.println("Welcome back " + customer.getName());
        int temp = -1;
        while(temp != 0)
        {
            listCustomer.get(customerID).toString2();
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
            double withdraw;

            switch (temp)

            {
                case 1:
                    System.out.println("Please introduce the amount you want to deposit");
                    amount = getAmountFromUser();
                    //facade.makeDeposit(customer, amount);
                    break;

                case 2:
                    System.out.println("Please introduce the amount you want to withdraw");
                    withdraw = getAmountFromUser();
                    //facade.withdraw(customer, withdraw);
                    break;

                case 3:
                    //processTransfer(customerID);
                    break;

                case 4:
                    //facade.displayHistory(customer);
                    break;

                case 5:
                    //facade.displayBalance(customer);
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

    public int getInfoFromUser(){
        int input = -2;
        while (input == -2){
            try
            {
                Scanner s = new Scanner(System.in);
                input = s.nextInt();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Just numbers allowed. Please try again \n");
            }
        }
        return input;
    }

    public double getAmountFromUser(){
        double amount = -2;
        while (amount == -2){
            try
            {
                Scanner s = new Scanner(System.in);
                amount = s.nextDouble();
            }
            catch (InputMismatchException e)
            {
                System.out.println("Just numbers allowed. Try again");
            }
        }
        return amount;
    }
   public void processTransfer(int customerID) {
        double transfer;
        boolean isValidOption = true;
        Account originAccount = null;
        Account destinationAccount = null;
        Scanner scanTrans = new Scanner(System.in);
        while (isValidOption == false) {
            System.out.println("If you want to transfer from current account to savings account \n" +
                    "press 1.\n" + "If you want to transfer from savings account to current account \n" +
                    "pres 2.\n" + "If you want to exit this menu \n" + "press 3");
            String chosenOption = scanTrans.next();
            if (chosenOption.equals("1")) {
                originAccount = customer.getCurrentAccount();
                destinationAccount = customer.getSavingsAccount();

            } else if (chosenOption.equals("2")) {
                originAccount = customer.getSavingsAccount();
                destinationAccount = customer.getCurrentAccount();

            } else if (chosenOption.equals("3")) {
                return;

            } else {
                System.out.println("Invalid option");
                isValidOption = false;
            }
        }
        System.out.println("Please introduce the amount you wish to transfer");
        transfer = getAmountFromUser();
        facade.transfer(customer, transfer, originAccount, destinationAccount);
    }

    public void run() {
        welcomeDialogue();
    }

    public static void main(String[] args) {
        WelcomeMenu welcomeMenu = new WelcomeMenu();

        while (true) {
            welcomeMenu.run();
        }
    }
}