package account;

/**
 * Created by Ashkan Amiri
 * Date:  2020-12-04
 * Time:  13:46
 * Project: bankSystem
 * Copyright: MIT
 */
public class GUI {
}
while (true) {
        Customer customer = new Customer();
        System.out.println("(1)login | (2)register ");
        String status = scan.next();
        if (status.equals("2")) {
            register(scan, outputStream, properties, customer);
        }
        else if (status.equals("1")) {
            System.out.println("pleas enter username and password ");
            String username = scan.next();
            String password = scan.next();
            customer.setName(username);


    private static void option() {
        System.out.println("input your option: (1 | 2 | 3 | 4 | 5| 6 | 7) ");
        System.out.println("(1) deposit ");
        System.out.println("(2) withdraw ");
        System.out.println("(3) history ");
        System.out.println("(4) transfer ");
        System.out.println("(5) profile ");
        System.out.println("(6) check balance ");
        System.out.println("(7) exit ");
    }

    if(properties.getProperty(username) != null)
            if (properties.getProperty(username).equals(password)) {
        System.out.println("welcome to system");
        customers.add(customer);

        while (true) {
            option();
            String input = scan.next();
            switch (input) {
                case "1":
                    savingAccount(scan, customer);
                    break;
                case "2":
                    loan(scan, path, file, history, accountLoans, customers, employee, customer);
                    break;
                case "3":
                    history(path);
                    break;
                case "4":
                    profile(scan, customer);
                    break;

                case "5":
                    System.exit(0);
                    break;
            }
        }
    } else {
        System.out.println("invalid username and password");
    }
}
