package flyace;

import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 *
 * @author Stefan Elmgren
 * @version 1.02
 */
public class PassengerPlane extends AirPlane {

    private int nrOfSeats;
    private LinkedHashMap<Integer, Customer> seats = new LinkedHashMap<Integer, Customer>(nrOfSeats);

    //*********************** Contructors **************************************
    // All contructors use this constructor
    PassengerPlane(String name, int numberOfSeats) {
        this.setName(name);
        this.nrOfSeats = numberOfSeats;
    }

    PassengerPlane(int numberOfSeats) {
        this("Noname", numberOfSeats);
    }

    PassengerPlane() {
        this("Noname", 10);
    }

    @Override
    public void putCustomer(Customer customer, SeatClass seatclass) {
        int seatFound = -1;

        if (seats.size() < nrOfSeats) { // Seats available
            if (seatclass == seatclass.FIRST) { // First class
                for (int i = 0; i < 5; i++) {
                    if (seats.isEmpty() || seats.get(i) == null) { //empty seat found
                        seatFound = i;
                        break;
                    }
                }

                if (seatFound > -1) {
                    //Seat seat = new Seat(customer); 
                    seats.put(seatFound, customer); // Sätt kunden i sätet
                } else {
                    //erbjud plats i andra klass
                }
            } else if (seatclass == seatclass.ECONOMY) { // Economy class
                for (int i = 5; i < 10; i++) {
                    if (seats.get(i) == null) { //empty seat found
                        seatFound = i;
                        break;
                    }
                }
                if (seatFound > -1) {
                    //Seat seat = new Seat(customer); 
                    seats.put(seatFound, customer);  // Sätt kunden i sätet
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

    public LinkedHashMap<Integer, Customer> getSeats() {
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
