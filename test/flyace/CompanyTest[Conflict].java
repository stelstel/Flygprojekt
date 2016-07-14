package flyace;

import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Stefan Elmgren
 * @version 1.0
 */
public class CompanyTest {
    
    public CompanyTest() {
    }

    /**
     * Test of addMoney method, of class Company.
     */
    @Test
    public void testAddMoney() {
        System.out.println("addMoney");
        Company company = new Company("Acme");
        double moneyBeforeInput = company.getMoney();
        double profit = company.getProfit();
        int mon = 100;
        company.addMoney(mon);
        double moneyAfterInput = company.getMoney();
        assertEquals(moneyAfterInput, moneyBeforeInput + mon , 0.01 );
    }

    /**
     * Test of buyPlane method, of class Company.
     */
    @Test
    public void testBuyPlane() {
        System.out.println("buyPlane");
        
        PassengerPlane plane = new PassengerPlane();
        Company comp = new Company();
        int nrOfPlanesBeforeBuy = comp.getNumberOfPlanes();
        comp.buyPlane(plane);
        int nrOfPlanesAfterBuy = comp.getNumberOfPlanes();
        assertEquals(nrOfPlanesAfterBuy , nrOfPlanesBeforeBuy + 1 );
    }

    /**
     * Test of sellPlane method, of class Company.
     */
    @Test
    public void testSellPlane() {
        System.out.println("sellPlane");
        PassengerPlane plane = new PassengerPlane("StefAir", 25);
        Company comp = new Company();
        comp.buyPlane(plane);
        int nrOfPlanesBeforeSell = comp.getNumberOfPlanes();
        
        try {
            comp.sellPlane(plane);
        } catch (NoPlanesExistsException ex) {
            System.err.println("NoPlanesExistsException: " + ex.getMessage());
            Logger.getLogger(CompanyTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        int nrOfPlanesAfterSell = comp.getNumberOfPlanes();
        assertEquals(nrOfPlanesAfterSell , nrOfPlanesBeforeSell - 1 );
    }

    /**
     * Test of setName method, of class Company.
     */
    @Test
    public void testSetName() {
        System.out.println("setName");
        String name = "Kalle Svensson";
        Company comp = new Company();
        comp.setName(name);
        
        String nameFromGetName = comp.getName();
        assertEquals(name, nameFromGetName);
    }

    /**
     * Test of setProfit method, of class Company.
     */
    @Test
    public void testSetProfit() {
        System.out.println("setProfit");
        double profit = 0.2;
        Company comp = new Company();
        comp.setProfit(profit);
        assertEquals(profit, comp.getProfit(), 0.01);
    }

    /**
     * Test of getName method, of class Company.
     */
    @Test
    public void testGetName() {
        System.out.println("getName");
        
        String name = "Bert Svensson";
        Company comp = new Company();
        comp.setName(name);
        String expResult = "Bert Svensson";
        String result = comp.getName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getProfit method, of class Company.
     */
    @Test
    public void testGetProfit() {
        System.out.println("getProfit");
        Company instance = new Company();
        double expResult = 0.3;
        double result = instance.getProfit();
        assertEquals(expResult, result, 0.01);
    }
}