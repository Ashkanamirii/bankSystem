package bank;

public class Banksystemet implements Comparable<Banksystemet> {

    private String firstname = "";
    private String lastname = "";
    private int customerID;
    private double balance;
    private double accountNumber;

    public Banksystemet(int customerID, String firstname, String lastname, double accountNumber, double balance) {
        this.customerID = customerID;
        this.firstname = firstname;
        this.lastname = lastname;
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    public String getFirstname() {
        return firstname;
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

    public double getAccountNumber() {
        return accountNumber;
    }

    public boolean equals(Object other) {
        boolean valid = false;

        return valid;
    }

    public void toString2() {
        System.out.println("Namn: " + getFirstname() + " " + getLastname() +
                "\n" + "Saldo: " + getBalance() +
                "\n" + "Kontonummer: " + getAccountNumber());
    }


    @Override
    public int compareTo(Banksystemet o) {
        return this.customerID-o.customerID;
    }
}
