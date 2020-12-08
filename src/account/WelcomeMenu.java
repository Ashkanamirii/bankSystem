package account;
import bank.Banksystemet;
import bank.Customer;
import bank.Database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;


public class WelcomeMenu {

    LocalDateTime timeDateToday = LocalDateTime.now();
  //  CustomerDatabase customerDatabase = new CustomerDatabase("xxxxx.txt");

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

   /* public Customer findCustomer(int customer){

        if (customer.matches("[0-9]")) {
            return null; //customerDatabase.findByPersonNumber(customer);
        } else
            return null; //customerDatabase.findByName(customer);
        }*/

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

            switch (temp)

            {
               // Scanner scanMenu = new Scanner(System.in);
                case 1:
                    System.out.println("Please introduce the amount you want to deposit");
                    //facade.makeDeposit(customer, amount, accountType);
                    break;

                case 2:
                    System.out.println("Please introduce the amount you want to withdraw");
                 //   facade.withdraw(customer, amount);
                    break;

                case 3:
                    System.out.println("Please introduce the amount you want to transfer and destination account");
                //    facade.transfer(customer, amount, accountType, accountType);
                    break;

                case 4:
                  //  facade.displayHistory(customer);
                    break;

                case 5:
                  //  facade.displayBalance(customer);
                    listCustomer.get(customerID).toString2();
                    break;

                case 6:
                //    facade.updatePersonalInfo(customer);
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
        int input = 0;
       while (input == 0){
            try
            {
                Scanner s = new Scanner(System.in);
                input = s.nextInt();
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Just numbers allowed");
            }
        }
        return input;
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