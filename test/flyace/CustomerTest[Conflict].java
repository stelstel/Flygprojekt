package flyace;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class CustomerTest {
    
    public CustomerTest() {
    }

    /**
     * Test of getFirstName method, of class Customer.
     */
    @Test
    public void testGetFirstName() {
        System.out.println("getFirstName");
        Customer cust = new Customer("Steve", "Smith", "6705130075");
        String expResult = "Steve";
        String result = cust.getFirstName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSurname method, of class Customer.
     */
    @Test
    public void testGetSurname() {
        System.out.println("getSurname");
        Customer cust = new Customer("Steve", "Smith", "6705130075");
        String expResult = "Smith";
        String result = cust.getSurname();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFirstName method, of class Customer.
     */
    @Test
    public void testSetFirstName() {
        System.out.println("setFirstName");
        String nameAfterSet;
        String firstName = "Erik";
        Customer cust = new Customer("", "", "");
        cust.setFirstName(firstName);
        nameAfterSet = cust.getFirstName();
        assertEquals("Erik", nameAfterSet);
    }

    /**
     * Test of setSurname method, of class Customer.
     */
    @Test
    public void testSetSurname() {
        System.out.println("setSurname");
        String nameAfterSet;
        String surname = "Smith";
        Customer cust = new Customer("", "", "");
        cust.setSurname(surname);
        nameAfterSet = cust.getSurname();
        assertEquals("Smith", nameAfterSet);
    }
    
}
