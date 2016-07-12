package flyace;

import java.util.LinkedHashMap;

/**
 * @author Stefan Elmgren
 * @version 1.02
 */
public class PassengerPlane extends AirPlane {

    private int nrOfSeats;
    private LinkedHashMap<Integer, Seat> seats = new LinkedHashMap<Integer, Seat>(nrOfSeats);
    private double firstPrice = 5000.00;
    private double economyPrice = 20000.00;
    
    //*********************** Contructors **************************************
    // All contructors use this constructor
    PassengerPlane(String name, int numberOfSeats) {
        this.setName(name);
        this.nrOfSeats = numberOfSeats;
        
        for(int i = 0; i < nrOfSeats; i++ ){
            Seat seat = new Seat();
            seat.seatNumber = i;
            seat.seatstatus = SeatStatus.FREE;
            seats.put(i, seat);
            
            if(i < nrOfSeats / 2){
                seats.get(i).setPrice(firstPrice);
                seats.get(i).setSeatclass(SeatClass.FIRST);
            }
            else{
                seats.get(i).setPrice(economyPrice);
                seats.get(i).setSeatclass(SeatClass.ECONOMY);
            }
        }
    }

    PassengerPlane(int numberOfSeats) {
        this("Noname", numberOfSeats);
    }

    PassengerPlane() {
        this("Noname", 10);
    }

    @Override
    public void putCustomer(Ticket ticket){
    //public void putCustomer(Customer customer, SeatClass seatclass) {
        int seatFound = -1;

        if (seats.size() < nrOfSeats) { // Seats available
            if (ticket.getSeatClass() == SeatClass.FIRST) { // First class
                for (int i = 0; i < 5; i++) {
                    if (/*seats.isEmpty() || */ seats.get(i).getSeatstatus() == SeatStatus.FREE) { //empty seat found
                        seatFound = i;
                        break;
                    }
                }

                if (seatFound > -1) { //Free seat found
                    ticket.setSeat(seats.get(seatFound));
                } else {
                    //erbjud plats i andra klass
                }
            } else if (ticket.getSeatClass() == SeatClass.ECONOMY) { // Economy class
                for (int i = 5; i < 10; i++) {
                    if (/*seats.isEmpty() ||*/ seats.get(i).getSeatstatus() == SeatStatus.FREE) { //empty seat found
                        seatFound = i;
                        break;
                    }
                }
                if (seatFound > -1) {
                    ticket.setSeat(seats.get(seatFound));
                } else {
                    //erbjud plats i första klass
                }
            }
        } else {
            // All seats occupied
        }
    }

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
    void freeSeat(Customer customer) {
        String customersPersNum = customer.getPersonalNumber();
        
        for (int i = 0; i < nrOfSeats; i++) {
            if (seats.get(i) != null && customersPersNum.equals(customer.getPersonalNumber() ) ) {
                seats.remove(i);
            }
        }
    }

    @Override
    void freeAllSeats() {
        seats.clear();
    }
}
