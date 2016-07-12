
package flyace;


public class Ticket {
    
    
    
    
    
    public Ticket(){
    }
    
    
    
    
    private Customer customer ;
    private AirPlane plane;
    private Seat seat;
    

    
    public Customer getCustomer() {
        return customer;
    }

    
    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    
    public AirPlane getPlane() {
        return plane;
    }

    
    public void setPlane(AirPlane plane) {
        this.plane = plane;
    }

   
    public Seat getSeat() {
        return seat;
    }

   
    public void setSeat(Seat seat) {
        this.seat = seat;
    }
    
    
    
    
    
}
//     Customer
//	Plane
//	Seat
//	price
//	expired