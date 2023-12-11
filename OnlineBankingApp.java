package com.mycompany.onlinebankingapp;

import java.util.InputMismatchException;
import java.util.Scanner;

public class OnlineBankingApp {

    public static void main(String[] args) {
        Scanner accountNum = new Scanner(System.in);
        int accountNumber;
        boolean validAccount = false;
        
        System.out.println("+=========================+");
        System.out.println("+ CTU Banking Application +");
        System.out.println("+=========================+");
        System.out.println("");
        
        //Here the while will run until a valid account is found (validAccount = true)
        while (!validAccount){
            try{
            // Enter accoun number and press Enter
            System.out.println("Please enter your account number:  "); 
            accountNumber = accountNum.nextInt(); 
            }
            catch(InputMismatchException err){
            System.out.println();
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
            System.out.println("ERROR: Invalid Account Number");
            accountNum.nextLine();
            continue;
            }
            if (accountNumber == 13326){
                Account john = new Account("John ","Smith", "A00001", 1500);
                System.out.println("");
                john.menu();
                validAccount = true;
            }
        
            if (accountNumber == 41656){
                Account tim = new Account("Tim ", "Burton", "B00002", 200);
                System.out.println("");
                tim.menu();
                validAccount = true;
            }
        
            if (accountNumber == 81396){
                Account amber = new Account("Amber ", "Green", "C00003", 750);
                System.out.println("");
                amber.menu();
                validAccount = true;
            }
        
            if (accountNumber == 71490){
                Account emma = new Account("Emma ", "Vader", "D00004", 2500);
                System.out.println("");
                emma.menu();
                validAccount = true;
            }
            else{
                // The loop will ask for the account number again
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("ERROR: Invalid Account Number");
                System.out.println("");
            }
        }
    }   
}
