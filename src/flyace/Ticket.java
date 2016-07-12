
package flyace;

import java.util.Date;

public class Ticket {
    
    
    
     
    
    public Ticket(Customer customer, AirPlane plane,Seat seat,double price,Date expired){
    }
    
 
    private Customer customer ;
    private AirPlane plane;
    private Seat seat;
    private double price ;
    private Date expired;
    

    
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

    
    public double getPrice() {
        return price;
    }

    
    public void setPrice(double price) {
        this.price = price;
    }

    
    public Date getExpired() {
        return expired;
    }

    
    
    public void setExpired(Date expired) {
        this.expired = expired;
    }
    
}
