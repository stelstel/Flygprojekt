package flyace;

import java.util.Date;

public class Ticket {

    private Company company;
    private Customer customer;
    private PassengerPlane plane;
    private Seat seat;
    private double price;
    private Date expired;
    private SeatClass seatclass;
    
    public Ticket(){
        
    }
    
    public Ticket(SeatClass seatclass){
        this.seatclass = seatclass;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public PassengerPlane getPlane() {
        return plane;
    }

    public void setPlane(PassengerPlane plane) {
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

    public SeatClass getSeatClass() {
        return seatclass;
    }

    public void setSeatClass(SeatClass seatclass) {
        this.seatclass = seatclass;
    }
}
