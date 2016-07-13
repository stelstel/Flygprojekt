package flyace;

import java.util.LinkedHashMap;

/**
 * @author Stefan Elmgren
 * @version 1.03
 * 
 */
public class PassengerPlane extends AirPlane {

    private int nrOfSeats; //Number of passenger seats in the plane
    
    // Map of objects of Seat
    private LinkedHashMap<Integer, Seat> seats = new LinkedHashMap<Integer, Seat>(nrOfSeats);
   
    // The price of a first class ticket
    private double firstClassPrice = 5000.00;
    
    // The price of a economy class ticket
    private double economyPrice = 20000.00;
    
    //*********************** Contructors **************************************
    // All contructors use this constructor
    
    /**
     * 
     * @param name Name of the PassangerPlane
     * @param numberOfSeats Number of passenger seats in the plane
     */
    PassengerPlane(String name, int numberOfSeats) {
        this.setName(name);
        this.nrOfSeats = numberOfSeats;
        freeAllSeats();
    }

    /**
     * 
     * @param numberOfSeats Number of passenger seats in the plane
     */
    PassengerPlane(int numberOfSeats) {
        this("Noname", numberOfSeats);
    }

    PassengerPlane() {
        this("Noname", 10);
    }
    
    /**
     * 
     * @param ticket Ticket
     * Put customer in Seat
     */
    
    @Override
    public void putCustomer(Ticket ticket){
        int seatFound = -1;

        if (getNrOfFreeSeats() > 0) { // Seats available
            if (ticket.getSeatClass() == SeatClass.FIRST) { // First class
                for (int i = 0; i < 5; i++) { // Look in first class 
                    //empty seat found
                    if (seats.get(i).getSeatstatus() == SeatStatus.FREE) { 
                        seatFound = i;
                        break;
                    }
                }

                if (seatFound > -1) { // Free seat found in first class
                    //Set seat to occupied
                    seats.get(seatFound).setSeatstatus(SeatStatus.OCCUPIED);
                    // put the Seat in the ticket
                    ticket.setSeat(seats.get(seatFound));
                }
            // Economy class
            } else if (ticket.getSeatClass() == SeatClass.ECONOMY) { 
                for (int i = 5; i < 10; i++) {  // Look in economy class 
                    if (seats.get(i).getSeatstatus() == SeatStatus.FREE) { //empty seat found
                        seatFound = i;
                        break;
                    }
                }
                if (seatFound > -1) {
                    //Set seat to occupied
                    seats.get(seatFound).setSeatstatus(SeatStatus.OCCUPIED);
                    // put the Seat in the ticket
                    ticket.setSeat(seats.get(seatFound));
                }
            }
        } 
    }
    /**
     * 
     * @return int. Number of passenger seats (Free or occupied) 
     */
    public int getNrOfSeats() {
        return nrOfSeats;
    }

    public LinkedHashMap<Integer, Seat> getSeats() {
        return seats;
    }

    public void setNrOfSeats(int nrOfSeats) {
        this.nrOfSeats = nrOfSeats;
    }

    @Override
    void fly() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    // Remove one seat from the seats
    //void freeSeat(Customer customer) {
    void freeOneSeat(Ticket ticket) { 
               
        for (int i = 0; i < nrOfSeats; i++) {
            if (seats.get(i) != null && seats.get(i) == ticket.getSeat() )  {
                seats.remove(i);
            }
        }
    }

    @Override
    void freeAllSeats() {
        for(int i = 0; i < nrOfSeats; i++ ){
            Seat seat = new Seat();
            seat.seatNumber = i;
            seat.seatstatus = SeatStatus.FREE;
            seats.put(i, seat);
            
            if(i < nrOfSeats / 2){
                seats.get(i).setPrice(firstClassPrice);
                seats.get(i).setSeatclass(SeatClass.FIRST);
            }
            else{
                seats.get(i).setPrice(economyPrice);
                seats.get(i).setSeatclass(SeatClass.ECONOMY);
            }
        }
    }
    
    public int getNrOfFreeSeats(){
        int nrOfFreeSeats = 0;
        for(int i = 0; i < this.nrOfSeats; i++){
            //if(seats.get(i).getSeatstatus() == SeatStatus.FREE){
            if(seats.get(i).getSeatstatus() == SeatStatus.FREE){
                nrOfFreeSeats++;
            }
        }
        
        return nrOfFreeSeats;
    }

    public double getFirstClassPrice() {
        return firstClassPrice;
    }

    public void setFirstClassPrice(double firstClassPrice) {
        this.firstClassPrice = firstClassPrice;
    }

    public double getEconomyPrice() {
        return economyPrice;
    }

    public void setEconomyPrice(double economyPrice) {
        this.economyPrice = economyPrice;
    }
    
    
}
