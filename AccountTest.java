

import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class AccountTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class AccountTest
{
    private Customer customer1;
    private Transaction transact1;
    private Transaction transact2;
    private Transaction transact3;
    private Transaction transact4;
    private Account account1;

    /**
     * Default constructor for test class AccountTest
     */
    public AccountTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        
        
        customer1 = new Customer("Fermando", "Alonso");
        transact1 = new Transaction(200.00, "Credit", "ref2", new java.util.Date());
        transact2 = new Transaction(200.00, "CREDIT", "ref1", new java.util.Date());
        transact3 = new Transaction(100.00, "DEBIT", "ref2", new java.util.Date());
        transact4 = new Transaction(300.00, "CREDIT", "ref3", new java.util.Date());
        account1 = new Account(customer1, "12345");
        account1.addTransaction(transact2);
        account1.addTransaction(transact3);
        account1.addTransaction(transact4);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    @Test
    public void testAddTransaction()
    {
        Transaction transact5 = new Transaction(200.00, "CREDIT", "test", new java.util.Date());
        account1.addTransaction(transact5);
        assertEquals(4, account1.getNumberOfTransactions());
        assertEquals(.00, account1.getBalance(),0.1);
        assertEquals("test", account1.getTransactions()[3].getReference());
    }

    @Test
    public void removeTransaction()
    {
        account1.removeTransaction("ref1");
    }
}


