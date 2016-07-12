
package flyace;


public class Ticket {
    
    
    
    
    
    public Ticket(){
    }
    
    
    
    
    private Customer customer ;
    private AirPlane plane;
    private Seat seat;
    

    /**
     * @return the customer
     */
    public Customer getCustomer() {
        return customer;
    }

    /**
     * @param customer the customer to set
     */
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    /**
     * @return the plane
     */
    public AirPlane getPlane() {
        return plane;
    }

    /**
     * @param plane the plane to set
     */
    public void setPlane(AirPlane plane) {
        this.plane = plane;
    }

    /**
     * @return the seat
     */
    public Seat getSeat() {
        return seat;
    }

    /**
     * @param seat the seat to set
     */
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
    
    
    
    
}
//     Customer
//	Plane
//	Seat
//	price
//	expired