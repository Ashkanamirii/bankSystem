package account;

/**
 * Created by Ashkan Amiri, Jacaranda Perez, Iryna Gnatenko och Salem Koldzo
 * Date:  2020-11-30
 * Time:  13:58
 * Project: bankSystem
 * Copyright: MIT
 */
public abstract class Account {
    private long accountNumber;
    protected double balance;


    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }


    public void withDraw(double amount) {
        if (amount < balance){
        balance = balance - amount;
            System.out.println("\nWithdrawing $" + amount);
        }else {
            System.out.println("\nYour balance is not enough to complete this transaction");
        }
        printBalance();
    }

    public void deposit(double amount){
        if (amount > 0) {
            balance = balance + amount;
            System.out.println("\nDepositing $" + amount);
        } else{
            System.out.println("\nYour amount is incorrect");
        }
        printBalance();
    }
    public void transfer(double transferAmount,Account send,Account recieve, AccountType accountType) {

        String accountTypeforString1;
        String accountTypeforString2;

        if (accountType.equals(1)) {
             accountTypeforString1 = "SavingsAccount";
            accountTypeforString2 = "CurrentAccount";

        } else{
            accountTypeforString1 = "CurrentAccount";
            accountTypeforString2 = "SavingsAccount";
        }

            if (transferAmount < balance) {
                balance = balance - transferAmount;
                System.out.println("\nTransfering $ " + transferAmount + " from " + accountTypeforString2 + " to your " + accountTypeforString1);
            } else if (transferAmount <= 0) {
                System.out.println("\nInvalid amount to transfer.  Transaction cancelled.");
            } else {
                System.out.println("\nTransferring account balance is insufficient to transfer funds.");
            }

        printBalance();
    }

    public void printBalance (){
        System.out.println("Your balance is now: $" + balance + "\n");
    }

    abstract void showInfo();

    @Override
    public String toString() {
        return "\nAccountNumber: " + accountNumber +
                "\nBalance: " + balance
                ;
    }
}


