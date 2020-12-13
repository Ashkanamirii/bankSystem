package customer;

import bankFacade.Facade;
import database.Database;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RegisterOperation {

   protected List<Customer> customerFromDB = new ArrayList<>();
    protected Database dataDB = new Database();
    Facade bankFacade;

    public void blankspaces(){
        for(int clear = 0; clear < 1000; clear++) {
            System.out.println("\b") ;
        }
    }
    //a method to generate a random number (ID, PIN, account number)
    public int generateRandomNumber(int upperbound, int lowerbound) {

        Random rand = new Random();
        return rand.nextInt(upperbound - lowerbound) + lowerbound;
    }

    public boolean findByName(String name, String lastName) {
        boolean customer = false;
        for (Customer c : customerFromDB) {
            if (c.getFirstName().equalsIgnoreCase(name) && c.getLastName().equalsIgnoreCase(lastName)) {
                System.out.println("You are an existing customer. Please login.");
                bankFacade = new Facade();
                bankFacade.welcomeDialogue();
                customer = true;

            } else customer = false;

        }
        return customer;
    }

    public void welcomeMenuORquit(){
        System.out.println("What would you like to do next?\nPress (1) for Main menu or press (2) for EXIT");
        Scanner s = new Scanner(System.in);
        int customerchoise = s.nextInt();
        if (customerchoise == 1) {
            bankFacade = new Facade();
            bankFacade.welcomeDialogue();
        } else if (customerchoise == 2) {
            System.out.println("Thanks for choosing JavaBank. Good Bye!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice\n\n");
        }
    }

    public void continueORquit(){
        System.out.println("What would you like to do next?\nPress (1) for Main menu or press (2) for EXIT");
        Scanner s = new Scanner(System.in);
        int customerchoise = s.nextInt();
        if (customerchoise == 1) {
            blankspaces();
        } else if (customerchoise == 2) {
            System.out.println("Thanks for choosing JavaBank. Good Bye!");
            System.exit(0);
        } else {
            System.out.println("Invalid choice\n\n");
        }
    }

    public void registerNewCustomer() {
        customerFromDB = dataDB.addDataToCustomerList();
        try {
            blankspaces();
            Scanner input = new Scanner(System.in);
            System.out.println("Welcome to JavaBANK!");
            System.out.println("!!Christmas Offer!!");
            System.out.println("Register now to recive 1-year 0% No-Fee checking account and saving account");
            System.out.println("\n ------------------------- \n");
            System.out.println("Please state your First name: ");
            String name = input.nextLine().trim();
            System.out.println("Please state your Last name: ");
            String lastName = input.nextLine().trim();

            if (!findByName(name, lastName)) {

                Customer newCustomer = new Customer();
                newCustomer.setCustomerId(customerFromDB.size() / 2 + 1);
                newCustomer.setFirstName(name);
                newCustomer.setLastName(lastName);
                newCustomer.setCustomerPinCode((short) generateRandomNumber(9000, 1000));
                newCustomer.setAccount2(generateRandomNumber(27400000, 27300000));
                newCustomer.setBalance(generateRandomNumber(90, 10));
                newCustomer.setAccountTypeNewuser("Saving");
                customerFromDB.add(newCustomer);

                System.out.println();
                System.out.println(newCustomer.toString3());
                System.out.println();

                newCustomer.setAccount2(generateRandomNumber(27400000, 27300000));
                newCustomer.setBalance(generateRandomNumber(90, 10));
                newCustomer.setAccountTypeNewuser("Current");
                customerFromDB.add(newCustomer);

                System.out.println();
                System.out.println(newCustomer.toString4());
                System.out.println();
                welcomeMenuORquit();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
