package flyace;

import java.util.LinkedHashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author Stefan Elmgren
 * @version 1.04
 */
public class PassengerPlane extends AirPlane implements Runnable{
    private int nrOfSeats;
    private LinkedHashMap<Integer, Seat> seats = new LinkedHashMap<Integer, Seat>(nrOfSeats);
    private int numberOfSeats; //Number of passanger seats in the airplane
    private double firstPrice;
    private double economyPrice;
    
    //*********************** Contructors **************************************
    // All contructors use this constructor
    PassengerPlane(String name, int numberOfSeats) {
        this.economyPrice = 5000.00;
        this.firstPrice = 20000.00;
        this.setName(name);
        this.nrOfSeats = numberOfSeats;
        
        freeAllSeats();
        this.setStatus(PlaneStatus.INACTIVE);
    }

    PassengerPlane(int numberOfSeats) {
        this("Noname", numberOfSeats);
        this.economyPrice = 5000.00;
        this.firstPrice = 20000.00;
    }

    PassengerPlane() {
        this("Noname", 10);
        this.economyPrice = 5000.00;
        this.firstPrice = 20000.00;
    }

    public void putCustomer(Ticket ticket){
    // TODO Check if any free seats less, if not start the flight
        int seatFound = -1;

        if (getNrOfFreeSeats() > 0) { // Seats available
            if (ticket.getSeatClass() == SeatClass.FIRST) { // First class
                for (int i = 0; i < 5; i++) {
                    if (/*seats.isEmpty() || */ seats.get(i).getSeatstatus() == SeatStatus.FREE) { //empty seat found
                        seatFound = i;
                        break;
                    }
                }

                if (seatFound > -1) { //Free seat found
                    //Set seat to occupied
                    seats.get(seatFound).setSeatstatus(SeatStatus.OCCUPIED);
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
                    //Set seat to occupied
                    seats.get(seatFound).setSeatstatus(SeatStatus.OCCUPIED); 
                    ticket.setSeat(seats.get(seatFound));
                } else {
                    //erbjud plats i första klass
                }
            }
        } else {
            // All seats occupied
        }

        // If all seats are occupied and planeStatus is INACTIVE then it's time to fly
        PlaneStatus planeStatus = this.getStatus();
        if(planeStatus == PlaneStatus.INACTIVE && getNrOfFreeSeats() == 0){
            planeStatus = PlaneStatus.REFUELLING;
            new TimeToFly().checkIfItsTime(ticket.getPlane());
            new Fly(this.getName());
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
        /*
        REFUELLING, 2  minuter
        BOARDING,   8 minuter 
        TAKEOFF,    1 sekund
        INFLIGHT,   35 sekunder
        LANDING,    1 sekund
        DEBARKING,   10 minuter
        INACTIVE    ?
        */
        System.out.println(this.getName() + " is refuelling");
        this.setStatus(PlaneStatus.REFUELLING);
        try {
            //Thread.sleep(2*60*1000); //Sleep 2 minutes
            Thread.sleep(1000); // TODO change
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(this.getName() + " is boarding");
        this.setStatus(PlaneStatus.BOARDING);
        
        try {
            //Thread.sleep(8 * 60 * 1_000); // Sleep 8 minutes
            Thread.sleep(1000); // TODO change
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(this.getName() + " is taking off");
        this.setStatus(PlaneStatus.TAKEOFF);
        
        try {
            Thread.sleep(1000); //Sleep 1 second
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(this.getName() + " is in flight");
        this.setStatus(PlaneStatus.INFLIGHT);
        
        try {
            // Thread.sleep(35 * 1000); //Sleep 37 seconds
            Thread.sleep(5 * 1000); // TODO change
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(this.getName() + " is landing");
        this.setStatus(PlaneStatus.LANDING);
        
        try {
            Thread.sleep(1000); //Sleep 1 second
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println(this.getName() + " is debarking");
        this.setStatus(PlaneStatus.DEBARKING);
        
        try {
            //Thread.sleep(10*60*1000); //Sleep 10 minutes
            Thread.sleep(1000); // TODO change
        } catch (InterruptedException ex) {
            Logger.getLogger(PassengerPlane.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        this.freeAllSeats();
        
        System.out.println(this.getName() + " is inactive");
        this.setStatus(PlaneStatus.INACTIVE);
    }

    // Remove one seat from the seats
    void freeOneSeat(Ticket ticket) { 
               
        for (int i = 0; i < nrOfSeats; i++) {
            if (seats.get(i) != null && seats.get(i) == ticket.getSeat() )  {
                seats.remove(i);
            }
        }
    }

    void freeAllSeats() {
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
    
    public int getNrOfFreeSeats(){
        int nrOfFreeSeats = 0;
        for(int i = 0; i < this.nrOfSeats; i++){
            if(seats.get(i).getSeatstatus() == SeatStatus.FREE){
                nrOfFreeSeats++;
            }
        }
        
        return nrOfFreeSeats;
    }

    @Override
    public void run() {
        fly();
    }
}
