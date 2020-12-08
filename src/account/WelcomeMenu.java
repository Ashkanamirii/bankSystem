package account;
import bank.Customer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Scanner;


public class WelcomeMenu {

    LocalDateTime timeDateToday = LocalDateTime.now();
    CustomerDatabase customerDatabase = new CustomerDatabase("xxxxx.txt");


    public void welcomeDialogue() {

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Your Bank! \n Please press your desired option: \n (1)login | (2)register ");
        while (scan.hasNext()) {
            String chosenOption = scan.next();
            if (chosenOption.equals("2")) {
                //registerNewCustomer();

            } else if (chosenOption.equals("1")) {
                System.out.println("Please enter your userID");
                String customer = scan.next();
                customer = customer.trim();
                System.out.println("Enter now your pincode");
                String pincode = scan.next();
                pincode = pincode.trim();
                Customer foundCustomer = findCustomer(customer, pincode); /*metoden findCostumer kommer att ersättas
                av Salems metod*/
                if (foundCustomer == null) {
                    System.out.println("Customer not found");
                } else {
                    displayMenu(foundCustomer);
                }

            } else {
                System.out.println("Option not valid");
            }
        }
    }
    //metoden icke vidareutvecklad. Kommmer att ersättas
    public Customer findCustomer(String customer, String pincode){


        if (customer.matches("[0-9]")) {
            return null; //customerDatabase.findByPersonNumber(customer);
        } else
            return null; //customerDatabase.findByName(customer);
        }

    public void displayMenu(Customer customer){
        System.out.println("Welcome back " + customer.getName());
        int temp = -1;
        while(temp != 0)
        {
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

                double amount;
                double withdraw;
                double transfer;

                case 1:
                    System.out.println("Please introduce the amount you want to deposit");
                    amount = getAmountFromUser();
                    facade.makeDeposit(customer, amount);
                    break;

                case 2:
                    System.out.println("Please introduce the amount you want to withdraw");
                    withdraw = getAmountFromUser();
                    facade.withdraw(customer, withdraw);
                    break;

                case 3:
                    System.out.println("Please introduce the amount you want to transfer and destination account");
                    transfer = getAmountFromUser();
                    facade.transfer(customer, transfer, account, account);
                    break;

                case 4:
                    facade.displayHistory(customer);
                    break;

                case 5:
                    facade.displayBalance(customer);
                    break;

                case 6:
                    facade.updatePersonalInfo(customer);
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

    public double getAmountFromUser(){

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