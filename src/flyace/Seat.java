package flyace;

/**
 * @author Stefan Elmgren
 * @version 1.00
 */

public class Seat {
    Ticket ticket;
    SeatClass seatclass;
    int seatNumber;
    SeatStatus seatstatus;
    double price;
    
    //****************** Constructors ******************************************
    public Seat(Ticket ticket){
        this.ticket = ticket;
    }
    
    // Put customer in seat
    void assignCustomer(){
        this.seatstatus = SeatStatus.OCCUPIED;
    }
    
    // Remove customer from seat
    void removeCustomer(){
        this.seatstatus = SeatStatus.FREE;
    }
}
