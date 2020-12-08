package bank;

public class Banksystemet implements Comparable<Banksystemet> {

    private String firstname = "";
    private String lastname = "";
    private int customerID;
    private int customerPinCode;
    private int balance;
    private int accountNumber;


    public Banksystemet(int customerID, int customerPinCode, String firstname, String lastname, int accountNumber, int balance) {
        this.customerID = customerID;
        this.customerPinCode = customerPinCode;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
    }

    public int getCustomerPinCode() {
        return customerPinCode;
    }

    public String getLastname() {
        return lastname;
    }

    public int getCustomerID() {
        return customerID;
    }


    public double getBalance() {
        return balance;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public boolean equals(Object other) {
        boolean valid = false;

        return valid;
    }

    public void toString2() {
        System.out.println("\nNamn: " + getFirstname() + " " + getLastname() +
                "\n" + "Saldo: " + getBalance() +
                "\n" + "Kontonummer: " + getAccountNumber() + "\n" );
    }


    @Override
    public int compareTo(Banksystemet o) {
        return this.customerID-o.customerID;
    }
}
