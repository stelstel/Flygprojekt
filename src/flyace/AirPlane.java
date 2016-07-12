package flyace;
import java.util.LinkedHashMap;

/**
 * 
 * @author Stefan Elmgren
 * @version 1.2
 * Superclass
*/

public abstract class AirPlane {
    private String model; // Airplane model
    private LinkedHashMap<Integer, Customer> seats; //Customer seats in the airplane
    private String name; // Name of the airplane
    private int numberOfSeats; //Number of passanger seats in the airplane
    
    // Status of the airplane
    public enum status {
        TAKEOFF, 
        INFLIGHT, 
        LANDING, 
        REFUELLING, 
        BOARDING, 
        PASSANGERSLEAVING, 
        INACTIVE
    }
    
    /**
     * 
     * @param customer Customer object
     * @param seatclass First or economy class 
     */
    //abstract void putCustomer(Customer customer, SeatClass seatclass);
    abstract void putCustomer(Ticket ticket);
    
    abstract void fly();
    
    //abstract void reserveSeat();
    
    abstract void freeSeat(Customer customer);
    
    abstract void freeAllSeats();
    
    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public int getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    
    
}
