package flyace;

/**
 * @author Stefan Elmgren
 * @version 1.00
 */

public class Seat {
 //   Ticket ticket;
    SeatClass seatclass;
    int seatNumber;
    SeatStatus seatstatus;
    double price;
    
    //****************** Constructors ******************************************
//    public Seat(Ticket ticket){
//        this.ticket = ticket;
//    }
    
    
    // Put customer in seat
    void assignCustomer(){
        this.seatstatus = SeatStatus.OCCUPIED;
    }
    
    // Remove customer from seat
    void removeCustomer(){
        this.seatstatus = SeatStatus.FREE;
    }

    public SeatClass getSeatclass() {
        return seatclass;
    }

    public void setSeatclass(SeatClass seatclass) {
        this.seatclass = seatclass;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public SeatStatus getSeatstatus() {
        return seatstatus;
    }

    public void setSeatstatus(SeatStatus seatstatus) {
        this.seatstatus = seatstatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
