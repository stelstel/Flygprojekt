package flyace;

/**
 * @author Stefan Elmgren
 * @version 1.01
 */

public class Seat {
    SeatClass seatclass;
    int seatNumber;
    SeatStatus seatstatus;
    double price;
    private Ticket ticket;
    
    // Put customer in seat
    //void assignCustomer(){
    //    this.seatstatus = SeatStatus.OCCUPIED;
    //}
    
    // Remove customer from seat
    //void removeCustomer(){
    //    this.seatstatus = SeatStatus.FREE;
    //}

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
        // If seat is FREE again after flight, then indicate the ticket as invalid
        if(seatstatus == SeatStatus.FREE){
            ticket.setValid(false);
        }
    }

    public void setSeatstatus(SeatStatus seatstatus, Ticket ticket) {
        this.seatstatus = seatstatus;
        this.ticket = ticket;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
