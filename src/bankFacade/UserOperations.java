package bankFacade;

import customer.Customer;
import database.Database;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserOperations {

    protected List<Customer> customerFromDB = new ArrayList<>();
    protected Database dataDB = new Database();
    Facade bankFacade;

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
