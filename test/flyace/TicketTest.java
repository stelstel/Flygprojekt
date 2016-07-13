package flyace;

import java.util.Date;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan Elmgren
 * @version 1.00
 */
public class TicketTest {
    
    public TicketTest() {
    }

    /**
     * Test of getCompany method, of class Ticket.
     */
    @Test
    public void testGetSetCompany() {
        System.out.println("getCompany & setCompany");
        Company company = new Company("Acme");
        Ticket t = new Ticket();
        t.setCompany(company);
        String expResult = "Acme";
        String result = t.getCompany().getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getCustomer method, of class Ticket.
     */
    @Test
    public void testGetSetCustomer() {
        System.out.println("getCustomer & setCustomer");
        Ticket t = new Ticket();
        Customer cust = new Customer("Arne", "Larsson", "7001010101");
        t.setCustomer(cust);
        String expResult = "7001010101";
        String result = t.getCustomer().getPersonalNumber();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPlane method, of class Ticket.
     */
    @Test
    public void testGetSetPlane() {
        System.out.println("getPlane & setPlane");
        PassengerPlane pp = new PassengerPlane("Klasse", 15);
        Ticket t = new Ticket();
        t.setPlane(pp);
        AirPlane expResult = pp;
        AirPlane result = t.getPlane();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeat and setSeat method, of class Ticket.
     */
    @Test
    public void testGetSetSeat() {
        System.out.println("getSeat & setSeat");
        Ticket t = new Ticket();
        Seat s = new Seat();
        t.setSeat(s);
        Seat expResult = s;
        Seat result = t.getSeat();
        assertEquals(expResult, result);
    }

    /**
     * Test of getPrice method, of class Ticket.
     */
    @Test
    public void testGetSetPrice() {
        System.out.println("getPrice & setPrice");
        Ticket t = new Ticket();
        t.setPrice(100.00);
        double expResult = 100.0;
        double result = t.getPrice();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of getExpired and setExpired method, of class Ticket.
     */
    @Test
    public void testGetSetExpired() {
        System.out.println("getExpired & setExpired");
        Ticket t = new Ticket();
        Date date = new Date(1000);
        t.setExpired(date);
        Date expResult = date;
        Date result = t.getExpired();
        assertEquals(expResult, result);
    }

    /**
     * Test of getSeatClass and setSeatClass methods, of class Ticket.
     */
    @Test
    public void testGetSetSeatClass() {
        System.out.println("getSeatClass and setSeatClass");
        Ticket t = new Ticket();
        t.setSeatClass(SeatClass.FIRST);
        SeatClass expResult = SeatClass.FIRST;
        SeatClass result = t.getSeatClass();
        assertEquals(expResult, result);
    }
}
