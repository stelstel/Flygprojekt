package flyace;

import java.util.LinkedHashMap;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class PassengerPlaneTest {

    public PassengerPlaneTest() {
    }

    /**
     * Test of putCustomer method, of class PassengerPlane_old_01.
     */
    @Test
    public void testPutCustomer() {
        System.out.println("putCustomer");
        Customer customer = new Customer("Berit", "Olsson", "7005130075");
        SeatClass seatclass = SeatClass.FIRST;
        PassengerPlane pp = new PassengerPlane("Planet Arne", 10);
        LinkedHashMap<Integer, Customer> seats = pp.getSeats();

        int sizeBefore = seats.size();
//        for(int i= 0; i < 10; i++ ){
//            System.out.println("s= " + i + seats.toString());
//        }

        pp.putCustomer(customer, seatclass);

//        for(int i= 0; i < 10; i++ ){
//            System.out.println("s= " + i + seats.get(i));
//        }
        int sizeAfter = seats.size();
        assertEquals(sizeBefore, sizeAfter - 1);
    }

    /**
     * Test of getNrOfSeats method, of class PassengerPlane_old_01.
     */
    @Test
    public void testGetNrOfSeats() {
        System.out.println("getNrOfSeats");
        PassengerPlane p = new PassengerPlane("Lisa", 11);
        int expResult = 11;
        int result = p.getNrOfSeats();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of getSeats method, of class PassengerPlane_old_01.
//     */
//    @Test
//    public void testGetSeats() {
//        System.out.println("getSeats");
//        PassengerPlane_old_01 instance = new PassengerPlane_old_01();
//        LinkedHashMap<Integer, Seat> expResult = null;
//        LinkedHashMap<Integer, Seat> result = instance.getSeats();
//        assertEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }

    /*
     * Test of setNrOfSeats method, of class PassengerPlane_old_01.
     */
    @Test
    public void testSetNrOfSeats() {
        System.out.println("setNrOfSeats");
        int nrOfSeats = 19;
        PassengerPlane p = new PassengerPlane("Olof", 15);
        p.setNrOfSeats(nrOfSeats);
        int expResult = nrOfSeats;
        int result = p.getNrOfSeats();
        assertEquals(expResult, result);
    }

//    /**
//     * Test of fly method, of class PassengerPlane_old_01.
//     */
//    @Test
//    public void testFly() {
//        System.out.println("fly");
//        PassengerPlane_old_01 instance = new PassengerPlane_old_01();
//        instance.fly();
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    /**
     * Test of freeSeat method, of class PassengerPlane_old_01.
     */
    @Test
    public void testFreeSeat() {
        System.out.println("freeSeat");

        PassengerPlane p = new PassengerPlane("Plan", 10);
        LinkedHashMap<Integer,Customer> seats = p.getSeats();

        Customer customer = new Customer("Kalle", "Svensson", "6705130075");
        //Seat seat = new Seat(customer);
        p.putCustomer(customer, SeatClass.FIRST);

        Customer customer2 = new Customer("Karl", "Nilsson", "6805130075");
        //Seat seat2 = new Seat(customer2);
        p.putCustomer(customer2, SeatClass.ECONOMY);

//        System.out.println("Before");
//        for (int i = 0; i < 10; i++) {
//            System.out.println("s= " + i + seats.get(i));
//        }
        int sizeBefore = seats.size();

        p.freeSeat(customer);
        p.freeSeat(customer2);

//        System.out.println("After");
//        for (int i = 0; i < 10; i++) {
//            System.out.println("s= " + i + seats.get(i));
//        }
        int sizeAfter = seats.size();
        assertEquals(sizeAfter, sizeBefore - 2);
    }

    /**
     * Test of freeAllSeats method, of class PassengerPlane_old_01.
     */
    @Test
    public void testFreeAllSeats() {
        System.out.println("freeAllSeats");
        PassengerPlane p = new PassengerPlane("Plan Sten", 10);
        LinkedHashMap<Integer, Customer> seats = p.getSeats();
        Customer customer = new Customer("Stina", "Adel", "8705130075");
        p.putCustomer(customer, SeatClass.FIRST);

        int sizeBefore = seats.size();

        System.out.println("Before");
        for (int i = 0; i < 10; i++) {
            System.out.println("s= " + i + seats.get(i));
        }

        p.freeAllSeats();
        
        System.out.println("After");
        for (int i = 0; i < 10; i++) {
            System.out.println("s= " + i + seats.get(i));
        }

        int sizeAfter = seats.size();
        assertEquals(sizeAfter, sizeBefore - 1);
    }
}
