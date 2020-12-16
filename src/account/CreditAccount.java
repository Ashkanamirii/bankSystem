package account;

import customer.Customer;

import java.util.Scanner;

/**
 * Created by Ashkan Amiri
 * Date:  2020-12-15
 * Time:  17:44
 * Project: bankSystem
 * Copyright: MIT
 */
public class CreditAccount extends Account{

    public CreditAccount(long accountNumber, double balance, String date) {
        super(accountNumber, balance, date);
    }

    public void requestCreditCard(Customer customer){
//        System.out.println("Enter your balance request!  ");
////        Scanner scanner =  new Scanner(System.in);
//////        double balanceReq = scanner.nextDouble();
//////        if (checkApprovalBalanceReq(balanceReq , customer)){
////            System.out.println("Your request is approved");
//////            // TODO: 2020-12-15  creat card and account
//////        }else {
//////            System.out.println(" You  haven't enough credit for your request!");
//////        }

    }
}
