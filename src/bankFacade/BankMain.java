package bankFacade;

import java.util.Scanner;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-29
 * Time:  12:20
 * Project: bankSystem
 * Copyright: MIT
 */
public class BankMain {


    public static void main(String[] args) {
    Facade facade = new Facade();

        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to Your Bank! \n Please press your desired option: \n (1)login | (2)register ");
        while (scan.hasNext()) {
            String chosenOption = scan.next();
            if (chosenOption.equals("2")) {
                facade.makeNewCustomer();
            } else if (chosenOption.equals("1")) {
                System.out.println("Please enter your customerID:");
                int inputCustomerID = facade.getInfoFromUser();
                System.out.println("Please enter your pin code:");
                int inputCustomerPinCode = facade.getInfoFromUser();
                facade.checkCustomer(inputCustomerID, inputCustomerPinCode);
            } else
                System.out.println("Invalid option. Press 1 to login. Press 2 to register as a new customer");
        }
    }
}