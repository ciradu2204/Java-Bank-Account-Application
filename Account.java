/**
 * represents a bank account
 *
 */

public class Account
{
    // the customer
    private Customer customer;
    // the account number
    private String accountNumber;
    // the account balance
    private double balance;
    // the maximum number of transactions
    private final int MAX_TRANSACTIONS = 10;         
    // array to hold transactions
    private Transaction[] transactions;   
    // the number of Transactions in the array                                 
    private int numberOfTransactions;       

    /** 
     * @param customer a customer type object
     * @param accountNumber shows the accountNumber
     * @return Constructor for objects of type Account 
     */
    public Account(Customer customer, String accountNumber)
    {
        transactions = new Transaction[MAX_TRANSACTIONS];   
        numberOfTransactions = 0;
        this.customer = customer;
        this.accountNumber = accountNumber;
        balance = 0.0f;
    }
    /**
     * @return returns the account number
       
     */
    public String getAccountNumber()
    {
        return accountNumber;
    }
    /**
     * @return returns the customer name
       
     */
    public String getCustomerName()
    {
        return (customer.getFirstName() + " " + customer.getLastName());
    }
    /**
     * @return returns the account balance
       
     */
    
    public double getBalance()
    
    {
         
         
        
        return balance;
        
        
    }
    
    /**
     * @return returns the number of Transactions
       
     */
    
    public int getNumberOfTransactions()
    {
        return numberOfTransactions;
    }
    
    /**
     *  print details of the account and its
     current transactions
 
    */
    public void displayTransactions()   
    {
        System.out.format("Account: %s\nCustomer: %s\n",
            accountNumber,this.getCustomerName());

        for(int i=0;i<numberOfTransactions;i++)
        {
            Transaction trans = transactions[i];

            System.out.format("%4.2f    %s    %s    %s\n", trans.getAmount(),
                    trans.getType(),
                    trans.getReference(),
                    trans.getDateString());
        }
    }
    
    /**
     * adds a new Transaction object to the array 
     * of contained objects
     * @Param newTransaction the new Transaction to add
       
     */
    public void addTransaction(Transaction newTransaction)
    {
        if(numberOfTransactions < MAX_TRANSACTIONS)
       {
           transactions[numberOfTransactions] = newTransaction;
           numberOfTransactions++;
          
        }
        
        updateBalance();
     
    }
    
    /**
     * @return  gets the array of contained Transaction objects
     */
    public Transaction[] getTransactions()
    {
        return transactions;
    }
    /**
     * @return gets a contained Transaction object specified by its
      reference property
       
     */
    public Transaction getTransaction(String reference)
    {
       Transaction target = null;
       int i = 0;
       while(i<numberOfTransactions)
       {
           if(transactions[i].getReference().equals(reference))
           {
               target = transactions[i];
               break;
           }
           i++;
       }
       return target;
    }
     /**
     * removes a contained Transaction Object specified
     by its reference property
       
     */
    public void removeTransaction(String reference)
    {
       int i = 0;
       boolean found = false;
       while(i<numberOfTransactions)
       {
           if(transactions[i].getReference().equals(reference))
           {
               found = true;
               break;
           }
           i++;
       }
       if(found)
       {
           for(int j=i;j<numberOfTransactions;j++)
           {
               transactions[j] = transactions[j+1];
           }
           transactions[numberOfTransactions]=null;
           numberOfTransactions--;
       }
       updateBalance();
    }
     

    //calculates the total value of all transactions and assigns
    //this total to the account balance
  
    private void updateBalance()
    {
        double total = 0.0;   // total value of all transactions
            
        for(int i=0;i<numberOfTransactions;i++)
        {
            Transaction trans = transactions[i];
            
            if (trans.getType().equals("CREDIT"))
            {
                
                total = total + trans.getAmount();
                 System.out.println(total);
            }
            else if(trans.getType().equals("DEBIT"))
            {
                total =  total - trans.getAmount();
            }
        }
        this.balance = total;    // assign total to account balance field
    }

     /**
     * @return returns a String representation of this object
       
     */
    public String toString()
    {
        return String.format("Account number: %s, Customer: %s", 
            accountNumber, this.getCustomerName());
    }

}

