package com.mycompany.onlinebankingapp;
    
import java.util.InputMismatchException;
import java.util.Scanner;

public class Account {
    //Class Variables
    int balance;
    int previousDepositedTransaction;
    int previousWithdrawTransaction;
    String customerFirstName;
    String customerLastName;
    String customerID;
	
    //Class constructor
    Account(String fname, String lname,String custID, int AccBalance) {
        customerFirstName = fname;
        customerLastName = lname;
        customerID = custID;
        balance = AccBalance;
    }
	
    //Function for Depositing money
    void deposit(int amount) {
        balance = balance + amount;
        previousDepositedTransaction = amount;
        System.out.println("======================================================================================================");
        System.out.println("R" + amount + " has been successfully deposited into your account, your available balance is R" + balance);
        System.out.println("=======================================================================================================");
    }
	
    //Function for Withdrawing money
    void withdraw(int amount) {
        if (amount != 0 && amount <= balance) {
            balance = balance - amount;
            previousWithdrawTransaction = amount;
            System.out.println("======================================================================================================");
            System.out.println("R" + amount + " has been successfully withdrawn from your account, your remaining balance is R" + balance);
            System.out.println("=======================================================================================================");
        }
        else if(amount > balance){
            System.out.println("ERROR: Your withdrawal request has been declined due to insufficient funds. Your available balance is " + balance);
        }
    }
	
    //Function showing the previous transaction
    void getPreviousTransaction() {
        boolean displayTransaction = false;
        
        if (previousDepositedTransaction > 0) {
            System.out.println("Deposited: R" + previousDepositedTransaction);      
            displayTransaction = true;
        }
        
        if (previousWithdrawTransaction > 0) {
            System.out.println("Withdrawn: -R" + previousWithdrawTransaction);       
            displayTransaction = true;
        } 
        if (!displayTransaction) {
            System.out.println("No transaction occurred");
        }
    }
	
    //Function calculating interest of current funds after a number of months
    void calculateInterest(int months) {
        double interestRate;
        int newBalance;
        
        if (balance >= 100 && balance <= 500) {
            interestRate = 0.005; // 0.5%
            System.out.println("");
            System.out.println("The current interest rate is " + (100 * interestRate) + "%");
            newBalance = (int)((balance * interestRate * months) + balance);
            System.out.println("After " + months + " months, you balance will be: R" + newBalance);
            System.out.println("");
        }
        // If the amount is more than 500 it will fall in this group
        else if (balance > 500 && balance <= 1000) {
            interestRate = 0.02; // 2%
            System.out.println("");
            System.out.println("The current interest rate is " + (100 * interestRate) + "%");
            newBalance = (int)((balance * interestRate * months) + balance);
            System.out.println("After " + months + " months, you balance will be: R" + newBalance);
            System.out.println("");
        } 
        else if (balance > 1000) {
            interestRate = 0.05; // 5%
            System.out.println("");
            System.out.println("The current interest rate is " + (100 * interestRate) + "%");
            newBalance = (int)((balance * interestRate * months) + balance);
            System.out.println("After " + months + " months, you balance will be: R" + newBalance);
            System.out.println("");
        } 
        else{
            // Handle cases where the balance is less than 100
            System.out.println("");
            System.out.println("Account balance must be more than R100");
            System.out.println("");
        }   
    }
	
    //Function showing the main menu
    void menu() {
        int option = 0;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome, " + customerFirstName + customerLastName);
        System.out.println("Your customer ID is: " + customerID);
        System.out.println();
        System.out.println("What would you like to do?");
        System.out.println();
        System.out.println("1. Check your balance");
        System.out.println("2. Make a deposit");
        System.out.println("3. Make a withdraw");
        System.out.println("4. View previous transaction");
        System.out.println("5. Calculate interest");
        System.out.println("6. Exit");

        do {
            System.out.println();
            System.out.println("Enter an option: ");
            try{
                option = scanner.nextInt();
                System.out.println();
            }
            catch(InputMismatchException err){
                System.out.println();
                System.out.println("Error: invalid option. Please enter a number 1 - 6.");
                scanner.next();
                continue;
            }
            switch(option) {
                //Case 1 allows the user to check their account balance
		case 1 -> {
                    System.out.println("*************************************");
                    System.out.println("Balance = R" + balance);
                    System.out.println("*************************************");
                    System.out.println();
                    menu();
                    System.out.println();
                    }
		//Case 2 allows the user to deposit money into their account using the deposit function
                case 2 -> {
                    System.out.println("Enter an amount to deposit: ");
                    //To prevent the application from craching we will add the below exeption
                    try{
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println();
                    }
                    catch(Exception err){
                        System.out.println("*!***!***!***!***!***!***!***!***!***!***!***!***!***!***!*");
                        System.out.println("ERROR: This application does not accept decimal numbers."); 
                        System.out.println("*!***!***!***!***!***!***!***!***!***!***!***!***!***!***!*");
                        System.out.println("");
                    }
                    finally{
                        menu();
                    }
                }
		//Case '3' allows the user to withdraw money from their account using the withdraw function
                case 3 -> {
                    System.out.println("Enter an amount to withdraw: ");
                    //To prevent the application from craching we will add the below exeption
                    try{
                        int amount2 = scanner.nextInt();
                        withdraw(amount2);
                        System.out.println();
                    }
                    catch(Exception err){
                        System.out.println("*!***!***!***!***!***!***!***!***!***!***!***!***!***!***!*");
                        System.out.println("ERROR: This application does not accept decimal numbers."); 
                        System.out.println("*!***!***!***!***!***!***!***!***!***!***!***!***!***!***!*");
                        System.out.println("");
                        }
                    finally{
                        menu();
                    }
                }
		//Case '4' allows the user to view their most recent transaction using the getPreviousTransaction function
                case 4 -> {
                    System.out.println("*************************************");
                    getPreviousTransaction();
                    System.out.println("*************************************");
                    System.out.println();
                    menu();
                    System.out.println();
                }
		//Case 5 calculates the accrued interest on the account after a number of months are specified by the user
                case 5 -> {
                    System.out.println("+--------------------------------+");
                    System.out.println("| R100 to R500  | 1 month | 0.5% |");
                    System.out.println("| R600 to R1000 | 1 month |  2%  |");
                    System.out.println("| Over R1000    | 1 month |  5%  |");
                    System.out.println("+--------------------------------+");
                    System.out.println();
                    System.out.println("Enter how many months you want to save for accrued interest: ");
                    int months = scanner.nextInt();
                    calculateInterest(months);
                    menu();
                }
                //Case 6 exits the user from their account
		case 6 -> {
                    System.out.println("==============================");
                    System.out.println("Thank you for banking with us!");
                    System.out.println("==============================");
                    System.exit(0);
                }
                //The default case let's the user know that they entered an invalid number and explain what numbers are valid
		default ->System.out.println("Error: invalid option. Please enter a number 1 - 6.");
            } 
        } 
        while(option != 6);
    }	
}
