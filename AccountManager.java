

/**
 * Write a description of class AccountManager here.
 *
 * @author (Cynthia Iradukunda)
 * @version (a version number or a date)
 */

import java.util.Date;
import java.util.Scanner;
public class AccountManager{
    //the account 
     private Account account;
     //reader for reading user input
     private Scanner reader;
      private Transaction[] transactions;  
     
    
     
   public AccountManager(Account account){
          this.account = account;
          transactions = new Transaction[3]; 
          reader = new Scanner(System.in);
    }
    public void start(){
         System.out.println("Welcome TO THE ACCOUNT MANAGER APPLICATION");
          boolean finished = false;
         
        for(int i=0; i<3; i++){
              
            System.out.println("Welcome to the account Manager Application"); 
            // get amount 
            System.out.print("Transaction amount to add?\n>");
            String inputAmount = reader.nextLine();
            double amount = Double.parseDouble(inputAmount);
            // get type
            System.out.print("Transaction type?\n>");
            String Type = reader.nextLine();
            //get reference
          
            System.out.print("Transaction reference?\n>");
            String reference = reader.nextLine();
            // date is today's date
            Date date = new Date();
            //create transaction and add to account
            Transaction[] transactions = new Transaction[3];
            transactions[i] = new Transaction(amount,Type, reference, date);
            account.addTransaction(transactions[i]);
            System.out.println("Transaction added");
            account.displayTransactions();
            double balance = account.getBalance();
            System.out.println("this is your balance:" + balance);
            
        }
    
    }
    public static void main(String[] args) {
         Customer cust = new Customer("fernando","alonso");
       Account account =  new Account(cust, "1234");
         AccountManager accountManager = new AccountManager(account);
         accountManager.start(); 
       
    }
}
